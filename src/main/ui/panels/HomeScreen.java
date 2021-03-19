package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JPanel {

    private JFrame parent;

    GridLayout buttonLayout = new GridLayout(5, 1, 10, 10);

    public HomeScreen(JFrame frame) {
        parent = frame;
        setUpComponents(parent.getContentPane());

    }

    public void setUpComponents(Container pane) {
        final JPanel buttonPanel = new JPanel();
        final JPanel welcomeBox = new JPanel();
        buttonPanel.setLayout(buttonLayout);

        addButton("Start workout", buttonPanel);
        addButton("View your log", buttonPanel);
        addButton("Load workouts", buttonPanel);
        addButton("Save workouts", buttonPanel);
        addButton("Quit", buttonPanel);

        JLabel welcome = new JLabel("Welcome to your workout log! Please select an option above.");
        welcomeBox.add(welcome);

        pane.add(buttonPanel, BorderLayout.NORTH);
        pane.add(welcomeBox, BorderLayout.SOUTH);

    }

    private void addButton(String text, Container container) {
        JButton button = new JButton(text);
        if (text.equals("Start workout")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //addWorkout();
                }
            });
        } else if (text.equals("View your log")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //viewLog();
                }

            });
        } else if (text.equals("Load workouts")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //loadWorkouts();
                }
            });
        } else if (text.equals("Save workouts")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //saveWorkouts();
                }

            });

        } else if (text.equals("Quit")) {
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Container frame = button.getParent();
                    do {
                        frame = frame.getParent();
                    } while (!(frame instanceof JFrame)); // REFORMAT
                    ((JFrame) frame).dispose();
                }
            });

        }

        container.add(button);
    }
}
