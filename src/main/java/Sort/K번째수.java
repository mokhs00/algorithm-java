package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(array, commands);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < commands.length; i++) {

            List<Integer> subList =
                    list
                            .subList(commands[i][0]-1, commands[i][1])
                            .stream()
                            .sorted((o1, o2) -> o1 - o2)
                            .collect(Collectors.toList());
            answerList.add(subList.get(commands[i][2]-1));
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
