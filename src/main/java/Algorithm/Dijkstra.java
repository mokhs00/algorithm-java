package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    int N = 6;
    ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
    int[] dp;
    final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.init();
        // 0 2 3 1 2 4
        dijkstra.dijkstra(1);
    }

    public void dijkstra(int start) {

        // PriorityQueue 선언
        PriorityQueue<Cost> pq = new PriorityQueue<>(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o1.cost - o2.cost;
            }
        });

        // 비용 초기화
        dp[start] = 0;

        // 첫 노드 입력
        pq.add(new Cost(start, 0));

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()){

            Cost now = pq.poll();

            // 현재 노드와 연결된 노드 중 next.cost + now.cost < dp[next]인 경우
            // dp[next] = next.cost + dp[now]한 후
            // 이동 한 노드와 사용된 총 비용을 기록한 정보를 큐에 넣어줌
            ArrayList<Cost> nexts = graph.get(now.index);
            for (Cost next : nexts) {
                int totalCost = dp[now.index] + next.cost;
                if (totalCost < dp[next.index]){
                    dp[next.index] = totalCost;
                    pq.add(new Cost(next.index, totalCost));
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }



    }

    public void init() {
        dp = new int[N + 1];

        Arrays.fill(dp, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        initAddNodes();

    }

    public void initAddNodes() {
        graph.get(1).add(new Cost(2, 2));
        graph.get(1).add(new Cost(3, 5));
        graph.get(1).add(new Cost(4, 1));

        graph.get(2).add(new Cost(1, 2));
        graph.get(2).add(new Cost(3, 3));
        graph.get(2).add(new Cost(4, 2));

        graph.get(3).add(new Cost(1, 5));
        graph.get(3).add(new Cost(2, 3));
        graph.get(3).add(new Cost(4, 3));
        graph.get(3).add(new Cost(5, 1));
        graph.get(3).add(new Cost(6, 5));

        graph.get(4).add(new Cost(1, 1));
        graph.get(4).add(new Cost(2, 2));
        graph.get(4).add(new Cost(3, 3));
        graph.get(4).add(new Cost(5, 1));

        graph.get(5).add(new Cost(3, 1));
        graph.get(5).add(new Cost(4, 1));
        graph.get(5).add(new Cost(6, 2));

        graph.get(6).add(new Cost(5, 2));
        graph.get(6).add(new Cost(3, 5));
    }


    class Cost {
        int index;  // 노드 번호
        int cost;   // 현재 노드까지 이동하는 최소 비용

        public Cost(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Cost{" +
                    "index=" + index +
                    ", cost=" + cost +
                    '}';
        }
    }
}
