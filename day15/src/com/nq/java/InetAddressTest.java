package com.nq.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中的两个主要问题：
 * 1.如何准确地定位到网络上一台主机或多台主机；定位主机上的特定应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1.对应问题一： IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理层、数据链路层)
 *
 * 三、通信要素一：IP和端口号
 *
 *  1. IP：唯一的标识 Internet上的计算机 (通信实体)
 *  2. 在Java中使用InetAddress类代表IP
 *  3. IP分类：IPv4 和 IPv6； 万维网 和 局域网
 *  4. 域名：  www.baidu.com  www.mi.com  www.sina.com
 *  5. 本地回路地址：127.0.0.1 对应：localhost
 *
 *  6. 如何实例化InetAdress：两个方法：getByName(String host) / getLocalHost()
 *      两个常用方法：getHostName()：得到域名 / getHostAddress():得到ip地址
 *
 *  7。端口号：正在计算机上运行的进程。
 *  要求：不同进程有不同的端口号。
 *  范围：被规定为一个16位整数 0~65535
 *
 *  8.端口号与ip地址的组合得到一个网络套接字：Socket
 *
 * @Author Nq
 * @Data 2021-03-15-19:58
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");

            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);

            System.out.println(InetAddress.getLocalHost()); //获取本机地址

            //getHostName() : 得到域名
            System.out.println(inet2.getHostName());
            //getHostAddress():得到ip地址
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
