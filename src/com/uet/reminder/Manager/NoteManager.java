package com.uet.reminder.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DangChac-PC on 23/10/2016.
 * Class doi tuong com.uet.quanlycongviec.main.manager.NoteManager quan li danh sach cac com.uet.quanlycongviec.main.manager.Note
 */
public class NoteManager {
    ArrayList<ListNote> userListNote = new ArrayList<>();

    /**
     * Them 1 listNote moi vao danh sach
     * @param newList
     */
    public void add(ListNote newList) {
        userListNote.add(newList);
    }

    /**
     * Thay doi 1 note trong ListNote
     * @param assignNote
     * @param name
     * @param place
     * @param content
     * @param timeStart
     * @param timeFinish
     * @param repeat
     * @param done
     */
    public void change(Note assignNote, String name, String place, String content
            , String timeStart, String timeFinish, String repeat, boolean done) {
        for (ListNote list : userListNote) {
            if (list.searchNote(name) != null) {
                list.changeNote(assignNote, name, place, content
                        , timeStart, timeFinish, repeat, done);
            }
        }
    }

    /**
     * Xoa ListNote trong userListNote
     * @param assignListNote
     */
    public void remove(ListNote assignListNote) {
        userListNote.remove(assignListNote);
    }

    /**
     *
     * @param value
     * @return
     */
    public ListNote searchList(String value){
        for (ListNote list : userListNote) {
            if (list.getName().equalsIgnoreCase(value)) {
                return list;
            }
            if (list.getId().equalsIgnoreCase(value)) {
                return list;
            }
        }
        return null;
    }

    /**
     * Tim kiem Note trong tat ca
     * @param value
     * @return
     */
    public Note searchNote(String value) {
        for (ListNote list : userListNote) {
            if (list.searchNote(value) != null) {
                return list.searchNote(value);
            }
        }
        return null;
    }

    public ArrayList<ListNote> getUserListNote() {
        return userListNote;
    }

    public String toString(){
        String kq = "";
        for (ListNote list : userListNote) {
            kq += list.info();
        }
        return kq;
    }
}
