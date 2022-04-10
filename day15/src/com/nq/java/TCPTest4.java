package com.nq.java;


import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Nq
 * @Data 2021-03-16-20:14
 */
public class TCPTest4 {

    @Test
    public void client() throws IOException {

        Socket socket = new Socket("127.0.0.1",2020);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("hello.txt");

        byte[] buffer = new byte[20];
        int len;
        while((len = fis.read(buffer)) != -1){
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


        os.close();
        fis.close();
        socket.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("hello22.txt");

        byte[] buffer = new byte[20];
        int len;
        String data = "";
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
            data = new String(buffer,0,len);
        }


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(data.toUpperCase().getBytes());


        fos.close();
        is.close();
        socket.close();

    }


}
