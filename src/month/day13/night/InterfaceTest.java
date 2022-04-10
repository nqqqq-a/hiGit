package month.day13.night;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane plane = new Plane();
        
    }

}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("飞机起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机停止");
    }
}

class Kite implements Flyable{


    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}

class Bullet implements Flyable,Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}
