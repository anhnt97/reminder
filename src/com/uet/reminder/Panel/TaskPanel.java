package com.uet.reminder.Panel;

import com.uet.reminder.Manager.Note;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Hien thi danh sach cac cong viec cu the
 * Created by tuana on 14/11/2016.
 */
public class TaskPanel extends JPanel {
    private Button btAdd;
    private Button btEdit;
    private Button btDelete;
    private JLabel lbTimeCreate;
    private JLabel lbName;
    private JLabel lbRepeat;
    private JTextField tfTimeCreat;
    private JTextField tfName;
    private JTextField tfRepeat;
    private JList<Note> lTaskNotes;
    private DefaultListModel<Note> model;

    public TaskPanel(){
        initTaskPanel();
        model = new DefaultListModel<>();
        addModel(model);
        initCom();
    }

    private void initTaskPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    public void initCom(){
        btAdd = new Button("ADD");
        btAdd.setSize(80, 30);
        btAdd.setLocation(250,310 );
        add(btAdd);

        btEdit = new Button("EDIT");
        btEdit.setSize(80,30);
        btEdit.setLocation(btAdd.getX() + btAdd.getWidth() + 10, btAdd.getY());
        add(btEdit);

        btDelete = new Button("DELETE");
        btDelete.setSize(80,30);
        btDelete.setLocation(btEdit.getX() + btEdit.getWidth() + 10, btAdd.getY());
        add(btDelete);

        Font font = new Font("Tahoma", Font.PLAIN, 20);
        FontMetrics metrics = getFontMetrics(font);

        String txtTimeCreate = "Time Create";
        lbTimeCreate = new JLabel(txtTimeCreate);
        lbTimeCreate.setFont(font);
        lbTimeCreate.setSize(metrics.stringWidth(txtTimeCreate), metrics.getHeight());
        lbTimeCreate.setLocation(20, 10);
        add(lbTimeCreate);

        String txtName = "Name";
        lbName = new JLabel(txtName);
        lbName.setFont(font);
        lbName.setSize(metrics.stringWidth(txtName), metrics.getHeight());
        lbName.setLocation(lbTimeCreate.getX(), lbTimeCreate.getY() + lbTimeCreate.getHeight() + 10);
        add(lbName);

        tfName = new JTextField();
        tfName.setSize(200, lbName.getHeight());
        tfName.setLocation(lbName.getX() + lbName.getWidth() + 10, lbName.getY());
        add(tfName);

        String txtRepeat = "Repeat";
        lbRepeat = new JLabel(txtRepeat);
        lbRepeat.setFont(font);
        lbRepeat.setSize(metrics.stringWidth(txtRepeat), metrics.getHeight());
        lbRepeat.setLocation(tfName.getX() + tfName.getWidth() + 40, lbTimeCreate.getY() + lbTimeCreate.getHeight() + 10);
        add(lbRepeat);

        tfRepeat = new JTextField();
        tfRepeat.setSize(100, lbName.getHeight());
        tfRepeat.setLocation(lbRepeat.getX() + lbRepeat.getWidth() + 10, lbRepeat.getY());
        add(tfRepeat);

        lTaskNotes = new JList<>(model);
        lTaskNotes.setFixedCellHeight(50);
        lTaskNotes.setBorder(new EmptyBorder(10,20, 10, 10));
        lTaskNotes.setCellRenderer(new TaskNotePanel());

        JScrollPane scrollPane = new JScrollPane(lTaskNotes);
        scrollPane.setSize(tfRepeat.getWidth() + tfRepeat.getX() - lbName.getX(),200);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setLocation(lbName.getX(), lbName.getY() + lbName.getHeight() + 20);
        add(scrollPane);
    }

    public void addModel(DefaultListModel<Note> model){
//        try {
//           // getFileManager().readFile(getNoteManager());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (int i =0; i < getNoteManager().getUserNote().size(); i++){
//            System.out.println(getNoteManager().getNote(i));
//            model.addElement(getNoteManager().getNote(i));
//        }

        model.addElement(new Note("akssddasdasfasftttttt", "asa", "as","2:2.8/3/2", "2:2.8/3/2", "repeat", true));
        model.addElement(new Note("aks", "asa", "as","2:2.8/3/2", "2:2.8/3/2", "repeat", true));
        model.addElement(new Note("aks", "asa", "as","2:2.8/3/2", "2:2.8/3/2", "repeat", true));
        model.addElement(new Note("aks", "asa", "as","2:2.8/3/2", "2:2.8/3/2", "repeat", true));
        model.addElement(new Note("aks", "asa", "as","2:2.8/3/2", "2:2.8/3/2", "repeat", true));
    }
}
