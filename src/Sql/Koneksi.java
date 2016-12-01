/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FUCK_HIM
 */
public class Koneksi {
    public Connection con;
    public Statement stat;

    public void konek(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan","root","");
            stat=con.createStatement();
        }
        catch(Exception x){
            JOptionPane.showMessageDialog(null, "Not Connect "+x.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
