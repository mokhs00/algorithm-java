package Algorithm;

public class UnionFind {
    private int[] parents;

    public static void main(String[] args) {
        // 0번부터 4번까지 노드가 있다고 가정
        int n = 5;
        UnionFind unionFind = new UnionFind(n);

        unionFind.unionParent(2,3);
        unionFind.unionParent(3,4);
        unionFind.unionParent(1,2);
        unionFind.unionParent(0,2);

        // 모두 연결되어 있으므로 부모가 0이어야 함
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + unionFind.getParent(i));
        }


    }


    public UnionFind(int N) {
        this.parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    private void unionParent(int a, int b){

        int aParent = getParent(a);
        int bParent = getParent(b);
        if (aParent < bParent){
            parents[bParent] = aParent;
        }else {
            parents[aParent] = bParent;
        }
    }

    private int getParent(int child){

        if (parents[child] == child){
            return child;
        }

        return getParent(parents[child]);
    }


}
