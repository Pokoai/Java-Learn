package Chapter6_面向对象下.接口;

/**
 * Description: 《疯狂Java讲义》-Output接口（输出设备的规范）
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */

/**
 * 接口
 * 定义一种规范，使用普通方法(系统会自动添加 public abstract 修饰符)来实现
 * 也可以包含类方法、默认方法、私有方法（用于实现辅助方法，即类方法和默认方法的辅助）
 * 成员变量：只能定义静态常量（系统自动添加 public static final 修饰符)
 * 没有构造器、初始化块
 * 与抽象类最大的不同点在于：1.抽象类可能会事先实现部分功能，其他留给子类来实现；但接口仅作为一种规范，不实现。
 * 2.只能继承一个父类，但是可以实现多个接口
 */
public interface Output {
    // 成员变量，只能是常数
    int MAX_CACHE_LINE = 50;

    // 普通方法，作为输出设备的规范，只要某个类实现这两个方法，它就是一个输出设备
    void out();
    void getData(String msg);

    // 还可以定义默认方法，实现某些功能，必须有 default 修饰符且必须有方法体
    default void print(String... msgs) {
        for (var s : msgs) {
            System.out.println(s);
        }
    }

    // 还可以定义类方法，用 static 修饰
    static String staticTest() {
        return "接口里的类方法";
    }
}
