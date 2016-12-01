/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TableModel;

import data.DataPenjualanDetail;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FUCK_HIM
 */
public class TabModPenjualanOrder extends AbstractTableModel{
    String[] kolom={"KODE","NAMA BARANG","HARGA","BNY","SUB TOTAL","DISC %","TOTAL"};
    public Vector <DataPenjualanDetail> field=new Vector<DataPenjualanDetail>();

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
            case 2 : return field.get(rowIndex).getHarga_jual();
            case 3 : return field.get(rowIndex).getBny();
            case 4 : return field.get(rowIndex).getSub_total();
            case 5 : return field.get(rowIndex).getDisc();
            case 6 : return field.get(rowIndex).getTotal();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 3 : return true;
            case 5 : return true;
            default : return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int subtotal=0;
        int disc=0;
        DataPenjualanDetail dpt=(DataPenjualanDetail)field.elementAt(rowIndex);
        switch(columnIndex){
            case 3 : dpt.setBny(Integer.parseInt(aValue.toString()));
                     subtotal=field.get(rowIndex).getHarga_jual()*Integer.parseInt(aValue.toString());
                     dpt.setSub_total(subtotal);
                     disc=field.get(rowIndex).getHarga_jual()*Integer.parseInt(aValue.toString())*field.get(rowIndex).getDisc()/100;
                     dpt.setTotal(subtotal-disc);
                     break;

            case 5 : dpt.setDisc(Integer.parseInt(aValue.toString()));
                     disc=field.get(rowIndex).getSub_total()*Integer.parseInt(aValue.toString())/100;
                     dpt.setTotal(field.get(rowIndex).getSub_total()-disc);
                     break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }





    public void insert(DataPenjualanDetail dpd){
        field.add(dpd);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    public void update(DataPenjualanDetail dpd, int row){
        field.set(row, dpd);
        fireTableRowsUpdated(row, row);
    }

    public void delete(int row){
        field.remove(row);
        fireTableRowsDeleted(row-1, row-1);
    }

    public void removeAll(){
        field.removeAllElements();
        fireTableRowsDeleted(0, 0);
    }


   public int find(String temp){
        int a=-1;
        for(int n=0; n<field.size(); n++){
            if(field.get(n).getKode_item().equals(temp)) a=n;
        }
        return a;
    }

}
