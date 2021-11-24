package Chapter6_面向对象下.Lambda;

/**
 * Description: 《疯狂Java讲义》-Lambda表达式
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
interface Eatable {
    void taste(); // 无参数
}

interface Flyable {
    void fly(String weather); // 一个参数
}

interface Addable {
    int add(int a, int b); // 两个参数，有 return
}

public class LambdaQs {
    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }

    public void drive(Flyable f) {
        System.out.println("我正在驾驶" + f);
        f.fly("晴空");
    }

    public void test(Addable add) {
        System.out.println("5与3的和为：" + add.add(5, 3));
    }

    public static void main(String[] args) {
        var la = new LambdaQs();
        // 无参
        la.eat(() -> System.out.println("苹果的味道不错！"));
        // 一个参数
        la.drive(weather -> {
            System.out.println("今天的天气是：" + weather);
            System.out.println("直升机飞行平稳");
        });
        // 有返回值
        la.test((a, b) -> a + b);
    }
}
