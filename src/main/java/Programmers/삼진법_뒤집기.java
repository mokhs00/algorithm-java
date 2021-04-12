package Programmers;

public class 삼진법_뒤집기 {
    public int solution(int n) {
        int answer;
        String a = "";

        while (n > 0) {
            int m = n % 3;
            n /= 3;
            a += Integer.toString(m);
        }

        answer = Integer.parseInt(a, 3);

        return answer;

    }
}
