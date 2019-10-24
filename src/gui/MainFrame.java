package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TitlePanel titlePanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private Controller controller;

    public MainFrame(){

        super("Lottery");

        titlePanel = new TitlePanel(); //creating components
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        controller = new Controller();

        getContentPane().setBackground(new Color(80,174,205));  // color of the mainframe, works only on the mainframe
        titlePanel.setBackground(new Color(80,174,205)); //setting the color in the mainframe for the components
        formPanel.setBackground(new Color(80,174,205));
        tablePanel.setBackground(new Color(80,174,205));

        setMinimumSize(new Dimension(600, 400)); //sizing
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creation de la table en utilisant les données stockées dans la "bdd"
        tablePanel.setData(controller.getBet());

        //addButton implementation : the goal is to implement an interface that will allow to write the code of the actionListener in the gui.MainFrame (here)
        //1.creates an uninstantiated gui.FormListener type variable gui.FormPanel
        //2.with the setFormListener method in the gui.FormPanel, this variable is instantiated from the gui.MainFrame
        //3.the overriden method formEventOccured from the gui.FormListener interface will be used in the addButton
        // actionListener (gui.FormPanel) with the gui.FormEvent type object in parameters (that will have stored the
        // input values from the form).
        formPanel.setFormListenerAddButton(new FormListener(){

            @Override
            public void formEventOccured(FormEvent e) {
                controller.addBet(e);
                tablePanel.refresh();
            }
        });

        setLayout(new BorderLayout()); //basic organisation stuff for the component in the mainframe
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.EAST);
    }
}