package com.learn.java.lang.wangs.game;

/**
 * @author wangsai
 */

import java.util.Random;

/**
 *
 *
 1: 安全不可破解，每抽中一个蛋。要进行密码加密破解，AES对称加密
 【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】【】位图表示扭蛋
 时间戳+剩余的数字可以进行加密
 随机产生一个幸运数字作为中奖密码
 2: 中奖后，去除掉对应的数字
 3: 剩余后的密钥，序列化到一个文本文件中。（若强行破坏，必须重新开始）
 4: 如果已经中奖，必须清空奖池，剩余奖项，产生一定的幸运奖，幸运奖使用大富翁游戏来代替，可以有比较轻松的方式（
 比如：休假一天，吃喝玩乐，约朋友各种嗨干掉自闭症）

 设计:
 使用java窗口做界面，转动怎么搞呢？（动画效果）
 游戏进入后，输入
 扭蛋个数
 输入幸运中奖数字
 输入大奖奖池产品
 */
public class TwistedEggMachine {

    public static void main(String[] args) {
        // 客户端
        int days = 30;
        Random r = new Random();

        EggRule eggRule = new EggRule();
        for (int i = 0; i < 10; i++) {
            eggRule.init(days);
            eggRule.draw();
        }
    }
}
