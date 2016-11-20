package com.uet.reminder.Panel;

import com.uet.reminder.Manager.FileManager;
import com.uet.reminder.Manager.ListNote;
import com.uet.reminder.Manager.Note;
import com.uet.reminder.Manager.NoteManager;
import javafx.scene.image.ImageView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * Hien thi danh sach cac cong viec chung
 * Created by tuan anh on 14/11/2016.
 */
public class TaskListPanel extends JPanel {
    private Button btAdd;
    private Button btEdit;
    private Button btDelete;
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
        btAdd = new Button("ADD");
        btAdd.setSize(60, 30);
        btAdd.setLocation(10,330 );
        add(btAdd);

        btEdit = new Button("EDIT");
        btEdit.setSize(60,30);
        btEdit.setLocation(btAdd.getX() + btAdd.getWidth() + 10, btAdd.getY());
        add(btEdit);

        btDelete = new Button("DELETE");
        btDelete.setSize(60,30);
        btDelete.setLocation(btEdit.getX() + btEdit.getWidth() + 10, btAdd.getY());
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

        model.addElement(new ListNote("akssddasdasfasftttttt", "repeat", true));
        model.addElement(new ListNote("akssssd", "repeat", true));
        model.addElement(new ListNote("aksaaaa", "repeat", true));
        model.addElement(new ListNote("aksdggggg", "repeat", true));
        model.addElement(new ListNote("aksrrrr", "repeat", true));
        NoteManager noteManager = new NoteManager();
        noteManager.add(new ListNote("akssddasdasfasftttttt", "repeat", true));
        FileManager fileManager = new FileManager(noteManager);
        fileManager.writeFile();
    }
}
