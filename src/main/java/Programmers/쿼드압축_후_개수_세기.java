package Programmers;

public class 쿼드압축_후_개수_세기 {

    int zeroCount, oneCount;

    public int[] solution(int[][] arr) {

        function(0, 0, arr[0].length, arr.length, arr);
        int[] answer = {zeroCount, oneCount};
        return answer;
    }

    public void function(int x1, int y1, int x2, int y2, int[][] arr) {

        int zero = 0;
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (arr[i][j] == 0)
                    zero++;
            }
        }

        int m = (x2 - x1) * (y2 - y1);

        if (zero == m) {
            zeroCount++;
        } else if (zero == 0) {
            oneCount++;
        } else {
            int halfX = (x1 + x2) / 2;
            int halfY = (y1 + y2) / 2;

            function(x1, y1, halfX, halfY, arr);
            function(halfX, halfY, x2, y2, arr);
            function(halfX, y1, x2, halfY, arr);
            function(x1, halfY, halfX, y2, arr);

        }


    }

}
