package com.nq.java.question4;

import java.util.ArrayList;

/**
 * @Author Nq
 * @Data 2021-01-19-22:41
 */
public class test {
    public static void main(String[] args) {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnmiodef";
        String s4 = "eysdfghjkl";
        String s5 = "cxbghjp";
        System.out.println(getMaxSame(s4,s5));
        String s3 = getMaxSame(str1,str2);
        System.out.println(s3);

        System.out.println(getMaxSame2(str1, str2));
    }


    private static String getMaxSame(String str1,String str2){
        String max = null;
        String min = null;
        if (str1.length() > str2.length()){
            max = str1;
            min = str2;
        }else {
            max = str2;
            min = str1;
        }
        for (int i = 0;i < min.length();i++){
            for(int j = 0;j <= i;j++){
                //min.length - i是决定子串的长度
                //[j,min.length - i + j) 决定了取出来的子串
                String substring = min.substring(j, min.length()-i+j);//从小的字符串开始，从左向右移位比较
                if (max.contains(substring)){
                    //因为是从长到短的字符串长度找的，所以找到的时候就是最长的，直接返回即可
                    return substring;
//                    if (temp.length() < substring.length()){
//                        temp = substring;
//                    }
                }
            }
        }
        return null;
    }

    private static ArrayList getMaxSame2(String str1, String str2){
        String max = null;
        String min = null;
        ArrayList arrayList = new ArrayList();
        if (str1.length() > str2.length()){
            max = str1;
            min = str2;
        }else {
            max = str2;
            min = str1;
        }
        for (int i = 0;i < min.length();i++){
            for(int j = 0;j <= i;j++){
                //min.length - i是决定子串的长度
                //[j,min.length - i + j) 决定了取出来的子串
                String substring = min.substring(j, min.length()-i+j);//从小的字符串开始，从左向右移位比较
                if (max.contains(substring)){
                    //因为是从长到短的字符串长度找的，所以找到的时候就是最长的，直接返回即可
                    arrayList.add(substring);
                }
            }
            //在内层循环中要判断ArrayList是否为空，如果不为空
            //，说明已经找到长度最大的字符串了
            if (!arrayList.isEmpty()){
                break;
            }
        }
        return arrayList;
    }
}
