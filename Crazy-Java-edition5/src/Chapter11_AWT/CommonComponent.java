package Chapter11_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/29
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class CommonComponent {
    // 窗口
    Frame f = new Frame("测试");
    // 按钮
    Button ok = new Button("ok");
    Button b1 = new Button("dialog1");
    Button b2 = new Button("dialog2");
    Button b3 = new Button("load");
    Button b4 = new Button("save");
    // 单选框
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("male", cbg, true);
    Checkbox female = new Checkbox("female", cbg, false);
    // 复选框
    Checkbox married = new Checkbox("Married?", false);
    // 下拉选择框
    Choice colorChooser = new Choice();
    // 列表选择框
    List colorList = new List(6, true);
    // 多行文本域
    TextArea ta = new TextArea(5, 20);
    // 单行文本域
    TextField tf = new TextField(50);

    // 对话框
    Dialog d1 = new Dialog(f, "模式对话框", true);
    Dialog d2 = new Dialog(f, "非模式对话框", false);

    // 文件对话框
    FileDialog fd1 = new FileDialog(f, "选择需要打开的文件",
            FileDialog.LOAD);
    FileDialog fd2 = new FileDialog(f, "选择保存文件的路径",
            FileDialog.SAVE);

    // 菜单项
    private MenuBar mb = new MenuBar(); // 菜单条
    Menu file = new Menu("File"); // 菜单项容器
    MenuItem newItem = new MenuItem("new"); // 菜单项
    MenuItem saveItem = new MenuItem("save"); // 菜单项
    MenuItem exitItem = new MenuItem("Exit",
            new MenuShortcut(KeyEvent.VK_X)); // 为菜单项添加快捷键

    Menu edit = new Menu("Edit");
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("AutoWrap");
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");

    Menu format = new Menu("Format");
    MenuItem commentItem = new MenuItem("Comment",
            new MenuShortcut(KeyEvent.VK_C, true));
    MenuItem cancelItem = new MenuItem("Cancel");

    // 右键菜单
    PopupMenu pop = new PopupMenu();

    public void init() {
        // 下拉选择框内容
        colorChooser.add("red");
        colorChooser.add("blue");
        colorChooser.add("green");
        // 列表选择框内容
        colorList.add("red");
        colorList.add("blue");
        colorList.add("green");

        // 对话框
        d1.setBounds(20, 30, 300, 400);
        d2.setBounds(20, 30, 300, 400);
        // 按钮打开对话框
        b1.addActionListener(e -> d1.setVisible(true));
        b2.addActionListener(e -> d2.setVisible(true));

        // 文件对话框
        b3.addActionListener(e ->
        {
            fd1.setVisible(true);
            // 打印出用户选择的文件路径和文件名
            System.out.println(fd1.getDirectory() + fd1.getFile());
            ta.append("打开文件：" + fd1.getDirectory() + fd1.getFile() + "\n");
        });

        b4.addActionListener(e ->
        {
            fd2.setVisible(true);
            System.out.println(fd2.getDirectory() + fd2.getFile());
        });

        // 注册 ok 按钮的事件监听器
        ok.addActionListener(new OkListener());

        // 为窗口添加事件监听器-匿名内部类（仅使用一次）
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 为菜单项定义事件监听器-Lambda表达式
        ActionListener menuListener = e ->
        {
            var cmd = e.getActionCommand();
            ta.append("单击" + cmd + "菜单" + "\n");
            if (cmd.equals("Exit")) {
                System.exit(0);
            }
        };

        commentItem.addActionListener(menuListener);
        exitItem.addActionListener(menuListener);

        // 单行文本框 + ok 按钮 放入 bottom 面板中
        var bottom = new Panel();
        bottom.add(tf);
        bottom.add(ok);
        bottom.add(b1);
        bottom.add(b2);
        bottom.add(b3);
        bottom.add(b4);
        f.add(bottom, BorderLayout.SOUTH);

        // 下拉选择框 + 复选框 + 单选框 放入 checkPanel 面板中
        var checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        // 多行文本域 + checkPanel 放入垂直排列的 Box 中
        var topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);

        // topLeft + 列表选择框 放入水平排列的 Box 中
        var top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        // 菜单项
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

//        edit.add(autoWrap);
//        edit.addSeparator();
//        edit.add(copyItem);
//        edit.add(pasteItem);

        pop.add(autoWrap); // 右键菜单
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);

        final var pp = new Panel();
        pp.add(pop);
        pp.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop.show(pp, e.getX(), e.getY());
                }
        }
        });

        format.add(commentItem);
        format.add(cancelItem);
        edit.addSeparator();
        edit.add(format);

        mb.add(file);
        mb.add(edit);
        f.setMenuBar(mb);

        // top Box 添加到窗口中间
        f.add(top);
        f.add(pp, BorderLayout.NORTH);
        f.pack();
        f.setVisible(true);
    }

    // 定义 ActionListener 事件监听器类
    class OkListener implements ActionListener {
        // 定义事件处理器
        public void actionPerformed(ActionEvent e) {
            System.out.println("用户点击了 ok 按钮");
            tf.setText("Hello World!");
        }
    }

    // 定义窗口事件监听器-内部类实现接口方式
    // 很繁琐，必须重写每个抽象方法
    // 建议使用事件适配器
//    class WinListener implements WindowListener {
//        public void windowActivated(WindowEvent e) {
//            ta.append("窗口被激活!\n");
//        }
//        public void windowClosed(WindowEvent e) {
//            ta.append("窗口被成功关闭!\n");
//        }
//        public void windowClosing(WindowEvent e) {
//            ta.append("用户关闭窗口!\n");
//            System.exit(0);
//        }
//        public void windowDeactivated(WindowEvent e) {
//            ta.append("窗口失去焦点!\n");
//        }
//        public void windowDeiconified(WindowEvent e) {
//            ta.append("窗口被恢复!\n");
//        }
//        public void windowIconified(WindowEvent e) {
//            ta.append("窗口最小化!\n");
//        }
//        public void windowOpened(WindowEvent e) {
//            ta.append("窗口初次打开!\n");
//        }
//    }

    // 窗口事件适配器-内部类继承事件适配器方式
    // 实际上，推荐使用更简洁的匿名内部类
//    class WinListener extends WindowAdapter {
//        public void windowClosing(WindowEvent e) {
//            ta.append("用户关闭窗口!\n");
//            System.exit(0);
//        }
//    }

    public static void main(String[] args) {
        new CommonComponent().init();
    }
}
