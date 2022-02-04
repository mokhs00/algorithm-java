package BOJ;

import java.io.*;

public class 수_이어_쓰기_1_1748 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        /**
         * 1~N까지 탐색 시 메모리 초과. -> 작업량을 줄여야함
         * 각 자리수를 가지고 있는 숫자의 개수를 구하면 작업량을 줄일 수 있음
         * ex) 1의 자리숫자를 가지고 있는 수는 1~N까지,
         *     10의 자리숫자를 가지고 있는 수는 10~N까지,
         *     100의 자리숫자를 가지고 있는 수는 100~N까지
         * 예시를 통해 알 수 있듯이 i자리 숫자를 가지고 있는 수는 i~N까지이다.
         * 즉 i자리 숫자를 가지고 있는 수는 (N - i + 1)개가 된다.
         * 이를 이용해 풀이한다.
         */

        final long N = Integer.parseInt(br.readLine());

        long result = 0;
        long i = 1;

        while (i <= N) {
            result += N - i + 1;
            i *= 10;
        }

        bw.write(Long.toString(result));

        br.close();
        bw.close();
    }
}
