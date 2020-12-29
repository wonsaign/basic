package com.learn.java.lang.wangs.base.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * 类似div？？？
 * 粘合剂
 * 可以放入多个标签，但是必须依附于JFrame，JDialog，JApplet的顶级容器。
 */
public class JPanelDemo {

    public static void main(String[] agrs) {
        //创建一个JFrame对象
        JFrame jf=new JFrame("Java第二个GUI程序");
        //设置窗口大小和位置
        jf.setBounds(300, 100, 400, 200);
        //创建一个JPanel对象
        JPanel jp=new JPanel();
        //创建一个标签
        JLabel jl=new JLabel("这是放在JPanel上的标签");
        //设置背景色
        jp.setBackground(Color.white);
        //将标签添加到面板
        jp.add(jl);
        //将面板添加到窗口
        jf.add(jp);
        //设置窗口可见
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
