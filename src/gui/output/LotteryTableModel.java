package gui.output;

import game.WinningLottery;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LotteryTableModel extends AbstractTableModel {

    private List<WinningLottery> db;
    private String colNames [] = {"ID", "N1", "N2", "N3", "N4", "N5"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public List<WinningLottery> setLottery(List<WinningLottery> db) {
        return this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        WinningLottery winningLottery = db.get(row);

        switch (column){
            case 0 :
                return winningLottery.getiDLottery();
            case 1 :
                return winningLottery.getN1Lottery();
            case 2:
                return winningLottery.getN2Lottery();
            case 3:
                return winningLottery.getN3Lottery();
            case 4:
                return winningLottery.getN4Lottery();
            case 5 :
                return winningLottery.getN5Lottery();
        }
        return null;
    }
}
