package Chapter16_多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Description: 《疯狂Java讲义》
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/12/1
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class ThirdThread {
    public static void main(String[] args) {
        var rt = new ThirdThread(); // 不懂为啥要这一句
        // 1. Lambda 表达式创建 Callable 接口的对象
        // 2. 因为 FutureTask 类代表 Callable 接口中 call() 方法的返回值
        // 3. 所以可以使用 FutureTask 类来包装 Callable 对象
        // 4. 又因为 FutureTask 类 实现了 Runnable 接口，
        // 5. 所以可以把 FutureTask 对象作为 target 传给 Thread
        FutureTask<Integer> task = new FutureTask<> ((Callable<Integer>)() ->
        {
            // 重写 call() 方法
            var i = 0;
            for ( ; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                    + " 的循环变量i的值：" + i);
            }
            // call() 方法有返回值
            return i;
        });
        // 主线程执行体
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
                + " 的循环变量i的值：" + i);
            if (i == 20) {
                // 创建并启动线程
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            // 获取 线程的返回值
            System.out.println("子线程的返回值：" + task.get());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
