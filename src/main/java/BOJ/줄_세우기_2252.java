package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 줄_세우기_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        연결 정보가 주어진 N명의 학생 줄 세우기(DAG=방향성 비순환 그래프). => 위상정렬
     */

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        StringBuffer sb = new StringBuffer();

        List<List<Integer>> graph = new ArrayList<>();
        int[] linked = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int start = Integer.parseInt(input2[0]);
            int target = Integer.parseInt(input2[1]);
            linked[target] += 1;
            graph.get(start).add(target);
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < linked.length; i++) {
            if (linked[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            sb.append(current + " ");

            List<Integer> nodeList = graph.get(current);
            for (Integer node : nodeList) {
                if (--linked[node] == 0) {
                    queue.add(node);
                }
            }

        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
