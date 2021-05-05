package Programmers;

import java.util.HashSet;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42577?language=java#
public class 전화번호_목록 {
    /*
        전화번호부에 적힌 번호 중
        한 번호가 다른 번호의 접두어인 경우 false를 return
        아닌 경우 true를 return


        1. startsWith로 완전 탐색 시 n^2 -> 시간 초과
        시간을 줄이는 방법
        사전적 정렬을 이용.
        배열을 미리 정렬해두면, 119 11923213 12 1234 이런 식으로 정렬되어서
        바로 뒤에 문자만 확인해주면 됨.
        -> 시간 복잡도가 log 로 줄어듬

        2. hash를 이용한 방식
        phone_book[i]를 j까지 substring으로 잘라서 HashSet에 포함되는지 확인.
        -> HashSet.contains는 탐색 속도가 굉장히 빠르다
           hash로 구현되어있기 때문이라는데 따로 정리해놓자.

     */
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (set.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }


        return answer;
    }
}
