package StackAndQueue;

import java.util.Stack;

public class 주식가격 {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};
        for (int i : solution(input)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> time = new Stack<>();

        int currentTime = 0;

        for (; currentTime < prices.length; currentTime++) {

            while (!time.isEmpty() && prices[time.peek()] > prices[currentTime]){
                int t = time.pop();
                answer[t] = currentTime - t;
            }
            time.add(currentTime);
        }

        while(!time.isEmpty()){
            int pop = time.pop();
            answer[pop] = currentTime - (pop+1);
        }



        return answer;
    }

}


