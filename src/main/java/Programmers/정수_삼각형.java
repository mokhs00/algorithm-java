package Programmers;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                int a = dp[i - 1][j];
                int b = a;
                if (j > 0) {
                    a = dp[i - 1][j - 1];
                }

                dp[i][j] = Math.max(a, b) + triangle[i][j];
            }
        }

        int max = 0;

        for (int i : dp[dp.length - 1]) {
            if (max < i) {
                max = i;
            }
        }


        return max;
    }
}
