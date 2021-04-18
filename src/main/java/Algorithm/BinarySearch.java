package Algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 3, 1, 1, 3};
        // 오름차순 정렬
        Arrays.sort(array);
        // 이진 탐색 수행
        BinarySearch binarySearch = new BinarySearch();

        // 2가 존재하지 않으므로 -1 반환
        int test1 = binarySearch.binarySearch(array, 2);
        System.out.println("test1 : " + test1);
        // 정렬된 배열 기준  3의 마지막 인덱스 반환
        int test2 = binarySearch.binarySearch(array, 3);
        System.out.println("test2 : " + test2);


    }

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[right] != target) {
            return -1;
        }

        return right;
    }
}
