package BOJ;

import java.io.*;
import java.util.Stack;

public class 후위_표기식_1918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        중위 표기식 -> 후위 표기식 변환
        1. 문자가 나오면 sb.append
        2. 여는 괄호가 나오면 스택에 추가
        3. 닫는 괄호가 나오면 여는 괄호가 나올 때까지 스택에서 pop 하고 sb.append(pop)
        4. 연산자가 나오면 stack.peek보다 우선순위가 낮다면 지속해서
           스택에서 pop 하고 sb.append(pop) 이후 연산자를 push
     */


    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        char[] arr = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();


        for (int i = 0; i < arr.length; i++) {
            char now = arr[i];


            if (now >= 'A' && now <= 'Z') {
                answer.append(now);
                continue;
            }

            if (now == '(') {
                stack.push(now);
                continue;
            } else if (now == ')') {
                while (stack.peek() != '(') {
                    Character pop = stack.pop();
                    answer.append(pop);
                }
                stack.pop();
                continue;
            }

            while (!stack.isEmpty() && getOperatorRank(now) <= getOperatorRank(stack.peek())) {
                Character pop = stack.pop();
                answer.append(pop);
            }

            stack.push(now);

        }

        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            answer.append(pop);
        }


        bw.write(answer.toString());


        br.close();
        bw.close();
    }


    public static int getOperatorRank(char operator) {
        if (operator == '*') {
            return 3;
        } else if (operator == '/') {
            return 3;
        } else if (operator == '+') {
            return 2;
        } else if (operator == '-') {
            return 2;
        }

        return 1;
    }

}

