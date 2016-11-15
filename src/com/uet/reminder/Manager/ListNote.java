package com.uet.reminder.Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by DangChac-PC on 14/11/2016.
 * Quan li cac ListNote
 */
public class ListNote {
    private String name, id, repeat;
    ArrayList<Note> listNote;
    Boolean done;

    public ListNote() {
        listNote = new ArrayList<>();
    }

    public ListNote(String name, String repeat, Boolean done) {
        listNote = new ArrayList<>();
        this.name = name;
        this.repeat = repeat;
        this.done = done;
    }

    public void addNote(Note newNote){
        listNote.add(newNote);
        listNote.get(listNote.size() - 1).setId("N" + listNote.size());
    }

    /**
     * Sua com.uet.quanlycongviec.main.manager.Note assignNote bang cac thong tin moi
     * @param assignNote
     * @param name
     * @param place
     * @param timeStart
     * @param timeFinish
     * @param repeat
     */
    public void changeNote(Note assignNote, String name, String place, String content, String timeStart,
                           String timeFinish, String repeat, boolean done) {
        Note note = searchNote(assignNote.getName());
        note.setName(name);
        note.setPlace(place);
        note.setContent(content);
        note.setTimeFinish(timeFinish);
        note.setTimeStart(timeStart);
        note.setRepeat(repeat);
        note.setDone(done);
    }

    /**
     * Xoa assignNote khoi danh sach cac com.uet.quanlycongviec.main.manager.Note
     * @param assignNote
     */
    public void remove(Note assignNote) {
        listNote.remove(assignNote);
        for (int i = 0; i < listNote.size(); i++) {
            listNote.get(i).setId("N" + (i + 1));
        }
    }

    /**
     * Tim kiem note
     * @param value
     * @return
     */
    public Note searchNote(String value) {
        for (Note note : listNote) {
            if (note.getName().equalsIgnoreCase(value)) {
                return note;
            }
            if (note.getId().equalsIgnoreCase(value)) {
                return note;
            }
        }
        return null;
    }

    public String info(){
        String kq = "";
        kq += "ListID   : " + id + "\n";
        kq += "ListName : " + name  + "\n";
        kq += "IsRepeat : " + repeat + "\n";
        kq += "IsDone   : " + done + "\n";
        for (Note n : listNote) {
            kq += "ID  : " + n.getId() + "\n";
            kq += "Name: " + n.getName() + "\n";
        }
        return kq;
    }

    public int count(){
        return listNote.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public ArrayList<Note> getListNote() {
        return listNote;
    }
}
