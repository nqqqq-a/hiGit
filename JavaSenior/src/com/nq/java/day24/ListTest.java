package com.nq.java.day24;

/**
 *    |----Collection接口：单列集合，用来存储一个一个的对象
 *         |----List接口：存储有序的、可重复的数据。 --> “动态”数组,替换原有的数组
 *            |--->ArrayList：作为List接口的主要实现类，因为线程不安全的，执行效率高。底层使用Object[]存储
 *            |--->LinkedList：对于频繁的插入和删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 *            |--->Vector：作为List接口的古老实现类，线程安全的，效率低。底层使用Object[]存储
 *
 *   2.ArrayList的源码分析 :
 *     2.1 jdk 7的情况下
 *          ArrayList list = new ArrayList(); 底层创建了长度是10的Object[]数组elementData
 *          list.add(123);  elementData[0] = new Integer(123);
 *          ...
 *          list.add(11); 如果此次的添加导致底层的elementData数组容量不够，则扩容。
 *          默认扩容为原来的1.5倍，同时需要将原有的数组中的数据赋值到新的数组中。
 *
 *          建议：开发中使用带参的构造器 ArrayList list = new ArrayList(int initialCapacity) 即一开始就定义好初始长度
 *
 *      2.2 jdk 8中ArrayList的变化
 *      ArrayList list = new ArrayList(); 底层Object elementData初始化为{}，并没有创建长度为10的数组
 *      list.add(123); 第一次调用add()方法时，底层才创建了长度为10的数组，并将123添加到elementData数组中
 *      ...
 *      后续的添加扩容操作与jdk 7 相同
 *      2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式。而jdk8中的ArrayList的对象
 *               的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 *  3.LinkedList的源码分析
 *      LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123); 将123封装到Node中，创建了Node对象
 *
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *
 *  面试题：ArrayList、LinkedList、Vector三者的异同？
 *  同：三个类都实现了List接口，存储数据的特点相同： 有序可重复的数据
 *  不同：写在上面。
 *
 * @Author Nq
 * @Data 2021-01-26-10:57
 */
public class ListTest {


}
