package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 일곱_난쟁이_2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int N = 9;
        final int MAX_HEIGHT_SUM = 100;
        int heightSum = 0;

        List<Dwarf> dwarfList = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int height = Integer.parseInt(line);
            dwarfList.add(new Dwarf(i, height));
            heightSum += height;
        }

        Dwarf invalidDwarf1 = null;
        Dwarf invalidDwarf2 = null;

        for (Dwarf dwarf1 : dwarfList) {
            for (Dwarf dwarf2 : dwarfList) {
                if (dwarf1.getId() == dwarf2.getId()) {
                    continue;
                }

                int diff = heightSum - (dwarf1.getHeight() + dwarf2.getHeight());
                if (MAX_HEIGHT_SUM == diff) {
                    invalidDwarf1 = dwarf1;
                    invalidDwarf2 = dwarf2;
                    break;
                }
            }

            if (invalidDwarf1 != null && invalidDwarf2 != null) {
                break;
            }
        }

        dwarfList.remove(invalidDwarf1);
        dwarfList.remove(invalidDwarf2);

        dwarfList.sort(Comparator.comparing(Dwarf::getHeight));

        for (Dwarf dwarf : dwarfList) {
            bw.write(dwarf.getHeight() + "\n");
        }

        br.close();
        bw.close();
    }

    static class Dwarf {
        private int id;
        private int height;

        public Dwarf(int id, int height) {
            this.id = id;
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public int getHeight() {
            return height;
        }
    }
}
