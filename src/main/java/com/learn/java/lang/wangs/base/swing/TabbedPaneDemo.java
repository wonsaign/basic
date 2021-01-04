package com.learn.java.lang.wangs.base.swing;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 选项卡
 * @author wangsai
 */
public class TabbedPaneDemo extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("我的电脑 - 属性");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TabbedPaneDemo(),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    public TabbedPaneDemo()
    {
        super(new GridLayout(1,1));
        JTabbedPane tabbedPane=new JTabbedPane();
        ImageIcon icon=createImageIcon("tab.jp1g");
        JComponent panel1=makeTextPanel("计算机名");
        tabbedPane.addTab("计算机名",icon, panel1,"Does nothing");
        tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);
        JComponent panel2=makeTextPanel("硬件");
        tabbedPane.addTab("硬件",icon,panel2,"Does twice as much nothing");
        tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);
        JComponent panel3=makeTextPanel("高级");
        tabbedPane.addTab("高级",icon,panel3,"Still does nothing");
        tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);
        JComponent panel4=makeTextPanel("系统保护");
        panel4.setPreferredSize(new Dimension(410,50));
        tabbedPane.addTab("系统保护",icon,panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3,KeyEvent.VK_4);
        add(tabbedPane);
    }

    protected JComponent makeTextPanel(String text)
    {
        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path)
    {
        java.net.URL imgURL=TabbedPaneDemo.class.getResource(path);
        if(imgURL!=null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("Couldn't find file: "+path);
            return null;
        }
    }
}
