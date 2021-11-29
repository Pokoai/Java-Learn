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
public class FrameTest {
    public static void main(String[] args) {
        // 创建窗口
        var f = new Frame("测试窗口");
        // 创建面板
        var p = new Panel();
        // Panel 中添加组件
        p.add(new TextField(20));
        p.add(new Button("dick"));
        // Panel 加入到 Frame 中
        f.add(p);
        // 设置窗口参数
        f.setBounds(30, 30, 250, 200);
        // 设置窗口可见性
        f.setVisible(true);
    }
}
