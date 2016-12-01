/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author windows7
 */
public class DataBarang {
    private String kode_item;
    private String nama_item;
    private int stok;
    private int harga_beli;
    private int harga_jual;
    private String kode_kat;

    public int getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(int harga_beli) {
        this.harga_beli = harga_beli;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getKode_item() {
        return kode_item;
    }

    public void setKode_item(String kode_item) {
        this.kode_item = kode_item;
    }

    public String getKode_kat() {
        return kode_kat;
    }

    public void setKode_kat(String kode_kat) {
        this.kode_kat = kode_kat;
    }

    public String getNama_item() {
        return nama_item;
    }

    public void setNama_item(String nama_item) {
        this.nama_item = nama_item;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

   
}
