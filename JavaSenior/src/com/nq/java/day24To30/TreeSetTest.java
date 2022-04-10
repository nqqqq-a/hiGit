package com.nq.java.day24To30;

import com.nq.java.day24.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author Nq
 * @Data 2021-01-30-21:56
 */
public class TreeSetTest {

    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式:自然排序(实现Comparable接口) 和 定制排序(Comparator)

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：自定义类
        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",32));
        set.add(new Person("Jim",2));
        set.add(new Person("Mike",65));
        set.add(new Person("Jack",33));
        set.add(new Person("Jack",35));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(comparator); //此时用了comparator，用了定制排序

        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",32));
        set.add(new Person("Jim",2));
        set.add(new Person("Mike",65));
        set.add(new Person("Jack",33));
        set.add(new Person("Marry",33));
        set.add(new Person("Jack",35));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        int num = 1;
        Scanner sc = new Scanner(System.in);
        int n = 13;
        for(int i = 1;i <= n;i++){
            num *= i;
        }
        System.out.println(num);
    }
}
