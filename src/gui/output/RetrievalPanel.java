package gui.output;

import database.Bet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class RetrievalPanel extends JPanel {

    private JTable retrievalTable;
    private RetrievalTableModel retrievalTableModel;

    RetrievalPanel(){

        retrievalTableModel = new gui.output.RetrievalTableModel();
        retrievalTable = new JTable(retrievalTableModel);

        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Your bets");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(new JScrollPane(retrievalTable), BorderLayout.CENTER);
    }

    public void setData(List<Bet> bet) {
        retrievalTableModel.setData(bet);
    }

}
