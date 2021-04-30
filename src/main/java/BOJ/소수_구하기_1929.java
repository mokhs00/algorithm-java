package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1929
public class 소수_구하기_1929 {
    /*
        에라토스테네스의 체
        M부터 N까지의 소수를 구할 때
        i -> N의 제곱근까지 반복해서
        i의 배수를 모두 true 처리 함
        M~N까지 true인 경우 출력하면 됨.
     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] answer = new boolean[N + 1];
        answer[1] = true;


        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = 2; j * i <= N; j++) {
                int k = j * i;
                answer[k] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!answer[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}
