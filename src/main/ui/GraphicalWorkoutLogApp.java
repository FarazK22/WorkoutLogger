package ui;

import model.WorkoutLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;

public class GraphicalWorkoutLogApp extends JFrame {
    private static final String JSON_STORE = "./data/workouts.json";
    private WorkoutLog log;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public GraphicalWorkoutLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeFields();
        initializeGraphics();
    }

    private void initializeFields() {
    }

    private void initializeGraphics() {

    }
}
