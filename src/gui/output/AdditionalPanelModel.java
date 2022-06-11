package gui.output;

import game.Game;
import gui.input.MainFrame;
import gui.input.TablePanelModel;

import javax.swing.table.AbstractTableModel;

public class AdditionalPanelModel extends AbstractTableModel {

    private String colNames [] = {"Bet value", "Fitting numbers", "Multiplier"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return TablePanelModel.db.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {

        switch (column){
            case 0 :
                return MainFrame.betDAO.getBet().get(row).getBetAmountValue();
            case 1:
                return Game.calculateFittingNumbers(ResultFrame.game.getLotteryNumbers().get(row), MainFrame.betDAO.getBet().get(row));
            case 2 :
                return Game.calculateGainCoefficient(ResultFrame.game.getLotteryNumbers().get(row), MainFrame.betDAO.getBet().get(row));
        }
        return null;
    }
}
