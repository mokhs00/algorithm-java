package Algorithm;

import java.util.Arrays;

public class 에라토스테네스의_체 {

    public static void main(String[] args) {
        int N = 120;

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                int k = 2;
                while (i * k <= N) {
                    isPrime[i * k] = false;
                    k++;
                }
            }
        }
        System.out.println("2 : " + isPrime[2]);
        System.out.println("4 : " + isPrime[4]);
        System.out.println("13 : " + isPrime[13]);
    }
}
