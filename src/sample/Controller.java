package sample;

import com.jfoenix.controls.JFXToolbar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.DeflaterOutputStream;

public class Controller {

    //FX imports
    public Text topicOfTheDay, timeLeftTextOnly, taskText, timeLeft;
    public ToggleButton btn;
    public Button exitBtn;
    public ImageView closeImage;
    public AnchorPane anchorPane;

    //
    private double xOffset = 0;
    private double yOffset = 0;
    private int seconds = 3600;
    private String time, getLast;
    private boolean isRandomSelected = true;

    // Timer
    private Timer timer;

    // When the button is clicked obviously.
    @FXML void buttonClicked () {
        if (isRandomSelected) {
            getLast = Randomizer.getRandom(StringCollector.javaDev);
            isRandomSelected = false;
            Database.insert(getLast);

            timeLeftTextOnly.setVisible(true);
            topicOfTheDay.setVisible(true);
            taskText.setVisible(true);
            timeLeft.setVisible(true);
        }

        taskText.setText(getLast);
        if (btn.isSelected()) {
            startTimer();
            btn.setText("Pause");
            btn.setStyle("-fx-border-color: #242424; -fx-background-radius: 100; -fx-background-color: transparent; -fx-border-radius: 100;");
        } else {
            isPaused();
            btn.setText("Continue");
            btn.setStyle("-fx-border-color: #ED6E70; -fx-background-radius: 100; -fx-background-color: transparent; -fx-border-radius: 100;");
        }
    }

    // to exit the application
    @FXML void exitBtn () {
        Stage stage = (Stage) closeImage.getScene().getWindow();
        stage.close();
    }

    // Starts a timer for the period of learning today.
    private void startTimer () {

        timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run () {
                if (seconds >= 1) {
                    seconds--;

                    time = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    timeLeft.setText(time);
                }

                // Changing the text color of timeLeft when its appropriate & stops the Timer at 00:00. I know, i know. It's not a good solution.
                if (time.matches("30:00")) {
                    timeLeft.setFill(Color.YELLOW);
                } else if (time.matches("15:00")) {
                    timeLeft.setFill(Color.ORANGE);
                } else if (time.matches("03:00")) {
                    timeLeft.setFill(Color.RED);
                } else if (time.matches("00:00")) {
                    isFinished();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    // Helps the timer if pause is needed.
    private void isPaused () {
        timer.cancel();
    }

    // Stops the timer when finished, pretty much the same as the code above.
    private void isFinished () {
        timer.cancel();
    }

    private void onExit(){
        // pause timer
        // show popup
        // give a yes/no if want to exit
    }
}



