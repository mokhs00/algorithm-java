package BOJ;

import java.io.*;

public class 단어_뒤집기_2_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final String line = br.readLine();

        String[] split = line.split("");
        boolean isTag = false;

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < split.length; i++) {
            String current = split[i];

            if (">".equals(current)) {
                isTag = false;
                bw.append(current);
                continue;
            }

            if ("<".equals(current)) {
                isTag = true;
                sb = append(sb);
                bw.append(current);
                continue;
            }

            if (isTag) {
                bw.append(current);
                continue;
            }

            if (" ".equals(current)) {
                sb = append(sb);
                bw.append(current);
                continue;
            }

            sb.append(current);

        }
        bw.append(sb.reverse().toString());

        br.close();
        bw.close();
    }

    private static StringBuilder append(StringBuilder sb) throws IOException {
        bw.append(sb.reverse().toString());
        sb = new StringBuilder();
        return sb;
    }

}
