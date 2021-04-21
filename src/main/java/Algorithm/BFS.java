package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

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
        BFS bfs = new BFS();
        bfs.init();
        // 1 2 3 4 5 6
        bfs.bfs(1);
    }

    public void bfs(int start){
        System.out.println("BFS 시작");
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");

            visited[poll] = true;

            ArrayList<Integer> nextNodes = graph.get(poll);

            for (Integer nextNode : nextNodes) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                }
            }

        }
        System.out.println("\n탐색 종료");

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


}
