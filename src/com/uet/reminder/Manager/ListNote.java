package com.uet.reminder.Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by DangChac-PC on 14/11/2016.
 * Quan li cac ListNote
 */
public class ListNote {
    private String name, id, repeat;
    ArrayList<Note> listNote = new ArrayList<>();
    Boolean done;

    public ListNote() {
    }

    public ListNote(String name, String id, String repeat, Boolean done) {
        this.name = name;
        this.id = id;
        this.repeat = repeat;
        this.done = done;
    }

    public void addNote(Note newNote){
        listNote.add(newNote);
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
        Note note = searchNote(assignNote.getName());
        listNote.remove(note);
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
        String kq;
        kq = id + ": \n";
        kq = name + ": \n";
        kq = repeat + ": \n";
        kq = done + ": \n";
        for (Note n : listNote) {
            kq += n.info();
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
