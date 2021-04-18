package Programmers;

import java.util.Arrays;

/*
    https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int n = people.length;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {

            if (left == right) {
                answer++;
                break;
            }

            int sum = people[left] + people[right];

            if (limit < sum) {
                answer++;
                right--;
            } else {
                answer++;
                left++;
                right--;
            }


        }

        return answer;
    }
}
