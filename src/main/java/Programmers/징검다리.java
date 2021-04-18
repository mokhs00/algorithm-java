package Programmers;

import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int mid = (left + right) / 2;

        while (left <= right) {
            int count = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }

            }

            if (distance - prev < mid)
                count++;

            if (count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        answer = right;


        return answer;
    }

}
