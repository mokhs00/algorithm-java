package Programmers;

import java.util.*;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        int[] answer;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }


        int idx = 0;
        answer = new int[set.size()];
        System.out.println(set);

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            answer[idx] = iterator.next();
            idx++;
        }


        return answer;
    }
}

