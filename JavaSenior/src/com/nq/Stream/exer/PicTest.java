package com.nq.Stream.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author Nq
 * @Data 2021-03-06-11:10
 */
public class PicTest {

    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null; //会将里面自动包装成文件类
        FileOutputStream fos = null;
        try {
            //1.造流
            fis = new FileInputStream("nq.jpg");
            fos = new FileOutputStream("nqsecret.jpg");

            //2.具体操作
            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                //需要对字节数组进行修改，达到加密功能
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis = null; //会将里面自动包装成文件类
        FileOutputStream fos = null;
        try {
            //1.造流
            fis = new FileInputStream("nqsecret.jpg");
            fos = new FileOutputStream("nq2.jpg");

            //2.具体操作
            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                //需要对字节数组进行修改，达到加密功能
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
