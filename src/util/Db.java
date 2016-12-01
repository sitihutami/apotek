/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.Xml;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Db {
    private java.sql.Connection c;
    private java.sql.Statement s;

    public Db() throws SQLException {
        try {
            com.mysql.jdbc.Driver.class.newInstance();
        } catch (InstantiationException ex) {
            Xml.hindar(ex);
        } catch (IllegalAccessException ex) {
            Xml.hindar(ex);
        }c=DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan", "root", "");
        s=c.createStatement();
    }

    public void close() throws SQLException{
        s.close();
        c.close();
    }

    public void masuk(String sql) throws SQLException{
        s.execute(sql);
    }

    public java.sql.ResultSet keluar(String sql) throws SQLException{
        return s.executeQuery(sql);
    }

    public java.sql.PreparedStatement getPS(String sql) throws SQLException{
        return c.prepareStatement(sql);
    }
}