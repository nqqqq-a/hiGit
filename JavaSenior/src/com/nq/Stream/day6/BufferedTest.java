package com.nq.Stream.day6;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流：就是"套接"在已有流的基础上。
 *
 *
 * @Author Nq
 * @Data 2021-03-06-10:28
 */
public class BufferedTest {

    /*
    实现非文本文件的赋值
     */
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("");
            File destFile = new File("");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.具体复制：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

//                bos.flush(); //刷新缓冲区,底层写入时会隐时调用
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            //要求：先关闭外层的流，再关闭内层的流吧
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层的流时，会自动把内层流关闭，所以内层流的关闭可以省略
//        fos.close();
//        fis.close();
        }

    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello2.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello4.txt")));

            //读写操作
            //方式一：
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }
            //方式二：使用String
            String data;
            while((data = br.readLine())!= null){
                //方法一：
//                bw.write(data + "\n");  //data中本身不包含换行符
                //方法二：
                bw.write(data);//data中本身不包含换行符
                bw.newLine(); //加一个换行符
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
