package Chapter11_AWT;

import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/29
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class BorderLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");

        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("SOUTH"), SOUTH);
        f.add(new Button("NORTH"), NORTH);
        f.add(new Button("CENTER"));
        f.add(new Button("EAST"), EAST);
        f.add(new Button("WEST"), WEST);

        f.pack();
        f.setVisible(true);
    }
}
