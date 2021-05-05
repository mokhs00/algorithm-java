package Programmers;

import java.util.HashMap;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42578
public class 위장 {
    /*
        서로 다른 옷 조합의 수를 return
        최소 한 개의 옷은 입음.

        카테고리 별로 옷을 정리해두고
        (옷의 수 + 1(안 입는 경우)) 를 count에 곱해주고
        1(옷을 아무것도 안 입는 경우)을 빼준다
     */
    public int solution(String[][] clothes) {
        int answer = 1;


        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String category = clothe[1];
            Integer orDefault = map.getOrDefault(category, 0);
            map.put(category, orDefault + 1);
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Integer get = map.get(key);
            answer *= (get + 1);
        }
        answer--;


        return answer;
    }
}
