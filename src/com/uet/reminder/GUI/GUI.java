package com.uet.reminder.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 13/11/2016.
 */
public class GUI extends JFrame{
    public GUI(){
        super("REMINDER");
        this.setBounds(200,100,700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image imageIcon = new ImageIcon(getClass().getResource("/image/reminder.png")).getImage();
        this.setIconImage(imageIcon);
        initComponents();

    }

    private void initComponents() {

    }
}
