package com.learn.java.lang.wangs.base.swing;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JSlider;

/**
 * 滑块组件
 * @author wangsai
 */
public class JSliderDemo
{
    public static void main(String[] agrs)
    {
        JFrame frame=new JFrame("滑块组件示例");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=frame.getContentPane();
        JSlider slider=new JSlider(0,100);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        contentPane.add(slider);
        frame.setVisible(true);
    }
}
