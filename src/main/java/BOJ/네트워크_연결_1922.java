package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/1922
public class 네트워크_연결_1922 {
    /*
        최소 스패닝 트리 만들기
        간선을 정보를 비용 순으로 정렬하고
        UnionFind 이용하여 이미 연결되어 있다면 패스
        연결되어 있지 않다면 연결해주고 비용 추가
     */

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[M][3];

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(split[0]);
            graph[i][1] = Integer.parseInt(split[1]);
            graph[i][2] = Integer.parseInt(split[2]);
        }
        parents = new int[N + 1];

        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        // 비용 오름차순 정렬
        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            int cost = graph[i][2];

            int parentA = getParent(a);
            int parentB = getParent(b);

            if (parentA != parentB) {
                if (parentA < parentB) {
                    parents[parentB] = parentA;
                } else
                    parents[parentA] = parentB;
                answer += cost;
            }
        }

        System.out.println(answer);

    }

    public static int getParent(int child) {
        if (parents[child] == child)
            return child;
        else
            return getParent(parents[child]);
    }

}
