package Chapter15_IO;

import java.io.*;

/**
 * Description: 《疯狂Java讲义》- File对象
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/1
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        /**
         获取文件路径
         */
        File f = new File("F:\\");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath()); // 绝对路径

        /**
         构造 File 对象并不会产生任何磁盘操作，
         只有调用 File 对象的方法时才真正进行磁盘操作
         */
        File f1 = new File("C:\\java");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());

        /**
         * 创建和删除文件
          */
        File f2 = new File("D:\\javafile.java");
        f2.createNewFile();
        f2.delete();
        // 有时需要创建临时文件
        File f3 = File.createTempFile("tmp-", ".txt");
        f3.deleteOnExit(); // 退出 JVM 自动删除
        System.out.println(f3.isFile());
        System.out.println(f3.getAbsolutePath());

        /**
         * 遍历文件和目录
         */
        File[] fs1 = f.listFiles();
        for (var file : fs1) {
            System.out.println(file);
        }
        // 过滤文件，仅列出以 src 文件名结尾的文件
        File[] fs2 = f.listFiles((dir, name) -> name.endsWith("src"));
        for (var file : fs2) {
            System.out.println(file);
        }
    }
}
