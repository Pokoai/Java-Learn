package Chapter17_网络编程;

import java.io.*;
import java.net.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/2
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1. 创建 ServerSocket看，用于监听客户端 Socket 的连接请求
        var  ss = new ServerSocket(3000);
        // 2. 循环监听客户端的连接请求
        while (true) {
            // 3. 服务器端接收到请求后创建相应的 Socket
            var s = ss.accept();
            // 4. 将 Socket 对应的输出流包装为 PrintStream 处理流
            var ps = new PrintStream(s.getOutputStream());
            // 5. 服务器端进行普通IO操作
            ps.println("您好，你收到了服务器的新年祝福！");
            ps.println("相信自己的直觉，一直走下去！");
            // 6. 关闭输出流、关闭Socket
            ps.close();
            s.close();
        }
    }
}
