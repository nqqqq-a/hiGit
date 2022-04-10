package com.nq.month2.MapStudy;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author Nq
 * @Data 2021-02-10-9:57
 */
public class TreeMapTest {

    //TreeMap按照key排序，要求key必须是由同一个类创建的对象
    //自然排序、定制排序
    @Test
    public void test(){
        TreeMap map = new TreeMap();
        Person p1 = new Person("Tom", 25);
        Person p2 = new Person("Jerry", 32);
        Person p3 = new Person("Jack", 20);
        Person p4 = new Person("Rose", 18);
        map.put(p1,98);
        map.put(p2,89);
        map.put(p3,72);
        map.put(p4,100);

        System.out.println(map);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }
                throw new RuntimeException("数据传输类型");
            }
        });
        Person p1 = new Person("Tom", 25);
        Person p2 = new Person("Jerry", 32);
        Person p3 = new Person("Jack", 20);
        Person p4 = new Person("Rose", 18);
        map.put(p1,98);
        map.put(p2,89);
        map.put(p3,72);
        map.put(p4,100);

        System.out.println(map);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
