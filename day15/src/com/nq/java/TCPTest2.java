package com.nq.java;



import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Nq
 * @Data 2021-03-16-19:30
 */
public class TCPTest2 {

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
        //5.流的关闭
        fis.close();
        os.close();
        socket.close();


    }


    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("nq33.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) !=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("接受成功");

        fos.close();
        inputStream.close();
        serverSocket.close();

    }


}
