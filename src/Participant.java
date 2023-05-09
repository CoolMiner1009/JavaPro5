public class Participant {
    public void run() {
        System.out.println("Учасник пробігає відрізок дистанції");
    }

    public void jump() {
        System.out.println("Учасник перестрибує перешкоду");
    }
}

public class Human extends Participant {
    @Override
    public void run() {
        System.out.println("Людина пробігає відрізок дистанції");
    }

    @Override
    public void jump() {
        System.out.println("Людина перестрибує перешкоду");
    }
}

public class Cat extends Participant {
    @Override
    public void run() {
        System.out.println("Кіт пробігає відрізок дистанції");
    }

    @Override
    public void jump() {
        System.out.println("Кіт перестрибує перешкоду");
    }
}

public class Robot extends Participant {
    @Override
    public void run() {
        System.out.println("Робот пробігає відрізок дистанції");
    }

    @Override
    public void jump() {
        System.out.println("Робот перестрибує перешкоду");
    }
}
public class Obstacle {
    private int length;
    private int height;

    public Obstacle(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}

public class Treadmill extends Obstacle {
    public Treadmill(int length) {
        super(length, 0);
    }
}

public class Wall extends Obstacle {
    public Wall(int height) {
        super(0, height);
    }
}
    public static void main(String[] args) {
        Participant[] participants = {new Human(), new Cat(), new Robot()};
        Obstacle[] obstacles = {new Treadmill(100), new Wall(2)};

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                participant.overcome(obstacle);
            }
        }
    }
    public void overcome(Obstacle obstacle) {
        if (obstacle instanceof Treadmill) {
            System.out.printf("%s пробіг %d метрів.%n", this.getClass().getSimpleName(), obstacle.getLength());
        } else if (obstacle instanceof Wall) {
            if (obstacle.getHeight() > 2) {
                System.out.printf("%s не перестрибнув стіну висотою %d метрів. Він вибуває з гри.%n", this.getClass().getSimpleName(), obstacle.getHeight());
                return;
            } else {
                System.out.printf("%s перестрибнув стіну висотою %d метрів.%n", this.getClass().getSimpleName(), obstacle.getHeight());
            }
        }
    }

