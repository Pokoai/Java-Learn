package Chapter15_IO;

import java.io.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/1
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class KeyinTest {
    public static void main(String[] args) {
        try (
                // 1. 将 System.in（是 InputStream 抽象类的实例）转换为字符流
                var reader = new InputStreamReader(System.in);
                // 2. 将 reader 字符流（节点流）包装成处理流
                var br = new BufferedReader(reader))
        {
            String line = null;

            while ((line = br.readLine()) != null) { // 直接使用 readLine() 方法即可读取键盘输入
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入的内容为：" + line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
