package ui;

import model.WorkoutLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class GraphicalWorkoutLogApp extends JFrame {
    private static final String JSON_STORE = "./data/workouts.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private WorkoutLog log;


    private JFrame homeFrame = new JFrame("Workout Log");
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;


    public GraphicalWorkoutLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeFields();
        initializeFrame();
    }

    private void initializeFields() {
        log = new WorkoutLog();
    }

    private void initializeFrame() {
        homeFrame.setSize(new Dimension(WIDTH, HEIGHT));
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtons();
        homeFrame.setVisible(true);
        
    }

    private void addButtons() {
        JPanel buttonPanel = new JPanel();

        JButton newButton = new JButton("Start workout");
        JButton viewButton = new JButton("View your log");
        JButton loadButton = new JButton("Load workouts");
        JButton saveButton = new JButton("Save workouts");
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(newButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(quitButton);

        homeFrame.add(buttonPanel);
    }
}
