package BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 회의실_배정_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // 끝나는 시간 순, 끝나는 시간이 같다면 시작 시간이 느린 순
        PriorityQueue<P> pq = new PriorityQueue<P>((o1, o2) -> {
            if (o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });


        int answer = 0;

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            pq.add(new P(s, e));
        }



        // 가능한 회의 중에서 가장 먼저 끝나는 회의를 첫 번째로 선택
        P poll1 = pq.poll();

        int time = poll1.end;
        answer++;


        while(!pq.isEmpty()){

            // 회의가 끝난 시점을 기준으로 큐에서 다음 회의를 뽑음
            // 만약 그 회의가 이미 시작 시간이 지나간 회의라면 다시 뽑음
            P poll = pq.poll();
            if (poll.start < time){
                continue;
            }

            answer++;
            time = poll.end;


        }


        System.out.println(answer);


        sc.close();

    }

    static class P{

        int start;
        int end;

        public P(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }
}
