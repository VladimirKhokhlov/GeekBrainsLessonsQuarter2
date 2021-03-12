package lesson5;

public class App {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    public static void methodOne() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void methodTwo() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, h);
            long a = System.currentTimeMillis();
            for (int i = 0; i < a1.length; i++) {
                arr[i] = 1;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
//            System.currentTimeMillis();
            System.arraycopy(a1, 0, arr, 0, h);
            System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() - a);
        }).start();
        new Thread(() -> {
            System.arraycopy(arr, h, a2, 0, h);
            long a = System.currentTimeMillis();
            for (int i = 0; i < a2.length; i++) {
                arr[i] = 1;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
//            System.currentTimeMillis();
            System.arraycopy(a2, 0, arr, h, h);
            System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() - a);
        }).start();
    }
}