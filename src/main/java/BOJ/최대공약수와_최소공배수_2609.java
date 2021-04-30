package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2609
public class 최대공약수와_최소공배수_2609 {
    /*
        최대 공약수를 구하고
        최소 공배수를 구한다 -> A * B / gcd

     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int max = Math.max(A, B);
        int min = Math.min(A, B);


        while (min > 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }

        System.out.println(max);
        System.out.println(A * B / max);

        br.close();
    }


}



