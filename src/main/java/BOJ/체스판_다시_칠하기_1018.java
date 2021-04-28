package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1018
public class 체스판_다시_칠하기_1018 {
    /*
        모든 경우를 찾아주면 되는 문제
        보드를 순회하면서 현재 y, x를 기준으로 8*8로 자를 수 있을 때,
        보드 각 칸의 색이 번갈아가면서 나오는지 확인하고 count해주면 된다.
        주의* 각각 검정색, 흰색으로 시작하는 경우를 따져줘야함.
     */

    static int answer;
    static char[][] board;
    static char[] slot = {'W', 'B'};
    static int N, M;
    static int MAX = 64;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]); // y
        M = Integer.parseInt(input1[1]); // x
        answer = N * M;

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                function(i, j);
            }
        }

        System.out.println(answer);
    }

    public static void function(int y, int x) {
        int count = 0;
        int idx = 0;
        if (board[y][x] == 'B') {
            idx = 1;
        }

        for (int i = 0; i < 8; i++) {
            if (y + i >= N)
                return;
            for (int j = 0; j < 8; j++) {

                if (x + j >= M)
                    return;

                if (board[y + i][x + j] != slot[idx]) {
                    count++;
                }
                idx = change(idx);
            }
            idx = change(idx);
        }

        count = Math.min(MAX - count, count);

        if (count < answer) {
            answer = count;
        }
    }

    public static int change(int idx) {
        idx += 1;
        if (idx >= slot.length) {
            idx = 0;
        }

        return idx;
    }


}




