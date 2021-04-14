package Programmers;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            String[] split = s.split("0");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s1 : split) {
                stringBuilder.append(s1);
            }
            String next = stringBuilder.toString();

            long nextInt = next.length();
            answer[1] += s.length() - next.length();
            answer[0]++;

            s = Long.toBinaryString(nextInt);


        }
        return answer;
    }
}
