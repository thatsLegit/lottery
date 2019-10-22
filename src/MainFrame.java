import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TitlePanel titlePanel;
    private FormPanel formPanel;

    public MainFrame(){
        super("Lottery");

        getContentPane().setBackground(new Color(80,174,205));

        setLayout(new BorderLayout());

        titlePanel = new TitlePanel();
        formPanel = new FormPanel();

        titlePanel.setBackground(new Color(80,174,205));
        formPanel.setBackground(new Color(80,174,205));

        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
    }
}
