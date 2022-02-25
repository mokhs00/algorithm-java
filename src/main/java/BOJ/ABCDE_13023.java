package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ABCDE_13023 {
    /**
     * 그래프에서 연결된 친구가 연속적으로 총 4명인 경우가 있는지 찾는 문제
     * DFS 를 통해 탐색 - 양방향으로 이동 가능하므로 주의
     * stack 을 이용하면 visited 처리가 복잡함.
     * N의 수가 적당하다면, 재귀를 이용해 빠른 구현을 시도하자.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean visited[];
    static int result = 0;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        graph = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if (result == 1) {
                break;
            }
            dfs(i, 0);
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }

    public static void dfs(int current, int depth) {
        if (depth >= 4) {
            result = 1;
            return;
        }

        List<Integer> friends = graph.get(current);

        visited[current] = true;

        for (Integer friend : friends) {
            if (!visited[friend]) {
                dfs(friend, depth + 1);
            }
        }

        visited[current] = false;
    }
}
