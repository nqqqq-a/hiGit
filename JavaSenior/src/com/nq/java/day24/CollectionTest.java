package com.nq.java.day24;

import org.junit.Test;


import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *   说明：此时的存储，主要指的是内存层面的存储，不涉及持久化的存储(.txt,.jpg,.avi)
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据。
 *        比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改了。
 *      > 数组中提供的方法有限，对于添加、删除、插入数据等操作，非常不便，同时效率低。
 *      > 获取数组中实际元素的个数需求时，数组没有现成的属性或方法使用。
 *      > 数组存储数据的特点：有序、可重复数据。对于无序的需求，不可重复的需求，数组不能满足
 *
 * 二、集合框架
 *
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。 --> “动态”数组
 *  *              |--->实现类：ArrayList、LinkedList、Vector
 *          |----Set接口：存储无序的、不可重复的数据。 --> 高中讲的“集合”
 *              |--->实现类：HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据 --> 高中的函数：y = f(x)
 *           map里一个key不能对应多个value，但同样的value可以对应不同的key
 *          |--->实现类：HashMap、LinkedHashMap、TreeMap、Hashtable。Properties
 *
 *
 * 三、Collection接口这种的方法的使用
 *  1.向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * 四、方法
 * 1.add(Object e): 将元素e添加到集合col1中，此时我们没用泛型，所以是Object类。
 * 2.size():获取col1中的元素个数
 * 3.addAll(Collection col2): 将col2集合中的元素添加到调用此方法的集合中
 * 4.clear():清空集合中的元素。只清空数据，对象仍然存在。
 * 5.isEmpty:判断当前集合是否为空
 * 6.contains(Object obj):判断当前集合是否包含obj。实际使用的是equals()方法。
 * 7.remove(Object obj):移除obj的元素
 * 8.removeAll(Collection col): 差集 ---> 从当前集合中移除col中所有的元素,在当前集合中移除共有的部分
 * 9.retainAll(Collection col2): 交集 ---> 从当前集合中选取col2中也存在的元素，修改了当前集合
 * 10.equals(Object obj): 判断两个集合是否相等，又以为你是Collection，所以顺序也要保证一致。
 * 11.集合 --->数组：toArray()
 * 拓展：数组 --->集合？ 调用Arrays类的静态方法asList
 *
 * @Author Nq
 * @Data 2021-01-24-10:19
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection col1 = new ArrayList();

        //add(Object e): 将元素e添加到集合col1中，此时我们没用泛型，所以是Object类。
        col1.add("AA");
        col1.add("BB");
        col1.add(123); //自动装箱
        col1.add(new Date());
        System.out.println(col1);

        //size():获取col1中的元素个数
        System.out.println(col1.size());

        //addAll(Collection col2): 将col2集合中的元素添加到调用此方法的集合中
        Collection col2 = new ArrayList();
        col2.add(456);
        col2.add("CC");
        col1.addAll(col2);


        System.out.println(col1);
        System.out.println(col1.size()); //6

        //clear():清空集合中的元素。只清空数据，对象仍然存在。
        col2.clear();

        //isEmpty:判断当前集合是否为空
        System.out.println(col1.isEmpty()); //false
        System.out.println(col2.isEmpty()); //true 因为上一步把col2清空了

        //contains(Object obj):判断当前集合是否包含obj。实际使用的是equals()方法。
        col1.add(new Person("Jerry", 20));
        col1.add(false);
        System.out.println("contains: " + col1.contains(123));
        //使用String.equals()方法，比较的是值。
        System.out.println(col1.contains(new String("AA")));
        //重写Person类equals方法前，是false，重写后比较值，传回来是true。
        System.out.println(col1.contains(new Person("Jerry",20)));

        //containsAll(Collection col):判断形参中的所有元素是否都存在于调用该方法的集合中。
        Collection col = Arrays.asList(123,456);
        System.out.println(col1.containsAll(col));
    }

    @Test
    public void test2(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person("Jerry",20));
        col1.add(new String("Tom"));
        col1.add(false);

        System.out.println(col1);
        //remove(Object obj):移除obj的元素
        col1.remove(123); //返回值为Boolean类型,且只会删除第一个出现的元素
        System.out.println(col1);

        col1.remove(new Person("Jerry",20));
        System.out.println(col1);

        //removeAll(Collection col): 差集 ---> 从当前集合中移除col中所共有的元素,在当前集合中移除共有的部分
        Collection col2 = Arrays.asList(123,456,false);
        col1.removeAll(col2); //因为col2与col1都有465和false。所有col1中删除这两各个
        System.out.println(col1);

    }

    @Test
    public void test3(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person("Jerry",20));
        col1.add(new String("Tom"));
        col1.add(false);

        //retainAll(Collection col2): 交集 ---> 从当前集合中选取col2中也存在的元素，修改了当前集合
        Collection col2 = Arrays.asList(123,456,789);
        col1.retainAll(col2);
        System.out.println(col1);

        //equals(Object obj): 判断两个集合是否相等(包括顺序)，又因为是Collection下的List接口，所以顺序也要保证一致。
        Collection col3 = new ArrayList();
        col3.add(123);
        col3.add(456);
        col3.add(new Person("Jerry",20));
        col3.add(new String("Tom"));
        col3.add(false);

        System.out.println(col3.equals(col1));


    }

    @Test
    public void test4(){
        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(new Person("Jerry",20));
        col1.add(new String("Tom"));
        col1.add(false);

        //hashCode():返回调用该方法的hash值
        System.out.println(col1.hashCode());

        //集合 --->数组：toArray()
        Object[] arr = col1.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }

        //拓展：  数组 --->集合？ 调用Arrays类的静态方法asList
        List<String> strings = Arrays.asList("AA", "BB", "cc");
        System.out.println(strings);

        //iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}

