package Programmers;

import java.util.HashMap;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        HashMap<String, Integer> map = new HashMap<>();

        String[] split = skill.split("");

        for (int i = 1; i <= split.length; i++) {
            map.put(split[i - 1], map.getOrDefault(split[i - 1], 0) + i);
        }

        for (String skill_tree : skill_trees) {
            String[] split1 = skill_tree.split("");
            int count = 0;

            for (int i = 0; i < split1.length; i++) {

                String now = split1[i];
                Integer nowCount = map.get(now);

                if (nowCount == null) {
                    continue;
                }
                if (nowCount == count + 1) {
                    count++;
                }else {
                    answer--;
                    break;
                }

            }

        }

        return answer;
    }
}
