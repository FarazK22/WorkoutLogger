package ui;

import model.Workout;
import model.WorkoutLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panels.AddEnduranceScreen;
import ui.panels.AddFlexibilityScreen;
import ui.panels.AddStrengthScreen;
import ui.panels.HomeScreen;
import ui.panels.ViewScreen;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the GUI for the Workout Log app

public class GraphicalWorkoutLogApp extends JFrame {

    private JFrame homeFrame = new JFrame("Workout Log");
    public static final int WIDTH = 500;
    public static final int HEIGHT = 350;

    private static final String JSON_STORE = "./data/workouts.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private WorkoutLog log;

    private Workout activeWorkout;


    private AddEnduranceScreen endurancePanel;
    private AddFlexibilityScreen flexibilityPanel;
    private AddStrengthScreen strengthPanel;


    // MODIFIES: this
    // EFFECTS: Initializes the graphical workout log app which includes:
    //          - the JSON writer
    //          - the JSON reader
    //          - the class fields
    //          - the size of the frame
    public GraphicalWorkoutLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeFields();
        initializeFrame();
    }

    // MODIFIES: this
    // EFFECTS: instantiates a new workout log and the three different exercise panels
    private void initializeFields() {
        log = new WorkoutLog();
        endurancePanel = new AddEnduranceScreen(this);
        flexibilityPanel = new AddFlexibilityScreen(this);
        strengthPanel = new AddStrengthScreen(this);
    }

    // MODIFIES: homeFrame
    // EFFECTS: sets the size and default close operation for the homeFrame, calls initializeHome to set home screen
    private void initializeFrame() {
        homeFrame.setSize(new Dimension(WIDTH, HEIGHT));
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeHome();
        homeFrame.setVisible(true);
    }

    // MODIFIES: homeFrame
    // EFFECTS: sets up home screen with JPanel components from HomeScreen class
    public void initializeHome() {
        HomeScreen homePanel;
        homePanel = new HomeScreen(this);

        JPanel homeScreen = new JPanel();
        JPanel buttonPanel = homePanel.getButtonPanel();
        JPanel welcomePanel = homePanel.getWelcomePanel();

        homeScreen.add(buttonPanel, BorderLayout.NORTH);
        homeScreen.add(welcomePanel, BorderLayout.WEST);

        homeFrame.setContentPane(homeScreen);
        homeFrame.pack();
    }

    // MODIFIES: homeFrame
    // EFFECTS: wipes home screen and displays view screen
    public void viewLog() {
        JPanel viewScreen = initializeViewScreen();
        homeFrame.setContentPane(viewScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();

    }

    // EFFECTS: retrieves JPanel components from ViewScreen and returns screen to be added to homeFrame
    private JPanel initializeViewScreen() {
        ViewScreen viewPanel;
        viewPanel = new ViewScreen(this);

        JPanel viewScreen = new JPanel();
        JPanel textAreaPanel = viewPanel.getTextAreaPanel();
        JPanel textPanel = viewPanel.getTextPanel();
        JPanel backButtonPanel = viewPanel.getBackButtonPanel();

        viewScreen.add(textAreaPanel, BorderLayout.WEST);
        viewScreen.add(textPanel, BorderLayout.WEST);
        viewScreen.add(backButtonPanel, BorderLayout.SOUTH);

        return viewScreen;
    }

    // MODIFIES: this
    // EFFECTS: Instantiates new workout and prompts user to input workout date
    public void startNewWorkout() {
        String workoutDate = (String) JOptionPane.showInputDialog(
                homeFrame,
                "Enter today's date (MM/DD/YYYY)",
                "Workout Date",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "MM/DD/YYYY");
        Workout newWorkout = new Workout(workoutDate);
        this.activeWorkout = newWorkout;

        setExerciseScreenType();
    }

    // EFFECTS: prompts user for exercise type
    private void setExerciseScreenType() {
        Object[] possibilities = {"Endurance", "Flexibility", "Strength"};
        String exerciseType = (String) JOptionPane.showInputDialog(
                homeFrame,
                "Enter your workout type",
                "Exercise Type",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Endurance");

        JPanel addScreen = initializeAddScreen(exerciseType);
        setAddScreen(addScreen);
    }


    // MODIFIES: this
    // EFFECTS: sets frame to exercise adding screen
    private void setAddScreen(JPanel addScreen) {
        homeFrame.setContentPane(addScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();
    }

    // EFFECTS: prompts user for input on whether or not to continue adding exercises
    // if user says yes, prompts them to choose exercise type, else updates log
    public void continueOption() {
        playSound("success.wav");
        int n = JOptionPane.showConfirmDialog(
                homeFrame,
                "Success! Your exercise was successfully added. Would you like to add another?",
                "Exercise Added",
                JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            setExerciseScreenType();
        } else if (n == 1) {
            updateLog();
        }
    }

    // MODIFIES: this
    // EFFECTS: updates workout log with active workout and initializes home screen with updated info
    private void updateLog() {
        log.addWorkout(activeWorkout);
        initializeHome();
    }

    // EFFECTS: uses user selection for exercise type to determine proper exercise screen to return for display
    private JPanel initializeAddScreen(String exerciseType) {
        JPanel addPanel = null;
        if (exerciseType.equals("Strength")) {
            addPanel = getAddPanel(strengthPanel.getButtonPanel(), strengthPanel.getTextBoxPanel());
        } else if (exerciseType.equals("Endurance")) {
            addPanel = getAddPanel(endurancePanel.getButtonPanel(), endurancePanel.getTextBoxPanel());
        } else if (exerciseType.equals("Flexibility")) {
            addPanel = getAddPanel(flexibilityPanel.getButtonPanel(), flexibilityPanel.getTextBoxPanel());
        }
        return addPanel;
    }

    // EFFECTS: retrieves JPanel components from exercise screen class and returns them
    private JPanel getAddPanel(JPanel buttonPanel2, JPanel textBoxPanel) {
        JPanel addScreen = new JPanel();
        JPanel buttonPanel = buttonPanel2;
        JPanel textPanel = textBoxPanel;

        addScreen.add(textPanel, BorderLayout.WEST);
        addScreen.add(buttonPanel, BorderLayout.SOUTH);

        return addScreen;
    }

    // EFFECTS: loads workouts from JSON file
    public void loadWorkouts() {
        try {
            log = jsonReader.read();
            playSound("loaded.wav");
            JOptionPane.showMessageDialog(homeFrame,
                    "Successfully loaded workouts!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(homeFrame, "Unable to read from file: " + JSON_STORE,
                    "Load error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: saves workouts to JSON file
    public void saveWorkouts() {
        try {
            jsonWriter.open();
            jsonWriter.write(log);
            jsonWriter.close();
            playSound("success.wav");
            JOptionPane.showMessageDialog(homeFrame,
                    "Successfully saved workouts!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(homeFrame, "Unable to write to file: " + JSON_STORE, "Save error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: retrieves audio file to play
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    // GETTERS

    public WorkoutLog getLog() {
        return log;
    }

    public JFrame getFrame() {
        return homeFrame;
    }

    public Workout getActiveWorkout() {
        return activeWorkout;
    }

}
