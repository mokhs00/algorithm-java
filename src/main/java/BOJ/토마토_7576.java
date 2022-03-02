package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
    /*
    문제 : 토마토의 익은 상태가 전이되는 상황에서 전체에 전이되기 위해 걸리는 최소 시간을 출력하시오
    => BFS를 이용해 탐색하며 비용을 기록하고 전체 탐색에 필요한 비용을 출력하는 문제
    여기서 방문처리는 익은 토마토 여부로 한다 = 1이면 visited=true

    1. 익은 토마토를 queue에 추가
    2. BFS를 이용해 탐색하며 다음 과정을 따름
        1) 현재 좌표와 연결된 좌표를 이동가능한지 검사 (!isOutBound && map[y][x] == 0)
        2) 이동가능하다면 해당 좌표를 방문처리하고 cost를 기록한다.
        3) 해당 좌표를 queue에 추가한다.
    3. BFS 종료 이후에 익지 않은 토마토가 있는지 확인한다.
    4. 모든 토마토가 익은 상태라면 cost에 기록한 값들 중 최댓값을 출력한다.
     */
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int M;
    static int N;
    static int[][] map;
    static int[][] cost;


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        map = new int[N][M];
        cost = new int[N][M];

        for (int y = 0; y < N; y++) {
            String[] line = br.readLine().split(" ");
            for (int x = 0; x < line.length; x++) {
                map[y][x] = Integer.parseInt(line[x]);
            }
        }

        bfs();

        int result = calculateResult();

        bw.write(Integer.toString(result));

        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) {
                    queue.add(new Point(x, y));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.getX();
            int y = current.getY();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                boolean isOutBound = nextX < 0 || nextY < 0 || nextX >= M || nextY >= N;
                if (isOutBound) {
                    continue;
                }

                boolean isAvailable = map[nextY][nextX] == 0;
                if (isAvailable) {
                    map[nextY][nextX] = 1;
                    cost[nextY][nextX] = cost[y][x] + 1;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static int calculateResult() {
        int result = -1;
        mapLoop:
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    result = -1;
                    break mapLoop;
                }

                result = Math.max(result, cost[y][x]);
            }
        }
        return result;
    }

}


