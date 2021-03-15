package ui;

import java.io.FileNotFoundException;

// Represents main class where workout log app is launched


// EFFECTS: runs Workout Log app
public class Main {
    public static void main(String[] args) {
        try {
            new GraphicalWorkoutLogApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
