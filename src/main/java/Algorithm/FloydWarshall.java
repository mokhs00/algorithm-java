package Algorithm;

import java.util.Arrays;

public class FloydWarshall {

    static final int N = 4;
    // INF : 이동 불가능 = 비용의 최대값 + 1로 초기화
    static final int INF = 100001;

    int dp[][];

    public void init(int[][] costs) {
        dp = new int[N][N];

        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                dp[i][j] = costs[i][j];
            }
        }


    }


    public void run() {

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                for (int c = 0; c < N; c++) {
                    dp[a][b] = Math.min(dp[a][b], dp[a][c] + dp[c][b]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        FloydWarshall floydWarshall = new FloydWarshall();
        int[][] costs = {
                {0, 5, INF, 8},
                {7, 0, 9, INF},
                {2, INF, 0, 4},
                {INF, INF, 3, 0}
        };


        /*
            0   5   11  8
            7   0   9   13
            2   7   0   4
            5   10  3   0

            이 나옴
         */

        floydWarshall.init(costs);
        floydWarshall.run();

    }

}
