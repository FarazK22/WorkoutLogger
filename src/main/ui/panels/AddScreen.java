package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScreen extends JPanel {

    private String dateString;
    private String nameString;
    private String weightString;
    private String repString;
    private String durString;

    private final JLabel dateBox = new JLabel("Enter the workout date (MM/DD/YYYY):");
    private final JLabel nameBox = new JLabel("Enter the name of the exercise:");
    private final JLabel weightBox = new JLabel("Enter the weight lifted:");
    private final JLabel repBox = new JLabel("Enter the repetitions completed:");
    private final JLabel durBox = new JLabel("Enter the duration of the exercise:");

    private final JTextField textBox1 = new JTextField(10);
    private final JTextField textBox2 = new JTextField(10);
    private final JTextField textBox3 = new JTextField(10);
    private final JTextField textBox4 = new JTextField(10);
    private final JTextField textBox5 = new JTextField(10);

    private final JFrame parent;


    GridLayout textFieldLayout = new GridLayout(5, 2, 10, 10);

    public AddScreen(JFrame frame) {
        parent = frame;
        setUpComponents(parent.getContentPane());

    }
    //JTextField has gettext (oracle)



    private void setUpComponents(Container pane) {
        final JPanel textBoxPanel = new JPanel();
        final JPanel submitButtonPanel = new JPanel();
        
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
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFields();
            }
        });
        
        submitButtonPanel.add(submitButton);

        pane.add(textBoxPanel, BorderLayout.WEST);
        pane.add(submitButtonPanel, BorderLayout.SOUTH);

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
}
