package com.nq.java;


import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * @Author Nq
 * @Data 2021-03-15-22:18
 */
public class TCPTest {

    //客户端
    @Test
    public void client()  {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet1,8899);
            //获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();
            //写出操作
            outputStream.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }

    //服务端
    @Test
    public void sever(){
//        ServerSocket serverSocket = new ServerSocket(8899);
//
//        Socket accept = serverSocket.accept();
//        InputStream inputStream = accept.getInputStream();


        //可能会出现中文乱码
//        byte[] buffer = new byte[20];
//        int len;
//        while((len = inputStream.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }

    }
}
