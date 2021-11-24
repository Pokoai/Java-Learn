package Chapter6_面向对象下.内部类;

/**
 * Description: 《疯狂Java讲义》-匿名内部类
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
interface Product {
    double getPrice();
    String getName();
}

public class AnonymousTest {
    public void test(Product p) {
        System.out.println("购买了一个" + p.getName()
            + "，花掉了" + p.getPrice() + "元");
    }

    public static void main(String[] args) {
        var ta = new AnonymousTest();
        // 调用 test() 方法时，实现匿名内部类
        ta.test(new Product() {
            public double getPrice() {
                return 567.8;
            }

            public String getName() {
                return "AGP显卡";
            }
        });
    }
}
