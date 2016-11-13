package com.uet.reminder.TimerTask;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by tuana on 14/11/2016.
 */
public class TimerTaskNotification {
    private Timer timer;
    public TimerTaskNotification(int seconds){
        timer = new Timer();
        timer.schedule(new RemindTask(),seconds * 1000);
    }
    class RemindTask extends TimerTask{
        public void run() {

            timer.cancel();
        }
    }
}
