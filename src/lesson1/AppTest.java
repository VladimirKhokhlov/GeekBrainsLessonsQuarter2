package lesson1;

public class AppTest {
    public static void main(String[] args) {
        Human[] humans = {
                new Human("Олежка", 10, 20),
                new Human("Володька", 15, 30),
                new Human("Семён", 20, 40),
        };

        Cat[] cats = {
                new Cat("Мурзик", 15, 25),
                new Cat("Барсик", 25, 45),
                new Cat("Черныш", 35, 55),
        };

        Robot[] robots = {
                new Robot("Robot № 1", 25, 45),
                new Robot("Robot № 1", 35, 55),
                new Robot("Robot № 1", 45, 65),
        };

        Treadmill[] treadmills = {
                new Treadmill(30, 1),
                new Treadmill(45, 2),
                new Treadmill(60, 3),
        };

        Wall[] walls = {
                new Wall(10,1),
                new Wall(20,2),
                new Wall(30,3),
        };

        run(humans, treadmills, walls);
    }

    public static void run(Human[] humans, Treadmill[] treadmills, Wall[] walls) {
        for (Human human : humans) {
            for (Treadmill treadmill : treadmills) {
                if (human.MAX_DISTANCE >= treadmill.length) {
                    System.out.println(human.name + " пробежал " + treadmill.number + " дорожку");
                    jump(humans, walls);
                if (human.MAX_DISTANCE < treadmill.length) {
                    System.out.println(human.name + " не смог пробежать " + treadmill.number + " дорожку!");
                    break;
                }
                }
            }
        }
    }

    public static void jump(Human[] humans, Wall[] walls) {
        System.out.println();
        for (Human human : humans) {
            for (Wall wall : walls) {
                if (human.MAX_JUMP < wall.height) {
                    System.out.println(human.name + " не смог перепрыгнуть через  " + wall.number + " стену!");

                if (human.MAX_JUMP >= wall.height) {
                    System.out.println(human.name + " перепрыгнул через  " + wall.number + " стену");
                    return;
                }
                }

            }
        }
    }
}
