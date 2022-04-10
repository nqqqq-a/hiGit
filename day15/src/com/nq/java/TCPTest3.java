package com.nq.java;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Nq
 * @Data 2021-03-16-19:56
 */
public class TCPTest3 {

    @Test
    public void client() throws IOException {
        //1.创建socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.获取输出流
        OutputStream os = socket.getOutputStream();
        //3.创建输入流
        FileInputStream fis = new FileInputStream(new File("nq.jpg"));
        //4.具体过程
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        //关闭数据的输出
        socket.shutdownOutput();


        //5.接受服务器端的反馈数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        char[] cbuf = new char[20];
        int length;
        while((length = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, length);
            System.out.print(str);
        }




        //6.流的关闭
        is.close();
        isr.close();
        fis.close();
        os.close();
        socket.close();


    }



    @Test
    public void server() throws IOException {
        //建立服务器socket
        ServerSocket serverSocket = new ServerSocket(9090);
        //获取socket
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //创建输出流
        FileOutputStream fos = new FileOutputStream(new File("nq33.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) !=-1){
            fos.write(buffer,0,len);
        }





        //服务器给与客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，我是服务器，照片已经收到".getBytes());

        outputStream.close();
        fos.close();
        inputStream.close();
        serverSocket.close();

    }
}
