package Programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
public class K번째수 {
    /*
        i부터 j까지 자르고 정렬 후 k번째에 있는 수
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] temp = new int[j - i + 1];

            for (int q = 0; q < temp.length; q++) {
                temp[q] = array[i - 1];
                i++;
            }

            Arrays.sort(temp);

            answer[answerIndex++] = temp[k - 1];
        }
        return answer;
    }
}
