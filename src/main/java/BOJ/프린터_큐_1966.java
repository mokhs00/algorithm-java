package BOJ;

import java.util.*;

// https://www.acmicpc.net/problem/1966
public class 프린터_큐_1966 {

    /*
        문서를 순차적으로 꺼낼때 해당 문서의 중요도가 문서 묶음의 중요도 최대값이 아니면
        맨 뒤로 보냄.

        중요도 최대값을 구할 방법이 필요
            -> PriorityQueue를 이용
               중요도를 내림차순으로 정렬하여 첫 값이 중요도 최대값이 되도록 함.

        1. 문서의 인덱스와 중요도 값을 Queue에 담아서 이를 순회함
        2. Queue.poll한 문서의 중요도 값이 중요도 최대값(PriorityQueue.peek)보다 작다면,
            -> poll한 값을 다시 Queue에 넣어줌
           반대의 경우
            -> 문서를 프린트함 = 프린트된 문서 수(count)를 증가시키고,
               해당 인덱스가 출력 순서를 찾고자 하는 문서의 인덱스라면 이를 출력함.
     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String[] input1 = sc.nextLine().split(" ");
            int M = Integer.parseInt(input1[0]); // 문서의 개수
            int targetIndex = Integer.parseInt(input1[1]); // 타겟 인덱스


            // 문서의 중요도 정보
            String[] split = sc.nextLine().split(" ");


            Queue<Print> runningQueue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int index = 0;
            for (int j = 0; j < split.length; j++) {
                int weight = Integer.parseInt(split[j]);
                runningQueue.add(new Print(index++, weight));
                pq.add(weight);
            }

            int count = 0;
            while (!runningQueue.isEmpty()) {
                Print poll = runningQueue.poll();

                Integer max = pq.peek();

                if (poll.weight < max) {
                    runningQueue.add(poll);
                } else {
                    pq.poll();
                    count++;
                    if (poll.index == targetIndex) {
                        System.out.println(count);
                    }
                }
            }
        }

    }

    static class Print {
        int index;
        int weight;

        public Print(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

    }
}

