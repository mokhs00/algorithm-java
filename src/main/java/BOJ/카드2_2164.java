package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {


    /*
        1. 제일 위에 있는 카드를 버린다.
        2. 그 다음 제일 위에 있는 카드를 제일 아래로 옮긴다.
        3. 1,2 번을 반복
        4. 마지막에 남는 카드르 구한다.

     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }

        System.out.println(queue.poll());


        br.close();
    }


}



