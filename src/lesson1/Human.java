package lesson1;

public class Human {
    String name;
    final int MAX_JUMP;
    final int MAX_DISTANCE;

    public Human(String name, int max_jump, int max_distance) {
        this.name = name;
        this.MAX_JUMP = max_jump;
        this.MAX_DISTANCE = max_distance;
    }

    public static void run(){
        System.out.println("Человек пробежал");
    }

    public static void jump(){
        System.out.println("Человек прыгнул");
    }
}
