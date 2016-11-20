package com.uet.reminder.Panel;

import com.uet.reminder.Manager.ListNote;
import com.uet.reminder.Manager.Note;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NhatAnh on 19/11/2016.
 */
public class TaskListNotePanel extends JPanel implements ListCellRenderer<ListNote> {
    private JCheckBox cbIcon;
    private JLabel lbName;

    public TaskListNotePanel(){
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        cbIcon = new JCheckBox();
        cbIcon.setSize(100,100);
        lbName = new JLabel();
        lbName.setSize(100,100);
        cbIcon.setBackground(Color.WHITE);
        add(lbName, BorderLayout.WEST);
        add(cbIcon, BorderLayout.EAST);
    }


    @Override
    public Component getListCellRendererComponent(JList<? extends ListNote> list, ListNote value, int index, boolean isSelected, boolean cellHasFocus) {
        lbName.setText(value.getName());
        cbIcon.setSelected(true);
        return this;
    }
}
