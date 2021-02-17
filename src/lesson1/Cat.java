package lesson1;

public class Cat {
    String name;
    final int MAX_JUMP;
    final int MAX_DISTANCE;

    public Cat(String name, int max_jump, int max_distance) {
        this.name = name;
        MAX_JUMP = max_jump;
        MAX_DISTANCE = max_distance;
    }

    public static void run(){
        System.out.println("Кот побежал");
    }

    public static void jump(){
        System.out.println("Кот прыгнул");
    }
}
