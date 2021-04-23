package Algorithm;

public class ImageRotation {
    int N;
    int[][] arr;

    public static void main(String[] args) {

        ImageRotation imageRotation = new ImageRotation();
        imageRotation.init(5);
        imageRotation.showImage();

        imageRotation.rotationBorder(0, 0, 5);
        imageRotation.showImage();

        imageRotation.init(10);
        imageRotation.showImage();
        imageRotation.rotation(0, 0, 6);
        imageRotation.showImage();
    }


    public void init(int N) {
        N = N;
        arr = new int[N][N];
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
            }
        }
    }

    // x, y 기준으로 오른쪽으로 한 변이 size인 정사각형 이미지를 회전시킴
    public void rotation(int x, int y, int size) {

        int xEnd = x + size - 1;
        int yEnd = y + size - 1;
        if (xEnd >= arr.length || yEnd >= arr.length)
            throw new IllegalArgumentException("이미지 범위를 초과합니다.");

        while (size > 0) {
            rotationBorder(x, y, size);
            x++;
            y++;
            size -= 2;
        }

    }

    // x, y 기준으로 오른쪽으로 한 변이 size인 정사각형 이미지의 테두리를 회전시킴
    public void rotationBorder(int x, int y, int size) {

        int xEnd = x + size - 1;
        int yEnd = y + size - 1;
        if (xEnd >= arr.length || yEnd >= arr.length)
            throw new IllegalArgumentException("이미지 범위를 초과합니다.");

        for (int i = 0; i < size - 1; i++) {

            int temp = arr[y][x + i];
            arr[y][x + i] = arr[y + i][xEnd];
            arr[y + i][xEnd] = arr[yEnd][xEnd - i];
            arr[yEnd][xEnd - i] = arr[yEnd - i][x];
            arr[yEnd - i][x] = temp;
        }

    }

    public void showImage() {
        System.out.println();

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }

    }
}
