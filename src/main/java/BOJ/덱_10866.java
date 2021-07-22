package BOJ;

import java.io.*;
import java.util.LinkedList;

public class 덱_10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        final LinkedList<String> dequeue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];


            if ("push_front".equals(command)) {
                String value = inputs[1];

                dequeue.addFirst(value);
                continue;
            }


            if ("push_back".equals(command)) {
                String value = inputs[1];

                dequeue.addLast(value);
                continue;
            }

            if ("pop_front".equals(command)) {

                if (dequeue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                String value = dequeue.pollFirst();

                sb.append(value + "\n");
                continue;
            }

            if ("pop_back".equals(command)) {
                if (dequeue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                String value = dequeue.pollLast();

                sb.append(value + "\n");
                continue;
            }

            if ("size".equals(command)) {
                sb.append(dequeue.size() + "\n");
                continue;
            }

            if ("empty".equals(command)) {
                if (dequeue.isEmpty()) {
                    sb.append("1\n");
                    continue;
                }

                sb.append("0\n");
                continue;
            }

            if ("front".equals(command)) {

                if (dequeue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                String value = dequeue.peekFirst();

                sb.append(value + "\n");
                continue;
            }

            if ("back".equals(command)) {

                if (dequeue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                String value = dequeue.peekLast();

                sb.append(value + "\n");
                continue;
            }

        }

        bw.write(sb.toString());


        br.close();
        bw.close();
    }

}
