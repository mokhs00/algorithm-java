package Programmers;

public class N으로_표현 {
    int answer = 9;

    public int solution(int N, int number) {

        perm(N, number, 0, 0);

        if (answer >= 9)
            return -1;

        return answer;
    }

    public void perm(int N, int number, int count, int now) {

        if (now == number || count >= 9) {
            if (answer > count) {
                answer = count;
            }
            return;
        }

        int num = N;
        for (int i = 0; i < 8 - count; i++) {
            int temp = count + i + 1;
            perm(N, number, temp, now + num);
            perm(N, number, temp, now - num);
            perm(N, number, temp, now / num);
            perm(N, number, temp, now * num);

            num = num * 10 + N;
        }


    }
}
