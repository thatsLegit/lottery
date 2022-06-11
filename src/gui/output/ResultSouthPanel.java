package gui.output;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ResultSouthPanel extends JPanel {

    private JTextArea results;

    ResultSouthPanel(){

        results = new JTextArea();
        results.setEditable(false);

        Dimension dim = getPreferredSize();
        dim.height = 100;
        setPreferredSize(dim);

        results.setBackground(new Color(80, 174, 205));

        Border innerBorder = BorderFactory.createTitledBorder("Result statistics");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(new JScrollPane(results), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        results.append(text);
    }
}
