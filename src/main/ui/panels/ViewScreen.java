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

public class ViewScreen extends JPanel {

    private final JLabel viewBoxLabel = new JLabel("Your log: ");

    private GraphicalWorkoutLogApp parent;
    private JTextArea jt;
    private WorkoutLog log;

    private JPanel textAreaPanel;
    private JPanel textPanel;



    public ViewScreen(GraphicalWorkoutLogApp parent) {
        this.parent = parent;
        this.log = parent.getLog();
        textAreaPanel = setUpTextAreaPanel();
        textPanel = setUpTextPanel();

    }

    public JPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

    private JPanel setUpTextAreaPanel() {
        JPanel textAreaPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(jt);

        jt = new JTextArea(15, 28);
        jt.setEditable(false);
        printWorkouts(jt);

        textAreaPanel.add(jt);

        return textAreaPanel;
    }

    private JPanel setUpTextPanel() {
        JPanel textPanel = new JPanel();

        textPanel.add(viewBoxLabel);

        return textPanel;

    }


    private void printWorkouts(JTextArea jt) {
        String logText = this.log.printWorkouts();
        jt.append(logText);
    }
}
