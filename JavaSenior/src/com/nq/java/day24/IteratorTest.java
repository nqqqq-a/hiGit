package com.nq.java.day24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口，Iterator仅用于遍历集合(Collection)
 * 1.内部的方法：hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *   默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 * @Author Nq
 * @Data 2021-01-25-21:17
 */
public class IteratorTest {


      @Test
      public  void test1(){

          Collection col1 = new ArrayList();
          col1.add(123);
          col1.add(456);
          col1.add(new Person("Jerry",20)); //自动装箱
          col1.add(new String("Tom"));
          col1.add(false);


          for (Object o : col1) {
              System.out.println(o);
          }
          
//          while (iterator.hasNext()){
//              System.out.println(iterator.next());
//          }
      }
      @Test
    public void test2(){
          Collection col1 = new ArrayList();
          col1.add(123);
          col1.add(456);
          col1.add(new Person("Jerry",20)); //自动装箱
          col1.add(new String("Tom"));
          col1.add(false);

          Iterator iterator = col1.iterator();

          //错误写法一：next()方法会先下移，再取值，这样子下移了两次。 而且会出现越界。
//          while(iterator.next() != null){
//              System.out.println(iterator.next());
//          }

          //错误写法二：Iterator iterator = col1.iterator()一定要实例化出来，不能用匿名对象
          //每次调用iterator()都会得到一个全新的迭代器对象。
//          while (col1.iterator().hasNext()){
//              System.out.println(col1.iterator().next());
//          }
      }

      @Test
    public void test3(){
          Collection col1 = new ArrayList();
          col1.add(123);
          col1.add(456);
          col1.add(new Person("Jerry",20)); //自动装箱
          col1.add(new String("Tom"));
          col1.add(false);

          Iterator iterator = col1.iterator();
         while (iterator.hasNext()){
             Object obj = iterator.next();
             if ("Tom".equals(obj)) {
                 iterator.remove();
             }

         }
        //遍历集合
          //要重新赋一次迭代器，因为上一个迭代器已经指向最后了。
          iterator = col1.iterator();
         while (iterator.hasNext()){
             System.out.println(iterator.next());
         }

      }


}
