package Algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 3, 1, 1, 3};
        int n = array.length;
        // 오름차순 정렬
        Arrays.sort(array);
        // 이진 탐색 수행
        BinarySearch binarySearch = new BinarySearch();

        // 2가 존재하지 않으므로 -1 반환
        int test1 = binarySearch.binarySearch(array, 2, 0, n);
        System.out.println("test1 : " + test1);
        // 정렬된 배열 기준  3의 마지막 인덱스 반환
        int test2 = binarySearch.binarySearch(array, 3, 0, n);
        System.out.println("test2 : " + test2);

        // 정렬된 배열 기준 1의 개수 구하기 : 2개
        int test3 = binarySearch.upperBound(array, 1, 0, n)
                - binarySearch.lowerBound(array, 1, 0, n);
        System.out.println("test3 : " + test3);


    }

    public int binarySearch(int[] arr, int target, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[right] != target) {
            return -1;
        }

        return right;
    }


    /*
        arr에서 target의 가장 작은 인덱스를 반환
        target이 arr에 없다면 -1 반환
     */
    public int lowerBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[right] != target){
            return -1;
        }

        return right;
    }

    /*
        arr에서 target의 가장 큰 인덱스를 반환
        target이 arr에 없다면 -1 반환
     */
    public int upperBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (arr[right] != target){
            return -1;
        }

        return right;
    }
}
