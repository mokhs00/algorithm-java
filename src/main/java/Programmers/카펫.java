package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
public class 카펫 {
    /*
        중앙은 노란색,
        테두리 1줄은 갈색

        카펫의 가로 세로 크기를 순서대로 return
        가로 >= 세로

        풀이 1:
        전체 크기에서 가로 세로를 정하면,
        (가로 - 2) * (세로 - 2)가 노란색으로 칠해진 부분의 크기가 됨.
        이를 이용해서 노란색으로 칠해진 부분의 크기가 yellow와 일치하면,
        (가로: 큰 값, 세로: 작은 값) return
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalSize = brown + yellow;


        for (int height = 3; height <= totalSize; height++) {
            int width = totalSize / height;
            int yellowHeight = (height - 2);
            int yellowWidth = (width - 2);
            if (yellowHeight * yellowWidth == yellow) {
                answer[0] = Math.max(width, height);
                answer[1] = Math.min(width, height);
                break;
            }

        }


        return answer;
    }
}
