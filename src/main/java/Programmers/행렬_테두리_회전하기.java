package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/77485
public class 행렬_테두리_회전하기 {
    /*

        map을 만들고

        테두리를 한 칸씩 이동시킴.
        temp를 이용.
        x1,y1 값을 temp에 넣고 다음 순서(x1 + 1, y1)의 값을 t에 다시 담고  (x1 + 1, y1)에 temp값을 넣음.

        temp의 min 값을 찾고 리턴

     */
    int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];

        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                map[x][y] = y + ((x - 1) * columns);
            }
        }


        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    public int rotation(int x1, int y1, int x2, int y2) {

        int temp = map[x1][y1];
        int min = map[x1][y1];

        for (int i = y1 + 1; i <= y2; i++) {
            int t = map[x1][i];
            map[x1][i] = temp;
            temp = t;
            if (temp < min) {
                min = temp;
            }
        }

        for (int i = x1 + 1; i <= x2; i++) {
            int t = map[i][y2];
            map[i][y2] = temp;
            temp = t;
            if (temp < min) {
                min = temp;
            }
        }

        for (int i = y2 - 1; i >= y1; i--) {
            int t = map[x2][i];
            map[x2][i] = temp;
            temp = t;
            if (temp < min) {
                min = temp;
            }
        }

        for (int i = x2 - 1; i >= x1; i--) {
            int t = map[i][y1];
            map[i][y1] = temp;
            temp = t;
            if (temp < min) {
                min = temp;
            }
        }


        return min;

    }
}
