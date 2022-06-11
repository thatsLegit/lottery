package gui.output;

import javax.swing.*;
import java.awt.*;

public class ResultTitlePanel extends JPanel {

    private JTextArea title;

    ResultTitlePanel(){

        title = new JTextArea();
        title.setEditable(false);

        Font font = new Font("Helvetica", Font.BOLD, 25);
        title.setFont(font);
        title.setBackground(new Color(80,174,205));

        title.append("Bets result menu");
        add(title);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
}
