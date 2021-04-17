package Programmers;

import java.util.Arrays;

public class 단속카메라 {
    /*
        시작점 오름차순으로 정렬해두고
        route를 순회하며 route끼리 겹치는 가장 좁은 범위까지 좁힌다.
        만약, 다음 route의 시작점이 현재 right 보다 크다면
        left, right를 다음 route의 시작점, 도착점으로 옮기고 continue
     */

    public int solution(int[][] routes) {
        int answer = 1;

        // 시작점 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int left = -30001;
        int right = 30001;


        for (int[] route : routes) {
            int nextLeft = route[0];
            int nextRight = route[1];

            if (nextLeft > right) {
                left = nextLeft;
                right = nextRight;
                answer++;
            }
            if (left < nextLeft)
                left = nextLeft;
            if (right > nextRight)
                right = nextRight;
        }

        return answer;
    }
}
