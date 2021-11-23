package Chapter6_面向对象下.接口;

/**
 * Description: 《疯狂Java讲义》-打印机Printer，实现 Output、Product 两个接口
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/24
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class Printer implements Output, Product{
    // 创建打印队列
    private String[] printData = new String[MAX_CACHE_LINE]; // 打印的数据
    private int dataNum = 0; // 队列待打印任务数量

    // 实现 Output 的接口
    public void out() {
        while (dataNum > 0) {
            System.out.println("打印机打印: " + printData[0]);
            // 更新打印数组
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE) {
            System.out.println("待打印队列已满，添加失败。");
        }
        else {
            // 将数据添加进打印队列中
            printData[dataNum++] = msg;
        }
    }

    // 实现 Product 接口
    public int getProduceTime() {
        return 45;
    }

    public static void main(String[] args) {
        // 创建 Printer 对象，当成 Output 使用
        Output op = new Printer();
        op.getData("搞定Java");
        op.getData("不在话下");
        op.out();
        op.out();
        // 调用 Output 接口的默认函数
        op.print("每日耕耘", "日进一寸", "持续状态");

        // 创建 Printer 对象， 当成 Product 使用
        Product pt = new Printer();
        System.out.println(pt.getProduceTime());
    }

}
