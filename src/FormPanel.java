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

        Dimension dim = getPreferredSize();
        dim.width = 280;
        setPreferredSize(dim);

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

        subTitle.setEditable(false);

        Font font = new Font("Helvetica", Font.BOLD, 13);
        subTitle.setFont(font);
        subTitle.setBackground(new Color(80, 174, 205));

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

        n5.setEnabled(false);
        superBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = superBet.isSelected();
                n5.setEnabled(isTicked);
            }
        });

        n1.setPreferredSize(new Dimension(25,25));
        n2.setPreferredSize(new Dimension(25,25));
        n3.setPreferredSize(new Dimension(25,25));
        n4.setPreferredSize(new Dimension(25,25));
        n5.setPreferredSize(new Dimension(25,25));
        betAmount.setPreferredSize(new Dimension(50,20));

        Border innerBorder = BorderFactory.createTitledBorder("Place your bets");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
    }

    public void layoutComponents() {

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        ///////////// First row /////////////////////////
        gc.gridy = 0; // row position

        gc.weightx = 1;  //weights
        gc.weighty = 0.1;  //the size of the cell opposed to others cells

        gc.gridx = 0; //position of the cell
        gc.fill = GridBagConstraints.NONE; // Decides whether you want to fully fill your cells or not
        gc.anchor = GridBagConstraints.PAGE_START; // places the subtitle on top of the Panel
        gc.insets = new Insets(15, 0, 0, 0); //places a margin of 15pix on top
        add(subTitle, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 0.25;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        add(n1, gc);

        gc.gridx = 1;
        add(n2, gc);

        gc.gridx = 2;
        add(n3, gc);

        gc.gridx = 3;
        add(n4, gc);

        ///////////// Next row /////////////////////////

        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(superBetLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(superBet, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 0.1;

        gc.fill = GridBagConstraints.NONE; // Decides whether you want to fully fill your cells or not
        gc.gridx = 0;
        add(n5, gc);


        ///////////// Next row /////////////////////////
        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(betAmountLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(betAmount, gc);

        ///////////// Last row /////////////////////////
        gc.gridy++;

        gc.weightx = 1; //the size of the cell opposed to others cells
        gc.weighty = 1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(addNumbers, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(drawNumbers, gc);

    }
}
