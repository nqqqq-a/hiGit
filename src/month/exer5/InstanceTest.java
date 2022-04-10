package month.exer5;

public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest instanceTest = new InstanceTest();
        instanceTest.method(new Student());
    }

    public void method(Person e){
        String info = e.getinfo();
        System.out.println(info);
        if (e instanceof Graduate){
            System.out.println("a graduate student");
            System.out.println("a student");
            System.out.println("a person");
        }else if (e instanceof Student){
            System.out.println("a student");
            System.out.println("a person");
        }else System.out.println("a person");
    }
}
