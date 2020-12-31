package Hash;

import java.util.*;

import static java.util.stream.Collectors.*;

public class 위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;


        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 0) + 1);
        }

        System.out.println(hashMap);
        for (String s : hashMap.keySet()) {
            answer *= hashMap.get(s) + 1;
        }
        answer -= 1;
        return answer;
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p ->p[1], mapping(p -> p[0],counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x,y) -> x * (y +1 ))).intValue() -1;


    }
}
