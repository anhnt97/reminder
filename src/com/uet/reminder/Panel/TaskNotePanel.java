package com.uet.reminder.Panel;

import com.uet.reminder.Manager.Note;

import javax.swing.*;
import java.awt.*;

/**
 * hien thi trong noi dung trong tung phan tu jlist to do list
 * Created by NhatAnh on 20/11/2016.
 */
public class TaskNotePanel extends JPanel implements ListCellRenderer<Note> {
    private JCheckBox cbIcon;
    private JLabel lbName;

    public TaskNotePanel(){
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        cbIcon = new JCheckBox();
        cbIcon.setSize(100,100);
        lbName = new JLabel();
        lbName.setSize(100,100);
        cbIcon.setBackground(Color.WHITE);

        add(cbIcon,BorderLayout.WEST );//BorderLayout.EAST
        add(lbName);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Note> list, Note value, int index, boolean isSelected, boolean cellHasFocus) {
        lbName.setText(value.getName());
        return this;
    }
}
