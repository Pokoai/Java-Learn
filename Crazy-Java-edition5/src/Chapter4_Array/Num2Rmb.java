package Chapter4_Array;

import java.util.Arrays;

/**
 * Description: 《疯狂Java讲义》-第四章 数组
 * Author: Pokeai
 * WebSite: https://arctee.cn/
 * Github: https://github.com/pokoai/
 * Date: 2021/11/20
 * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
 */
public class Num2Rmb {
    // 首先定义成员变量
    private String[] hanArr = {"零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖"};
    private String[] zhenUnitArr = {"十", "百", "千"};
    private String[] xiaoUnitArr = {"角", "分"};

    // 将数分解为整数和小数，并转化为字符串，便于后续定位每个数字
    private String[] divide(double num) {
        // 整数
        var zheng = (long) num;
        // 小数
        var xiao = Math.round((num - zheng) * 100);
        // 转化为字符串
        return new String[] {zheng+"", String.valueOf(xiao)};
    }

    // 将四位数的数字字符串转化为汉字字符串
    private String toHanStr(String numStr) {
        int numLen = numStr.length();
        var result = "";

        for (var i = 0; i < numLen; i++) {
            // 取出其中的一位数字字符并转化为数字整数
            var num = numStr.charAt(i) - 48;
            if (i != numLen - 1 && num != 0) {
                result += hanArr[num] + zhenUnitArr[numLen - 2 - i];
            }
            else {
                result += hanArr[num];
            }
        }
        return result;
    }

    // 将两位数的小数字符串转化为汉字字符串
    private String xiao2HanStr(String numStr) {
        int numLen = numStr.length();
        String result = "";

        for (var i = 0; i < numLen; i++) {
            var num = numStr.charAt(i) - 48;
            result += hanArr[num] + xiaoUnitArr[i];
        }
        return result;
    }

    // main函数
    public static void main(String[] args) {
        var rmb = new Num2Rmb();
        double num = 1783.451;
        String out;

        var han = rmb.divide(num);
        out = rmb.toHanStr(han[0]) + rmb.xiao2HanStr(han[1]);
        System.out.println(out);
    }

}
