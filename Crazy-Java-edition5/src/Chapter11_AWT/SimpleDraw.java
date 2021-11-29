package Chapter11_AWT;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/30
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class SimpleDraw {
    // 先定义好常量
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private Frame f = new Frame("简单绘图");
    private Button rect = new Button("Rect");
    private Button oval = new Button("Oval");
    private String shape = ""; // 将要绘制的图形变量
    private MyCanvas drawArea = new MyCanvas();

    public void init() {
        var p = new Panel();

        // 注册监听器
        rect.addActionListener(e ->
        {
            shape = RECT_SHAPE;
            drawArea.repaint();
        });

        oval.addActionListener(e ->
        {
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        p.add(rect);
        p.add(oval);
        f.add(p, BorderLayout.SOUTH);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.pack();
        f.setVisible(true);
    }

    // 创建 Canvas 子类，重写 paint() 方法实现绘图
    public class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            var rand = new Random();

            if (RECT_SHAPE == shape) {
                g.setColor(new Color(220, 100, 80));
                g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }
            if (OVAL_SHAPE == shape) {
                g.setColor(new Color(16, 53, 230));
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }

}
