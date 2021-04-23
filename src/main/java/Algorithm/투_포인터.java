package Algorithm;

public class 투_포인터 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5};

        int M = 5;

        int count = 0;

        int left = 0, right = 0;

        while (left < arr.length) {

            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            if (sum >= M) {
                System.out.println(left + " ~ " + right);
                left++;
                count++;
            } else {
                right++;
            }
        }

        // {1,2,3}, {2,3}, {3,2}, {2,5}, {5} 총 5개
        System.out.println(count);
    }
}
