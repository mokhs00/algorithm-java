package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기_2022KAKAO_LV1 {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Integer> idIndexMap = new HashMap();
            Map<String, Set<String>> userReportMap = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                idIndexMap.put(id_list[i], i);
            }

            for (String item : report) {
                String[] items = item.split(" ");
                String reportedUserId = items[0];
                String targetUserId = items[1];

                Set<String> reportSet = userReportMap.getOrDefault(targetUserId, new HashSet<>());
                reportSet.add(reportedUserId);

                userReportMap.put(targetUserId, reportSet);
            }


            Set<String> userReportTargetSet = userReportMap.keySet();

            for (String target : userReportTargetSet) {
                Set<String> reportUserSet = userReportMap.get(target);

                if (reportUserSet.size() >= k) {
                    for (String user : reportUserSet) {
                        answer[idIndexMap.get(user)] += 1;
                    }
                }
            }

            return answer;
        }

    }
}
