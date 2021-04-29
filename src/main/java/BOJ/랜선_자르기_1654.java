package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1654
public class 랜선_자르기_1654 {
    /*
        자를 랜선의 길이를 mid로 두고 이분 탐색을 진행한다.

        *중요
        랜선의 길이의 범위가 int를 초과함을 주의한다.
        실수로 "2^31-1이라서 int는 32bit니까 2^31-1? 되겠네"라고 생각해서 삽질했다.
        java에서 int는 범위가 (음의 범위 + 0 + 양의 범위)이므로 양의 범위로는 2^16-1까지 되는 것....
        (수면 부족은 치명적..)

     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] lines = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }


        long left = 0;
        long right = Integer.MAX_VALUE;

        long mid = 0;


        while (left <= right) {
            int count = 0;
            mid = (left + right) / 2;


            for (int i = 0; i < lines.length; i++) {
                count += lines[i] / mid;
            }

            if (count >= N) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
