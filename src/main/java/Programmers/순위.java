package Programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
public class 순위 {

    /*
        탐색을 통해 순위를 매길 수 없는 사람을 골라내는 문제,
        A의 순위를 매길 수 있는 경우 : A에 대하여 A를 제외한 모든 선수들과의 전적에 방향성이 있어야함
            여기서 방향성이란?
                = A가 B에게 진다면 -1, A가 C에게 이긴다면 1
            결론적으로, A와 다른 선수 간에 방향성이 정해지지 않는 경우가 있다면,
            A의 순위를 정할 수 없음
        --
        전체 탐색을 통해 방향성을 설정해야함.
        방향성을 설정한다 -> 비용이 존재해야함 (-1, +1)

        ex) A에서 바로 B로는 갈 수 없지만, C를 거쳐 B로는 갈 수 있다면,
            A에서 B로 가는 방향(-1)과 C에서 B로가는 방향(-1)이 일치한다면
            (=A, B, C만 있는 상황에서 A는 B, C에게 지고, C도 B에게 진다. -> A는 B에게 진다.
              만약 C가 B에게 이긴다면 순서를 정할 수 없는 상황에 된다.
              즉 같은 방향성을 지녀야한다.)

            따라서, 초기 데이터를 가지고 각각에 맞게 비용을 (INF, 1, -1)로 초기화를 해둔 뒤
            순회하면서 비용이 i에서 j로 가는 비용이 INF라면,
                i에서 k를 거쳐 j로 갈 수 있는 경우,
                i에서 k로 가는 비용(방향)과 k에서 j로 가는 비용(방향)이 일치할 때
                해당 방향으로 i에서 j로 가는 비용을 설정한다.

            이는 플로이드 워셜 알고리즘의 순회 방식과 유사하다.
            노드 수가 적으므로 플로이드 워셜 알고리즘의 시간복잡도 O(n^3)를 통과할 수 있다.

     */
    public int solution(int n, int[][] results) {
        int answer = n;
        final int INF = 101;

        int[][] graph = new int[n + 1][n + 1];

        for (int[] ints : graph) {
            Arrays.fill(ints, INF);
        }

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] == INF) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                        if (graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == INF) {
                    answer--;
                    break;
                }
            }
        }


        return answer;
    }
}
