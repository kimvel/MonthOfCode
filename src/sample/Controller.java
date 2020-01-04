package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML private Text taskText;
    @FXML private ToggleButton btn;
    @FXML private Text timeLeft;

    private int seconds = 3600;
    private String time;
    private Timer timer;

    // When the button is clicked obviously.
    @FXML void buttonClicked(){
        String getLast = Randomizer.getRandom(Randomizer.availableTasks);

        taskText.setText(getLast);
        if (btn.isSelected()){
            startTimer();
            Database.insert(getLast);
        } else{
            isPaused();
            btn.setText("Paused");
        }
    }

    // Starts a timer for the periode of learning today.
    private void startTimer (){

        timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run(){
                if (seconds >= 1) {
                    seconds--;

                    time = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    timeLeft.setText(time);
                }

                // Changing the text color of timeLeft when its appropriate & stops the Timer at 00:00.
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
    }

    // Helps the timer if pause is needed.
    private void isPaused(){
        timer.cancel();
    }

    // Stops the timer when finished, pretty much the same as the code above.
    private void isFinished(){
        timer.cancel();
    }
}



