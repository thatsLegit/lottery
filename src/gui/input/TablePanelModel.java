package gui.input;

import javax.swing.table.AbstractTableModel;

import Models.Bet;

import java.util.List;

public class TablePanelModel extends AbstractTableModel {

    public static List<Bet> db;
    private String [] colNames = {"ID", "Nombre 1", "Nombre 2", "Nombre 3", "Nombre 4", "Nombre 5", "Super bet ", "Mise"};

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Bet> db){
        this.db = db;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Bet bet = db.get(row);

        switch(column){
            case 0:
                return bet.getId();
            case 1:
                return bet.getNumber1();
            case 2:
                return bet.getNumber2();
            case 3:
                return bet.getNumber3();
            case 4:
                return bet.getNumber4();
            case 5:
                return bet.getNumber5();
            case 6:
                return bet.getIsSuperBet();
            case 7:
                return bet.getBetAmountValue();
        }
        return null;
    }
}
