package BOJ;

import java.io.*;

public class _123_더하기_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int T = Integer.parseInt(br.readLine());
        final int MAX_N = 10;

        int[] memo = new int[MAX_N + 1];

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i <= MAX_N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(memo[n] + "\n");
        }


        br.close();
        bw.close();
    }
}
