package com.nq.java.day23;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类继承于Enum类，而不是Object类
 * @Author Nq
 * @Data 2021-01-23-16:54
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //1.toString()
        System.out.println(summer);
//        System.out.println(Season1.class.getSuperclass());
        System.out.println("--------------");
        //2.values():
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }

        //3.valueOf(String objName):根据提供的objName，返回objName的枚举类
        //把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        //如果字符串不是对应的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter1 = Season1.valueOf("WINTER1");

        winter.show();
    }
}

interface Info{
    void show();
}

//使用enum关键字定义枚举类
enum Season1 implements  Info{

    //1.enum定义的枚举类要首先提供当前枚举类的多个对象，多个对象之间用，隔开
    //且不需要private static final 和 new 一个对象
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("这是春天");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("这是冬天");
        }
    };
    //2.声明Season对象的属性 : private final
    private  final String seasonName;
    private  final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

    //enum关键字下的toString()方法会打印出对象名本身，如果有需求，才要重写toString90

//    //其他诉求2：提供toString()
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
