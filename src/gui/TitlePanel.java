package gui;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private JTextArea title;

    public TitlePanel() {

        title = new JTextArea();
        title.setEditable(false);

        Font font = new Font("Helvetica", Font.BOLD, 25);
        title.setFont(font);
        title.setBackground(new Color(80,174,205));

        title.append("Welcome to the Tolo bet interface");
        add(title);
        setLayout(new FlowLayout(FlowLayout.CENTER));

    }
}
