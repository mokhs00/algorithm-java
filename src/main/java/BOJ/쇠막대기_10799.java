package BOJ;

import java.io.*;
import java.util.Stack;

public class 쇠막대기_10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        스택을 이용.
        1. '(' 쌓고 ')' 만나면 pop -> stack.size() = 막대의 개수
        2. prev가 '('이고 현재 값이 ')' 이면 stack.pop() 후에 stack.size()를 더함
            아닐 때, stack.pop() 후에 +1
     */


    public static void main(String[] args) throws IOException {
        final String line = br.readLine();
        String[] split = line.split("");

        Stack<String> stack = new Stack<>();
        String prev = "";
        int answer = 0;

        for (int i = 0; i < split.length; i++) {
            String current = split[i];

            if (current.equals("(")) {
                stack.push(current);
            }

            if (current.equals(")")) {
                stack.pop();

                if (prev.equals("(")) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }


            prev = current;
        }

        bw.write(Integer.toString(answer));

        br.close();
        bw.close();
    }


}
