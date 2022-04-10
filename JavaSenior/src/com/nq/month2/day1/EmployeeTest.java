package com.nq.month2.day1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author Nq
 * @Data 2021-02-01-11:51
 */
public class EmployeeTest {

    //使用自然排序
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("刘德华",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("张学友",43,new MyDate(1972,6,2));
        Employee e3 = new Employee("郭富城",44,new MyDate(1973,7,3));
        Employee e4 = new Employee("黎明",51,new MyDate(1969,2,4));
        Employee e5 = new Employee("梁朝伟",50,new MyDate(1970,1,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

//        System.out.println(set);
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //使用定制排序
    @Test
    public void test2(){

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1,Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    //方式一：
//                    int minusYear = b1.getYear() - b2.getYear();
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    int minusDay = b1.getDay() - b2.getDay();
//                    //比较年
//                    if (minusYear != 0){
//                        return minusYear;
//                    }
//                    //比较月
//                    if (minusMonth != 0){
//                        return minusMonth;
//                    }
//                    //比较日
//                    return minusDay;

                    //方式二：
                    return b1.compareTo(b2);
                }
               throw new RuntimeException("数据类型不一致");
//                return 0;
            }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1972,6,2));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1973,7,3));
        Employee e4 = new Employee("liming",51,new MyDate(1969,2,4));
        Employee e5 = new Employee("liangchaowei",50,new MyDate(1970,1,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
