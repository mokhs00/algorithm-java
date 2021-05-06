package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
public class 기능개발 {
    /*
        진도가 100%일때 서비스에 반영
        뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됨.

        time을 두고

     */
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList<>();


        Queue<Job> progressesQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressesQueue.offer(new Job(progresses[i], speeds[i]));
        }

        int time = 0;
        // 해당 시간에 완료된 작업 수
        int count = 0;
        while (!progressesQueue.isEmpty()) {
            Job poll = progressesQueue.poll();

            int p = poll.progress;
            int s = poll.speed;


            if (p + (s * time) < 100) {
                // count가 있다면 이미 완료된 작업들이 있으므로 answerList에 count를 추가하고
                // count를 0으로 초기화
                if (count > 0) {
                    answerList.add(count);
                }
                count = 0;

                // 현재 작업이 완료될 때까지 time을 진행하고 완료 판정
                // Math.ceil() 올림 || Math.round() 반올림 || Math.floor() 버림
                time = (int) Math.ceil((double) (100 - p) / s);

                count++;
            } else {
                count++;
                continue;
            }

        }

        // 마지막 작업을 완료한 후에도 count 추가.
        answerList.add(count);

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}
