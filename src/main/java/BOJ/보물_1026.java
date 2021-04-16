package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 보물_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);


        for (int i = 0; i < N; i++) {
            answer += arr1[i] * arr2[N - i - 1];

        }

        System.out.println(answer);

    }


}
