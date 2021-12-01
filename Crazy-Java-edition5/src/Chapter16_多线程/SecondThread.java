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
 * 实现 Runnable 接口创建线程
 * 优点：多线程间共享线程类的实例变量 + 还可以继承其他类
 * 缺点：编程稍微复杂些
 */
public class SecondThread implements Runnable { // 1. 实现 Runnable 接口
    private int i;
    // 2. 重写 run() 方法，即线程执行体
    public void run() {
        for (; i < 100; i++) {
            // 只能使用 Thread.currentThread() 获取当前线程
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (var i = 0; i < 100; i++) {
            // 主线程
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
            if (i == 20) {
                // 3. 创建 SecondThread 对象作为 Thread 的target
                var st = new SecondThread();
                new Thread(st, "新线程1").start();
                Thread.sleep(1);
                new Thread(st, "新线程2").start();
                Thread.sleep(1);
            }
        }
    }

}
