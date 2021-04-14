package Programmers;

public class 풍선_터뜨리기 {
    public int solution(int[] a) {
        int answer = 2;

        int left = a[0];
        int right = a[a.length - 1];

        for (int i = 0; i < a.length; i++) {

            if (a[i] < left) {
                left = a[i];
                answer++;
            }

            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];
                answer++;
            }

            if (left == right) {
                return answer - 1;
            }

        }
        return answer;
    }
}
