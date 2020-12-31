package Hash;

import java.util.HashMap;
import java.util.HashSet;

public class 전화번호_목록 {


    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(phone_book[0].length());
//        System.out.println(solution(phone_book));

    }

    private static boolean solution(String[] phone_book) {
        boolean answer = true;


        HashSet<String> hashSet = new HashSet();
        for (String s : phone_book) {
            hashSet.add(s);
        }

        for (String s : hashSet) {
            for (String target : hashSet) {
                if (s.equals(target))
                    continue;
                if (target.length() >= s.length() && target.substring(0, s.length()).equals(s)) {
                    answer = false;
                    break;
                }
                if (target.length() < s.length() && s.substring(0, target.length()).equals(target)){
                    answer = false;
                    break;
                }
            }
        }


        return answer;
    }


}
