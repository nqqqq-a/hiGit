package com.nq.Stream.day1;

import org.junit.Test;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、流的分类：
 * 1.操作数据单位：节点流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类              节点流（又称文件流）                                  缓冲流(处理流的一种)
 * InputStream          FileInputStream  (read(byte[] buffer))            BufferedInputStream  (read(byte[] buffer))
 * OutputStream         FileOutputStream (write(byte[] buffer,0,len))     BufferedOutputStream (write(byte[] buffer,0,len)) / flush()
 * Reader               FileReader  (read(char[] cbuf))                   BufferedReader    (read(char[] cbuf))
 * Writer               FileWriter  (write(char[] cbuf,0,len))            BufferedWriter    (write(char[] cbuf,0,len))  / flush()
 *
 *
 * @Author Nq
 * @Data 2021-03-01-17:14
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt"); //相较于当前工程 即shangxuetang
        System.out.println(file.getAbsolutePath());
    }

    /*
    将JavaSenior下饿的hello.txt文件内容读入到程序中，并输出到控制台

    说明点：
    1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作，一定要使用try-catch-finally处理
    3.读入的文件一定要存在，否则就会报FileNotFoundException。

     */
    @Test
    public void test() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明我们要操作的文件
            File file = new File("hello.txt");//相较于当前Module 即JavaSenior下
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入过程
            //read(): 返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }

            //方式二：语法上对于方式一的修改
            int data;
            while((data = fr.read()) != -1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级：使用read()的重载方法
    @Test
    public void test2()  {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int read;
            while ((read = fr.read(cbuf)) != -1){
                for (int i = 0; i < read; i++) {
                    System.out.print(cbuf[i]);
                }
                //方式二：
//                String str = new String(cbuf,0,read);
//                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流(资源)的关闭
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1.输出操作，对于的File可以不存在的。并不会报异常
    2.
        File对于的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对于的硬盘中的文件如果存在：
                 如果流使用的构造器是：FileWriter(file,false) / FileWriter(file)：会对原有文件覆盖
                 如果流使用的构造器是：FileWriter(file,true): 不会对原有文件覆盖，而是在后面追加。
    2.
     */
    @Test
    public void test3()  {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,false);

            //3.写出的具体操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream too!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void testFileReaderFileWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile = new File("hello1.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入流和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; //记录每次读入到cbuf数组中的数据的长度。
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符，即读到的长度。
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
