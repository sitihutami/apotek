/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;
import data.DataPenjualan;
import javax.swing.JOptionPane;
/**
 *
 * @author windows7
 */
public class dbPenjualan {
    Koneksi koneksi=new Koneksi();

    public boolean insert(DataPenjualan dp){
        boolean cek=true;
        try{
            String sql="insert into penjualan values ("+
                       "'"+dp.getNo_nota()+"','"+dp.getTotal()+"',"+
                       "'"+dp.getDisc()+"','"+dp.getTotal_all()+"',"+
                       "'"+dp.getTgl_order()+"','"+dp.getKet()+"',"+
                       "'"+dp.getKode_pel()+"','"+dp.getNama()+"',"+
                       "'"+dp.getTgl_bayar()+"')";

            koneksi.konek();
            koneksi.stat.executeUpdate(sql);
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z){
            cek=false;
            JOptionPane.showMessageDialog(null, "Pemasukan Data GAGAL !!!\n"+z.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }

    public boolean delete(int id){
        boolean cek=true;
        try{
            String sql="delete from penjualan where no_nota='"+id+"'";
            koneksi.konek();
            koneksi.stat.executeUpdate(sql);
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z){
            JOptionPane.showMessageDialog(null, "Penghapusan Data GAGAL !!!\n"+z.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            cek=false;
        }
        return cek;
    }
}
