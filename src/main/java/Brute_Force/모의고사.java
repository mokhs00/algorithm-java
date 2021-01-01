package Brute_Force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 모의고사 {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        for (int i : solution(answers)) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] a = new int[3];


        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % (p1.length)])
                a[0]++;
            if (answers[i] == p2[i % (p2.length)])
                a[1]++;
            if (answers[i] == p3[i % (p3.length)])
                a[2]++;
        }
        int maxScore = Math.max(a[0], Math.max(a[1], a[2]));
        List<Integer> list = new ArrayList<>();
        return list.stream().mapToInt(i->i.intValue()).toArray();


        /*for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % (p1.length)])
                a[0]++;
            if (answers[i] == p2[i % (p2.length)])
                a[1]++;
            if (answers[i] == p3[i % (p3.length)])
                a[2]++;
        }

        List<Integer> answerList = new ArrayList<>();
        int max = Arrays.stream(a).max().getAsInt();
        for (int i = 0; i < a.length; i++) {
            if (max != 0 && a[i] >= max)
                answerList.add((i + 1));
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;*/
    }

}
