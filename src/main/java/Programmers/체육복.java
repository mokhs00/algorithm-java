package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
public class 체육복 {
    /*
        체격 순으로 학생 번호가 매겨져 있음.
        바로 앞 번호의 학생이나 바로 뒷 번호의 학생에게만 체육복을 빌려줄 수 있음

        최대한 많은 학생이 체육 수업을 들어야 함
        = 최대한 많은 학생이 체육복을 가지고 있게 함.

     */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i + 1, 1);
        }

        for (int i = 0; i < lost.length; i++) {
            map.put(lost[i], map.get(lost[i]) - 1);
        }

        for (int i = 0; i < reserve.length; i++) {
            map.put(reserve[i], map.get(reserve[i]) + 1);
        }

        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            Integer now = map.get(key);

            if (now > 0) {
                answer++;
                continue;
            }
            // 체육복이 없다면 앞 사람 혹은 뒷 사람에게 빌려야함.
            // 앞 사람이 먼저 빌려주는 게 좋을듯
            if (now < 1) {
                Integer front = map.get(key - 1);
                if (front != null && front > 1) {
                    map.put(key - 1, front - 1);
                    map.put(key, 1);
                    answer++;
                    continue;
                }

                Integer back = map.get(key + 1);

                if (back != null && back > 1) {
                    map.put(key + 1, back - 1);
                    map.put(key, 1);
                    answer++;
                    continue;
                }
            }
        }

        return answer;
    }
}
