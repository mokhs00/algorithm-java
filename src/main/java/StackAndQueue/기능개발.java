package StackAndQueue;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        int[] progresses = {0, 0, 0, 0};
        int[] speeds = {100, 50, 34, 25};

        for (int i : solution(progresses, speeds)) {
            System.out.println(i);
        }


    }


    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int index = 0; index < progresses.length; index++) {
            queue.offer(index);
        }


        int cost = 0;
        int stack = 0;
        while (!queue.isEmpty()) {
            int index = queue.peek();
            if (progresses[index] + (cost * speeds[index]) >= 100) {
                int poll = queue.poll();
                index++;
                stack++;
                if (poll == progresses.length - 1)
                    answerList.add(stack);
            } else {
                cost++;
                if (stack > 0) {
                    answerList.add(stack);
                    stack = 0;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

