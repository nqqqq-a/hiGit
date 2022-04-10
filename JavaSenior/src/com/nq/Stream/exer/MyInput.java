package com.nq.Stream.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Nq
 * @Data 2021-03-06-16:58
 */
public class MyInput {

    public static String readString(){
        String str = " ";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  str;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static double readByte(){
        return Byte.parseByte(readString());
    }

    public static double readLong(){
        return Long.parseLong(readString());
    }




}
