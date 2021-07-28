package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 오등큰수_17299 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
        F()는 등장한 횟수

        answer stack, temp stack 두고
        map에 F()를 담음

        역순회 하면서 temp를 활용

        temp가 비어있지 않다면, F가 더 작다면 계속 pop

        pop 이후에 stack에 남은 값이 있다면 해당 값을 answer에 push

        없으면 -1를 answer에  push(= temp가 비어있다면 answer.push("-1"))


        temp에 현재값(current)을 담음

     */


    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        Stack<String> answer = new Stack<>();
        Stack<String> temp = new Stack<>();

        Map<String, Integer> F = new HashMap<>();

        String[] line = br.readLine().split(" ");
        for (String l : line) {
            Integer get = F.getOrDefault(l, 0);
            F.put(l, get + 1);
        }


        for (int i = line.length - 1; i >= 0; i--) {
            String current = line[i];

            while (!temp.isEmpty() && F.get(current) >= F.get(temp.peek())) {
                temp.pop();
            }

            if (temp.isEmpty()) {
                answer.push("-1");
            } else {
                answer.push(temp.peek());
            }

            temp.push(current);
        }


        while (!answer.isEmpty()) {
            sb.append(answer.pop() + " ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}



