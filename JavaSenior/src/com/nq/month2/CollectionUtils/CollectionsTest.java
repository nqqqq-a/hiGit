package com.nq.month2.CollectionUtils;

import org.junit.Test;

import java.util.*;

/**
 * Collections:操作Collection、Map的工具类
 *
 *
 *
 * 面试题：Collection 和 Collections的区别？
 * 1.Collection是一个接口，而Collections是一个工具类
 *
 *
 *
 * @Author Nq
 * @Data 2021-02-10-10:49
 */
public class CollectionsTest {

/*
reverse(List): 反转 List 中元素的顺序
shuffle(List): 对 List 集合元素进行随机排序
sort(List): 根据元素的自然排序顺序对指定 List 集合元素按升序排序
sort(List,Comparator): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
swap(List,int,int): 将指定 list 集合中的 i 处元素和 j 处元素进行交换。

Object max(Collection): 根据元素的自然排序，返回给定集合中的最大元素
Object max(Collection,Comparator): 根据 Comparator 指定的顺序，返回给定集合中的最大元素
Object min(Collection): 根据元素的自然排序，返回给定集合中的最小元素
Object min(Collection,Comparator):根据 Comparator 指定的顺序，返回给定集合中的最小元素
int frequency(Collection,Object): 返回指定集合中指定元素的出现次数
void copy(List dest,List src): 将src中的内容赋值到dest中。
boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换 List 对于的旧值
*/

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println("插入时顺序：" + list);
//      reverse(List): 反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println("reverse:" + list);
//      shuffle(List): 对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println("shuffle:" + list);
//      sort(List): 根据元素的自然排序顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println("使用自然排序的sort:" + list);
//      sort(List,Comparator): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println("使用Comparator的sort:" + list);
//      swap(List,int,int): 将指定 list 集合中的 i 处元素和 j 处元素进行交换。
        Collections.swap(list,1,2);
        System.out.println("swap:" + list);
//      Object max(Collection): 根据元素的自然排序，返回给定集合中的最大元素
        System.out.println("max:" + Collections.max(list));

        list.add(765);list.add(765);
//      int frequency(Collection,Object): 返回指定集合中指定元素的出现次数
        int frequency = Collections.frequency(list, 765);
        System.out.println("frequency:" + frequency);
    }


    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

//      void copy(List dest,List src): 将src中的内容赋值到dest中。
        //错误做法，因为底层要dest.size() >= list.size()
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);

//      boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换 List 对于的旧值
        Collections.replaceAll(list,43,66);
        System.out.println(list);

        /*
        Collections 类中提供了多个 synchronizedXxx() 方法,
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题

         */
        //返回的synchronizedList即为线程安全的list
        List synchronizedList = Collections.synchronizedList(list);

    }

}
