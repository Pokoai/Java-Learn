package Chapter17_网络编程.多线程聊天室;

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

// 接收客户端键盘输入信息，并传送给服务器
public class MyClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket
        var socket = new Socket("127.0.0.1", 3000);
        // 开启客户端线程
        new Thread(new ClientThread(socket)).start();

        // 获取该Socket对应的输出流
        var ps = new PrintStream(socket.getOutputStream());
        // 将键盘输入流包装为BufferedReader流
        var br = new BufferedReader(new InputStreamReader(System.in));
        // 输出到服务器
        String line = null;
        while ((line = br.readLine()) != null) {
            ps.println(line);
        }
    }
}
