package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage mainApplication) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainApplication.setTitle("30 days of code");
        mainApplication.setScene(new Scene(root, 300, 400));
        mainApplication.initStyle(StageStyle.TRANSPARENT);
        mainApplication.setResizable(false);
        mainApplication.show();

            // get
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
            // move
        root.setOnMouseDragged(event -> {
            mainApplication.setX(event.getScreenX() - xOffset);
            mainApplication.setY(event.getScreenY() - yOffset);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// TODO
//  -   Check if last db input is same as the newly randomized task, if true > randomize again and print.
//  -   On-exit show a popup with the message "Are you sure?" and two button options, yes and no.
//  -   Count total hours coded, and show on App.
//  -   Pause effect? blur effect, popup..
//  -   Animations?
//  -   Error: [SQLITE_CONSTRAINT]  Abort due to constraint violation (UNIQUE constraint failed: Table1.check1)
//  -   Move window with the new titlebar
//  -   Png is shit.