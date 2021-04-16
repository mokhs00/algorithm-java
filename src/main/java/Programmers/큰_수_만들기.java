package Programmers;

public class 큰_수_만들기 {
    /*
        n(number의 길이 - k)개의 숫자를 뽑으면 되는 문제.

        1. 가장 큰 숫자를 찾아 answer에 더한다.
            [현재 인덱스보다 커야하며, 그 숫자를 선택했을 때 오른쪽으로 n - 1개의 숫자가 있어야함]
        2. n--;


     */
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();


        int n = number.length() - k;
        char[] numbers = number.toCharArray();

        int left = 0;

        while (n > 0) {

            char max = '0' - 1;
            int idx = left;
            for (int i = left; i < numbers.length - n + 1; i++) {
                char now = numbers[i];

                if (now > max) {
                    max = now;
                    idx = i;
                }

            }
            left = idx + 1;
            sb.append(numbers[idx]);
            n--;

        }


        answer = sb.toString();

        return answer;
    }

}
