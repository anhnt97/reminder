package com.uet.reminder.Panel;

import com.uet.reminder.Manager.FileManager;
import com.uet.reminder.Manager.ListNote;
import com.uet.reminder.Manager.Note;
import com.uet.reminder.Manager.NoteManager;
import javafx.scene.image.ImageView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

/**
 * Hien thi danh sach cac cong viec chung
 * Created by tuan anh on 14/11/2016.
 */
public class TaskListPanel extends JPanel implements ListSelectionListener {
    private JButton btAdd;
    private JButton btEdit;
    private JButton btDelete;
    private JList<ListNote> lTaskListNotes;
    private DefaultListModel<ListNote> listModel;

    public TaskListPanel(){
        initTaskListPanel();
        listModel = new DefaultListModel<>();
        addModel(listModel);
        initComponents();
    }

    private void initTaskListPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    private void initComponents() {
        btAdd = new JButton("ADD");
        btAdd.setSize(60, 30);
        btAdd.setLocation(10,330 );
        add(btAdd);

        btEdit = new JButton("EDIT");
        btEdit.setSize(60,30);
        btEdit.setLocation(btAdd.getX() + btAdd.getWidth() + 2, btAdd.getY());
        add(btEdit);

        btDelete = new JButton("DELETE");
        btDelete.setSize(80,30);
        btDelete.setLocation(btEdit.getX() + btEdit.getWidth() + 2, btAdd.getY());
        add(btDelete);

        lTaskListNotes = new JList<ListNote>(listModel);
        lTaskListNotes.setFixedCellHeight(50);
        lTaskListNotes.setBorder(new EmptyBorder(10,20, 10, 10));
        lTaskListNotes.setCellRenderer(new TaskListNotePanel());

        JScrollPane scrollPane = new JScrollPane(lTaskListNotes);
        scrollPane.setSize(190,300);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setLocation(20, 20);
        add(scrollPane);

        lTaskListNotes.addListSelectionListener(this);
    }

    public void addModel(DefaultListModel<ListNote> model){
//        try {
//           // getFileManager().readFile(getNoteManager());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (int i =0; i < getNoteManager().getUserNote().size(); i++){
//            System.out.println(getNoteManager().getNote(i));
//            model.addElement(getNoteManager().getNote(i));
//        }

        model.addElement(new ListNote("Làm bai tập opp", "repeat", true));
        model.addElement(new ListNote("bài tập web", "repeat", true));
        model.addElement(new ListNote("bài tập android", "repeat", true));
        model.addElement(new ListNote("aksdggggg", "repeat", true));
        model.addElement(new ListNote("aksrrrr", "repeat", true));
        NoteManager noteManager = new NoteManager();
        noteManager.add(new ListNote("akssddasdasfasftttttt", "repeat", true));
        FileManager fileManager = new FileManager(noteManager);
        fileManager.writeFile();
    }

    /**Bat su kien click vao jlist*/
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
