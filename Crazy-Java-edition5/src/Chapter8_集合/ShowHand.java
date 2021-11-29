//package Chapter8_集合;
//
//import java.util.*;
///**
// * Description: 《疯狂Java讲义》
// * Author: Pokeai
// * WebSite: https://arctee.cn/
// * Github: https://github.com/pokoai/
// * Date: 2021/11/26
// * 『戒急戒躁，心装大盘。日日耕耘，精进成长。』
// */
//public class ShowHand {
//    // 定义该游戏支持多少个玩家
//    private final int PLAY_NUM = 4; // 常量值，用 final 修饰
//    // 定义扑克牌的所有花色和数值
//    private String[] types = {"方块", "黑桃", "红桃", "梅花"};
//    private String[] values = {"2", "2", "3", "4", "5",
//        "6", "7", "8", "9", "10",
//        "J", "Q", "K", "A"};
//    // 定义所有的玩家手
//    private String[] players = new String[PLAY_NUM];
//    // 一局游戏剩下的扑克牌
//    private List<String> cards = new LinkedList<>();
//    // 定义玩家手上的牌
//    private List<String>[] playersCards = new List[PLAY_NUM];
//
//    // 初始化扑克牌
//    public void initCards() {
//        for (var i = 0; i < types.length; i++) {
//            for (var j = 0; j < values.length; j++) {
//                cards.add(types[i] + values[j]);
//            }
//        }
//        Collections.shuffle(cards); // 洗牌
//    }
//
//    // 初始化玩家用户名
//    public void initPlayer(String... names) {
//        if (names.length > PLAY_NUM || names.length < 2) {
//            System.out.println("玩家数量不对");
//            return;
//        }
//        else {
//            for (var i = 0; i < names.length; i++) {
//                players[i] = names[i];
//            }
//        }
//    }
//
//    // 初始化玩家手上的牌
//    public void initPlayerCards() {
//        for (var i = 0; i < players.length; i++) {
//            if (players[i] != null && players[i].equals("")) {
//                playersCards[i] = new LinkedList<String>();
//            }
//        }
//    }
//
//    // 输出所有牌，测试用
//    public void showAllCards() {
//        for (String card : cards) {
//            System.out.println(card);
//        }
//    }
//
//    // 派发扑克牌
//    public void deliverCard(String name) {
//        // 获取 name 在 players 字符数组中的索引
//        int firstPos = ArrayUtils.search(players, name); // ArrayUtils 无效
//
//        for (var i = firstPos; i < PLAY_NUM; i++) {
//            if (players[i] != null) {
//                playersCards[i].add(cards.get(0));
//                cards.remove(0);
//            }
//        }
//        for (var i = 0; i < firstPos; i++) {
//            if (players[i] != null) {
//                playersCards[i].add(cards.get(0));
//                cards.remove(0);
//            }
//        }
//    }
//
//    // 输出玩家手上的牌
//    public void showPlayerCards()
//    {
//        for (var i = 0; i < PLAY_NUM; i++)
//        {
//            // 当该玩家不为空时
//            if (players[i] != null)
//            {
//                // 输出玩家
//                System.out.print(players[i] + " ： " );
//                // 遍历输出玩家手上的扑克牌
//                for (var card : playersCards[i])
//                {
//                    System.out.print(card + "\t");
//                }
//            }
//            System.out.print("\n");
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        var sh = new ShowHand();
//        sh.initPlayer("电脑玩家", "孙悟空");
//        sh.initCards();
//        sh.initPlayerCards();
//        // 下面测试所有扑克牌，没有实际作用
//        sh.showAllCards();
//        System.out.println("---------------");
//        // 下面从"孙悟空"开始派牌
//        sh.deliverCard("孙悟空");
//        sh.showPlayerCards();
//		/*
//		这个地方需要增加处理:
//		1.牌面最大的玩家下注.
//		2.其他玩家是否跟注?
//		3.游戏是否只剩一个玩家?如果是，则他胜利了。
//		4.如果已经是最后一张扑克牌，则需要比较剩下玩家的牌面大小.
//		*/
//        // 再次从"电脑玩家"开始派牌
//        sh.deliverCard("电脑玩家");
//        sh.showPlayerCards();
//    }
//}
