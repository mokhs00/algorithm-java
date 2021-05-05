package Programmers;

import java.util.HashMap;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
public class 완주하지_못한_선수 {

    /*
        단 한 명의 완주하지 못 한 선수를 찾아라
        *동명이인이 있을 수 있음.

        HashMap
        key는 이름, value는 count로 두고
        participant 배열을 돌면서 count를 기록

        completion를 돌면서 HashMap의 key와 매칭되는 사람의 count를 줄이자.

     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            Integer orDefault = map.getOrDefault(p, 0);
            map.put(p, orDefault + 1);
        }

        for (String c : completion) {
            Integer get = map.get(c);
            map.put(c, get - 1);
        }

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            Integer count = map.get(key);
            if (count > 0) {
                answer = key;
                break;
            }

        }


        return answer;
    }
}
