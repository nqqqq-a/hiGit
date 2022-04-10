package com.nq.Stream.day6;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流(看后缀)
 *  InputStreamReader：将一个字节的输入流转换为字符的输入流
 *  OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.处理流的作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 ---> 字符数组、字符串
 *   编码：字符数组、字符串 ---> 字节、字节数组
 *
 * 4.字符集
 *
 * @Author Nq
 * @Data 2021-03-06-14:39
 */
public class InputStreamReaderTest {

    @Test
    public void test1(){
        InputStreamReader isr = null; //使用系统默认的字符集
        try {
            FileInputStream fis = new FileInputStream("hello1.txt");
            isr = new InputStreamReader(fis);

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
    综合使用InputStreamReader 和 OutputStreamWriter
     */
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File  file1 = new File("hello1.txt");
            File  file2 = new File("hello_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos,"gbk"); //charsetName为字符集

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
