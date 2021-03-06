package ui.panels;

import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JPanel {

    private GraphicalWorkoutLogApp parent;

    private JPanel buttonPanel;
    private JPanel welcomePanel;


    GridLayout buttonLayout = new GridLayout(5, 1, 10, 10);

    public HomeScreen(GraphicalWorkoutLogApp parent) {
        this.parent = parent;
        buttonPanel = setUpHomeButtons();
        welcomePanel = setUpHomeWelcome();

    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    private JPanel setUpHomeWelcome() {
        JPanel welcomeBox = new JPanel();
        JLabel welcome = new JLabel("Welcome to your workout log! Please select an option.");
        welcomeBox.add(welcome);

        return welcomeBox;
    }

    public JPanel setUpHomeButtons() {
        JPanel buttonBox = new JPanel();

        buttonBox.setLayout(buttonLayout);

        addButton("Start workout", buttonBox);
        addButton("View your log", buttonBox);
        addButton("Load workouts", buttonBox);
        addButton("Save workouts", buttonBox);
        addButton("Quit", buttonBox);

        return buttonBox;


    }

    private void addButton(String text, Container container) {
        JButton button = new JButton(text);
        if (text.equals("Start workout")) {
            startButton(button);
        } else if (text.equals("View your log")) {
            viewButton(button);
        } else if (text.equals("Load workouts")) {
            loadButton(button);
        } else if (text.equals("Save workouts")) {
            saveButton(button);

        } else if (text.equals("Quit")) {
            quitApp(button);
        }

        container.add(button);
    }

    private void quitApp(JButton button) {
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

    private void saveButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.saveWorkouts();
            }

        });
    }

    private void loadButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.loadWorkouts();
            }
        });
    }

    private void viewButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.viewLog();
            }

        });
    }

    private void startButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.startNewWorkout();
            }
        });
    }
}
