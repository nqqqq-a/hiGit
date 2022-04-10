package com.nq.java.question2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author Nq
 * @Data 2021-01-19-22:02
 */
public class Turn {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。
    比如“abcdefg”反转为“abfedcg”
     */
    public static void main(String[] args) {
        String s1 = "abcdefg";
        int first = 2, last = 5;
        char[] chars = s1.toCharArray();
        System.out.println(chars);
        for (;first < last;first++,last--){
            char temp = chars[first];
            chars[first] = chars[last];
            chars[last] = temp;
        }
        System.out.println(chars);

    }

//    @Test
//    private  String reverse1(String str,int startIndex,int endIndex){
//        if (str != null){
//            //0-startIndex部分
//            String reverseStr = str.substring(0,startIndex);
//            //中间要反转部分
//            for (int i = endIndex;i >= startIndex;i--){
//                reverseStr += str.charAt(i);
//            }
//            //endIndex-最后
//            reverseStr += str.substring(endIndex + 1);
//
//            return reverseStr;
//        }
//        return null;
//    }
//
//    @Test
//    private  String reverse2(String str,int startIndex,int endIndex){
//        StringBuilder stringBuilder = new StringBuilder(str.length());
//        if (str != null){
//            stringBuilder.append(str, 0, startIndex);
//            for (int i = endIndex;i >= startIndex;i--){
//                stringBuilder.append(str.charAt(i));
//            }
//            stringBuilder.append(endIndex + 1);
//            return stringBuilder.toString();
//        }
//        return null;
//    }

    @Test
    public void test(){
    String s2 = "  sds  dasda  cs ad s d  ";
        char[] chars = s2.toCharArray();

        int pre = 0,bottom = chars.length - 1;
        while (chars[pre] == ' ') {
            pre++;
        }
        while (chars[bottom] == ' '){
            bottom--;
        }
        int length = bottom - pre ;
        char[] newchars = new char[length + 1];
        for (int i = 0;i <= length;i++){
            newchars[i] = chars[pre++];
        }
        System.out.println(chars);
        System.out.println(newchars);
    }

    @Test
    public void test3(){
        String s1 = "abkkcadkabkebfkabkskab";
        int sum = 0;
        while (s1.contains("ab")){
            sum++;
            s1 = s1.substring(s1.indexOf("ab") + 1);
        }
        System.out.println(sum + "次");
    }

    @Test
    public void test4(){
        String s1 = "cvhellobnm";
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        String s = String.valueOf(chars);
        System.out.println(s);
    }

}
