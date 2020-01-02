package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

// TODO; FIX: The "task" is updating if you press the button to pause.
// TODO: CSS AS GUI?
// TODO: Check if last db input is same as the newly randomized task, if true > randomize again and print.
