package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class 에디터_1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String line = br.readLine();
        String[] inputs = line.split("");

        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(Arrays.asList(inputs));

        int cursorIndex = linkedList.size();


        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");

            if (split[0].equals("L")) {
                if (cursorIndex <= 0) {
                    continue;
                }

                cursorIndex--;
            }

            if (split[0].equals("D")) {
                if (cursorIndex >= linkedList.size()) {
                    continue;
                }

                cursorIndex++;
            }

            if (split[0].equals("B")) {
                if (cursorIndex <= 0) {
                    continue;
                }

                int targetIndex = cursorIndex - 1;
                linkedList.remove(targetIndex);

                cursorIndex--;

                continue;
            }

            if (split[0].equals("P")) {
                String value = split[1];

                int targetIndex = cursorIndex;
                linkedList.add(targetIndex, value);

                cursorIndex++;
            }


        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < linkedList.size(); i++) {
            sb.append(linkedList.get(i));
        }

        System.out.println(sb.toString());

        br.close();
        bw.close();
    }
}
