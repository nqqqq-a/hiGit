package com.nq.Stream.day6;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @Author Nq
 * @Data 2021-03-06-16:23
 */
public class OtherStreamTest {

    /*
    1.标准的输入、输出流
    1.1
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream in) / setOut(OutputStream out)方法重新指定输入和输出流

     1.3练习
     从键盘读入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
     直至输入 e 或 exit 时，退出程序

     方法一：使用Scanner实现
     方法二：使用System.in实现 System.in ---> 转换流 ---> BufferedReader的readLine()

     */

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String data;
            while (true){
                System.out.println("请输入字符串: ");
                data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
    3.数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串、基本类型的变量写到文件中。
    注意：处理异常时，仍然用try-catch-finally
     */
    @Test
    public void test3(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("hello9.txt"));

            dos.writeUTF("聂琦");
            dos.writeInt(23);
            dos.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。

    注意点：读取不同类型的数据的顺序要与当初写入文件时，保持数据的顺序一致
     */
    @Test
    public void test4(){
        DataInputStream dis = null;
        try {
            //1.创建流
            dis = new DataInputStream(new FileInputStream("hello9.txt"));

            //2.实际操作
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();
            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("isMale:" + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
