package etc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.
 * <p>
 * The input list is not necessarily ordered in any way.
 * <p>
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 * <p>
 * 중첩될 수 있는 인터벌들을 갖는 리스트가 있습니다. 중첩되는 인터벌들을 하나로 합친 새로운 리스트를 반환하세요.
 * <p>
 * 입력 리스트는 정렬되어 있지 않습니다.
 * <p>
 * 예를 들어, [(1, 3), (5, 8), (4, 10), (20, 25)] 가 주어지면, [(1, 3), (4, 10), (20, 25)] 를 반환해야 합니다.
 */
public class MergeIntervals {

    /**
     * 풀이
     *
     * -> 입력된 배열을 순회하며 해당 interval(범위)가 중복되는 경우, interval을 하나로 병합하여 기록한 배열을 반환.
     *
     * 범위가 중복되는 경우 -> 포함(1~3, 2~3 => 1~3) or 확장(1~3, 2~4 => 1~4)
     *
     * 1. input 배열을 미리 출발점 [0] 오름차순 기준으로 정렬
     * 2. mergedList에 첫번쨰 값 추가 (input[0])
     * 3. 정렬된 input 배열을 순회하며 mergedList의 마지막 값과 다음 조건문을 통해 연산 방식을 결정함
     *    1) 포함되는 경우 => continue;
     *    2) 확장되는 경우 => 기존 mergedList의 확장된 값의 범위로 변경
     *    3) 위 조건에 해당되지 않는 경우 => mergedList에 현재 값을 추가함     *
     *
     */

    public static void main(String[] args) throws IOException {
        int[][] input1 = new int[][]{{1, 3}, {5, 8}, {4, 10}, {20, 25}};
        int[][] result1 = new int[][]{{1, 3}, {4, 10}, {20, 25}};

        int[][] input2 = new int[][]{{1, 3}, {5, 8}, {4, 10}, {20, 25}, {22, 27}};
        int[][] result2 = new int[][]{{1, 3}, {4, 10}, {20, 27}};

        boolean result1Equals = Arrays.deepEquals(result1, mergeIntervals(input1));
        System.out.println(result1Equals);

        boolean result2Equals = Arrays.deepEquals(result2, mergeIntervals(input2));
        System.out.println(result2Equals);


    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> mergedList = new ArrayList<>();

        mergedList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentElement = intervals[i];
            int[] mergedListLastElement = mergedList.get(mergedList.size() - 1);

            boolean isIncluded = mergedListLastElement[0] <= currentElement[0] && mergedListLastElement[1] >= currentElement[1];
            if (isIncluded) {
                continue;
            }

            boolean isExpanding = mergedListLastElement[0] <= currentElement[0] && mergedListLastElement[1] >= currentElement[0] && mergedListLastElement[1] <= currentElement[1];
            if (isExpanding) {
                mergedListLastElement[1] = currentElement[1];
                continue;
            }

            mergedList.add(currentElement);
        }

        return mergedList.toArray(new int[mergedList.size()][2]);

    }

}
