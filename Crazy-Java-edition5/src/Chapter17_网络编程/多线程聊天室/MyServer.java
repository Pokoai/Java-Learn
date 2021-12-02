package Chapter17_网络编程.多线程聊天室;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/2
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */

// 创建服务器的ServerSocket等待客户端连接，连接后就创建一个客户端线程并加入到列表中
public class MyServer {
    // ArrayList 保存所有的 Socket
    public static List<Socket> socketList = new ArrayList<>(); // 未考虑线程安全

    public static void main(String[] args) throws IOException {
        var ss = new ServerSocket(3000);
        while (true) {
            var s = ss.accept();
            socketList.add(s); // 添加到列表中
            // 服务器开启一个新线程专用于该Socket对应的客户端
            new Thread(new ServerThread(s)).start();
        }
    }
}
