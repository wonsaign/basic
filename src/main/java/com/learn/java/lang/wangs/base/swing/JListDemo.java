package com.learn.java.lang.wangs.base.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * 列表
 * @author wangsai
 */
public class JListDemo {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Java列表框组件示例");
        frame.setVisible(true);

        JPanel jp=new JPanel();    //创建面板
        String[] items=new String[]{"身份证","驾驶证","军官证"};
        JList list=new JList(items);    //创建JList

        JLabel label1=new JLabel("证件类型：");    //创建标签
        jp.add(label1);

        jp.add(list);
        frame.add(jp);

        frame.setBounds(300,200,400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
