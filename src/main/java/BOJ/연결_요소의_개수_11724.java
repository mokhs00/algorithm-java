package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연결_요소의_개수_11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        연결 요소(Connected Component) 수는 연결된 덩어리의 수를 의미
        따라서 전체 노드를 순회하며, 해당 노드를 시작으로하는 그래프 탐색을 통해 각 노드를 방문처리하고,
        방문처리되지 않은 노드가 있을 때 연결 요소의 수를 카운트한다.

        주의*
        방향이 없는 그래프이므로 다음 연결 노드로의 이동 전에 방문처리를 해야 무한루프에 빠지지 않을 수 있다.

     */
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[N + 1];
        int result = 0;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] connectInfo = br.readLine().split(" ");
            int u = Integer.parseInt(connectInfo[0]);
            int v = Integer.parseInt(connectInfo[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            result += 1;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                visited[current] = true;

                for (Integer node : graph.get(current)) {
                    if (!visited[node]) {
                        visited[node] = true;
                        queue.add(node);
                    }
                }
            }
        }


        bw.write(Integer.toString(result));

        bw.close();
        br.close();
    }
}


