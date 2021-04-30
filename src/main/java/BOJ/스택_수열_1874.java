package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class 스택_수열_1874 {
    /*
        *StringBuilder를 사용하면 출력 시간 단축
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }


        Stack<Integer> stack = new Stack<>();

        int now = 1;

        for (int i = 1; i <= N; i++) {

            stack.add(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek() == inputs[now]) {
                stack.pop();
                sb.append("-\n");
                now++;
            }


        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb.toString());
    }
}
