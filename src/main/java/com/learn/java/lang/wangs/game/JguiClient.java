package com.learn.java.lang.wangs.game;

import com.learn.java.lang.wangs.base.swing.TabbedPaneDemo;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Swing客户端
 * @author wangsai
 */
public class JguiClient {
    /**
     * 写一个Gui的客户端
     */

    public static void main(String[] args) {
        JFrame jf = new JFrame("客户端");
        // 有关闭按钮
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 默认尺寸
        jf.setSize(800, 600);
        jf.setBounds(300,200,400,100);
        // 是否可视
        jf.setVisible(true);

        // 设置选项卡，其中有游戏，奖品两个选项
        jf.add(new Tabbed(),BorderLayout.CENTER);
        // 必须要有这句话
        jf.pack();
    }

    static class Tabbed extends JPanel{

        public Tabbed()
        {
            super(new GridLayout(1,1));
            JTabbedPane tabbedPane=new JTabbedPane();

            ImageIcon icon=createImageIcon("tab.jp1g");
            JComponent panel1 = makeTextPanel("游戏");
            tabbedPane.addTab("扭蛋机",icon, panel1,"Does nothing");
            tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

            JComponent panel2 = rewordsList();
            panel2.setPreferredSize(new Dimension(410,50));
            tabbedPane.addTab("奖池列表",icon,panel2,"Does nothing at all");
            tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);

            JComponent panel3 = manageRewordsList();
            panel3.setPreferredSize(new Dimension(410,50));
            tabbedPane.addTab("管理奖池",icon,panel3,"Does nothing at all");
            tabbedPane.setMnemonicAt(1,KeyEvent.VK_3);

            add(tabbedPane);
        }
    }

    /**
     * 添加和删除大奖
     * @param text
     * @return
     */
    protected static JComponent manageRewordsList() {
        // 粘合容器，依赖于顶级容器frame
        JPanel jp = new JPanel(false);

        // 创建标签
        JLabel label = new JLabel("当前现有大奖：");
        label.setHorizontalAlignment(JLabel.CENTER);
        jp.add(label);
        // 产品列表条目，创建JList，展示奖品
        JList jList = new JList(new String[]{"switch", "单反", "投影仪", "ps4"});
        jp.add(jList);

        // 新增加两个按钮
        JButton buttonAdd=new JButton("新增");
        JButton buttonDel=new JButton("删除");
        jp.add(buttonAdd);
        jp.add(buttonDel);

        //创建JComboBox， 我不需要这个
        //JComboBox cmb=new JComboBox();
        //用于显示信息
        JLabel showInfo=new JLabel();
        //用于输入信息
        JTextField jtf=new JTextField(16);
        //jp.add(cmb);
        jp.add(showInfo);
        jp.add(jtf);

        buttonDel.addActionListener(new ManageRewordsActionListener(jp, showInfo, jtf, jList));
        buttonAdd.addActionListener(new ManageRewordsActionListener(jp, showInfo, jtf, jList));
        //cmb.addItemListener(new ManageRewordsItemListener(jp, showInfo));
//        jList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                String str=e.getItem().toString();
//                jp.add(showInfo);
//                showInfo.setText("您选择的奖品是："+str);
//            }
//        });

        // 设置布局
        // jp.setLayout(new GridLayout(1,1));
        return jp;
    }

    /**
     * 奖品列表，添加和删除大奖
     * @param text
     * @return
     */
    protected static JComponent rewordsList() {
        // 粘合容器，依赖于顶级容器frame
        JPanel jp = new JPanel(false);

        // 创建标签
        JLabel label = new JLabel("大奖有：");
        label.setHorizontalAlignment(JLabel.CENTER);
        jp.add(label);

        // 产品列表条目，创建JList
        jp.add(new JList(new String[]{"switch", "单反", "投影仪"}));
        // 设置布局
        jp.setLayout(new GridLayout(1,1));
        return jp;
    }

    protected static JComponent makeTextPanel(String text) {
        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL= TabbedPaneDemo.class.getResource(path);
        if(imgURL!=null) {
            return new ImageIcon(imgURL);
        }
        else {
            System.err.println("Couldn't find file: "+path);
            return null;
        }
    }


    static class ManageRewordsActionListener implements ActionListener {

        private JPanel panel;
        // private JComboBox cmb;    //创建JComboBox
        private JLabel showInfo;    //用于显示信息
        private JTextField jtf;    //用于输入信息

        private JList jList;


//        public ManageRewordsActionListener(JPanel panel, JComboBox cmb, JLabel showInfo, JTextField jtf) {
//            this.panel = panel;
//            this.cmb = cmb;
//            this.showInfo = showInfo;
//            this.jtf = jtf;
//        }

        public ManageRewordsActionListener(JPanel panel, JLabel showInfo, JTextField jtf, JList jList) {
            this.panel = panel;
            this.showInfo = showInfo;
            this.jtf = jtf;
            this.jList = jList;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List vList = jList.getSelectedValuesList();
            String command = e.getActionCommand();
            //添加按钮处理
            if(command.equals("新增")) {
                if(jtf.getText().length()!=0) {
                    //cmb.addItem(jtf.getText());    //添加项
                    vList.add(jtf.getText());
                    panel.add(showInfo);
                    showInfo.setText("添加成功，新增了："+jtf.getText());
                } else {
                    panel.add(showInfo);
                    showInfo.setText("请输入要添加奖品");
                }
            }
            //删除按钮处理
            if(command.equals("删除")) {
                if(jtf.getText().length()!=0) {
                    //先获得要删除的项的值
                    String strDel = jtf.getText();
                    //cmb.removeItem(strDel);    //删除项
                    vList.remove(strDel);
                    panel.add(showInfo);
                    showInfo.setText("删除成功，删除了："+strDel);
                } else {
                    panel.add(showInfo);
                    showInfo.setText("请选择要删除的奖品");
                }
            }
        }

//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String command = e.getActionCommand();
//            //添加按钮处理
//            if(command.equals("新增")) {
//                if(jtf.getText().length()!=0) {
//                    cmb.addItem(jtf.getText());    //添加项
//                    panel.add(showInfo);
//                    showInfo.setText("添加成功，新增了："+jtf.getText());
//                } else {
//                    panel.add(showInfo);
//                    showInfo.setText("请输入要添加奖品");
//                }
//            }
//            //删除按钮处理
//            if(command.equals("删除")) {
//                if(cmb.getSelectedIndex()!=-1) {
//                    //先获得要删除的项的值
//                    String strDel=cmb.getSelectedItem().toString();
//                    cmb.removeItem(strDel);    //删除项
//                    panel.add(showInfo);
//                    showInfo.setText("删除成功，删除了："+strDel);
//                } else {
//                    panel.add(showInfo);
//                    showInfo.setText("请选择要删除的奖品");
//                }
//            }
//        }
    }

    static class ManageRewordsItemListener implements ItemListener {

        //用于显示信息
        private JPanel jp;
        private JLabel showInfo;


        public ManageRewordsItemListener(JPanel jp, JLabel showInfo) {
            this.showInfo = showInfo;
            this.jp = jp;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            String str=e.getItem().toString();
            jp.add(showInfo);
            showInfo.setText("您选择的奖品是："+str);
        }
    }
}
