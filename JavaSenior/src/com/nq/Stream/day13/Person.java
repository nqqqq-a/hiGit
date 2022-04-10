package com.nq.Stream.day13;

import java.io.Serializable;

/**
 * Person类需要满足如下的要求，方可序列化
 * 1.实现Serializable接口
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *      也必须可序列化。(默认情况下：基本数据类型都是可序列化的)
 * @Author Nq
 * @Data 2021-03-13-11:10
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 475463534532L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
