package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 나무_자르기_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        이분 탐색을 이용해 최적의 값을 찾아낸다.
        나무 높이의 범위는 int에 포함되지만, 나무 높이의 합은 int를 벗어날 수 있다. 그러므로 long을 사용하자
     */
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer> woodList = new ArrayList<>();

        int maxHeight = 0;

        for (String wood : br.readLine().split(" ")) {
            int woodHeight = Integer.parseInt(wood);
            woodList.add(woodHeight);
            maxHeight = Math.max(maxHeight, woodHeight);
        }


        long start = 0;
        long end = maxHeight;

        while (start <= end) {
            long mid = (start + end) / 2;

            long totalSlicedHeight = 0;

            for (Integer woodHeight : woodList) {
                long slice = woodHeight - mid;
                if (slice > 0) {
                    totalSlicedHeight += slice;
                }
            }

            if (totalSlicedHeight < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(Long.toString(end));

        bw.close();
        br.close();
    }
}
