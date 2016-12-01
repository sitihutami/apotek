/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;
import data.DataBarang;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author windows7
 */
public class TabModBarang extends AbstractTableModel {
    String[] kolom={"KODE","NAMA_BARANG"};
    public Vector<DataBarang> field=new Vector<DataBarang>();

    public int getRowCount() {
        return field.size();
    }

    public int getColumnCount() {
        return kolom.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return field.get(rowIndex).getKode_item();
            case 1 : return field.get(rowIndex).getNama_item();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }

    public void insert(DataBarang databarang){
        field.add(databarang);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    public void update(DataBarang databarang, int row){
        field.set(row, databarang);
        fireTableRowsUpdated(row, row);
    }

    public void delete(int row){
        field.remove(row);
        fireTableRowsDeleted(row-1, row-1);
    }

    public void removeAll(){
        field.removeAllElements();
    }

    public int find(String temp){
        int a=-1;
        for(int n=0; n<field.size(); n++){
            if(field.get(n).getKode_item().equals(temp)) a=n;
        }
        return a;
    }
}
