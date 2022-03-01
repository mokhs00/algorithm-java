package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 미로_탐색_2178 {
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
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int[][] map;
    static int[][] cost;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        cost = new int[N][M];

        for (int y = 0; y < N; y++) {
            String[] split = br.readLine().split("");
            for (int x = 0; x < split.length; x++) {
                map[y][x] = Integer.parseInt(split[x]);
            }
        }

        cost[0][0] = 1;
        bfs(0, 0);
        result = cost[N - 1][M - 1];

        bw.write(Integer.toString(result));

        bw.close();
        br.close();
    }


    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.getX();
            int currentY = current.getY();

            for (int i = 0; i < 4; i++) {

                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                boolean isOutBound = nextX < 0 || nextY < 0 || nextX >= M || nextY >= N;
                if (isOutBound) {
                    continue;
                }

                boolean isVisited = map[nextY][nextX] == 0;
                if (isVisited) {
                    continue;
                }

                queue.add(new Point(nextX, nextY));

                map[nextY][nextX] = 0;
                cost[nextY][nextX] = cost[currentY][currentX] + 1;
            }
        }
    }
}
