package Programmers;

import java.util.HashSet;
import java.util.Set;

public class 로또의_최고_순위와_최저_순위 {
    /*
        lottos가 win_nums와 얼마나 일치하는지 판별
        -> HashSet을 이용하면 좋을듯
        0의 개수 세기

     */
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        final int MAX = win_nums.length;
        int matchCount = 0;
        int zeroCount = 0;

        Set<Integer> winNumSet = new HashSet<>();


        for (int i = 0; i < win_nums.length; i++) {
            winNumSet.add(win_nums[i]);
        }

        for (int i = 0; i < lottos.length; i++) {
            int lotto = lottos[i];
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            if (winNumSet.contains(lotto)) {
                matchCount++;
            }
        }

        int maxMatchCount = matchCount + zeroCount;

        answer[0] = getRank(maxMatchCount);
        answer[1] = getRank(matchCount);


        return answer;
    }

    public int getRank(int matchCount) {

        int rank = 6;
        if (matchCount == 6) {
            rank = 1;
        }
        if (matchCount == 5) {
            rank = 2;
        }
        if (matchCount == 4) {
            rank = 3;
        }
        if (matchCount == 3) {
            rank = 4;
        }
        if (matchCount == 2) {
            rank = 5;
        }
        if (matchCount < 2) {
            rank = 6;
        }

        return rank;
    }
}
