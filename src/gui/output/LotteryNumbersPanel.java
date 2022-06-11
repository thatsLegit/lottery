package gui.output;

import javax.swing.*;
import javax.swing.border.Border;

import Models.Lottery;

import java.awt.*;
import java.util.List;

public class LotteryNumbersPanel extends JPanel {

    private JTable lotteryNumbersTable;
    private gui.output.LotteryTableModel lotteryTableModel;

    LotteryNumbersPanel(){

        lotteryTableModel = new gui.output.LotteryTableModel();
        lotteryNumbersTable = new JTable(lotteryTableModel);

        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Winning numbers");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(new JScrollPane(lotteryNumbersTable), BorderLayout.CENTER);
    }

    public void setLottery(List<Lottery> lottery) {
        lotteryTableModel.setLottery(lottery);
    }
}
