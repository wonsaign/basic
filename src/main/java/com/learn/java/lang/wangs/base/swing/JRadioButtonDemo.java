package com.learn.java.lang.wangs.base.swing;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonDemo {

    public static void main(String[] agrs) {
        JFrame frame=new JFrame("Java单选组件示例");    //创建Frame窗口
        JPanel panel=new JPanel();    //创建面板
        JLabel label1=new JLabel("现在是哪个季节：");
        JRadioButton rb1=new JRadioButton("春天");    //创建JRadioButton对象
        JRadioButton rb2=new JRadioButton("夏天");    //创建JRadioButton对象
        JRadioButton rb3=new JRadioButton("秋天",true);    //创建JRadioButton对象
        JRadioButton rb4=new JRadioButton("冬天");    //创建JRadioButton对象
        label1.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        ButtonGroup group=new ButtonGroup();
        //添加JRadioButton到ButtonGroup中
        group.add(rb1);
        group.add(rb2);
        panel.add(label1);
        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);
        panel.add(rb4);
        frame.add(panel);
        frame.setBounds(300, 200, 400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
