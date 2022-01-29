package BOJ;

import java.io.*;

public class 사탕_게임_3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        int result = 1;

        for (int i = 0; i < N; i++) {
            char[] items = br.readLine().toCharArray();
            for (int j = 0; j < items.length; j++) {
                board[i][j] = items[j];
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                result = Math.max(calculateMaxCount(), result);
                swap(i, j, i, j + 1);

                swap(j, i, j + 1, i);
                result = Math.max(calculateMaxCount(), result);
                swap(j, i, j + 1, i);
            }
        }
        bw.write(Integer.toString(result));


        br.close();
        bw.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static int calculateMaxCount() {
        int maxCount = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                count = board[i][j - 1] == board[i][j] ? count + 1 : 1;

                maxCount = Math.max(count, maxCount);
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                count = board[j - 1][i] == board[j][i] ? count + 1 : 1;

                maxCount = Math.max(count, maxCount);
            }
        }

        return maxCount;
    }
}
