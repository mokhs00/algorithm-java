package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1436
public class 영화감독_숌_1436 {
    /*
        count = 0; num = 0;
        num을 1씩 증가시켜가며 666을 포함하는지 확인하고
        포함한다면 count+=1.
        count가 N과 일치하면 num을 출력 후 종료.
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 0;
        while (true) {
            num++;
            boolean contains = Integer.toString(num).contains("666");
            if (contains) {
                count++;
                if (count == N) {
                    System.out.println(num);
                    break;
                }
            }

        }


    }


}
