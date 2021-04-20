package Algorithm;

public class DP_피보나치수열 {

    public static void main(String[] args) {

        int N = 5;

        int[] dp = new int[N];

        // 초기값 입력
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 1 1 2 3 5  정답은 5
        System.out.println(dp[N-1]);
    }
}
