package BOJ;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class 스택_수열_1874 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int nextNum = 1;

        Stack<Integer> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());


            while (nextNum <= input) {
                stack.push(nextNum++);
                sb.append("+\n");
            }

            if (stack.peek() == input) {
                stack.pop();
                sb.append("-\n");
            }

        }

        if (!stack.isEmpty()) {
            sb = new StringBuffer("NO");
        }
        bw.write(sb.toString());


        br.close();
        bw.close();
    }
}
