package com.nq.java.question2;

import java.util.Scanner;

/**
 * @Author Nq
 * @Data 2021-02-02-23:40
 */
public class turn2 {
    public static void main(String[] args) {
        boolean Flage = true;
        Scanner scanner = new Scanner(System.in);
        while (Flage){
            System.out.println("输入一个子串，我们会输出它的最大回文子串：");
            System.out.println("输入-1退出：");
            String s = scanner.nextLine();
            if ("-1".equals(s)){
                Flage = false;
            }else {
                String s1 = longestPalindrome(s);
                System.out.println(s1);
            }

        }

    }

    private static String longestPalindrome(String s) {

        for(int i = 0;i < s.length();i++){
            for(int j = 0;j <= i ;j++){
                String str = s.substring(j,s.length() - i + j);
                StringBuilder news = new StringBuilder(str);
                if(news.reverse().toString().equals(str)){
                    return str;
                }
            }
        }
        return null;
    }
}
