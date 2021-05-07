package Programmers;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/42584
public class 주식가격 {

    /*
       초 단위로 기록된 주식 가격이 주어짐.

       가격이 떨어지지 않은 기간은 몇 초인지 return

       가격이 떨어짐 ->

       1원, 2원, 3원, 2원, 3원 이면
       3원 -> 2원으로 갈때 떨어진 것.


       스택에 지난 가격들을 담음.
       스택.peek이 다음 주식가격보다 크다면.
       다음 주식가격보다 큰 지난 가격들을 모두 뺌
       빼면서 시간 계산.

       prices를 돌면서 위 과정을 진행하고

       스택에 값이 남아있다면, 모두 빼면서 시간을 계산함.

       유지 시간 계산은 다음과 같음
       유지시간 = 현재시간 - 해당 시간

       [피드백]
       위 과정으로 풀긴 했는데 코드가 복잡해짐.
       Price 클래스(time, price)를 만들었는데 멤버 변수로 둔 time은 prices의 index와 동일하고
       index 로 prices의 값을 조회할 수 있으므로 Price 클래스가 굳이 필요하진 않음.

       스택을 쓰지 않는 풀이.
       prices를 for문으로 돌면서
       i는 현재 시간. 현재 시간을 기준으로 prices for문을 ((i + 1) ~ end) 까지 돌면서
       answer[i]++;해줌.
       현재 가격보다 k시간의 가격이 더 작다면 break;


     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        for (int currentTime = 1; currentTime < prices.length; currentTime++) {

            Integer preTime = stack.peek();

            if (prices[preTime] > prices[currentTime]) {
                stack.pop();
                answer[preTime] = currentTime - preTime;

                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if (prices[peek] > prices[currentTime]) {
                        stack.pop();
                        answer[peek] = currentTime - peek;
                    } else {
                        break;
                    }
                }
            }

            stack.add(currentTime);
        }
        int endTime = prices.length - 1;

        while (!stack.isEmpty()) {
            Integer time = stack.pop();
            answer[time] = endTime - time;
        }


        return answer;
    }

}
