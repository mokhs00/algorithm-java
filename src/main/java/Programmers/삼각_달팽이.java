package Programmers;

import java.util.ArrayList;

public class 삼각_달팽이 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[][] list = new int[n][n];

        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};

        int t = 1;
        int x = 0;
        int y = -1;
        int d = 0;
        int k = n;
        while(k > 0){
            int temp = k;


            while(temp > 0){
                x += dx[d];
                y += dy[d];
                list[y][x] = t;
                temp--;
                t++;
            }

            d++;
            if(d > 2)
                d = 0;

            k--;
        }

        k = 1;
        while(k <= n){
            for(int j = 0; j < k; j++){
                answer.add(list[k-1][j]);
            }
            k++;
        }

        return answer;
    }
}
