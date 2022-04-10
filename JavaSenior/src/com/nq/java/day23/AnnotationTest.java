package com.nq.java.day23;

/**
 * @Author Nq
 * @Data 2021-01-23-20:25
 */
public class AnnotationTest {
    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int num = 10;

        num++;
        System.out.println(num);
    }
}
