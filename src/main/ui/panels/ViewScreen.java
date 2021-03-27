package ui.panels;

import model.Workout;
import model.WorkoutLog;
import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;
import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the components of the view log screen on the workout log app

public class ViewScreen extends JPanel {

    private final JLabel viewBoxLabel = new JLabel("Your log: ");

    private GraphicalWorkoutLogApp parent;
    private JTextArea jt;
    private WorkoutLog log;

    private JPanel textAreaPanel;
    private JPanel textPanel;
    private JPanel backButtonPanel;

    // MODIFIES: this
    // EFFECTS: initializes a view screen with a parent (GUI), the GUI's workout log, a text panel,
    //          text area panel, and back button panel
    public ViewScreen(GraphicalWorkoutLogApp parent) {
        this.parent = parent;
        this.log = parent.getLog();
        textAreaPanel = setUpTextAreaPanel();
        textPanel = setUpTextPanel();
        backButtonPanel = setUpBackButton();

    }

    // EFFECTS: returns a JPanel object representing the back button
    private JPanel setUpBackButton() {
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.initializeHome();
            }
        });

        buttonPanel.add(backButton);

        return buttonPanel;
    }

    // EFFECTS: returns a JPanel object representing the text area
    private JPanel setUpTextAreaPanel() {
        JPanel textAreaPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(jt);


        jt = new JTextArea(15, 28);
        jt.setEditable(false);
        printWorkouts(jt);

        textAreaPanel.add(jt);

        return textAreaPanel;
    }

    // EFFECTS: returns a JPanel object representing the text to be displayed
    private JPanel setUpTextPanel() {
        JPanel textPanel = new JPanel();

        textPanel.add(viewBoxLabel);

        return textPanel;

    }



    // MODIFIES: jt
    // EFFECTS: prints the workout log onto the text area
    private void printWorkouts(JTextArea jt) {
        String logText = this.log.printWorkouts();
        jt.append(logText);
    }


    // GETTERS

    public JPanel getBackButtonPanel() {
        return backButtonPanel;
    }

    public JPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

}
