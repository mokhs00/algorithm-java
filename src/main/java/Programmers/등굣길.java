package Programmers;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];


        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[y - 1][x - 1] = -1;
        }
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0)
                    continue;
                // isPuddle
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                int a = 0;
                if (i > 0)
                    a = dp[i - 1][j];
                int b = 0;
                if (j > 0)
                    b = dp[i][j - 1];

                dp[i][j] = (a + b) % 1000000007;
            }
        }
        for (int[] ints : dp) {

        }

        return dp[n - 1][m - 1];
    }

}
