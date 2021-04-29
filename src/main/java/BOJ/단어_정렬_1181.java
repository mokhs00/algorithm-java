package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://www.acmicpc.net/problem/1181
public class 단어_정렬_1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arrayList.add(input);
        }

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }

        });

        for (int i = 0; i < arrayList.size(); i++) {
            String now = arrayList.get(i);
            if (i > 0 && now.equals(arrayList.get(i - 1)))
                continue;
            System.out.println(now);
        }

    }
}
