package ui.panels;

import model.Workout;
import model.exercises.StrengthExercise;
import ui.GraphicalWorkoutLogApp;
import ui.panels.AddScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the components of the add strength exercise screen on the workout log app

public class AddStrengthScreen extends AddScreen {

    private String exerciseType = "Strength";

    private Integer weight;
    private Integer reps;

    private StrengthExercise exercise;

    private final JLabel weightBox = new JLabel("Enter the weight lifted:");
    private final JLabel repBox = new JLabel("Enter the repetitions completed:");

    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);
    private final JTextField textBox5 = new JTextField(10);


    private JFrame homeFrame;




    // MODIFIES: this
    // EFFECTS: instantiates a strength screen with the parent (GUI), a new button panel, text box panel, and the
    //          JFrame (homeFrame)
    public AddStrengthScreen(GraphicalWorkoutLogApp parent) {
        super(parent);
        buttonPanel = setUpSubmitButton();
        textBoxPanel = setUpTextPanel();
        homeFrame = parent.getFrame();

    }

    // EFFECTS: Returns a JPanel object representing the text entry boxes
    private JPanel setUpTextPanel() {
        JPanel textBoxPanel = new JPanel();


        textBoxPanel.setLayout(textFieldLayout);

        textBoxPanel.add(nameBox);
        textBoxPanel.add(textBox2);
        textBoxPanel.add(weightBox);
        textBoxPanel.add(textBox3);
        textBoxPanel.add(repBox);
        textBoxPanel.add(textBox4);
        textBoxPanel.add(durBox);
        textBoxPanel.add(textBox5);

        return textBoxPanel;
    }

    // EFFECTS: Returns a JPanel object representing the submit button
    private JPanel setUpSubmitButton() {
        JPanel submitButtonPanel = new JPanel();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFields();
            }
        });

        submitButtonPanel.add(submitButton);

        return submitButtonPanel;
    }


    // MODIFIES: workout
    // EFFECTS: Takes text inputs and creates a new exercise with information, adds exercise to the workout
    private void saveFields() {
        nameString = textBox2.getText();
        weight = Integer.parseInt(textBox3.getText());
        reps = Integer.parseInt(textBox4.getText());
        dur = Integer.parseInt(textBox5.getText());

        exercise = new StrengthExercise(nameString, exerciseType, dur, reps, weight);

        Workout workout = parent.getActiveWorkout();
        workout.addExercise(exercise);

        parent.continueOption();

    }

    // GETTER

    public String getExerciseType() {
        return exerciseType;
    }
}
