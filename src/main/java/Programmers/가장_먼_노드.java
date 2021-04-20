package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] distance;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);

        }

        Queue<Integer> queue = new LinkedList<>();

        distance[1] = 0;
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            ArrayList<Integer> lines = graph.get(poll);
            for (Integer line : lines) {
                if (!visited[line]) {
                    queue.add(line);
                    visited[line] = true;
                    distance[line] = distance[poll] + 1;
                }
            }


        }

        Arrays.sort(distance);
        int max = distance[n];
        for (int i = distance.length - 1; i >= 0; i--) {
            if (distance[i] >= max) {
                answer += 1;
            } else
                break;
        }


        return answer;
    }
}
