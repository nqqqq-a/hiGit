package com.nq.java.day24To30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author Nq
 * @Data 2021-01-30-16:09
 */
public class ListExer {

    /*
    区分List当中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updataList(list);
        System.out.println(list);
    }

    private static void updataList(List list){
        list.remove(2); //父类的引用指向子类对象，优先调用子类的remove方法
//        list.remove(Integer.valueOf(2));
    }
}

