package Chapter17_网络编程;

import java.net.*;
import java.io.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/2
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 创建客户端的 Socket
        var socket = new Socket("127.0.0.1", 3000);
        // 2. 将 Socket 对应的输入流包装为 BufferedReader
        var br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        // 3. 进行普通IO操作
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        // 4. 关闭输入流，关闭Socket
        br.close();
        socket.close();
    }
}
