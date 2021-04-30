package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수_찾기_1978 {
    /*
        에라토스테네스의 체
        M부터 N까지의 소수를 구할 때
        i -> N의 제곱근까지 반복해서
        i의 배수를 모두 true 처리 함

        true인 경우 count++
     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        final int MAX = 1000;

        boolean[] answer = new boolean[MAX + 1];
        answer[1] = true;


        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            for (int j = 2; j * i <= MAX; j++) {
                int k = j * i;
                answer[k] = true;
            }
        }

        int count = 0;

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(s[i]);
            if (!answer[num]) {
                count++;
            }
        }

        System.out.println(count);


        br.close();
    }


}
