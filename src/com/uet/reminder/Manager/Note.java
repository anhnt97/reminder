package com.uet.reminder.Manager;
/**
 * Created by DangChac-PC on 23/10/2016.
 */

/**
 * Class doi tuong ghi chu. Quan li cac ghi chu cua ngươi dung
 * Thuoc tinh:
 * Name      : Ten ghi chu
 * Place     : Dia diem
 * Content   : Noi Dung
 * TimeStart : Thoi gian bat dau
 * TimeFinish: Deadline
 * Repeat    : Loai lap (Once, EveryDay, EvevryWeek)
 * Done      : Da hoan thanh?
 */
public class Note {
    //Khai bao cac thong tin cua ghi chu
    private String id;
    private String name, place, content;
    private Time timeStart = new Time();
    private Time timeFinish = new Time();
    boolean done;
    private String repeat;

    /**
     * Khoi tao
     */
    public Note(String name, String place, String content, String timeStart
            , String timeFinish, String repeat, boolean done) {
        this.name = name;
        this.place = place;
        this.content = content;
        this.timeStart.setTime(timeStart);
        this.timeFinish.setTime(timeFinish);
        this.repeat = repeat;
        this.done = done;
    }

    public Note() {
        id = null;
        name = null;
        place = null;
        content = null;
        timeStart = new Time();
        timeFinish = new Time();
        repeat = "";
        done = false;
    }

    /**
     * In ra noi dung com.uet.quanlycongviec.main.manager.Note
     */
    public String info(){
        String s = "";
        s += "ID        : " + id;                   s += '\n';
        s += "Name      : " + name;                 s += '\n';
        s += "Place     : " + place;                s += '\n';
        s += "Content   : " + content;              s += '\n';
        s += "TimeStart : " + timeStart.getTime();  s += '\n';
        s += "TimeFinish: " + timeFinish.getTime(); s += '\n';
        s += "Repeat    : " + repeat;               s += '\n';
        s += "IsDone    : " + done;                 s += '\n';
        return s;
    }


    /**
     * Getter, Setter
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTimeStart() {
        return timeStart.getTime();
    }

    public void setTimeStart(String timeStart) {
        this.timeStart.setTime(timeStart);
    }

    public String getTimeFinish() {
        return timeFinish.getTime();
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish.setTime(timeFinish);
    }

    public String isRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
