package Brute_Force;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class 소수_찾기 {

    /**
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     *
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * numbers는 길이 1 이상 7 이하인 문자열입니다.
     * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     *
     * 입출력 예
     * numbers	return
     * 17	    3
     * 11	    2
     *
     * 입출력 예 설명
     * 예제 #1
     * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
     *
     */

    /**
     * 풀이
     */
    public static void main(String[] args) {

        String numbers = "17";

        HashSet<Integer> set = new HashSet<>();


        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        permutaion("", numbers, set);

        for (Integer integer : set) {
            if (integer == 2) answer++;
            if (integer % 2 != 0 && isPrime(integer)) {
                answer++;
            }
        }

        return answer;


    }

    private static boolean isPrime(Integer i) {
        if (i == 0 || i == 1) return false;
        for (int j = 3; j <= (int) Math.sqrt(i); j += 2) {
            if (i % j == 0) return false;

        }
        return true;
    }


    private static void permutaion(String prefix, String numbers, HashSet<Integer> set) {
        int n = numbers.length();

        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++) {
            permutaion(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, n), set);
        }


    }


//    private static int answer = 0;
//    private static Set<Integer> set = new HashSet<>();
//
//    public static int solution(String numbers) {
//
//        char[] list = numbers.toCharArray();
//
//        for (int i = 1; i <= list.length; i++) {
//            permutation(list, 0, list.length, i);
//        }
//
//        return answer;
//    }
//
//    private static void permutation(char[] arr, int depth, int n, int r) {
//        if (depth == r) {
//            // 만약 소수이면 answer ++;
//            if (isPrime(arr, r)) {
//                answer++;
//                return;
//            }
//        }
//
//
//        for (int i = depth; i < n; i++) {
//            swap(arr, depth, i);
//            permutation(arr, depth + 1, n, r);
//            swap(arr, depth, i);
//        }
//
//    }
//
//    private static void swap(char[] arr, int depth, int i) {
//        char temp = arr[depth];
//        arr[depth] = arr[i];
//        arr[i] = temp;
//    }
//
//    static boolean isPrime(char[] arr, int r) {
//
//        String str = "";
//        for (int i = 0; i < r; i++) {
//            str += arr[i];
//        }
//
//        int number = Integer.parseInt(str);
//
//
//        // 소수 판별
//
//        // 이미 set에 있으면 false
//
//        // 0이면 false
//        if (number <= 1 || set.contains(number))
//            return false;
//
//        for (int i = 2; i * i <= number; i++) {
//            if (number % i == 0)
//                return false;
//        }
//
//        set.add(number);
//        return true;
//
//
//    }


}
