package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
public class 가장_먼_노드 {
    /*
        1번 노드에서부터 다른 노드로 가는 최단 거리를 구하고,
        = 다익스트라, 플로이드워셜
        (이 문제에서는 간선의 비용이 같으므로 BFS로 depth를 체크하는 방식도 가능)
        거리 중 가장 먼 것을 기준으로 같은 거리에 있는 노드의 수를 셈.

        다시 풀면서 느낀점.
        다시 푸는 문제인데도 오래걸렸다.. (거의 1시간)

        오래 걸린 원인들
        1. 플로이드 워셜로 했다가 시간 초과. -> BFS로 변경함
        2. 방문처리를 정확하게 하지 않아서 시간 초과 -> 방문 처리 로직에 문제가 있어 시간 초과가 발생했다.

        피드백
        1. 시간 복잡도를 생각하지 않은 풀이 접근..
            -> 플로이드 워셜을 고른 이유 : 구현이 간단하고 빨리 풀고 싶었다.
               시간 복잡도가 n^3인 것을 알고 있었지만 일단 구현해봤던 것..
           해결 방법 :
           문제를 침착하게 바라보고 여유를 가지는 것이 필요할 것 같다.
           + 플로이드 워셜은 노드의 수가 100개 정도일 때만 사용하자..

        2. BFS 방문 처리 실수로 인한 시간 초과
            -> BFS의 과정에서 해당 노드가 Queue에서 빠질 때 방문처리하고,
               해당 노드와 연결되고 방문처리되지 않은 노드를 모두 Queue에 넣었다.
               그 결과 같은 노드가 Queue에 여러번 들어가는 바람에 시간 초과가 발생했다.
                case : 1번 노드와 2번 노드가 연결되어 있고
                       1번 노드, 2번 노드에 동시에 연결된 노드들이
                       Queue에 중복으로 들어가게 된다.
                       이 동시에 연결된 노드들이 많아진다면?..
            해결 방법 :

            실수를 방지하기 위해 방문처리 하는 방식을 정해두는 것이 좋겠다.
            Queue에 노드를 넣은 후에 바로 방문처리 하는 방식을 사용하자.

     */
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        int d[] = new int[n + 1];

        Arrays.fill(d, INF);
        boolean[] visited = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 1));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int index = poll.index;
            int weight = poll.weight;
            if (visited[index]) {
                continue;
            }
            visited[index] = true;
            if (d[index] > weight) {
                d[index] = weight;
            }

            ArrayList<Integer> arrayList = graph.get(index);

            for (int i = 0; i < arrayList.size(); i++) {
                Integer next = arrayList.get(i);
                if (!visited[next]) {
                    queue.add(new Node(weight + 1, next));
                }
            }


        }

        int max = 0;
        for (int i = 1; i < d.length; i++) {
            if (d[i] != INF && d[i] >= max) {
                if (d[i] > max) {
                    max = d[i];
                    answer = 1;
                    continue;
                }

                answer++;
            }
        }


        return answer;
    }

    class Node {
        int weight;
        int index;

        public Node(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }
}