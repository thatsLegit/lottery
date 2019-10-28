package gui.output;

import database.Bet;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RetrievalTableModel extends AbstractTableModel {

    public static List<Bet> db;
    private String colNames [] = {"N1", "N2", "N3", "N4", "N5", "SB"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }


    public List<Bet> setData(List<Bet> db) {
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
        Bet bet = db.get(row);

        switch(column){
            case 0:
                return bet.getNumber1();
            case 1:
                return bet.getNumber2();
            case 2:
                return bet.getNumber3();
            case 3:
                return bet.getNumber4();
            case 4:
                return bet.getNumber5();
            case 5:
                if (bet.getIsSuperBet()){
                    return "YES";
                } else return "NO";
        }
        return null;
    }
}
