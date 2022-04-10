package com.nq.Stream.day13;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile原理
 * 1.RandomAccessFile直接继承于java.long.Object类，实现了DataInput和DataOutput接口
 * 2.既可以作为一个输入流，又可以作为一个输出流（使用一个类，但不是一个对象）
 *
 * 3.如果RandomAccessFile作为输出流，写出到的文件不存在，则在执行过程中自动创建
 *      如果文件存在,则会覆盖原有文件内容。(默认从头覆盖)
 *
 * @Author Nq
 * @Data 2021-03-13-16:00
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile(new File("nq.jpg"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("nq5.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(buffer)) != -1 ){
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 =  new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);
        raf1.write("sdad".getBytes());

        raf1.close();
    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 =  new RandomAccessFile("hello.txt","rw");

        raf1.seek(3); //将指针调到指标为3的位置
        //保存指针3后面的所有数据到builder
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer),0,len);
        }
        //调回指针，写入“sdad”
        raf1.seek(3);
        raf1.write("sdad".getBytes());

        //将builder的数据写入文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }
}
