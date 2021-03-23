package ui.panels.AddScreens;

import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFlexibilityScreen extends AddScreen {

    private String exerciseType = "Flexibility";

    private String repString;

    private final JLabel repBox = new JLabel("Enter the repetitions completed:");

    private final JTextField textBox1 = new JTextField(10);
    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);

    private GraphicalWorkoutLogApp parent;

    public AddFlexibilityScreen(GraphicalWorkoutLogApp parent) {
        super(parent);
        buttonPanel = setUpSubmitButton();
        textBoxPanel = setUpTextPanel();
    }

    private JPanel setUpTextPanel() {
        JPanel textBoxPanel = new JPanel();


        textBoxPanel.setLayout(textFieldLayout);

        textBoxPanel.add(dateBox);
        textBoxPanel.add(textBox1);
        textBoxPanel.add(nameBox);
        textBoxPanel.add(textBox2);
        textBoxPanel.add(repBox);
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
                parent.addExercise("Flexibility");
            }
        });

        submitButtonPanel.add(submitButton);

        return submitButtonPanel;
    }

    private void saveFields() {
        dateString = textBox1.getText();
        nameString = textBox2.getText();
        repString = textBox3.getText();
        durString = textBox4.getText();

        JOptionPane.showMessageDialog(this,
                "Success.");

    }

    public String getExerciseType() {
        return exerciseType;
    }

    public String getRepString() {
        return repString;
    }
}
