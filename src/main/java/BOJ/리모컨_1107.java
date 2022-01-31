package BOJ;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 리모컨_1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        // 1. 최대한 가까운 채널을 맞춘다 -> 1 ~ 999999 채널 중 하나로 미리 맞춘 상황을 가정하여 모두 탐색한다
        // 2. 채널 이동 수를 확인한다.
        int initChannel = 100;
        int targetChannel = Integer.parseInt(br.readLine()); // N
        int disabledButtonCount = Integer.parseInt(br.readLine()); // M
        Set<Character> disabledButtons = new HashSet<>();

        if (disabledButtonCount > 0) {
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < split.length; i++) {
                disabledButtons.add(split[i].charAt(0));
            }
        }

        int result = Math.abs(initChannel - targetChannel);

        channelLoop:
        for (int nowChannel = 0; nowChannel <= 999999; nowChannel++) {
            String nowChannelString = String.valueOf(nowChannel);
            int length = nowChannelString.length();

            for (int i = 0; i < length; i++) {
                if (disabledButtons.contains(nowChannelString.charAt(i))) {
                    continue channelLoop;
                }
            }
            int clickCount = Math.abs(targetChannel - nowChannel) + length;
            result = Math.min(result, clickCount);
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }
}
