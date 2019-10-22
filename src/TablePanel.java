import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TablePanel extends JPanel {

    private JTable table;

    public TablePanel(){

        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        table = new JTable();

        Border innerBorder = BorderFactory.createTitledBorder("Bets display table");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    }
}
