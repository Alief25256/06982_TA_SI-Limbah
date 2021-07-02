package Model;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    private Integer id_transaksi,id_pemasok,id_barang,harga_barang,stok_barang,total_harga,bayar,kembalian;
    private String nama_pemasok,nama_barang,nama_pembeli;
    private Barang barang;
    private Pemasok pemasok;
    private Date tgl_transaksi;
    private ArrayList<Transaksi> arrTransaksi;

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok (String nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }
        public Integer getId_pemasok() {
        return id_pemasok;
    }

    public void setId_pemasok (Integer id_pemasok) {
        this.id_pemasok = id_pemasok;
    }
    public Integer getId_barang() {
        return id_barang;
    }

    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(Integer harga_barang) {
        this.harga_barang = harga_barang;
    }

    public Integer getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(Integer total_harga) {
        this.total_harga = total_harga;
    }

    public Integer getBayar() {
        return bayar;
    }

    public void setBayar(Integer bayar) {
        this.bayar = bayar;
    }

    public Integer getKembalian() {
        return kembalian;
    }

    public void setKembalian(Integer kembalian) {
        this.kembalian = kembalian;
    }
    
    public String getNama_pembeli(){
        return nama_pembeli;
    }
    
    public void setNama_pembeli(String nama_pembeli){
    this.nama_pembeli = nama_pembeli;
}
      public Integer getStok_barang() {
        return stok_barang;
    }

    public void setStok_barang(Integer stok_barang) {
        this.stok_barang = stok_barang;
    }

    public ArrayList<Transaksi> getArrTransaksi() {
        return arrTransaksi;
    }

    public void setArrTransaksi(ArrayList<Transaksi> arrTransaksi) {
        this.arrTransaksi = arrTransaksi;
    }
    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }


    public Barang getBarang() {
        return barang;
    }
      public void setbarang(Barang barang) {
        this.barang = barang;
    }
       public Date getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public void setPemasok(String pemasok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

