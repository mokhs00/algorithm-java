package etc;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Given a binary tree, find a minimum path sum from root to a leaf.
 *
 * For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.
 *
 *   10
 *  /  \
 * 5    5
 *  \     \
 *    2    1
 *        /
 *      -1
 *
 * 주어진 이진 트리에서, 루트 (최상위 노드) 에서 리프 (자식이 없는 최하위 노드) 까지의 경로를 모두 더하였을 떄 가장 작은 값을 갖는 경로를 찾고, 그 합을 반환하세요.
 *
 * 예를 들어, 이 트리에서 최소 값을 갖는 경로는 [10, 5, 1, -1] 이며, 그 합인 15를 반환해야 합니다.
 *
 *   10
 *  /  \
 * 5    5
 *  \     \
 *    2    1
 *        /
 *      -1
 */
public class MinimumPath {

    static class Node {
        private long value;
        private Node left;
        private Node right;

        public Node(long value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static Long minimumPath(Node firstNode) {
        long lowestTotalCost = Long.MAX_VALUE;

        // List = [Node, totalCost]
        Stack<List<Object>> nodeCostMapStack = new Stack<>();

        nodeCostMapStack.add(List.of(firstNode, firstNode.getValue()));

        while (!nodeCostMapStack.isEmpty()) {
            List<Object> pop = nodeCostMapStack.pop();
            Node node = (Node) pop.get(0);
            long totalCost = (Long) pop.get(1);

            boolean isLastNode = Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight());
            if (isLastNode) {
                lowestTotalCost = Math.min(lowestTotalCost, totalCost);
                continue;
            }

            boolean hasRightNode = !Objects.isNull(node.getRight());
            if (hasRightNode) {
                Node right = node.getRight();
                nodeCostMapStack.add(List.of(right, totalCost + right.getValue()));
            }

            boolean hasLeftNode = !Objects.isNull(node.getLeft());
            if (hasLeftNode) {
                Node left = node.getLeft();
                nodeCostMapStack.add(List.of(left, totalCost + left.getValue()));
            }
        }

        return lowestTotalCost;
    }

    static void test1() {
        Node input = new Node(10,
                new Node(5,
                        null,
                        new Node(2)),
                new Node(5,
                        null,
                        new Node(1,
                                new Node(-1),
                                null)));

        long result = 15;


        System.out.println(minimumPath(input) == result);
    }

    static void test2() {
        Node input = new Node(10);
        long result = 10;

        System.out.println(minimumPath(input) == result);
    }

    static void test3() {
        Node input = new Node(10,
                new Node(5,
                        null,
                        new Node(2)),
                new Node(5));

        long result = 15;

        System.out.println(minimumPath(input) == result);
    }

    static void test4() {
        Node input = new Node(10,
                new Node(5, null, new Node(2)),
                new Node(5, null, new Node(1)));

        long result = 16;

        System.out.println(minimumPath(input) == result);
    }

    static void test5() {
        Node input = new Node(10,
                new Node(5,
                        null,
                        new Node(2)),
                new Node(5,
                        null,
                        new Node(1,
                                new Node(-1),
                                null)));
        long result = 15;

        System.out.println(minimumPath(input) == result);
    }
}
