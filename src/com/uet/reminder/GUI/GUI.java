package com.uet.reminder.GUI;

        import com.uet.reminder.Panel.DisplayPanel;
        import com.uet.reminder.common.CommonVLs;

        import javax.swing.*;
        import java.awt.*;

/**
 * Giao dien chinh cua chuong trinh
 * Created by tuan anh on 13/11/2016.
 */
public class GUI extends JFrame{
    private DisplayPanel displayPanel;
    public GUI(){
        super("REMINDER");
        this.setBounds(200,100, CommonVLs.WIDTH_SCREEN,CommonVLs.HEGHT_SCREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image imageIcon = new ImageIcon(getClass().getResource("/image/reminder.png")).getImage();
        this.setIconImage(imageIcon);
        initComponents();

    }

    private void initComponents() {
        displayPanel = new DisplayPanel();
        this.add(displayPanel);
    }
}
