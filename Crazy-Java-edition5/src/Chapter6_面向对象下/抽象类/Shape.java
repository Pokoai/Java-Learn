package Chapter6_面向对象下.抽象类;

/**
 * Description: 《疯狂Java讲义》- 抽象类
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public abstract class Shape {
    {
        System.out.println("执行Shape的初始化块...");
    }  // 抽象类的初始化块在创建其子类实例的时候被调用

    // 成员变量
    private String color;

    // 计算周长的抽象方法
    public abstract double calPerimeter();
    // 返回形状的抽象方法
    public abstract String getType();
    // Shape构造器
    public Shape(){};

    public Shape(String color) {
        this.color = color;
    }
    // color的getter和setter的方法
}


