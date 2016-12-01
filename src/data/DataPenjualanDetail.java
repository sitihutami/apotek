/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author windows7
 */
public class DataPenjualanDetail extends ExOrderDetail{
    private int no_nota;
    private int harga_jual;

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(int no_nota) {
        this.no_nota = no_nota;
    }


}
