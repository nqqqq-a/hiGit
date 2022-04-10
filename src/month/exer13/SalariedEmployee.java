package month.exer13;

public class SalariedEmployee extends Employee{

    private double monthlySalary;

    @Override
    public double earnings() {
    return monthlySalary;
    }

    public SalariedEmployee(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }


    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString();
    }
}
