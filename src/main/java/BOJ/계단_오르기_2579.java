package BOJ;

import java.util.Scanner;

public class 계단_오르기_2579 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] steps = new int[N];

        for (int i = 0; i < N; i++) {
            steps[i] = sc.nextInt();
        }

        int[] dp = new int[N];

        if (N < 2) {
            System.out.println(steps[0]);
            return;
        }

        if (N < 3){
            System.out.println(steps[0] + steps[1]);
            return;
        }

        dp[0] = steps[0];
        dp[1] = steps[0] + steps[1];
        dp[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);

        for (int i = 3; i < steps.length; i++) {
            dp[i] = Math.max(dp[i - 3] + steps[i - 1] + steps[i], dp[i - 2] + steps[i]);
        }

        System.out.println(dp[N - 1]);

    }
}
