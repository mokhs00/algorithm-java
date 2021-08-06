package BOJ;

import java.io.*;

public class 차량_번호판_1_16968 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        번호판의 길이는 최대 4
        cd, dd 이런 식으로 주어짐
        각각 의미하는 바는 다음과 같음
            d -> 숫자  -> 0~9 총 10가지
            c -> 문자  -> a~z 총 26가지
            dd - > 10 * 9

        *같은 문자 or 숫자가 연속해서 2번 나타나면 안됨!

        앞에 꺼랑 같은 거면
     */

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        long answer = 0;

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (i == 0) {
                if (chars[i] == 'd') {
                    answer += getTotalCount(chars[i]);
                } else if (chars[i] == 'c') {
                    answer += getTotalCount(chars[i]);
                }

                continue;
            }

            if (chars[i] == chars[i - 1]) {
                answer *= getTotalCount(chars[i]) - 1;
            } else {
                answer *= getTotalCount(chars[i]);
            }
        }

        bw.write(Long.toString(answer));

        br.close();
        bw.close();
    }


    public static int getTotalCount(char k) {
        int dTotalCount = 10;
        int cTotalCount = 26;

        if (k == 'd') {
            return dTotalCount;
        }

        if (k == 'c') {
            return cTotalCount;
        }
        return 0;
    }

}
