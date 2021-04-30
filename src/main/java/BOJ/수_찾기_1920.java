package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 수_찾기_1920 {

    /*
        이진탐색
        solution1 : 이진탐색 구현
        solution2 : Arrays.binarySearch 이용
        solution3 : HashSet.contains 이용
     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {


        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];


        String[] inputs1 = br.readLine().split(" ");
        for (int i = 0; i < inputs1.length; i++) {
            arr[i] = Long.parseLong(inputs1[i]);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");


        long[] inputs2 = new long[M];

        for (int i = 0; i < M; i++) {
            inputs2[i] = Long.parseLong(s[i]);
        }

//        solution1(N, arr, M, inputs2);
        solution2(N, arr, M, inputs2);
//        solution3(N, arr, M, inputs2);


    }

    public static void solution1(int N, long[] arr, int M, long[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            long l = inputs[i];

            int left = 0;
            int right = N - 1;
            int mid = 0;

            while (left <= right) {
                mid = (left + right) / 2;

                long value = arr[mid];

                if (value == l) {
                    break;
                }
                if (value < l) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (arr[mid] == l) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }


        }

        System.out.println(sb.toString());


    }

    public static void solution2(int N, long[] arr, int M, long[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            long l = inputs[i];

            int result = Arrays.binarySearch(arr, l);

            if (result >= 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void solution3(int N, long[] arr, int M, long[] inputs) {

        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < inputs.length; i++) {
            long l = inputs[i];

            boolean result = set.contains(l);

            if (result) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }
}
