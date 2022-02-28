package BOJ;

import java.io.*;
import java.util.PriorityQueue;

public class 단지번호붙이기_2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder resultStringBuilder = new StringBuilder();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            String[] split = br.readLine().split("");
            for (int x = 0; x < split.length; x++) {
                map[y][x] = Integer.parseInt(split[x]);
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) {
                    priorityQueue.add(bfs(x, y));
                }
            }
        }


        resultStringBuilder.append(priorityQueue.size() + "\n");

        while (!priorityQueue.isEmpty()) {
            resultStringBuilder.append(priorityQueue.poll() + "\n");
        }


        bw.write(resultStringBuilder.toString());

        bw.close();
        br.close();
    }


    static int bfs(int x, int y) {
        boolean isOutBound = x < 0 || y < 0 || x >= N || y >= N;
        if (isOutBound) {
            return 0;
        }

        boolean isVisited = map[y][x] == 0;
        if (isVisited) {
            return 0;
        }

        map[y][x] = 0;

        return 1 + bfs(x + 1, y) + bfs(x - 1, y) + bfs(x, y + 1) + bfs(x, y - 1);
    }
}
