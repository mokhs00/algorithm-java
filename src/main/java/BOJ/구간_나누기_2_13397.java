package BOJ;

import java.util.Scanner;

// https://www.acmicpc.net/problem/13397
public class 구간_나누기_2_13397 {
    /*
        이분 탐색
        구간의 점수를 mid로 주고 이분 탐색
        구간의 수가 M 보다 작으면 right = mid -1;
        반대로 M 이상이면 left = mid + 1;

     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            int count = 0;
            int k = -1; // 구간 합
            int max = arr[0]; // 구간의 최대 값
            int min = arr[0]; // 구간의 최소 값

            for (int i = 0; i < arr.length; i++) {
                int now = arr[i];

                if (now < min) {
                    min = now;
                }
                if (now > max) {
                    max = now;
                }
                k = max - min;

                if (k >= mid) {
                    count++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            if (count < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
