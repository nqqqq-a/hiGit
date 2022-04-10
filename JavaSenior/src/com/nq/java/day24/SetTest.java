package com.nq.java.day24;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1.Set接口的框架：
 *
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *   |----Set接口：存储无序的、不可重复的数据。 --> 高中讲的“集合”
 *     |--->实现类：HashSet：作为Set接口的主要实现类,线程不安全的；可以存储null值
 *        |--->实现类：LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历。加入了双向指针
 *                   优点：对于频繁的遍历操作,LinkedList效率高于HashSet。
 *     |--->实现类：TreeSet：红黑树！可以按照添加对象的指定属性进行排序。
 *
 * 1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 *
 * 2. 要求：向Set中添加的数据，其一定要重写hashCode()和equals()
 *    要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 * @Author Nq
 * @Data 2021-01-30-16:26
 */
public class SetTest {
    /*

    一、Set:存储无序的、不可重复的数据
    以HashSet为例说明：
    1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引顺序添加，而是根据数据的hash值决定的。

    2.不可重复性：保证添加的元素按照equals()方法判断时，返回true即为相同元素。
                创建的对象添加时要重写equals()和hashcode()方法

    二、添加元素的过程：以HashSet为例：
    我们想Set中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
    此哈希值根据某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），
    判断此位置上是否存在元素：
        如果此位置上没有元素，则元素a直接添加在此位置上。成功！--->情况一
        如果有其他元素，逐一比较元素a与此位置上的元素的hash值：
            如果哈希值不同，则元素a添加进去。！--->情况二
            如果哈希值相同，进而调用a所在类的equals()方法：
                返回 true，则不插入a。
                返回 false，则插入成功。--->情况三

        对于添加成功的情况二与情况三而言：元素a与已经存在指定索引位置上的数据以链表方式存储
        jdk 7：元素a放在数组中，指向原来的元素
        jdk 8：原来的元素放在数组中，指向元素a （七上八下）

        HashSet底层：数组+链表的结构。

     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    LinkedHashSet的使用
    在HashSet的基础上使用一个双向链表。按照插入时的顺序，将指针标记好。
    记录了此数据的前一个数据和后一个数据
    优点：对于频繁的遍历操作,LinkedList效率高于HashSet。
     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
