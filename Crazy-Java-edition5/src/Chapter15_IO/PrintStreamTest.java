package Chapter15_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Description: 《疯狂Java讲义》- 处理流对节点流进行包装
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/1
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                var fos = new FileOutputStream("out.txt"); // 节点流
                var ps = new PrintStream(fos) )  // 处理流
        {
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
