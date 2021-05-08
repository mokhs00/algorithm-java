package Programmers;

import java.util.PriorityQueue;

public class 더_맵게 {
    /*
        모든 음식의 스코빌 지수를 K 이상을 만들어야한다

        그 방법으로 스코빌 지수가 가장 낮은 두 음식을 아래와 같은 방법으로 섞는다.
        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 +
                              두번째로 맵지 않은 음식의 스코빌 지수 * 2

        모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복

        PriorityQueue 오름차순 정렬을 이용해서 품.
     */
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (pq.size() > 1) {
            Integer firstPeek = pq.peek();

            if (firstPeek < K) {
                Integer first = pq.poll();
                Integer second = pq.poll();

                pq.offer(first + second * 2);
                answer++;
            } else {
                break;
            }
        }

        if (pq.peek() < K) {
            return -1;
        }


        return answer;
    }
}
