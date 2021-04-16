package BOJ;

import java.util.Scanner;

public class 구간_합_구하기_4_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        int[] d = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        d[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            d[i] = arr[i] + d[i - 1];
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(d[j - 1] - d[i - 1] + arr[i]);
        }


    }


}
