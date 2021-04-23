package Algorithm;

public class PrefixSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4};
        int[] prefixSum = new int[arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSum[i] = sum;
        }

        // arr[1]부터 arr[3] 구간 합 2 + 3 + 2 = 7
        System.out.println(prefixSum[3] - prefixSum[0]);

    }
}
