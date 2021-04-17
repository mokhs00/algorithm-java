package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    private int[] parents;
    int totalCost = 0;


    public static void main(String[] args) {

        /*
            4개의 노드가 존재하고
            그래프에서 각 간선의 정보(노드1, 노드2, 비용)이 주어진 상황이라고 가정하고
            트리를 만드는데 드는 최소 비용을 구한다.
            아래 예시의 경우 최소 비용은 4
         */
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};


        // 비용 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        Kruskal kruskal = new Kruskal(n);

        kruskal.run(costs);
        System.out.println(kruskal.getTotalCost());

    }

    private int getParent(int child){
        if (this.parents[child] == child){
            return child;
        }

        return getParent(this.parents[child]);
    }

    public Kruskal(int N) {
        this.parents = new int[N];

        for (int i = 0; i < this.parents.length; i++) {
            this.parents[i] = i;
        }
    }

    private int getTotalCost(){
        return this.totalCost;
    }

    private void run(int[][] costs){
        for (int[] c : costs) {
            int first = c[0];
            int second = c[1];
            int cost = c[2];

            int parentFirst = getParent(first);
            int parentSecond = getParent(second);

            // 연결되어 있지 않다면
            if (parentFirst != parentSecond){
                // 비용추가
                totalCost += cost;
                // 두 노드를 연결 : 부모 노드를 갱신
                if (parentFirst < parentSecond){
                    this.parents[parentSecond] = parentFirst;
                }else {
                    this.parents[parentFirst] = parentSecond;
                }
            }

        }





    }





}
