package Hash;

import java.util.HashSet;

public class 전화번호_목록 {


    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

//        System.out.println(phone_book[0].length());
        long start = System.currentTimeMillis();
        System.out.println(solution(phone_book));
        System.out.print("Millis : ");
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    private static boolean solution(String[] phone_book) {
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            for (int j = i + 1; j < phone_book.length; j++) {
//                if (phone_book[i].startsWith(phone_book[j])) {
//                    return false;
//                }
//                if (phone_book[j].startsWith(phone_book[i])) {
//                    return false;
//                }
//            }
//        }
//        return true;

        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {

                String s = phone_book[i];
                String target = phone_book[j];

                if (target.length() >= s.length() && target.substring(0, s.length()).equals(s)) {
                    return false;

                }
                if (target.length() < s.length() && s.substring(0, target.length()).equals(target)) {
                    return false;
                }
            }
        }
        return answer;
    }


}
