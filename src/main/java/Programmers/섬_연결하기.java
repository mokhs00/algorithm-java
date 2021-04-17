package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {
    int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int c = cost[2]; // cost


            int startParent = findParent(start);
            int endParent = findParent(end);
            if (startParent != endParent) {
                if (startParent < endParent)
                    parents[endParent] = startParent;
                else
                    parents[startParent] = endParent;
                answer += c;
            }
        }

        return answer;
    }

    public int findParent(int child) {
        if (parents[child] == child) {
            return child;
        }
        return findParent(parents[child]);
    }
}
