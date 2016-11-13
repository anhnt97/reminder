import com.uet.reminder.GUI.GUI;
import com.uet.reminder.TimerTask.TimerTaskNotification;

/**
 * Created by tuana on 13/11/2016.
 */
public class Main {
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setVisible(true);
        TimerTaskNotification timerTaskNification = new TimerTaskNotification(5);
    }
}
