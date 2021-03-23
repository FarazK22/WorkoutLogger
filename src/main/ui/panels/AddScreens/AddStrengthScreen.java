package ui.panels.AddScreens;

import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStrengthScreen extends AddScreen {

    private String exerciseType = "Strength";

    private String weightString;
    private String repString;

    private final JLabel weightBox = new JLabel("Enter the weight lifted:");
    private final JLabel repBox = new JLabel("Enter the repetitions completed:");

    private final JTextField textBox1 = new JTextField(10);
    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);
    private final JTextField textBox5 = new JTextField(10);


    private GraphicalWorkoutLogApp parent;


    public AddStrengthScreen(GraphicalWorkoutLogApp parent) {
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
        textBoxPanel.add(weightBox);
        textBoxPanel.add(textBox3);
        textBoxPanel.add(repBox);
        textBoxPanel.add(textBox4);
        textBoxPanel.add(durBox);
        textBoxPanel.add(textBox5);

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
        dateString = textBox1.getText();
        nameString = textBox2.getText();
        weightString = textBox3.getText();
        repString = textBox4.getText();
        durString = textBox5.getText();

        JOptionPane.showMessageDialog(this,
                "Success.");

    }

    public String getWeightString() {
        return weightString;
    }

    public String getRepString() {
        return repString;
    }

    public String getExerciseType() {
        return exerciseType;
    }
}
