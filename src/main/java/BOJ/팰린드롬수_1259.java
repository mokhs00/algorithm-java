package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/1259

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            StringBuilder sb = new StringBuilder(input);
            String reverse = sb.reverse().toString();


            if (reverse.equals(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }

    }
}
