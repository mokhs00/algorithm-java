package BOJ;

import java.io.*;

public class 날짜_계산_1476 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        final int E = Integer.parseInt(inputs[0]) - 1; // 1 ~ 15
        final int S = Integer.parseInt(inputs[1]) - 1; // 1 ~ 28
        final int M = Integer.parseInt(inputs[2]) - 1; // 1 ~ 19

        long result = 0;

        while (true) {
            if (result % 15 == E && result % 28 == S && result % 19 == M) {
                break;
            }
            result++;
        }

        bw.write(Long.toString(result + 1));

        br.close();
        bw.close();
    }
}
