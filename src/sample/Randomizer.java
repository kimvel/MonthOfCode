package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.Random;

class Randomizer {

    // String array that contains "tasks" or the generals of OOP.
    static String[] availableTasks = {"Arrays", "Enums", "Objects", "Hashmap",
            "Polymorphism", "Abstraction", "Classes", "Encapsulation", "Information hiding",
            "Inheritance", "Interface", "Messaging", "Procedure"};

    // Gives a random String from the availableTasks array.
    static String getRandom(String[] str){

        // Gets random element from availableTasks array
        int rnd = new Random().nextInt(str.length);

        // returns the randomized string
        return str[rnd];
    }
}
