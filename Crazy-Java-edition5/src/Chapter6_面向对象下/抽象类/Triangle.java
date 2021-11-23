package Chapter6_面向对象下.抽象类;

/**
 * Description: 《疯狂Java讲义》- 抽象类
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
//        this.a = a;
//        this.b = b;
//        this.c = c;
        setSides(a, b, c);
    }
    public void setSides(double a, double b, double c) {
        if (a > b + c || b > a + c || c > a + b) {
            System.out.println("三角形两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // 重写Shape抽象方法
    public double calPerimeter()
    {
        return a + b + c;
    }

    public String getType() {
        return "三角形";
    }

    public static void main(String[] args) {
        Shape s = new Triangle("红色", 3, 4, 5);
        System.out.println(s.calPerimeter());
        System.out.println(s.getType());
    }
}
