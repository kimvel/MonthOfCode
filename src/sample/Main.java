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

// TODO
// Clean up variable names, or just names in general
// Timer doesn't stop
// Timer needs a pause
// CSS for GUI?
