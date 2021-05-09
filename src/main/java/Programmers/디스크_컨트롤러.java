package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
class 디스크_컨트롤러{
    /*
        작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면
        평균이 얼마가 되는지 return(소수점 이하는 버림)

        작업의 요청부터 종료까지 걸린 시간을 줄이는 법 :
        현재 시간을 기준으로 이전에 요청된 작업들 중 가장빨리 끝나는 작업(비용이 가장 적은)을 선택한다.

     */

    public int solution(int[][] jobs) {
        int answer = 0;


        PriorityQueue<Job> readyQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.request - o2.request;
            }
        });

        PriorityQueue<Job> runningQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            int request = jobs[i][0];
            int cost = jobs[i][1];

            readyQueue.offer(new Job(request, cost));
        }


        int currentTime = 0;
        while (!readyQueue.isEmpty()) {

            while (!readyQueue.isEmpty() && readyQueue.peek().request <= currentTime) {
                Job poll = readyQueue.poll();
                runningQueue.offer(poll);
            }

            if (!runningQueue.isEmpty()) {
                Job runningPoll = runningQueue.poll();

                currentTime += runningPoll.cost;

                answer += currentTime - runningPoll.request;
            } else {
                currentTime++;
            }

        }

        while (!runningQueue.isEmpty()) {
            Job runningPoll = runningQueue.poll();

            currentTime += runningPoll.cost;

            answer += currentTime - runningPoll.request;
        }


        answer /= jobs.length;
        return answer;
    }

    class Job {
        int request;
        int cost;

        public Job(int request, int cost) {
            this.request = request;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "request=" + request +
                    ", cost=" + cost +
                    '}';
        }
    }
}