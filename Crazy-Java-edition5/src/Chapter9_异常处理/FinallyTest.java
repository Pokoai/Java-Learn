package Chapter9_异常处理;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/28
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */

// 原始方法：打开文件资源后手动关闭
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("a.txt");
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return;
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行 finally 块里的资源回收");
        }
    }
}
