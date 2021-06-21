package Model;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    private Integer id_transaksi;
    private Pemasok nama_pemasok;
    private Pemasok id_pemasok;
    private String nama_pembeli;
    private Barang id_barang;
    private Barang nama_barang;
    private Barang harga_barang;
    private Barang stok_barang;
    private Integer total_harga;
    private Integer bayar;
    private Integer kembalian;
    private ArrayList<Transaksi> arrTransaksi;

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Pemasok getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok (Pemasok nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }
        public Pemasok getId_pemasok() {
        return id_pemasok;
    }

    public void setId_pemasok (Pemasok id_pemasok) {
        this.id_pemasok = id_pemasok;
    }
    public Barang getId_barang() {
        return id_barang;
    }

    public void setId_barang(Barang id_barang) {
        this.id_barang = id_barang;
    }

    public Barang getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(Barang nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Barang getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(Barang harga_barang) {
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

    public ArrayList<Transaksi> getArrTransaksi() {
        return arrTransaksi;
    }

    public void setArrTransaksi(ArrayList<Transaksi> arrTransaksi) {
        this.arrTransaksi = arrTransaksi;
    }
}

