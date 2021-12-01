package Chapter16_多线程;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/1
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */

/**
 * 通过继承创建线程
 * 优点：代码简单 + 可直接使用 this 获取当前线程
 * 缺点：多个线程无法共享线程类的实例变量 + 无法再继承其他类
 */
public class FirstThread extends Thread { // 1. 继承 Thread 类
    private int i;
    // 2. 重写 run() 方法
    public void run() { // 线程执行体
        for ( ; i < 100; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
            + " " + i);
            if (i == 20) {
                // 3. 启动线程
                new FirstThread().start();
                // 启动第二条线程
                new FirstThread().start();
            }
        }
    }
}
