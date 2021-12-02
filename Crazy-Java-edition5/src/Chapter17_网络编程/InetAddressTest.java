package Chapter17_网络编程;

import java.net.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/2
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        // 1. 根据主机名获取 InetAddress 实例
        InetAddress ip = InetAddress.getByName("arctee.cn");
        // 判断是否可达
        System.out.println(ip.isReachable(2000));

        // 2. 根据原始 IP 地址获取 InetAddress 实例
        InetAddress ip2 = InetAddress.getByAddress(new byte[] {47, 103, 89, 114});
        System.out.println(ip2.isReachable(2000));

        // 根据 InetAddress 实例获取 IP 地址
        System.out.println(ip.getHostAddress());
        // 获取该 InetAddress 实例对应的全限定域名
        System.out.println(ip2.getCanonicalHostName());

    }


}
