/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author windows7
 */
class ExOrderDetail {
    private String kode_item;
    private String nama_item;
    private int bny;
    private int disc;
    private int sub_total;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBny() {
        return bny;
    }

    public void setBny(int bny) {
        this.bny = bny;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public String getKode_item() {
        return kode_item;
    }

    public void setKode_item(String kode_item) {
        this.kode_item = kode_item;
    }

    public String getNama_item() {
        return nama_item;
    }

    public void setNama_item(String nama_item) {
        this.nama_item = nama_item;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }
}
