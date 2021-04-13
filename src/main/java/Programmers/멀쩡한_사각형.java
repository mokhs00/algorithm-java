package Programmers;

import java.math.BigInteger;

class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        long answer = w * h;

        int i = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

        answer = answer - i * (w / i + h / i - 1);

        return answer;
    }
}