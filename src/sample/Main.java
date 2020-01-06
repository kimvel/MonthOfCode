package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage mainApplication) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainApplication.setTitle("30 days of code");
        mainApplication.setScene(new Scene(root, 300, 400));
        mainApplication.show();
        mainApplication.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

// TODO; CSS AS GUI?
// TODO; Check if last db input is same as the newly randomized task, if true > randomize again and print.
// TODO; On-exit show a popup with the message "Are you sure?" and two button options, yes and no.
// TODO; Count total hours coded, and show on App.
// TODO; Pause effect? blur effect, popup..