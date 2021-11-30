package Chapter11_AWT;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/30
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class HandDraw {
    // 画布尺寸
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    // preX、preY保存了上一次鼠标拖动事件的鼠标坐标
    private int preX = -1;
    private int preY = -1;
    // 右键菜单，用于设置画笔颜色
    PopupMenu pop = new PopupMenu("画笔颜色");
    MenuItem redItem = new MenuItem("red");
    MenuItem greenItem = new MenuItem("green");
    MenuItem blueItem = new MenuItem("blue");
    // 按钮
    Button clear = new Button("clear");
    // BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT,
            BufferedImage.TYPE_3BYTE_BGR);
    // 获取 image 对象的 Graphics
    Graphics g = image.getGraphics(); // 通过 g 向 image 中添加图形
    // 画布对象
    private DrawCanvas drawArea = new DrawCanvas();
    // 窗口
    Frame f = new Frame("手绘程序");
    // 保存画笔颜色
    private Color foreColor = new Color(255, 0, 0);

    public void init() {
        // 右键菜单的事件监听器
        ActionListener menuListener = e ->
        {
            if (e.getActionCommand().equals("red")) {
                foreColor = new Color(255, 0, 0);
            }
            if (e.getActionCommand().equals("green")) {
                foreColor = new Color(0, 255, 0);
            }
            if (e.getActionCommand().equals("blue")) {
                foreColor = new Color(0, 0, 255);
            }
        };
        // 为三个菜单添加事件监听器
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);
        drawArea.add(pop);

        // 将image对象的背景色填充成白色
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        // 监听鼠标移动动作
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (preX > 0 && preY > 0) {
                    g.setColor(foreColor);
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                preX = e.getX();
                preY = e.getY();
                drawArea.repaint();
            }
        });

        // 监听鼠标事件
        drawArea.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                // 松开鼠标键时，把上一次鼠标拖动事件的X、Y坐标设为-1。
                preX = -1;
                preY = -1;
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        clear.addActionListener(e ->
        {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
            drawArea.repaint();
            g.setColor(foreColor);
        });

        f.add(drawArea);
        f.add(clear, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    // 自定义画布类
    class DrawCanvas extends Canvas {
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new HandDraw().init();
    }
}
