package BOJ;

import java.io.*;

// https://www.acmicpc.net/problem/9093
public class 단어_뒤짚기_9093 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length; j++) {
                StringBuilder tempSb = new StringBuilder();
                sb.append(tempSb.append(s[j]).reverse().append(" "));
            }
            bw.write(sb.toString() + "\n");

        }

        br.close();
        bw.close();
    }
}
