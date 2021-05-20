package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42860
public class 조이스틱 {
    /*
        맨 처음에는 A로만 이루어진 알파벳,
        첫 번째 칸에서 시작

        상하로 움직이는 것과 좌우로 움직이는 것을 분리해서 구현.

        상하 움직임 :
        Math.min('J' - 'A', 'Z' - 'J' + 1)

        좌우 움직임 :
        탐색을 통해서 좌우 각 방향으로 이동했을 때 이동 최소값을 구함.
        방향이 바뀌면, 그 방향으로 쭉 진행함.
     */
    public int solution(String name) {
        int answer = 0;

        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'A') {
                // 상하 이동
                answer += Math.min(Math.abs(chars[i] - 'A'), Math.abs('Z' - chars[i] + 1));
            }

        }


        // 최소 이동 거리
        int min = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            int next = i + 1;
            while (next < chars.length && chars[next] == 'A') {
                next++;
            }

            // i까지 이동하고, <- 방향으로 가는 것과 -> 방향으로 가는 것을 비교
            min = Math.min(min, i + chars.length - next + i);
        }

        answer += min;


        return answer;
    }
}
