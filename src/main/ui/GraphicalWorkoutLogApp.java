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
    public static final int HEIGHT = 350;

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
        viewPanel = new ViewScreen(this);
        addPanel = new AddScreen(this);
        homePanel = new HomeScreen(this);
        homePanel.setOpaque(true);
    }

    private void initializeFrame() {
        homeFrame.setSize(new Dimension(WIDTH, HEIGHT));
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeHome();
        homeFrame.setVisible(true);
    }


    private void initializeHome() {
        JPanel homeScreen = new JPanel();
        JPanel buttonPanel = homePanel.getButtonPanel();
        JPanel welcomePanel = homePanel.getWelcomePanel();

        homeScreen.add(buttonPanel, BorderLayout.NORTH);
        homeScreen.add(welcomePanel, BorderLayout.WEST);

        homeFrame.setContentPane(homeScreen);
        homeFrame.pack();
    }

    public void viewLog() {
        JPanel viewScreen = initializeViewScreen();
        homeFrame.setContentPane(viewScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();

    }

    private JPanel initializeViewScreen() {
        JPanel viewScreen = new JPanel();
        JPanel textAreaPanel = viewPanel.getTextAreaPanel();
        JPanel textPanel = viewPanel.getTextPanel();

        viewScreen.add(textAreaPanel, BorderLayout.SOUTH);
        viewScreen.add(textPanel, BorderLayout.NORTH);

        return viewScreen;
    }

    public void addWorkoutScreen() {
        JPanel addScreen = initializeAddScreen();
        homeFrame.setContentPane(addScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();
    }

    private JPanel initializeAddScreen() {
        JPanel addScreen = new JPanel();
        JPanel buttonPanel = addPanel.getButtonPanel();
        JPanel textPanel = addPanel.getTextBoxPanel();

        addScreen.add(textPanel, BorderLayout.WEST);
        addScreen.add(buttonPanel, BorderLayout.SOUTH);

        return addScreen;

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

    public WorkoutLog getLog() {
        return log;
    }

    public JFrame getFrame() {
        return homeFrame;
    }
}
