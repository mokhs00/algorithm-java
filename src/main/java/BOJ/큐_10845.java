package BOJ;

import java.io.*;
import java.util.LinkedList;

public class 큐_10845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        queue 구현 문제,
        가장 앞에 있는 정수와 가장 뒤에 있는 정수를 뽑아야하므로 deque
        -> LinkedList

     */
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());


        LinkedList<Integer> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");
            String command = split[0];

            if (command.equals("push")) {
                String value = split[1];
                queue.offer(Integer.parseInt(value));
                continue;
            }

            if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                sb.append(queue.pollFirst() + "\n");
                continue;
            }

            if (command.equals("size")) {
                sb.append(queue.size() + "\n");
                continue;
            }

            if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                    continue;
                }

                sb.append("0\n");
                continue;
            }

            if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                sb.append(queue.peekFirst() + "\n");
                continue;
            }

            if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                sb.append(queue.peekLast() + "\n");
                continue;
            }
        }

        bw.write(sb.toString());


        br.close();
        bw.close();
    }
}
