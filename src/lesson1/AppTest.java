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
                new Robot("Robot № 2", 35, 55),
                new Robot("Robot № 3", 45, 65),
        };

        Treadmill[] treadmills = {
                new Treadmill(30, 1),
                new Treadmill(45, 2),
                new Treadmill(60, 3),
        };

        Wall[] walls = {
                new Wall(10, 1),
                new Wall(20, 2),
                new Wall(30, 3),
        };

        startCompetition(humans, cats, robots, treadmills, walls);
    }

    public static boolean startCompetition(Human[] humans, Cat[] cats, Robot[] robots, Treadmill[] treadmills, Wall[] walls) {
        for (Human human : humans) {
            for (Treadmill treadmill : treadmills) {
                if (human.MAX_DISTANCE < treadmill.length) {
                    System.out.println(human.name + " не смог пробежать " + treadmill.number + " дорожку!");
                    human.check = false;
                    break;
                }
                System.out.println(human.name + " пробежал " + treadmill.number + " дорожку");
            }
            if (human.check) {
                for (Wall wall : walls) {
                    if (human.MAX_JUMP < wall.height) {
                        System.out.println(human.name + " не смог перепрыгнуть через " + wall.number + " стену!");
                        break;
                    }
                    System.out.println(human.name + " перепрыгнул через " + wall.number + " стену");
                }
            }
        }
        System.out.println();
        for (Cat cat : cats) {
            for (Treadmill treadmill : treadmills) {
                if (cat.MAX_DISTANCE < treadmill.length) {
                    System.out.println(cat.name + " не смог пробежать " + treadmill.number + " дорожку!");
                    cat.check = false;
                    break;
                }
                System.out.println(cat.name + " пробежал " + treadmill.number + " дорожку");
            }
            if (cat.check) {
                for (Wall wall : walls) {
                    if (cat.MAX_JUMP < wall.height) {
                        System.out.println(cat.name + " не смог перепрыгнуть через " + wall.number + " стену!");
                        break;
                    }
                    System.out.println(cat.name + " перепрыгнул через " + wall.number + " стену");
                }
            }
        }
        System.out.println();
        for (Robot robot : robots) {
            for (Treadmill treadmill : treadmills) {
                if (robot.MAX_DISTANCE < treadmill.length) {
                    System.out.println(robot.name + " не смог пробежать " + treadmill.number + " дорожку!");
                    robot.check = false;
                    break;
                }
                System.out.println(robot.name + " пробежал " + treadmill.number + " дорожку");
            }
            if (robot.check) {
                for (Wall wall : walls) {
                    if (robot.MAX_JUMP < wall.height) {
                        System.out.println(robot.name + " не смог перепрыгнуть через " + wall.number + " стену!");
                        break;
                    }
                    System.out.println(robot.name + " перепрыгнул через " + wall.number + " стену");
                }
            }
        }
        return false;
    }
}
