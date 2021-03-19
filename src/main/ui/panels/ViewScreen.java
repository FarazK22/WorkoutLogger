package ui.panels;

import javax.swing.*;
import java.awt.*;

public class ViewScreen extends JPanel {

    private final JLabel viewBoxLabel = new JLabel("Your log: ");
    private final JTextArea textArea = new JTextArea(10, 20);

    private JFrame parent;

    public ViewScreen(JFrame frame) {
        parent = frame;
        setUpComponents(parent.getContentPane());
    }

    private void setUpComponents(Container pane) {
        final JPanel textAreaPanel = new JPanel();
        final JScrollPane scrollPane = new JScrollPane(textArea);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        textArea.setEditable(false);

        textAreaPanel.add(viewBoxLabel);
        textAreaPanel.add(textArea, c);
        textAreaPanel.add(scrollPane, c);

        pane.add(textAreaPanel);

    }
}
