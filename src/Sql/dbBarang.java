/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sql;

import data.DataBarang;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author FUCK_HIM
 */
public class dbBarang {
    Koneksi koneksi=new Koneksi();

    public boolean insert(DataBarang db){
        boolean cek=true;
        try{
            String sql="insert into barang values ("+
                       "'"+db.getKode_item()+"','"+db.getNama_item()+"',"+
                       "'"+db.getStok()+"','"+db.getHarga_beli()+"',"+
                       "'"+db.getHarga_jual()+"','"+db.getKode_kat()+"')";

            koneksi.konek();
            koneksi.stat.executeUpdate(sql);
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception Z){
            JOptionPane.showMessageDialog(null, "Pemasukan Data GAGAL !!!\n"+Z.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            cek=false;
        }
        return cek;
    }

    public boolean update(DataBarang db,String id){
        boolean cek=true;
        try{
            String sql="update barang set "+
                       "kode_item='"+db.getKode_item()+"',"+
                       "nama_item='"+db.getNama_item()+"',"+
                       "stok='"+db.getStok()+"',"+
                       "harga_beli='"+db.getHarga_beli()+"',"+
                       "harga_jual='"+db.getHarga_jual()+"',"+
                       "kode_kat='"+db.getKode_kat()+"' "+
                       "where kode_item='"+id+"';";
            koneksi.konek();
            koneksi.stat.executeUpdate(sql);
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z){
            JOptionPane.showMessageDialog(null, "Pengeditan Data GAGAL !!!\n"+z.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            cek=false;
        }
        return cek;
    }

    public void barangStok(String kode_item,int n){
        try{
            String sql="update barang set "+
                       "stok='"+n+"' "+
                       "where kode_item='"+kode_item+"';";
            koneksi.konek();
            koneksi.stat.executeUpdate(sql);
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z){}
    }

    public boolean delete(String id){
        boolean cek=true;
        try{
            String sql="delete from barang where kode_item='"+id+"'";
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
