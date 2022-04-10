package month.day13.night;

public interface Flyable {

    //全局常量 public final static 默认会有,可以省略
    int MAX_SPEED = 7900;
    public final static  int MIN_SPEED = 1;

    // 默认有 public abstract
    public abstract void fly();
    void stop();

}

interface Attackable extends Flyable{
    void attack();

    @Override
    void fly();
}
