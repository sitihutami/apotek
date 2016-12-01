/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author windows7
 */
class ExOrder {
    String nama;
    private int total;
    private int disc;
    private int total_all;
    private String tgl_order;
    private int ket;
    private String tgl_bayar;
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public int getKet() {
        return ket;
    }

    public void setKet(int ket) {
        this.ket = ket;
    }

    public String getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }

    public String getTgl_order() {
        return tgl_order;
    }

    public void setTgl_order(String tgl_order) {
        this.tgl_order = tgl_order;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_all() {
        return total_all;
    }

    public void setTotal_all(int total_all) {
        this.total_all = total_all;
    }
}
