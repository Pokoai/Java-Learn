package Chapter6_面向对象下.内部类;

/**
 * Description: 《疯狂Java讲义》-内部类
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */

/**
 * 内部类：静态/非静态
 * 想要访问静态内部类的成员时，可以直接使用 外部类的类名.内部类类名. 成员变量
 * 而要访问非静态内部类成员时，必须要先创建外部类的实例，麻烦些。
 * 故首先考虑使用静态内部类
 */
public class Cow {
    // 成员变量
    private double weight;
    // 构造器
    public Cow() {};

    public Cow(double weight) {
        this.weight = weight;
    }
    // 非静态内部类
    private class CowLeg {
        // 实例变量
        private double length;
        private String color;
        // 构造器
        public CowLeg() {};
        public CowLeg(double length, String color) {
            this.length = length;
            this.color = color;
        }

        // 内部类实例方法
        public void info() {
            System.out.println("当前牛腿颜色是："
                + color + "，长：" + length);
            // 访问外部类的 private 修饰的成员变量
            System.out.println("本牛腿所在奶牛重：" + weight);
        }

        public void innerTest() {
            System.out.println("内部类实例方法测试");
        }
    }

    // 外部类的实例方法
    public void test() {
        // 想要访问内部类的实例方法，需要创建内部类的对象去调用
        var cl = new CowLeg(1.12, "黑白相间");
        cl.info();
    }

    // 主函数
    public static void main(String[] args) {
        // 首先创建外部类的对象
        var cow = new Cow(344.34);
        cow.test(); // 已经在 test() 中创建了内部类对象
        // 外部类中调用内部类方法
        cow.new CowLeg(345,"黑白").innerTest();
    }

}
