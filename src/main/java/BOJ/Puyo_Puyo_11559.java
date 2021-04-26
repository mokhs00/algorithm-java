package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/11559
public class Puyo_Puyo_11559 {

    /*
        1. field를 돌면서 BFS를 이용해 주변에 몇개의 같은 뿌요가 있는지 확인한다.

        2. 그룹이 있다면(4개 이상 뭉쳐있다면) 사라짐
            * 그룹이 여러 그룹이라면 한 번에 터짐.
           (사라지려면 사라질 대상 좌표를 기록해둬야됨.)
           count++;

        3. 사라진 칸 위에 있는 뿌요들이 내려와 칸을 채운다.
     */

    static int MAX_Y = 12; // 줄의 수
    static int MAX_X = 6; // 문자 수
    static char[][] field = new char[MAX_Y][MAX_X];
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<Node> toRemove = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < MAX_Y; i++) {
            field[i] = br.readLine().toCharArray();
        }

        Puyo_Puyo_11559 puyo_puyo_11559 = new Puyo_Puyo_11559();

        int solution = puyo_puyo_11559.solution();

        System.out.println(solution);


    }

    public int solution() {
        int answer = 0;

        while (true) {
            visited = new boolean[MAX_Y][MAX_X];

            for (int y = 0; y < MAX_Y; y++) {
                for (int x = 0; x < MAX_X; x++) {
                    bfs(x, y);
                }
            }

            if (!toRemove.isEmpty()) {
                answer++;
            } else {
                break;
            }


            while (!toRemove.isEmpty()) {
                Node poll = toRemove.poll();
                int x = poll.x;
                int y = poll.y;
                field[y][x] = '.';
            }

            down();

        }

        return answer;
    }

    public void bfs(int x, int y) {
        char target = field[y][x];
        if (target == '.') {
            visited[y][x] = true;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        // 연결되어 있고 색이 같은 뿌요를 기록할 Queue
        Queue<Node> link = new LinkedList<>();

        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            visited[poll.y][poll.x] = true;

            link.add(poll);

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= MAX_X || nextY >= MAX_Y) {
                    continue;
                }

                char nextNode = field[nextY][nextX];
                if (!visited[nextY][nextX] && nextNode == target) {
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        // 4개 이상일때
        if (link.size() >= 4) {
            while (!link.isEmpty()) {
                Node poll = link.poll();
                toRemove.add(poll);
            }
        }


    }

    public void down() {
        for (int x = 0; x < MAX_X; x++) {
            Queue<Character> queue = new LinkedList<>();
            for (int y = MAX_Y - 1; y >= 0; y--) {
                if (field[y][x] != '.') {
                    queue.add(field[y][x]);
                }
            }

            for (int y = MAX_Y - 1; y >= 0; y--) {
                if (queue.isEmpty()) {
                    field[y][x] = '.';
                    continue;
                }
                field[y][x] = queue.poll();
            }
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
