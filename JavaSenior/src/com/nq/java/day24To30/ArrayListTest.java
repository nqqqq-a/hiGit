package com.nq.java.day24To30;


import com.nq.java.day24.Person;
import org.junit.Test;

import java.util.*;

/**
 * @Author Nq
 * @Data 2021-01-30-9:35
 */
public class ArrayListTest {

    /*
    void add(int index,Object ele): 在index位置插入ele元素
    boolean addAll(int index,Collection eles):从index位置开始讲eles中的所有元素添加进来
    Object get(int index):获取指定index位置的元素
    int indexOf(Object obj):返回obj在集合中首次出现的位置
    int lastIndexOf(Object obj):返回obj在当前集合中最后一次出现的位置
    Object remove(int index):移除指定index位置的元素，并返回此元素
    Object set(int index,Object ele):设置指定index位置的元素为ele
    List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合

     总结：常用方法
     增：add(Object obj)
     删：remove(int index) / remove(Object obj)
     改：set(int index,Object ele)
     查：get(int index)
     插：add(int index,Object ele)
     长度：size()
     遍历：①Iterator迭代器方式
          ②增强for循环
          ③普通的循环

     */
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------");

        //方式二：增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("---------");

        //方式三：普通的循环
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }

    }

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles):从index位置开始讲eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
//        list.add(list1); 这样子将list1当做一个整体加入了list中
        System.out.println(list.size()); //6 + 3
//        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置，若不存在，返回-1
        int index = list.indexOf(456);
        System.out.println(index);


        //int lastIndexOf(Object obj):返回obj在当前集合中最后一次出现的位置,若不存在，返回-1
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index,Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
        List newlist = list.subList(1, 3);
        System.out.println(newlist);

    }

}
