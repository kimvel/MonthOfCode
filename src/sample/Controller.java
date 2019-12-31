package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

import static sample.CountdownTimer.seconds;
import static sample.CountdownTimer.time;

public class Controller {

    @FXML private Text teksjt;
    @FXML private Button btn;
    @FXML private Text timeLeft;

    @FXML void buttonClicked(){

        teksjt.setText(Randomizer.getRandom(Randomizer.availableTasks));
        btn.setDisable(true);
        btn.setText("Pause");
        startTimer();
    }

    public String startTimer(){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run(){
                if (seconds >= 1) {
                    seconds--;

                    CountdownTimer.time = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    timeLeft.setText(CountdownTimer.time);
                }

                // Changing the text color of timeLeft when its appropriate
                if (time.matches("30:00")){
                    timeLeft.setFill(Color.YELLOW);
                } else if (time.matches("15:00")){
                    timeLeft.setFill(Color.ORANGE);
                } else if (time.matches("03:00")){
                    timeLeft.setFill(Color.RED);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        return CountdownTimer.time;
    }
}



