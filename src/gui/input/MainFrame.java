package gui.input;

import javax.swing.*;

import DAO.BetDAO;

import java.awt.*;

public class MainFrame extends JFrame {

    private gui.input.TitlePanel titlePanel;
    private gui.input.FormPanel formPanel;
    private gui.input.TablePanel tablePanel;
    public static BetDAO betDAO;  //public static because needs to be accessed in the lottery package also

    public MainFrame(){

        super("Lottery");

        titlePanel = new gui.input.TitlePanel(); //creating components
        formPanel = new gui.input.FormPanel();
        tablePanel = new gui.input.TablePanel();
        betDAO = new BetDAO();

        getContentPane().setBackground(new Color(80,174,205));  // color of the mainframe, works only on the mainframe
        titlePanel.setBackground(new Color(80,174,205)); //setting the color in the mainframe for the components
        formPanel.setBackground(new Color(80,174,205));
        tablePanel.setBackground(new Color(80,174,205));

        setMinimumSize(new Dimension(600, 400)); //sizing
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creation de la table en utilisant les données stockées dans la "bdd"
        tablePanel.setData(betDAO.getBet());

        //addButton implementation : the goal is to implement an interface that will allow to write the code of the actionListener in the gui.MainFrame (here)
        //1.creates an uninstantiated gui.FormListener type variable gui.FormPanel
        //2.with the setFormListener method in the gui.FormPanel, this variable is instantiated from the gui.MainFrame
        //3.the overriden method formEventOccured from the gui.FormListener interface will be used in the addButton
        // actionListener (gui.FormPanel) with the gui.FormEvent type object in parameters (that will have stored the
        // gui.input values from the form).
        formPanel.setFormListenerAddButton(new FormListener(){

            @Override
            public void formEventOccured(gui.input.FormEvent e) {
                betDAO.addBet(e);
                tablePanel.refresh();
            }
        });

        setLayout(new BorderLayout()); //basic organisation stuff for the component in the mainframe
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.EAST);
    }
}
