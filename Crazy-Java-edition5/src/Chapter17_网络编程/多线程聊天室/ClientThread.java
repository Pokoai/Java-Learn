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

// 接收服务器端发来的信息并打印到命令行面板
public class ClientThread implements Runnable {
    // 该线程处理的Socket
    Socket s = null;
    // 该Socket对应的输入流
    BufferedReader br = null; // 还没有Socket实例,所以无法创建输入流，故可以在构造器里创建

    // 构造器
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        // 初始化输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    // 重写run()方法
    public void run() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
