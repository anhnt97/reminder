package com.uet.reminder.Panel;

import com.uet.reminder.common.CommonVLs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        this.setLayout(null);
        this.setBounds(0,0, CommonVLs.WIDTH_SCREEN,CommonVLs.HEGHT_SCREEN);
        initComponents();
    }

    private void initComponents() {
        lbLogo = new JLabel();
        lbLogo.setBounds(10,10,200,50);
        CommonVLs.setPicture(lbLogo,getClass().getResource("/image/reminder_logo.png").getPath());
        this.add(lbLogo);
//        search = new JButton("Search");
//        search.setBounds(20,30,100,50);
//        this.add(search);
    }
}
