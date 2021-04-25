package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
    /*
        탑은 꼭대기에서 왼쪽으로 레이저를 쏜다.
        스택에는 매번 탑의 인덱스를 담는다.

        while(idx < tops.length){
            1. 스택이 비어있지 않다면,
                tops[stack.peek] 값이 현재값(tops[idx])보다 크거나 같다면 stack.peek을 출력하고 break;
                작다면 pop해줌.
                스택이 빌때까지 위 과정을 반복
            2. 스택이 비어있다면 0을 출력
        }


        ** Scanner 사용 시 메모리 초과가 생김
        -> Scanner 대신 BufferedReader를 사용하여 해결
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tops = new int[N];

        String arrInput = br.readLine();
        StringTokenizer st = new StringTokenizer(arrInput);

        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        int idx = 1;

        System.out.print(0 + " ");

        while (idx < tops.length) {
            int now = tops[idx];

            while (!stack.isEmpty()) {
                Integer peek = stack.peek();

                if (tops[peek] >= now) {
                    System.out.print(peek + 1 + " ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }


            stack.add(idx++);
        }

        br.close();
    }


}
