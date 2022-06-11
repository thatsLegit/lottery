package gui.output;

import javax.swing.table.AbstractTableModel;

import Models.Lottery;

import java.util.List;

public class LotteryTableModel extends AbstractTableModel {

    private List<Lottery> db;
    private String colNames [] = {"N1", "N2", "N3", "N4", "N5"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public List<Lottery> setLottery(List<Lottery> db) {
        return this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Lottery lottery = db.get(row);

        switch (column){
            case 0 :
                return lottery.getN1Lottery();
            case 1:
                return lottery.getN2Lottery();
            case 2:
                return lottery.getN3Lottery();
            case 3:
                return lottery.getN4Lottery();
            case 4 :
                return lottery.getN5Lottery();
        }
        return null;
    }
}
