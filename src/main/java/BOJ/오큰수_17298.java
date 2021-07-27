package BOJ;

import java.io.*;
import java.util.Stack;

public class 오큰수_17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        Ai -> i번째 수
        Ai의 오큰수 NGE(i) : 오른쪽에 있으면서 Ai보다 큰 수 중에 가장 왼쪽에 있는 수

        완전 탐색 시 N^2이므로 1초 초과

        오른쪽부터 왼쪽으로 스택을 이용한 탐색
        스택에는 가장 오른쪽 수가 초기값을 들어가있음.

        스택에는 다음 값이 들어감
        - 현재 값 < 이전 값(오른쪽) -> sb.append(stack.peek() + " ") 해주고 스택에 넣음
        - 현재 값 > 이전 값(오른쪽) -> stack을 탐색하면서 이전 값이 작을 동안 stack.pop 해줌
          이전 값이 더 큰 경우를 찾으면 해당 값을 sb.append 해주고 stack에 현재 값을 넣음
          못 찾으면 sb.append("-1 ") 해주고 stack에 현재 값을 넣음

     */

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());
        String[] lines = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        // init
        answer.push(-1);
        stack.push(Integer.parseInt(lines[lines.length - 1]));

        for (int i = lines.length - 2; i >= 0; i--) {
            int current = Integer.parseInt(lines[i]);
            Integer right = stack.peek();

            if (current < right) {
                answer.push(right);
                stack.push(current);
                continue;
            }

            stack.pop();

            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (current >= peek) {
                    stack.pop();
                } else {
                    answer.push(peek);
                    break;
                }
            }

            if (stack.isEmpty()) {
                answer.push(-1);
                stack.push(current);
                continue;
            }

            stack.push(current);

        }

        while (!answer.isEmpty()) {
            Integer pop = answer.pop();
            sb.append(pop + " ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }


}
