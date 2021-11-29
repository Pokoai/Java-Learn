package Chapter11_AWT;

import java.awt.*;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/29
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class FlowLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");

        f.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (var i = 0; i < 10; i++) {
            f.add(new Button("Button" + i));
        }
        f.pack();
        f.setVisible(true);
    }
}
