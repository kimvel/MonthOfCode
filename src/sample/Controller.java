package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private int seconds = 5;
    private String time;
    private String getLast;

    @FXML private Text teksjt;
    @FXML private ToggleButton btn;
    @FXML private Text timeLeft;

    Timer timer;

    @FXML void buttonClicked(){
        getLast = Randomizer.getRandom(Randomizer.availableTasks);

        teksjt.setText(getLast);
        if (btn.isSelected()){
            startTimer();
            Database.insert(getLast);
        } else{
            isPaused();
            btn.setText("Paused");
        }
    }

    private String startTimer (){

        timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run(){
                if (seconds >= 1) {
                    seconds--;

                    time = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    timeLeft.setText(time);
                }

                // Changing the text color of timeLeft when its appropriate
                if (time.matches("30:00")){
                    timeLeft.setFill(Color.YELLOW);
                } else if (time.matches("15:00")){
                    timeLeft.setFill(Color.ORANGE);
                } else if (time.matches("03:00")){
                    timeLeft.setFill(Color.RED);
                } else if (time.matches("00:00")){
                    isFinished();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        return time;
    }

    public void isPaused(){
        timer.cancel();
    }

    public void isFinished(){
        timer.cancel();
    }
}



