package cn.chen.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo01 {
    public static void main(String[] args) throws UnknownHostException {
        // 1.获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 2.根据指定主机名获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-6HEP67H");
        System.out.println("host1:" + host1);

        // 3.根据域名返回 InetAddress对象，
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2:" + host2);

        // 4.通过InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2的IP:" + hostAddress);

        // 5.通过InetAddress 对象，获取对应的主机名/或者域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}
