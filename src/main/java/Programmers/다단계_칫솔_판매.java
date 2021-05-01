package Programmers;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/77486?language=java#
public class 다단계_칫솔_판매 {
    /*
        추천인에게 본인의 판매 건마다 해당 건의 판매 수익 10%를 준다
        10%를 계산한 금액이 1원 미만인 경우 수익을 분배하지 않는다.

        칫솔은 개당 100원이다.

        enroll : i번째 판매원 이름
        referral : i번째 판매원의 추천인 이름

        seller : i번째 판매 기록의 판매원 이름
        amount : i번째 판매 기록의 판매량

        return 각 판매원이 득한 이익금

        풀이 :
            추천인 관계를 정리해두고 판매건(seller, amount)들을 순회하며
            A(현재 판매원을 1이라고 하자, 1의 추천인(2)이 있는 경우, plus(판매 금액의 10%)가 1이상 이라면 본인(1)의 가격에서 빼고
                현재 판매원을 추천인(2)의 시점으로 바꾼다. -> 추천인(2)의 추천인(3)이 있는지 확인해야함.
                (2)의 시점에서 판매 금액은 plus(1의 판매 금액의 10%)이고 추천인은 (3)이된다.
                 )
            위 A 과정을 추천인이 없을때까지 반복한다.

        * 이 문제를 보며 찾은 안 좋은 습관
            문제를 빨리 풀기 위해서 마음이 급한 탓에
            문제를 급하게 읽고 넘어가 충분히 이해하지 못하는 습관이 있다.

            이 문제에서는 다음과 같은 상황이 발생했다.

            모든 판매금액을 판매원에 맞게 더해놓고 그 total 금액을
            해당 판매원의 추천인에게 10%를 주는 잘못된 알고리즘을 구현해서 시간이 오래 걸렸다.
             -> 만약 수익금이(8 + 12)라면 1원만 추천인에게 줘야하지만..
                총 수익금을 20으로 계산해 2원을 추천인에게 주는 오류가 있다.


            이 습관은 문제의 설명글이 길다면 실수를 할 가능성이 높다.
            실제로 문제를 잘못 이해하고 구현하는 탓에 빨리 풀지도 못한다.
            여유를 가지고 문제를 충분히 이해한 뒤에 구현을 시작하자.
    */
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // total 수익금
        HashMap<String, Integer> totalMoney = new HashMap<>();

        // enroll referral 관계를 Map에 정리
        HashMap<String, String> recommender = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            recommender.put(enroll[i], referral[i]);
        }


        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * 100;

            while (recommender.get(s) != null) {
                // 추천인이 있다면, 해당 판매의 수익금 10% 만큼을 추천인에게 줘야함.
                int plus = a / 10;
                // 만약 수익금 10% < 1 라면 안 줘도 됨.
                if (plus < 1) {
                    // 그대로 저장
                    Integer sOrDefault = totalMoney.getOrDefault(s, 0);
                    totalMoney.put(s, sOrDefault + a);
                    break;
                }

                // 10 % 빠진 거 저장.
                Integer sOrDefault = totalMoney.getOrDefault(s, 0);
                totalMoney.put(s, sOrDefault + a - plus);

                // 다음 싸이클로 이동해야됨.
                // 현재 값 -> 추천인
                a = plus;
                s = recommender.get(s);
            }

        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = totalMoney.getOrDefault(enroll[i], 0);
        }


        return answer;
    }
}
