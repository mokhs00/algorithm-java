package BOJ;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class 괄호_9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int i = Integer.parseInt(br.readLine());

        main:
        for (int h = 0; h < i; h++) {
            Stack<String> stack = new Stack<>();

            String input = br.readLine();
            String[] split = input.split("");

            for (int k = 0; k < split.length; k++) {
                String cur = split[k];

                if (cur.equals("(")) {
                    stack.add("(");
                    continue;
                }

                if (cur.equals(")")) {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        continue main;
                    }

                    stack.pop();
                }

            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        br.close();
        bw.close();
    }
}
