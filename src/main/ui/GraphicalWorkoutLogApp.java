package ui;

import model.WorkoutLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panels.AddScreen;
import ui.panels.HomeScreen;
import ui.panels.ViewScreen;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GraphicalWorkoutLogApp extends JFrame {

    private JFrame homeFrame = new JFrame("Workout Log");
    public static final int WIDTH = 500;
    public static final int HEIGHT = 250;

    private static final String JSON_STORE = "./data/workouts.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private WorkoutLog log;


    private HomeScreen homePanel;
    private AddScreen addPanel;
    private ViewScreen viewPanel;


    public GraphicalWorkoutLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeFields();
        initializeFrame();
    }

    private void initializeFields() {
        log = new WorkoutLog();
        viewPanel = new ViewScreen(homeFrame);
    }

    private void initializeFrame() {
        homeFrame.setSize(new Dimension(WIDTH, HEIGHT));
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.add(viewPanel);
        homeFrame.setVisible(true);
    }


    private void viewLog() {
    }

    private void addWorkout() {

    }

    private void loadWorkouts() {
        try {
            log = jsonReader.read();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(homeFrame, "Unable to read from file: " + JSON_STORE,
                    "Load error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveWorkouts() {
        try {
            jsonWriter.open();
            jsonWriter.write(log);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(homeFrame, "Unable to write to file: " + JSON_STORE, "Save error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private WorkoutLog getLog() {
        return log;
    }
}
