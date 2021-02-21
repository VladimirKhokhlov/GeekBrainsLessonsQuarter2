package lesson1;

public class Robot {
    String name;
    final int MAX_JUMP;
    final int MAX_DISTANCE;
    boolean check = true;

    public Robot(String name, int max_jump, int max_distance) {
        this.name = name;
        MAX_JUMP = max_jump;
        MAX_DISTANCE = max_distance;
    }

    public static void run(){
        System.out.println("Робот побежал");
    }

    public static void jump(){
        System.out.println("Робот прыгнул");
    }
}
