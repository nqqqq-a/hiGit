package com.nq.java.day20;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的api测试
 *
 * @Author Nq
 * @Data 2021-01-20-22:24
 */
public class DateTimeTest {

    /*
    java.util.Data类
            |---java.sql.Date类
    1.两个构造器的使用

    2.两个方法的使用
        >toString():显示当前的年，月，日，时，分，秒,时区
        >getTime():获取当前时间的时间戳(与1970年1月1日0时0分0秒之间以毫秒为单位的时间差)

    3.java.sql.Date对应着数据库中的日期类型的变量
        如果已经导入java.util.Date
        >如何实例化:new java.sql.Date(long date);
        >如何将java.util.Date对象转换为java.sql.Date对象
            1.多态创建对象，向下转型
            2.java.sql.Date date6 = new java.sql.Date(date5.getTime());
     */
    @Test
    public void test2(){
        //构造器一：Data()：创建了一个当前时间的Data对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Wed Jan 20 22:33:38 CST 2021
        System.out.println(date1.getTime()); //1611153356065

        //构造器二：
        Date date = new Date(1251123356060L);
        System.out.println(date);
        System.out.println(date.getTime());

        //如果已经导入java.util.Date
        //        >如何实例化:new java.sql.Date(long date);
        java.sql.Date date2 = new java.sql.Date(1611153356065L);
        System.out.println(date2);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一： 多态创建对象，向下转型
        Date date3 = new java.sql.Date(1611153356065L);
        java.sql.Date date4 = (java.sql.Date) date3;
        //情况二:
        Date date5 = new Date();
        java.sql.Date date6 = new java.sql.Date(date5.getTime());
        System.out.println(date6);

    }

    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }
}
