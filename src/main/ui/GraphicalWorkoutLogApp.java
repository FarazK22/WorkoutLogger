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

    private Workout activeWorkout;



    private AddEnduranceScreen endurancePanel;
    private AddFlexibilityScreen flexibilityPanel;
    private AddStrengthScreen strengthPanel;



    public GraphicalWorkoutLogApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeFields();
        initializeFrame();
    }

    private void initializeFields() {
        log = new WorkoutLog();
        endurancePanel = new AddEnduranceScreen(this);
        flexibilityPanel = new AddFlexibilityScreen(this);
        strengthPanel = new AddStrengthScreen(this);
    }

    private void initializeFrame() {
        homeFrame.setSize(new Dimension(WIDTH, HEIGHT));
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeHome();
        homeFrame.setVisible(true);
    }

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

    public void viewLog() {
        JPanel viewScreen = initializeViewScreen();
        homeFrame.setContentPane(viewScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();

    }

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

    public Workout getActiveWorkout() {
        return activeWorkout;
    }

    private void setAddScreen(JPanel addScreen) {
        homeFrame.setContentPane(addScreen);
        homeFrame.revalidate();
        homeFrame.repaint();
        homeFrame.pack();
    }

    public void continueOption() {

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

    private void updateLog() {
        log.addWorkout(activeWorkout);
        initializeHome();
    }

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

    private JPanel getAddPanel(JPanel buttonPanel2, JPanel textBoxPanel) {
        JPanel addScreen = new JPanel();
        JPanel buttonPanel = buttonPanel2;
        JPanel textPanel = textBoxPanel;

        addScreen.add(textPanel, BorderLayout.WEST);
        addScreen.add(buttonPanel, BorderLayout.SOUTH);

        return addScreen;
    }


    public void loadWorkouts() {
        try {
            log = jsonReader.read();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(homeFrame, "Unable to read from file: " + JSON_STORE,
                    "Load error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveWorkouts() {
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
