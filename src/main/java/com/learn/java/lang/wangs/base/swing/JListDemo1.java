package com.learn.java.lang.wangs.base.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;


/**
 * 带下拉框带列表
 * @author wangsai
 */
public class JListDemo1 extends JFrame
{
    public JListDemo1()
    {
        setTitle("Java列表框组件示例");
        //设置窗体退出时操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体位置和大小
        setBounds(100,100,300,200);
        //创建内容面板
        JPanel contentPane=new JPanel();
        //设置面板的边框
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //设置内容面板为边界布局
        contentPane.setLayout(new BorderLayout(0, 0));
        //应用内容面板
        setContentPane(contentPane);
        //创建滚动面板
        JScrollPane scrollPane=new JScrollPane();
        //将面板增加到边界布局中央
        contentPane.add(scrollPane,BorderLayout.CENTER);
        JList list=new JList();
        //限制只能选择一个元素
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //在滚动面板中显示列表
        scrollPane.setViewportView(list);
        //创建一个含有12个元素的数组
        String[] listData=new String[12];
        for (int i=0;i<listData.length;i++)
        {
            //为数组中各个元素赋值
            listData[i]="这是列表框的第"+(i+1)+"个元素~";
        }
        //为列表填充数据
        list.setListData(listData);
    }
    public static void main(String[] args)
    {
        JListDemo1 frame=new JListDemo1();
        frame.setVisible(true);
    }
}
