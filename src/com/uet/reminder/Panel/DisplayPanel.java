package com.uet.reminder.Panel;

import com.uet.reminder.common.CommonVLs;

import javax.swing.*;
import java.awt.*;

/**
 * Panel hien thi khi khoi dong chuong trinh
 * Created by tuan anh on 14/11/2016.
 */
public class DisplayPanel extends JPanel{
    /** label chua logo */
    JLabel lbLogo;
    /** anh logo */
    Image logo;
    /** Button tim kiem */
    JButton search;
    public DisplayPanel(){
        this.setBounds(0,0, CommonVLs.WIDTH_SCREEN,CommonVLs.HEGHT_SCREEN);
        initComponents();
    }

    private void initComponents() {
        logo = new ImageIcon(getClass().getResource("/image/reminder_logo.png")).getImage();
        logo.getScaledInstance(10,10,Image.SCALE_SMOOTH);
        lbLogo = new JLabel();
        lbLogo.setBounds(1,1,10,10);
        lbLogo.setIcon(new ImageIcon(logo));
        this.add(lbLogo);

        search = new JButton("Search");
        search.setBounds(20,30,10,50);
        this.add(search);
    }
}
