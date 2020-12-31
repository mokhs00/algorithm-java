package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class H_Index {

    public static void main(String[] args) {
        int[] citations = {4,3,2,2};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int citation : citations) {
            list.add(citation);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int get = list.get(i);
            if (0 >= list.size()-i-get) {
                return list.size()-i;
            }
        }
        return answer;
    }
}
