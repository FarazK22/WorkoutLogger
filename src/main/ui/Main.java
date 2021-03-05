package ui;

import java.io.FileNotFoundException;

// EFFECTS: runs Workout Log app
public class Main {
    public static void main(String[] args) {
        try {
            new WorkoutLogApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
