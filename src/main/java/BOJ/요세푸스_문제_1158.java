package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class 요세푸스_문제_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final String[] inputs = br.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int K = Integer.parseInt(inputs[1]);

        ArrayList<String> answerList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        int currentIndex = 0;

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            currentIndex = (currentIndex + K - 1) % list.size();
            Integer value = list.get(currentIndex);
            answerList.add(value.toString());

            list.remove(currentIndex);
        }

        String join = String.join(", ", answerList);
        join = "<" + join + ">";

        bw.write(join);

        br.close();
        bw.close();
    }
}
