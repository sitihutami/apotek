/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;
import Sql.Koneksi;
import data.Xml;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author windows7
 */
public class SQL {
    Koneksi koneksi=new Koneksi();

    public int bnyTransaksi(){
        int jml=0;
        try{
            koneksi.konek();
            ResultSet set=koneksi.stat.executeQuery("select count(no_nota) from penjualan ");
            while(set.next()){
                jml=set.getInt("count(no_nota)");
            }
            set.close();
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z) { JOptionPane.showMessageDialog(null, z.getMessage());}
        return jml;
    }

    public int c2(String a,String b){
        int jml=0;
        try{
            koneksi.konek();
            ResultSet set=koneksi.stat.executeQuery("select COUNT(no_nota)as ddd from penjualan_det "+
                                                    "where "+
                                                    "no_nota in ( select no_nota from penjualan_det where kode_item='"+a+"') "+
                                                    "and "+
                                                    "no_nota in ( select no_nota from penjualan_det where kode_item='"+b+"')");
            while(set.next()){
                jml=set.getInt("ddd");
            }
            set.close();
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception x){Xml.hindar(x);}
        return jml;
    }


    public int c3(String a,String b,String c){
        int jml=0;
        try{
            koneksi.konek();
            ResultSet set=koneksi.stat.executeQuery("select count(DISTINCT no_nota) from penjualan_det "+
                                                    "where "+
                                                    "no_nota in ( select no_nota from penjualan_det where kode_item='"+a+"') "+
                                                    "and "+
                                                    "no_nota in ( select no_nota from penjualan_det where kode_item='"+b+"') "+
                                                    "and "+
                                                    "no_nota in ( select no_nota from penjualan_det where kode_item='"+c+"')");
            while(set.next()){
                jml=set.getInt("count(DISTINCT no_nota)");
            }
            set.close();
            koneksi.stat.close();
            koneksi.con.close();
        }
        catch(Exception z){JOptionPane.showMessageDialog(null, z.getMessage());}
        return jml;
    }
}
