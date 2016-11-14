package com.uet.reminder.Manager;

/**
 * Created by DangChac-PC on 27/10/2016.
 */
public class Time {
    private int hour, minutes, day, month, year;

    public Time() {
        hour = 0;
        minutes = 0;
        day = 0;
        month = 0;
        year = 0;
    }

    /**
     * Khoi tao ko bao gom ngay
     * @param hour
     * @param minutes
     */
    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    /**
     * Khoi tao day du
     * @param hour
     * @param minutes
     * @param day
     * @param month
     * @param year
     */
    public Time(int hour, int minutes, int day, int month, int year) {
        this.hour = hour;
        this.minutes = minutes;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setTime(String time) {
        String s = "";
        int i = 0;
        while (time.charAt(i) != ':') {
            s += time.charAt(i);
            i++;
        }
        hour = Integer.parseInt(s);
        i++;
        s = "";
        while (i < time.length()) {
            if (time.charAt(i) == '.') {
                break;
            } else {
                s += time.charAt(i);
                i++;
            }
        }
        minutes = Integer.parseInt(s);
        i++;
        s = "";
        while (i < time.length()) {
            if (time.charAt(i) == '/') {
                break;
            } else {
                s += time.charAt(i);
                i++;
            }
        }
        if (s != "") {
            day = Integer.parseInt(s);
        }
        i++;
        s = "";
        while (i < time.length()) {
            if (time.charAt(i) == '/') {
                break;
            } else {
                s += time.charAt(i);
                i++;
            }
        }
        if (s != "") {
            month = Integer.parseInt(s);
        }
        i++;
        s = "";
        while (i < time.length()) {
            s += time.charAt(i);
            i++;
        }
        if (s!= "") {
            year = Integer.parseInt(s);
        }
    }

    public String getTime(){
        String time = "";
        time = hour + ":" + minutes + "." + day + "/" + month + "/" + year;
        return time;     }


    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
