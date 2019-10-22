import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TitlePanel titlePanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;

    public MainFrame(){

        super("Lottery");

        titlePanel = new TitlePanel(); //creating components
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        getContentPane().setBackground(new Color(80,174,205));  // color of the mainframe, works only on the mainframe
        titlePanel.setBackground(new Color(80,174,205)); //setting the color in the mainframe for the components
        formPanel.setBackground(new Color(80,174,205));
        tablePanel.setBackground(new Color(80,174,205));

        setMinimumSize(new Dimension(600, 500)); //sizing
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout()); //basic organisation stuff for the component in the mainframe
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.EAST);
    }
}
