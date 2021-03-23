package ui.panels.AddScreens;

import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEnduranceScreen extends AddScreen {

    private String exerciseType = "Endurance";

    private String distanceString;

    private final JLabel distanceBox = new JLabel("Enter the distance travelled (in km):");


    private final JTextField textBox1 = new JTextField(10);
    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);

    private GraphicalWorkoutLogApp parent;

    public AddEnduranceScreen(GraphicalWorkoutLogApp parent) {
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
        dateString = textBox1.getText();
        nameString = textBox2.getText();
        distanceString = textBox3.getText();
        durString = textBox4.getText();

        JOptionPane.showMessageDialog(this,
                "Success.");

    }

    public String getExerciseType() {
        return exerciseType;
    }
    public String getDistanceString() {
        return distanceString;
    }
}
