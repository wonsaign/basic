package com.learn.java.lang.wangs.base.swing;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author wangsai
 * checkbox复选框
 */
public class JCheckBoxDemo {

    public static void main(String[] agrs) {
        JFrame frame=new JFrame("Java复选组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
        JLabel label=new JLabel("流行编程语言有：");
        label.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        JCheckBox chkbox1=new JCheckBox("C#", true);    //创建指定文本和状态的复选框
        JCheckBox chkbox2=new JCheckBox("C++");    //创建指定文本的复选框
        JCheckBox chkbox3=new JCheckBox("Java");    //创建指定文本的复选框
        JCheckBox chkbox4=new JCheckBox("Python");    //创建指定文本的复选框
        JCheckBox chkbox5=new JCheckBox("PHP");    //创建指定文本的复选框
        JCheckBox chkbox6=new JCheckBox("Perl");    //创建指定文本的复选框
        jp.add(label);
        jp.add(chkbox1);
        jp.add(chkbox2);
        jp.add(chkbox3);
        jp.add(chkbox4);
        jp.add(chkbox5);
        jp.add(chkbox6);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
