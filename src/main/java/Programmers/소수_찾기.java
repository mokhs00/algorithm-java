package Programmers;

import java.util.HashSet;

// https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class 소수_찾기 {

    /*
        조각을 붙여 만들 수 있는 수의 조합을 구하고
        그 조합을 탐색하며 소수인지 판별하면됨.
        소수 판별, 조합 만들기

        소수 판별 : 제곱근까지 계산해서 시간 줄이기.
        조합 : 재귀 활용해서 계산하기.
     */

    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        perm(numbers, "");

        for (Integer integer : set) {
            if (isPrime(integer)) {
                answer++;
            }
        }


        return answer;
    }


    public void perm(String numbers, String now) {

        if (!now.equals("")) {
            set.add(Integer.valueOf(now));
        }

        for (int i = 0; i < numbers.length(); i++) {
            perm(numbers.substring(0, i) + numbers.substring(i + 1, numbers.length()),
                    now + numbers.substring(i, i + 1));
        }
    }


    public boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;


    }
}
