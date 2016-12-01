/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;
import data.DataPenjualan;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author windows7
 */
public class TabModPenjualan extends AbstractTableModel{
    String[] kolom={"NOTA ","TGL ORDER"};
    public Vector<DataPenjualan> field=new Vector<DataPenjualan>();

    public int getRowCount() {
        return field.size();
    }

    public int getColumnCount() {
        return kolom.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return field.get(rowIndex).getNo_nota();
            case 1 : return field.get(rowIndex).getTgl_order();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         return kolom[column];
    }

    public void insert(DataPenjualan dp){
        field.add(dp);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    public void update(DataPenjualan dp, int row){
        field.set(row, dp);
        fireTableRowsUpdated(row, row);
    }

    public void delete(int row){
        field.remove(row);
        fireTableRowsDeleted(row-1, row-1);
    }

    public void removeAll(){
        field.removeAllElements();
    }
}
