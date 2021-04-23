package BOJ;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class 괄호_9012 {
    /*
        ( 일때 스택에 넣고
        ) 일때는 스택에서 빼야함
            -> 스택이 비어 있다면 false

    */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();

            char[] chars = input.toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isVPS = true;

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(') {
                    stack.add(chars[j]);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    stack.pop();
                }
            }
            String answer = "";

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            if (isVPS)
                answer = "YES";
            else
                answer = "NO";

            System.out.println(answer);
        }

    }
}
