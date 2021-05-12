package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42746
public class 가장_큰_수 {
    /*
        0 또는 양의 정수가 주어졌을 때,
        정수를 이어 붙여서 만들 수 있는 가장 큰 수를 return
        앞자리가 가장 큰 순서대로 정렬함.

        *0만 있을 경우 예외처리 하기.
        -> 정렬 후 첫번째 숫자가 0인 경우.

        numbers를 String으로 변환해서 리스트에 옮긴 뒤
        정렬한다.

        정렬 기준은 다음과 같다.
        (a+b)와 (b+a) 중 더 큰 값이 앞으로 가게한다. -> 내림차순.
        전자가 크다면 a가 우선순위
        후자가 크다면 b가 우선순위


     */
    public String solution(int[] numbers) {
        String answer = "";


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(Integer.toString(numbers[i]));
        }


        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });


        if (arrayList.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for (String s : arrayList) {
            sb.append(s);
        }

        answer = sb.toString();

        return answer;
    }
}
