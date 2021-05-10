package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/7662
public class 이중_우선순위_큐_7662 {
    /*
        이중 우선순위 큐
        TreeMap을 이용해서 구현한다.
     */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                String s1 = s[0];
                String s2 = s[1];

                if (s1.equals("I")) {
                    int key = Integer.parseInt(s2);
                    Integer orDefault = map.getOrDefault(key, 0);
                    map.put(key, orDefault + 1);
                }

                if (s1.equals("D")) {

                    if (map.isEmpty()) {
                        continue;
                    }

                    if (s2.equals("1")) {
                        Integer lastKey = map.lastKey();
                        Integer max = map.get(lastKey);
                        if (max == 1) {
                            map.remove(lastKey);
                        } else {
                            map.put(lastKey, max - 1);
                        }
                    }

                    if (s2.equals("-1")) {
                        Integer firstKey = map.firstKey();
                        Integer max = map.get(firstKey);
                        if (max == 1) {
                            map.remove(firstKey);
                        } else {
                            map.put(firstKey, max - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }

        }
        System.out.println(sb.toString());


        br.close();
    }


}



