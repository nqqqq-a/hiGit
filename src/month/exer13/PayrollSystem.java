package month.exer13;

import java.net.CacheRequest;
import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {

        //方法一：输入一个月份
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入当月的月份：");
//        int month = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        Employee[] emps = new Employee[2];
        emps[0] = new SalariedEmployee("马森",1002,new MyDate(2000,05,03),10000);
        emps[1] = new HourlyEmolyee("潘雨声",1003,new MyDate(2001,11,15),60,240);

        for (int i = 0;i < emps.length;i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资为：" + salary);

            if (month + 1 == emps[i].getBirthday().getMonth()){
                System.out.println("生日快乐,奖励100元");
            }
        }
    }
}
