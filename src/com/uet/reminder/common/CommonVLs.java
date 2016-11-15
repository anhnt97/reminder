package com.uet.reminder.common;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *Cac du lieu dung chung trong toan bo chuong trinh
 * Created by tuan anh on 14/11/2016.
 */
public class CommonVLs {
   public static final int WIDTH_SCREEN = 700;
   public static final int HEGHT_SCREEN = 500;
   public static void setPicture(JLabel label, String fileName) {
      try {
         BufferedImage image = ImageIO.read(new File(fileName));
         int w = label.getSize().width;
         int h = label.getSize().height;
         int iw = image.getWidth();
         int ih = image.getHeight();
         int dw = 0;
         int dh = 0;
         if (w / h > iw / ih) {
            dh = h;
            dw = dh * iw / ih;
         } else {
            dw = w;
            dh = dw * ih / iw;
         }
         ImageIcon icon = new ImageIcon(image.getScaledInstance(dw, dh,
                 Image.SCALE_SMOOTH));
         label.setIcon(icon);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
