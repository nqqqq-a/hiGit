package month.exer12;

public class Test {
    public static void main(String[] args) {
        Employee employee = new CommonEmployee();
        Employee employee1 = new Manager("nq",01,10000,5000);

        employee.work();
        employee1.work();


    }
}
