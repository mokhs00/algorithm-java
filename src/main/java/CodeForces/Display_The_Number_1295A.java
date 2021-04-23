package CodeForces;

import java.util.Scanner;

public class Display_The_Number_1295A {
    /*
        1 : 2
        7 : 3
        4 : 4
        2 : 5
        3 : 5
        5 : 5
        0 : 6
        6 : 6
        9 : 6
        8 : 7

        자리 수가 최대한 많아야하므로 2로 나눠서 1을 최대한 붙이고
        2로 나눈 나머지가 1 이라면 7을 붙일 수 있으므로 맨 앞에 7을 붙인다.
        ->
        1. StringBuilder에 2로 나눈 나머지가 1이면 7을 붙이고 아니면 1을 붙임
        2. 2로 나눈 몫-1 만큼 1을 붙임
     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            int r = input / 2;
            int c = input % 2;
            StringBuilder sb = new StringBuilder();
            if (c == 0) {
                sb.append(1);
            } else {
                sb.append(7);
            }
            for (int j = 1; j < r; j++) {
                sb.append(1);
            }

            System.out.println(sb.toString());

        }


    }
}
