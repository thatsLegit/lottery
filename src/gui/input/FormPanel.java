package gui.input;

import gui.output.ResultFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel {

    private JTextArea subTitle;
    private JTextField n1;
    private JTextField n2;
    private JTextField n3;
    private JTextField n4;
    private JTextField n5;
    private JCheckBox superBet;
    private JLabel superBetLabel;
    private JTextField betAmount;
    private JLabel betAmountLabel;
    private JButton addNumbers;
    private JButton drawNumbers;
    private FormListener formListenerAddButton;

    public FormPanel() {

        //sizing the Formpanel
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        //components
        subTitle = new JTextArea();
        n1 = new JTextField();
        n2 = new JTextField();
        n3 = new JTextField();
        n4 = new JTextField();
        n5 = new JTextField();
        superBet = new JCheckBox();
        superBetLabel = new JLabel("2. Super bet ? ");
        betAmount = new JTextField();
        betAmountLabel = new JLabel("3. Bet = ");
        addNumbers = new JButton("Add bets");
        drawNumbers = new JButton("Draw numbers");

        //adding components
        subTitle.append("1. Choose numbers :");
        add(subTitle);
        add(n1);
        add(n2);
        add(n3);
        add(n4);
        add(n5);
        add(superBet);
        add(superBetLabel);
        add(betAmount);
        add(betAmountLabel);
        add(addNumbers);
        add(drawNumbers);

        //putting a "condition" to n5 (super bet)
        n5.setEnabled(false);
        superBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = superBet.isSelected();
                n5.setEnabled(isTicked);
                n5.setText("");
            }
        });

        //subtitle "choose numbers"
        subTitle.setEditable(false);
        Font font = new Font("Helvetica", Font.BOLD, 13);
        subTitle.setFont(font);
        subTitle.setBackground(new Color(80, 174, 205));

        //sizing tiny components
        n1.setPreferredSize(new Dimension(25, 20));
        n2.setPreferredSize(new Dimension(25, 20));
        n3.setPreferredSize(new Dimension(25, 20));
        n4.setPreferredSize(new Dimension(25, 20));
        n5.setPreferredSize(new Dimension(25, 20));
        betAmount.setPreferredSize(new Dimension(50, 20));

        addNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //here I can only extract a text value but it will transformed into an int in the gui.FormEvent class
                //gui.input the numbers and check for errors
                String number1 = n1.getText();
                String number2 = n2.getText();
                String number3 = n3.getText();
                String number4 = n4.getText();
                String number5 = n5.getText();
                Boolean isSuperBet = superBet.isSelected();

                if (isSuperBet && number5.equals("")) {
                    JOptionPane.showMessageDialog(null, "A number should be entered", "ERROR", JOptionPane.ERROR_MESSAGE);
                    throw new IllegalArgumentException("A number 5 should be entered");
                }

                if (isSuperBet) {
                    checkForErrors1(number1, number2, number3, number4);
                    checkForErrors2(number5);
                } else {
                    checkForErrors1(number1, number2, number3, number4);
                }

                String betAmountValue = betAmount.getText();
                int amount = Integer.parseInt(betAmountValue);
                if (amount < 1){
                    JOptionPane.showMessageDialog(null, "A bet should strictly positive", "ERROR", JOptionPane.ERROR_MESSAGE);
                    throw new IllegalArgumentException("A bet should strictly positive");
                }

                //storing the gui.input
                FormEvent ev = new FormEvent(this, number1, number2, number3, number4, number5, isSuperBet, betAmountValue);

                //retrieving data
                if (formListenerAddButton != null) {
                    formListenerAddButton.formEventOccured(ev);
                }

                //clearing all the fields after having added the data into the table
                n1.setText("");
                n2.setText("");
                n3.setText("");
                n4.setText("");
                n5.setText("");
                n5.setEnabled(false);
                superBet.setSelected(false);
                betAmount.setText("");
            }
        });

        drawNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        new ResultFrame().setVisible(true);
                    }
                });
            }
        });

        //placing border
        Border innerBorder = BorderFactory.createTitledBorder("Place your bets");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //gridBagLayout
        layoutComponents();
    }

    public void layoutComponents() {

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        ///////////// First row /////////////////////////
        gc.gridy = 0; // row position

        gc.weighty = 0.05;  //the size of the cell opposed to others cells

        gc.gridx = 0; //position of the cell
        gc.anchor = GridBagConstraints.PAGE_START; // places the subtitle on top of the Panel
        gc.insets = new Insets(30, 0, 0, 0); //places a margin of 30pix on top
        add(subTitle, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weighty = 0.35;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;  //n1/n2/n3 in the same cell, n4 in 2nd cell
        add(n1, gc);
        gc.anchor = GridBagConstraints.CENTER;
        add(n2, gc);
        gc.anchor = GridBagConstraints.LINE_END;
        add(n3, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 40, 0, 0);
        add(n4, gc);


        ///////////// Next row /////////////////////////

        gc.gridy++;

        gc.weighty = 0.2;
        gc.weightx = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(30, 0, 0, 0);
        add(superBetLabel, gc);
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(30, 0, 0, 30);
        add(superBet, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.gridx = 0;
        gc.weighty = 0.3;
        gc.anchor = GridBagConstraints.CENTER; // Decides whether you want to fully fill your cells or not
        gc.insets = new Insets(0, 0, 0, 0);
        add(n5, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(betAmountLabel, gc);
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 20 ,0, 0);
        add(betAmount, gc);


        ///////////// Last row /////////////////////////
        gc.gridy++;

        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0 ,0, 0);
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        add(addNumbers, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        add(drawNumbers, gc);
    }

    public void setFormListenerAddButton(FormListener listener) {
        this.formListenerAddButton = listener;
    }

    //checking for errors
    public void checkForErrors1(String n1, String n2, String n3, String n4) {
        ArrayList<Integer> nb = new ArrayList<>();
        nb.add(Integer.parseInt(n1));
        nb.add(Integer.parseInt(n2));
        nb.add(Integer.parseInt(n3));
        nb.add(Integer.parseInt(n4));

        for (int i = 0; i < nb.size(); i++) {
            if (nb.get(i) < 1 || nb.get(i) > 20) {
                JOptionPane.showMessageDialog(null, "Number " + (i+1) + " should in between 1 and 20", "ERROR", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Number " + (i+1) + " should in between 1 and 20");
            }
        }
    }

    public void checkForErrors2(String n5){
        Integer number5 = Integer.parseInt(n5);

        if (number5 < 1 || number5 > 10){
            JOptionPane.showMessageDialog(null, "Number 5 should in between 1 and 10", "ERROR", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Number 5 should in between 1 and 10");
        }
    }
}
