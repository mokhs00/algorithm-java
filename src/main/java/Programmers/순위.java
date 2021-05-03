package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
public class 순위 {

    /*
        1~n번까지 n명의 선수가 있음.

        정확하게 순위를 매길 수 있는 선수의 수를 return

        순위를 매기는 법 : A 선수가 B 선수보다 실력이 좋다면
                         A 선수는 B 선수를 항상 이김.

        방향성이 있는 노드 간의 관계 -> 그래프 문제

        ex) 4의 기준..
        4의 기준으로 2는 4보다 아래지만, 2에게 이기는 1은 4와의 경기 경과가 없으면 순위를 매길 수가 없음.
        -> 4에게 지는 사람(k)가 있으면 k에게 지는 사람들은 4기준으로 순위를 매길 수가 있음.
           반대로 4에게 이기는 사람(L)이 있으면 L에게 이기는 사람들은 4기준으로 순위를 매길 수 있음.

        순위를 매길 수 없는 경우 : 이기거나 지는 방향성이 다른 경우

        알고리즘 :
        노드 간의 간선의 비용(이기면 1, 지면 -1)를 설정하고,
        그래프를 탐색하면서 A에서 B로 가는 비용의 방향성을 기록함.
        A에서 B로가는 비용을 측정 불가능하고,
        A에서 K로 가는 비용이 1이고 K에서 B로 가는 비용이 1이면
        A에서 B로 가는 비용은 1이 됨.
        비용은 모두 구해서 메모한 뒤에
        비용을 측정할 수 없는 경우를 제외하고 경우의 수를 셈

        모든 노드에서 모든 노드로 가는 정보를 기록해야하고,
        노드의 수가 100개 이하이므로 플로이드 워셜 사용

        -------------------------------------------------------------------
        피드백
        시간 소요 : 20분
        안 좋은 습관 : 간선의 정보를 두번 기록함.
        results 배열에 간선의 정보가 담겨져서 제공되는데
        이를 graph라는 행렬에 다시 기록함..
        제출하고 나서 원하는대로 안 나오자 print 찍어보고 알아냄

     */

    static final int INF = 0; // 순위를 매길 수 없음.

    public int solution(int n, int[][] results) {
        int answer = 0;
        // 거리
        int[][] d = new int[n + 1][n + 1];

        for (int[] result : results) {
            int a = result[0];
            int b = result[1];
            d[a][b] = 1;
            d[b][a] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] == INF) {
                        if (d[i][k] == d[k][j]) {
                            d[i][j] = d[i][k];
                        }
                    }

                }
            }
        }

        answer = n;

        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[i].length; j++) {
                if (i != j && d[i][j] == INF) {
                    answer--;
                    break;
                }
            }
        }


        return answer;
    }
}