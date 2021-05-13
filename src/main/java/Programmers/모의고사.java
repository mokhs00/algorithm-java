package Programmers;

import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
public class 모의고사 {

    /*
        문제를 찍는 패턴이 있음.
        1번 사람 : 1 2 3 4 5
        2번 사람 : 2 1 2 3 2 4 2 5
        3번 사람 : 3 3 1 1 2 2 4 4 5 5

        1번문제부터 마지막 문제까지 위 방법으로 찍어서 누가 문제를 가장 많이 맞췄는지 return
     */
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (p1[i % p1.length] == answers[i]) {
                score[0]++;
            }
            if (p2[i % p2.length] == answers[i]) {
                score[1]++;
            }
            if (p3[i % p3.length] == answers[i]) {
                score[2]++;
            }
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                arrayList.add(i + 1);
            }
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }


        return answer;
    }
}
