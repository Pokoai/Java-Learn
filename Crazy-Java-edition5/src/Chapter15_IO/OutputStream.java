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
public class OutputStream {
    public static void main(String[] args) throws IOException {
        try (
            // 创建字节输入流
            var fis = new FileInputStream("src/Chapter15_IO/FileTest.java");
            // 创建字节输出流
            var fos = new FileOutputStream("out.java");
            // 创建字符输出流
            var fw = new FileWriter("poem.txt") )
        {
            var buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read()) > 0) {
                fos.write(buff, 0, hasRead);
            }

            fw.write("此情可待成追忆\r\n");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

    }
}
