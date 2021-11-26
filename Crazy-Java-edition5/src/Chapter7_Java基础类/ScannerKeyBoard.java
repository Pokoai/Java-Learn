package Chapter7_Java基础类;

import java.util.Scanner;
import java.io.File;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class ScannerKeyBoard {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);

        //sc.useDelimiter("\n");
        while(sc.hasNext()) {
            System.out.println("键盘输入的内容是：" + sc.next());
        }

//        var sc2 = new Scanner( new File("D:\\6_归档\\桌面\\待归纳语录.txt"));
//        while (sc2.hasNextLine()) {
//            System.out.println(sc2.next
    }

}
