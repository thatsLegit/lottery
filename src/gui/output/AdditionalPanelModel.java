package gui.output;

import game.Game;
import gui.input.MainFrame;

import javax.swing.table.AbstractTableModel;

public class AdditionalPanelModel extends AbstractTableModel {

    private String colNames [] = {"Bet value", "Fitting numbers", "Multiplicator"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return RetrievalTableModel.db.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {

        switch (column){
            case 0 :
                return MainFrame.controller.getBet().get(row).getBetAmountValue();
            case 1:
                return Game.calculateGainCoefficient(ResultFrame.game.getLotteryNumbers(), MainFrame.controller.getBet());
            case 2 :
                return Game.calculateFittingNumbers(ResultFrame.game.getLotteryNumbers(), MainFrame.controller.getBet());
        }
        return null;
    }
}
