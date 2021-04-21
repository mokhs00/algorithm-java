package Algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    /*
        노드의 개수 6
        그래프 모양 :
                  1
                 / \
                2   3
               /   / \
              4   5   6
    */
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int n = 6; // 노드의 총 개수
    boolean[] visited;

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.init();
        // stack을 이용한 구현
        // stack을 이용한 구현은 가장 마지막에 넣은 노드를 pop 하므로 현 그래프에서 오른쪽을 먼저 탐색함
        // 1 3 6 5 2 4 순으로 탐색

        dfs.dfs1(1);

        dfs.init();
        // 재귀를 이용한 구현
        // 1 2 4 3 5 6 순으로 탐색
        System.out.println();
        System.out.println("재귀를 이용한 탐색 시작");
        dfs.dfs2(1);
        System.out.println();
        System.out.println("탐색 종료");

    }

    public void init() {
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);
        graph.get(3).add(6);
    }

    // Stack을 이용한 구현
    public void dfs1(int start) {
        System.out.println();
        System.out.println("Stack을 이용한 탐색 시작");
        Stack<Integer> stack = new Stack<>();
        stack.add(1);

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            visited[pop] = true;

            System.out.print(pop + " ");

            ArrayList<Integer> nextNodes = graph.get(pop);

            for (Integer nextNode : nextNodes) {
                if (!visited[nextNode]) {
                    stack.add(nextNode);
                }
            }
        }
        System.out.println();
        System.out.println("탐색 종료");
    }

    // 재귀를 이용한 구현
    public void dfs2(int now) {
        System.out.print(now + " ");

        visited[now] = true;
        ArrayList<Integer> nextNodes = graph.get(now);

        for (Integer nextNode : nextNodes) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs2(nextNode);
            }
        }
    }


}
