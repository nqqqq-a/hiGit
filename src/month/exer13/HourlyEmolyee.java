package month.exer13;

public class HourlyEmolyee extends Employee{

    private int wage; //每小时工资
    private int hour; //月工作小时数

    public HourlyEmolyee() {
    }

    public HourlyEmolyee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmolyee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmolyee{"+ super.toString()  +"}";
    }
}
