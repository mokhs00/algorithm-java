package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

// https://www.acmicpc.net/problem/1302
public class 베스트셀러_1302 {
    /*
        HashMap에 담아서 카운트 해주고
        HashMap을 돌며 카운트가 가장 크고 사전순으로 앞서는 key, value를 찾는다.
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Integer orDefault = map.getOrDefault(input, 0);
            map.put(input, orDefault + 1);
        }

        Set<String> keySet = map.keySet();

        int max = 0;
        String maxKey = "";
        for (String key : keySet) {
            Integer integer = map.get(key);
            if (integer >= max) {
                if (max == integer) {
                    if (maxKey.compareTo(key) > 0) {
                        maxKey = key;
                    }
                    continue;
                }
                max = integer;
                maxKey = key;
            }
        }

        System.out.println(maxKey);
    }


}
