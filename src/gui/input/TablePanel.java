package gui.input;

import database.Bet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable table;
    private TablePanelModel tableModel;

    public TablePanel(){

        Dimension dim = getPreferredSize();
        dim.width = 550;
        setPreferredSize(dim);

        tableModel = new gui.input.TablePanelModel();
        table = new JTable(tableModel);

        table.setBackground(new Color(80, 174, 205));

        Border innerBorder = BorderFactory.createTitledBorder("Bets display table");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Bet> bet) {
        tableModel.setData(bet);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
