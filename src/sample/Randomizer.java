package sample;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.Random;

public class Randomizer {

    public static String[] availableTasks = {"Arrays", "Enums", "Objects", "Hashmap", "Polymorphism"};

    public static String getRandom(String[] str){

        // Gets random element from availableTasks array
        int rnd = new Random().nextInt(str.length);

        // returns the randomized string
        return str[rnd];
    }
}
