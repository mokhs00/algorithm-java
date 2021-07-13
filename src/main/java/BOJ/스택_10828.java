package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            String command = split[0];

            if (command.equals("push")) {
                stack.push(Integer.parseInt(split[1]));
                continue;
            }

            if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                Integer pop = stack.pop();
                System.out.println(pop);
                continue;
            }


            if (command.equals("size")) {
                System.out.println(stack.size());
                continue;
            }

            if (command.equals("empty")) {
                if (stack.empty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }

            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
                continue;
            }


        }


    }
}
