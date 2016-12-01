/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author windows7
 */
public class DataPenjualan extends ExOrder{
    private int no_nota;
    private String kode_pel;


    public String getKode_pel() {
        return kode_pel;
    }

    public void setKode_pel(String kode_pel) {
        this.kode_pel = kode_pel;
    }

    public int getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(int no_nota) {
        this.no_nota = no_nota;
    }
}
