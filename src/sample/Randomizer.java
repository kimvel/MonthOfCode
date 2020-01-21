package sample;

import java.util.Random;

class Randomizer {

    // Gives a random String from the availableTasks array.
    static String getRandom(String[] getString){

        // Gets random element from availableTasks array
        int random = new Random().nextInt(getString.length);

        // returns the randomized string
        return getString[random];
    }
}
