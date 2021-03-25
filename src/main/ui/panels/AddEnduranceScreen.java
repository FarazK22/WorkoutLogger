package ui.panels;

import model.Workout;
import model.exercises.EnduranceExercise;
import ui.GraphicalWorkoutLogApp;
import ui.panels.AddScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEnduranceScreen extends AddScreen {

    private String exerciseType = "Endurance";

    private Double distance;

    private final JLabel distanceBox = new JLabel("Enter the distance travelled (in km):");


    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);

    private JFrame homeFrame;

    public AddEnduranceScreen(GraphicalWorkoutLogApp parent) {
        super(parent);
        buttonPanel = setUpSubmitButton();
        textBoxPanel = setUpTextPanel();
        homeFrame = parent.getFrame();
    }

    private JPanel setUpTextPanel() {
        JPanel textBoxPanel = new JPanel();


        textBoxPanel.setLayout(textFieldLayout);


        textBoxPanel.add(nameBox);
        textBoxPanel.add(textBox2);
        textBoxPanel.add(distanceBox);
        textBoxPanel.add(textBox3);
        textBoxPanel.add(durBox);
        textBoxPanel.add(textBox4);

        return textBoxPanel;
    }

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

    private void saveFields() {
        nameString = textBox2.getText();
        distance = Double.parseDouble(textBox3.getText());
        dur = Integer.parseInt(textBox4.getText());
        EnduranceExercise exercise = new EnduranceExercise(nameString, "Endurance", dur, distance);

        Workout workout = parent.getActiveWorkout();
        workout.addExercise(exercise);


        parent.continueOption();

    }

    public String getExerciseType() {
        return exerciseType;
    }
}
