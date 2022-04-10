package month.exer5;

public class Person {
    protected String name = "person";
    protected int age = 50;

    public String getinfo(){
        return "name:" + name + "\n" + "age:"+age;
    }
}


class Student extends Person{
    protected String school = "pku";

    @Override
    public String getinfo() {
        return "name:" + name + "\n" + "age:"+age + "\n" + "school" + school;
    }
}

class Graduate extends Student {
    public String major = "IT";

    @Override
    public String getinfo() {
        return "name:" + name + "\n" + "age:"+age + "\n" + "school" + school
                +"\n major:"+major;
    }
}