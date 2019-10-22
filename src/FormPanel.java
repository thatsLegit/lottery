import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public FormPanel() {

        //sizing the Formpanel
        Dimension dim = getPreferredSize();
        dim.width = 270;
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
            }
        });

        //subtitle "choose numbers"
        subTitle.setEditable(false);
        Font font = new Font("Helvetica", Font.BOLD, 13);
        subTitle.setFont(font);
        subTitle.setBackground(new Color(80, 174, 205));

        //sizing tiny components
        n1.setPreferredSize(new Dimension(20, 20));
        n2.setPreferredSize(new Dimension(20, 20));
        n3.setPreferredSize(new Dimension(20, 20));
        n4.setPreferredSize(new Dimension(20, 20));
        n5.setPreferredSize(new Dimension(20, 20));
        betAmount.setPreferredSize(new Dimension(40, 20));

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

        gc.weightx = 1;  //weights
        gc.weighty = 0.05;  //the size of the cell opposed to others cells

        gc.gridx = 0; //position of the cell
        gc.anchor = GridBagConstraints.PAGE_START; // places the subtitle on top of the Panel
        gc.insets = new Insets(20, 0, 0, 0); //places a margin of 15pix on top
        add(subTitle, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weighty = 0.35;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;  //n1/n2/n3 in the same cell, n4 in 2nd cell
        add(n1, gc);
        gc.anchor = GridBagConstraints.CENTER;
        add(n2, gc);
        gc.anchor = GridBagConstraints.LINE_END;
        add(n3, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(n4, gc);


        ///////////// Next row /////////////////////////

        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(superBetLabel, gc);
        gc.anchor = GridBagConstraints.LINE_END;
        add(superBet, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.gridx = 0;
        gc.weighty = 0.05;
        gc.anchor = GridBagConstraints.CENTER; // Decides whether you want to fully fill your cells or not
        add(n5, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(betAmountLabel, gc);
        gc.anchor = GridBagConstraints.CENTER;
        add(betAmount, gc);


        ///////////// Last row /////////////////////////
        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(addNumbers, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(drawNumbers, gc);
    }
}
