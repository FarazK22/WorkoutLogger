package ui.panels;

import model.WorkoutLog;
import ui.GraphicalWorkoutLogApp;

import javax.swing.*;
import java.awt.*;

public abstract class AddScreen extends JPanel {

    protected final JLabel nameBox = new JLabel("Enter the name of the exercise:");
    protected final JLabel durBox = new JLabel("Enter the duration of the exercise:");

    protected String nameString;
    protected Integer dur;

    protected JPanel buttonPanel;
    protected JPanel textBoxPanel;

    GridLayout textFieldLayout = new GridLayout(5, 2, 10, 10);

    protected GraphicalWorkoutLogApp parent;

    protected WorkoutLog log;

    public AddScreen(GraphicalWorkoutLogApp parent) {
        this.parent = parent;
        this.log = parent.getLog();
    }


    public String getNameString() {
        return nameString;
    }

    public Integer getDur() {
        return dur;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JPanel getTextBoxPanel() {
        return textBoxPanel;
    }
}
