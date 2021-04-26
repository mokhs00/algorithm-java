package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/2504
public class 괄호의_값_2504 {
    /*

        Stack을 이용해 괄호의 쌍이 맞는지 확인하고,
        곱셉 법칙을 이용한다
        곱할 값으로 temp 값을 둔다. 자세한 설명은 다음과 같다.
        ( or [가 나오면 2 or 3을 temp에 곱하고
        ) or ]가 나오면 temp를 answer에 더해주고 temp를 2 or 3으로 나눈다.

        *단. ) or ]이 연속으로 나오는 상황, 즉 answer에 값을 더해줘야하는 상황이 연속적으로 나온다면,
        temp를 answer에 더해주지 않는다.

        *마지막에 stack이 비어있지 않다면 이는 올바른 괄호쌍이 아니므로 answer = 0 으로 처리해준다.

     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char[] chars = input.toCharArray();


        int answer = 0;
        int temp = 1;

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];

            if (now == '(') {
                stack.add(now);
                temp *= 2;
                continue;
            }
            if (now == '[') {
                stack.add(now);
                temp *= 3;
                continue;
            }

            // 빼야할 때
            if (stack.isEmpty()) {
                answer = 0;
                break;
            }

            Character pop = stack.pop();

            if (now == ')') {
                if (pop != '(') {
                    answer = 0;
                    break;
                }
                if (!(chars[i - 1] == ')' || chars[i - 1] == ']'))
                    answer += temp;
                temp /= 2;


            }

            if (now == ']') {
                if (pop != '[') {
                    answer = 0;
                    break;
                }
                if (!(chars[i - 1] == ')' || chars[i - 1] == ']'))
                    answer += temp;
                temp /= 3;


            }
        }
        if (!stack.isEmpty()) {
            answer = 0;
        }

        System.out.println(answer);
    }


}

