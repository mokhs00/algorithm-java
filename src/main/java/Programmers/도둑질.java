package Programmers;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        int N = money.length;

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];


        // 첫번째 집을 턴 경우 = 마지막 집을 못 텀
        dp1[0] = money[0];
        dp1[1] = money[0];
        dp1[2] = money[0];


        // 첫번째 집을 털지 않은 경우 = 마지막 집을 털 수 있음.
        dp2[0] = 0;
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);

        for (int i = 3; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i - 1], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        answer = Math.max(dp1[N - 1], dp2[N - 1]);

        return answer;
    }
}
