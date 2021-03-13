package lesson5;

public class App {

    static final int size = 10_000_000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    public static void methodOne() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void methodTwo() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        Thread threadOne = new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, h);
            for (int i = 0; i < a1.length; i++) {
                arr[i] = 1;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, h);

        });
        Thread threadTwo = new Thread(() -> {
            System.arraycopy(arr, h, a2, 0, h);
            for (int i = 0; i < a2.length; i++) {
                arr[i] = 1;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, h, h);
        });
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }
}