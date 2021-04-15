package Programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 지형_이동 {
    boolean[][] visited;
    int cost;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] land, int height) {
        int answer = 0;
        visited = new boolean[land.length][land.length];

        Queue<P> queue = new LinkedList<>();
        // 사다리를 놓고 지나갈 수 있는 위치
        PriorityQueue<P> priorityQueue = new PriorityQueue<>();

        queue.add(new P(0, 0, 0));

        while (!queue.isEmpty()) {
            P poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;
            if (!visited[nowY][nowX]) {
                for (int i = 0; i < 4; i++) {
                    int tempX = nowX + dx[i];
                    int tempY = nowY + dy[i];
                    if (tempX < 0 || tempX >= land.length || tempY < 0 || tempY >= land.length) {
                        continue;
                    }

                    int cost = Math.abs(land[nowY][nowX] - land[tempY][tempX]);
                    if (!visited[tempY][tempX]) {
                        // 만약 사다리를 설치해야한다면 큐에 넣지 않고 우선순위 큐에 넣음 -> 사다리를 놓을 수 있는 위치 기록
                        if (cost > height) {
                            priorityQueue.add(new P(tempX, tempY, cost));
                            continue;
                        }
                        // 방문되지 않았다면 큐에 추가해줌.
                        queue.add(new P(tempX, tempY, cost));
                    }
                }
            }
            visited[nowY][nowX] = true;


            if (queue.isEmpty()) {
                while (!priorityQueue.isEmpty()) {
                    P pqPoll = priorityQueue.poll();
                    int pqTempX = pqPoll.x;
                    int pqTempY = pqPoll.y;
                    // 방문되지 않았다면 큐에 넣어주고 비용 기록
                    if (!visited[pqTempY][pqTempX]) {
                        queue.add(new P(pqTempX, pqTempY, 0));
                        answer += pqPoll.c;
                        break;
                    }


                }
            }

        }


        return answer;
    }

    class P implements Comparable<P> {
        int x;
        int y;
        int c;

        public P(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return this.c - o.c;
        }

    }

}
