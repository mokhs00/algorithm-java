package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 후위_표기식2_1935 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    /*
         후위 표기식 계산 구현. 숫자 크기에 주의

     */

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> values = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        String line = br.readLine();
        char[] split = line.toCharArray();

        char key = 'A';
        for (int i = 0; i < N; i++) {
            Integer v = Integer.parseInt(br.readLine());

            values.put(key++, v);
        }


        for (int i = 0; i < split.length; i++) {
            Character now = split[i];

            Integer value = values.get(now);

            if (value == null) {
                Double a = stack.pop();
                Double b = stack.pop();

                Double k = calculate(String.valueOf(now), b, a);
                stack.push(k);
            } else {
                stack.push(Double.valueOf(value));
            }
        }

        Double answer = stack.pop();

        pw.printf("%.2f", answer);

        pw.flush();
        pw.close();
        br.close();
    }

    private static Double calculate(String now, Double a, Double b) {

        if (now.equals("*")) {
            return a * b;
        } else if (now.equals("/")) {
            return a / b;
        } else if (now.equals("+")) {
            return a + b;
        } else if (now.equals("-")) {
            return a - b;
        }

        throw new RuntimeException("잘못된 입력");
    }


}
