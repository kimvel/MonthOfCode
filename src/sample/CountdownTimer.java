package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

    static int seconds = 3600;
    static String time;

    @FXML private Text timeLeft;

    public String startTimer(){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run(){
                if (seconds >= 1) {
                    seconds--;

                    time = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    System.out.println(time);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
        return time;
    }
}


