package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1085
public class 직사각형에서_탈출_1085 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        int distance1 = Math.min(x, y);
        int distance2 = Math.min(w - x, h - y);
        int answer = Math.min(distance1, distance2);

        System.out.println(answer);
    }
}
