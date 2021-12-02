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

// 接受客户端的信息并广播给所有客户端
public class ServerThread implements Runnable {
    // 定义该线程处理的Socket
    Socket s = null;
    // 定义该Socket相应的输入流
    BufferedReader bf = null;

    // 构造器
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        // 初始化输入流
        bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    // 重写 run() 方法，线程执行体
    public void run() {
        try {
            // 读取客户端的输入信息
            String line = null;
            while ((line = readFromClient()) != null) {
                // 将该信息广播给所有客户端
                for (var s : MyServer.socketList) { // 遍历所有的客户端Socket
                    var ps = new PrintStream(s.getOutputStream()); // 包装输出流
                    ps.println(line);
                }
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // 辅助方法，同时用于捕获异常
    private String readFromClient() {
        try {
            return bf.readLine();
        }
        // 客户端关闭了Socket会导致没有输出流
        catch (IOException e) {
            // 删除该Socket
            MyServer.socketList.remove(s);
        }

        return null; // 不知这里为何要加这一句，不加会报错
    }
}
