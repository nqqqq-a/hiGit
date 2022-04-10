package com.nq.java.day21;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期的API测试
 * 1.System类中的currentTimeMillis();
 * 2.java.util.Date和java.sql.Date类
 *      >构造器
 *      >getTime()和toString()
 * 3.SimpleDateFormat类
 * 4.Calender类
 *
 * @Author Nq
 * @Data 2021-01-21-19:00
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
        1.1 格式化： 日期 ---> 字符串
        1.2 解析：格式化的逆过程 字符串 ---> 日期

    2.SimpleDateFormat的实例化

     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化 ： 日期 ---> 字符串
        Date date = new Date();
        System.out.println(date); //未格式化的

        System.out.println(sdf.format(date)); //对date进行格式化，返回String类型

        //解析：格式化的逆过程 字符串 ---> 日期
        //字符串有格式要求，所以一般不使用默认构造器
        String str = "2021/1/21 下午7:10";
        System.out.println(sdf.parse(str));
        System.out.println("***********");

        //一般使用带参数的
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        //格式化
        String format1 = sdf2.format(date);
        System.out.println(format1);
        //解析
        Date parse = sdf2.parse("2021.01.21 20:27:44");
        System.out.println(parse);
    }

    /*
    练习一：字符串“2020-09-08"转换为java.sql.Date

    练习二：“三天打鱼，两天晒网”，从1990.01.01开始执行打鱼，问xxxx.xx.xx 打鱼？晒网？

     */
    @Test
    public void practice1() throws ParseException {
        String birth = "2020.09.08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        Date date = sdf.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calendar日历类(抽象类)的使用

     */
    @Test
    public void testCalendar(){
        /*1.实例化
            >方式一：创建其子类(GregorianCalendar)对象
            >方式二：调用其静态方法getInstance()  常用
        */
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());
        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():将一个Calendar类变为Date对象
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():将一个Date---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

    /*
    注意：
        1.获取月份时，一月是0，二月是1，...12月是11
        2.获取星期时，周日是1，周一是2..周六是7
     */
    @Test
    public void test6(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }





}
