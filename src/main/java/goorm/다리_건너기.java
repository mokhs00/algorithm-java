package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 다리_건너기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * 다리를 건너기 위해 최적의 비용을 찾는 문제
     * 각 사람의 이동속도는 서로 다름.
     * 1차 시도 :
     * 가장 빠른 2명을 이동시킨 뒤 가장 느린 2명을 이동시키는 방식으로 풀이했음
     * 결과 : 오답
     * <p>
     * 2차 시도 :
     * 1차 시도에서 1, 8, 9, 10 의 케이스는 1이 모든 사람을 이동시키는 것이 1차 시도의 방식보다 비용이 적게 듬을 확인함
     * 따라서 비용을 계산하는 방법을 고려한 결과
     * 가장 비용이 많이 드는 2명을 이동시키고, 손전등은 원래 위치로 돌아오는 것을 목표로 다음 2가지 식이 도출됨
     * 아래 식에선 4명 + @ 의 기준으로 하며, 각 사람에게 비용이 적게 드는 순으로 a, b, c, d의 식별자를 부여함.
     * (a < b < c < d)
     * <p>
     * 1. (가장 빠른 2명을 이동 시킨 뒤 가장 느린 2명을 이동시키는 경우)
     * b(a, b 오른쪽 이동) + a(a가 돌아옴) + d(c, d 오른쪽 이동) + b(b가 돌아옴)
     * => a + 2b + d
     * 2. (가장 빠른 1명이 가장 느린 2명을 이동시키는 경우)
     * d(a, b 오른쪽 이동) + a(a가 돌아옴) + c(a, c 오른쪽 이동) + a(a가 돌아옴)
     * => 2a + c + d
     * <p>
     * 위 2가지 식의 값 중 더 적은 비용을 선택하면 최적의 비용을 도출할 수 있음
     * 이 방식으로 풀이
     * <p>
     * 결과 : 정답
     */
    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());
        long cost = 0;

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list);

        while (!list.isEmpty()) {
            if (N == 2) {
                cost += list.get(1);
                break;
            } else if (N == 1) {
                cost += list.get(0);
                break;
            }

            if (list.size() == 3) {
                cost += list.get(0) + list.get(1) + list.get(2);
                break;
            } else if (list.size() <= 2) {
                cost += list.get(list.size() - 1);
                break;
            } else {
                long a = list.get(0); // faster1
                long b = list.get(1); // faster2
                long c = list.get(list.size() - 2); // slower2
                long d = list.get(list.size() - 1); // slower1


                cost += Math.min(a + b * 2 + d, a * 2 + c + d);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }

        bw.write(Long.toString(cost));

        br.close();
        bw.close();
    }
}
