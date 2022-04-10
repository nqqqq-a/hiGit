package com.nq.java.day21;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8 中日期时间API测试
 *
 * @Author Nq
 * @Data 2021-01-22-10:45
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date);
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    1.实例化
        1.1.now()：获取当前时间
        1.2.of()：设置指定时间
    2.方法

     */
    @Test
    public void test1(){
        //now():获取当前的日期，时间，日期＋时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年，月，日，时，分，秒。且没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 50);
        System.out.println(localDateTime1);

        //getXxx()：获取相关属性，都是无偏移量的
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx()：设置时间给一个新的对象 不会像Calendar类一样吧本身的数据也修改掉
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(23);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfMonth());
        LocalDateTime localDateTime3 = localDateTime.withYear(2077);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime3.getYear());

        //plus、minus两个方法。
        LocalDateTime localDateTime4 = localDateTime.plusMonths(5);
        System.out.println(localDateTime4);
        LocalDateTime localDateTime5 = localDateTime4.minusMonths(4);
        System.out.println(localDateTime5);

    }

    /*
    Instant的使用
    类似于java.util.Date
    */
    @Test
    public void test2(){
        //now()://获取的是本初子午线的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //中国的时区要＋8个小时,所以添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取瞬时点的毫秒数  从1970年1.1 0:0:0
        long toEpochMilli = instant.toEpochMilli();
        System.out.println(toEpochMilli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 --->Date(long mills)
        Instant instant1 = Instant.ofEpochMilli(1611289807807L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */
    @Test
    public void test3(){
//      方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        //格式化 日期 ---> 字符串 但都是标准格式
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析 字符串 ---> 日期
        TemporalAccessor parse = formatter.parse("2021-01-22T12:49:34.7479184");
        System.out.println(parse);


//      方式二：本地化相关的格式。如：ofLocalizedDateTime()FormatStyle.LONG)
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
//        String format = formatter1.format(LocalDate.now());
//        System.out.println(format);
//      方式三：自定义的格式。如：ofPattern("yyyy-MM--dd hh:mm:ss E") 常用！
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");

        //格式化
        String format = formatter1.format(LocalDateTime.now());
        System.out.println(format);

        //解析
        TemporalAccessor parse1 = formatter1.parse("2021-01-21 15:48:58 周四");
        System.out.println(parse1);



    }
}
