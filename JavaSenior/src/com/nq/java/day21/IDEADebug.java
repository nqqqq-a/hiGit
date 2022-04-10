package com.nq.java.day21;

import org.junit.Test;

/**
 * @Author Nq
 * @Data 2021-01-21-17:43
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str); //会把null当做字符串加入到里面
        //在append方法中，判断出如果字符串为空，则会加入“null”这个字符串
        System.out.println(sb.length()); //会输出null的长度

        System.out.println(sb); //输出“null”

        StringBuffer sb1 = new StringBuffer(str); //抛出NullPointerException异常

        System.out.println(sb1);
    }


}
