package Programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42747?language=java
class H_Index {
    /*
        H-Index :
        과학자가 발표한 논문 n 편 중,
        h번 이상 인용된 논문이
        h편 이상이고,
        나머지 논문이 h번 이하 인용되었을 때.
        h의 최댓값

        을 구하여라.

        정렬 이용.

     */
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int now = citations[i];
            // citations.length - i = citations.length -1 - i + 1
            if (now >= citations.length - i) {
                return citations.length - i;
            }
        }

        return answer;
    }
}