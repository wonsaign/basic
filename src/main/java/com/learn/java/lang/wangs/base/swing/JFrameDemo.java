package com.learn.java.lang.wangs.base.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class JFrameDemo extends JFrame {

    public JFrameDemo() {
        //设置显示窗口标题
        setTitle("Java 第一个 GUI 程序");
        //设置窗口显示尺寸
        setSize(400,200);
        //置窗口是否可以关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建一个标签
        JLabel jl = new JLabel("这是使用JFrame类创建的窗口");
        //获取当前窗口的内容窗格
        Container c = getContentPane();
        //将标签组件添加到内容窗格上
        c.add(jl);
        //设置窗口是否可见
        setVisible(true);
    }

    public static void main(String[] agrs) {
        new JFrameDemo();    //创建一个实例化对象
    }
}
