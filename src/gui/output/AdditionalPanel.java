package gui.output;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdditionalPanel extends JPanel {

    private JTable additionPanelTable;

    AdditionalPanel(){

        additionPanelTable = new JTable();

        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Information");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(new JScrollPane(additionPanelTable), BorderLayout.CENTER);
    }

    /*public void setData(List<Bet> bet) {
        additionalTableModel.setData(bet);
    }*/
}
