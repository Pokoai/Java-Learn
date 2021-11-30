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
public class HandDraw2 {
    // 画图区尺寸
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    // 鼠标上一次位置
    private int preX = -1;
    private int preY = -1;
    // 右键菜单
    PopupMenu pop = new PopupMenu();
    MenuItem red = new MenuItem("red");
    MenuItem green = new MenuItem("green");
    MenuItem blue = new MenuItem("blue");
    // 按钮
    Button clearButton = new Button("clear");
    // BufferedImage 对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    // 获取 Graphics 对象
    Graphics g = image.getGraphics();
    // 画布对象
    DrawCanvas drawCanvas = new DrawCanvas();
    // 窗口对象
    Frame f = new Frame("简单手绘程序");
    // 存储颜色
    private Color foreColor = new Color(255, 0, 0);

    // 初始化
    public void init() {
        // 菜单项目监听器
        // 因为有三个菜单项需要注册该监听器，所以创建一个监听器实例变量分别赋予三者
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

        red.addActionListener(menuListener);
        green.addActionListener(menuListener);
        blue.addActionListener(menuListener);

        // 构建右键菜单
        pop.add(red);
        pop.add(green);
        pop.add(blue);
        drawCanvas.add(pop);
        f.add(drawCanvas);

        // 绘制区填充白色背景
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        // 画布设为合适大小
        drawCanvas.setPreferredSize(new Dimension(500, 400));

        // 鼠标监听器
        drawCanvas.addMouseListener(new MouseAdapter()
        {
            // 重写鼠标释放处理器
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop.show(drawCanvas, e.getX(), e.getY());
                }
                // 释放鼠标后绘制位置重新开始
                preX = -1;
                preY = -1;
            }
        });

        // 鼠标移动监听器
        drawCanvas.addMouseMotionListener(new MouseMotionAdapter()
        {
            // 重写鼠标拖拽监听器
            public void mouseDragged(MouseEvent e) {
                if (preX > 0 && preY > 0) {
                    g.setColor(foreColor);
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                // 更新坐标值
                preX = e.getX();
                preY = e.getY();
                // 调用画布的 repaint() 方法
                drawCanvas.repaint();
            }
        });

        // clear 按钮监听器
        clearButton.addActionListener(e ->
        {
            // 填充白色矩形背景覆盖掉之前的绘制痕迹
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
            // 恢复之前的画笔颜色
            g.setColor(foreColor);
        });

        // WindowClosing 监听器
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(clearButton, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

    }

    // 画布类
    class DrawCanvas extends Canvas {
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new HandDraw2().init();
    }
}
