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

/**
 * InputStream 是一个抽象类
 * 其中最重要的方法 int read()方法，读到末尾返回-1
 */
public class InputStream {
    public static void main(String[] args) throws IOException {
        /**
         * FileInputStream字节流读取-手动关闭文件
         */
        // 创建 FileInputStream 字节流
        var input = new FileInputStream("src\\Chapter12_Swing\\HandDraw.java");
        // 创建一个长度为1024的竹筒
        var buff = new byte[1024];
        // 实际读取的字节数
        int hasRead = 0;
        // 开始取水
        while ((hasRead = input.read(buff)) > 0) {
            System.out.println(new String(buff, 0, hasRead));
        }
        input.close();

        /**
         * FileReader字符流读取文件 - 自动关闭文件资源
         */
        try (var fr = new FileReader("src\\Chapter12_Swing\\HandDraw.java")) {
            var cbuff = new char[32];
            int hasReadC = 0;
            while ((hasReadC = fr.read(cbuff)) > 0) {
                System.out.println(new String(cbuff, 0, hasReadC));
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
