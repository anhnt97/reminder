package com.uet.reminder.Panel;

import com.uet.reminder.GUI.GUI;
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
    Image imgLogo;
    /** Button tim kiem */
    JButton btSearch;
    /** text field tim kiem */
    JTextField tfSearch;

    private TaskListPanel taskListPanel;

    private TaskPanel taskPanel;

    public DisplayPanel(){
        this.setLayout(null);
        this.setBounds(0,0, CommonVLs.WIDTH_SCREEN,CommonVLs.HEGHT_SCREEN);
        initComponents();
    }

    private void initComponents() {
        lbLogo = new JLabel();
        lbLogo.setBounds(30,10,200,50);
        CommonVLs.setPicture(lbLogo,getClass().getResource("/image/reminder_logo.png").getPath());
        this.add(lbLogo);
        tfSearch = new JTextField();
        tfSearch.setBounds(lbLogo.getX() + lbLogo.getWidth() + 20,20,300,30);
        this.add(tfSearch);
        btSearch = new JButton("Search");

        ImageIcon imgSearch = new ImageIcon(getClass().getResource("/image/search_icon.png"));
        Image imgTemp = imgSearch.getImage();
        Image newImg = imgTemp.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        btSearch.setIcon(new ImageIcon(newImg));
        btSearch.setBounds(tfSearch.getWidth() + tfSearch.getX() + 30,20,100,30);
        this.add(btSearch);

        taskListPanel = new TaskListPanel();
        taskListPanel.setSize(CommonVLs.WIDTH_SCREEN/4 + 30, CommonVLs.HEGHT_SCREEN - tfSearch.getY() - tfSearch.getHeight() - 70);
        taskListPanel.setLocation(0, tfSearch.getY() + tfSearch.getHeight() + 40);
        this.add(taskListPanel);

        taskPanel = new TaskPanel();
        taskPanel.setSize(CommonVLs.WIDTH_SCREEN - taskListPanel.getWidth() - taskListPanel.getX() - 40, taskListPanel.getHeight() - 20);
        taskPanel.setLocation(taskListPanel.getWidth() + taskListPanel.getX() + 30, taskListPanel.getY() + 20);
        this.add(taskPanel);
    }
}
