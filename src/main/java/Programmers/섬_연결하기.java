package Programmers;

import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
public class 섬_연결하기 {
    /*
        최소 비용으로 모든 노드를 연결해 최소 비용 트리를 만드는 크루스칼 알고리즘
     */
    int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        // 간선의 비용 순으로 정렬하고
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        // a와 b가 연결되어 있지 않다면 연결해주고 비용 추가
        // a와 b가 연결되어 있다면 더하지 않음
        // 연결되어 있음은 UnionFind를 이용
        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            int parentA = getParent(a);
            int parentB = getParent(b);
            if (parentA != parentB) {
                answer += cost;
                if (parentA > parentB) {
                    parents[parentA] = parentB;
                } else
                    parents[parentB] = parentA;
            }
        }

        return answer;
    }

    public int getParent(int child) {

        if (child == parents[child]) {
            return child;
        }
        return getParent(parents[child]);
    }
}


