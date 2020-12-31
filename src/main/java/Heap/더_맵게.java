package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {
        // Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다
        // 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        /*
         1. Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
         2. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return
         */


        // ! 코스빌 지수가 같을 수도?

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        while (heap.peek() < K){
            if (heap.size() < 2) return -1;
            int min1 = heap.poll();
            int min2 = heap.poll();
            heap.offer(min1 + (min2 * 2));
            answer++;
        }

        return answer;
    }

    /*  효율성 테스트 fail

    int answer = 0;
        int temp;
        int min;


        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < scoville.length; i++) {
            array.add(scoville[i]);
        }

        while(true) {
            // 1. index 부여 -> 최소값 찾고 index, temp 에 넣음 -> 그 다음 (temp <= value) 찾음, if(인덱스 제외)
            // 정렬하면 빨라질지도

            min = Collections.min(array);

            if (min >= K) break;
            if (array.size() == 1 && array.get(0) < K){
                return -1;
            }

            array.remove(array.indexOf(min));

            temp = min;
            min = Collections.min(array);
            array.remove(array.indexOf(min));

            // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            array.add(temp + (min * 2));
            answer++;
        }*/


}
