package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가장_큰_수 {

    public static void main(String[] args) {
        int[] numbers = {0,0,0,0};


        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {

        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }

//        String answer = "";
//
//        List<String> list = new ArrayList<>();
//
//        for (int number : numbers) {
//            String s = Integer.toString(number);
//            list.add(s);
//        }
//
//        list.sort((s, anotherString) -> (s+s+s).compareTo(anotherString+anotherString+anotherString));
//        for (int i = list.size()-1; i >= 0; i--) {
//            answer += list.get(i);
//        }
//
//        if (answer.startsWith("0")){
//            answer = "0";
//        }
//
//        return answer;
    }
}
