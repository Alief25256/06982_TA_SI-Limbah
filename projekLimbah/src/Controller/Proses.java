package Controller;

import Model.*;
import Database.koneksi;
import java.sql.*;
import java.util.*;

public class Proses {
    koneksi koneksi;
    ArrayList<Barang> arrBarang;
    ArrayList<Pemasok> arrPemasok;
    ArrayList<Transaksi> arrTransaksi;
    
    public Proses() throws SQLException {
        this.koneksi = new koneksi();
        this.arrBarang = new ArrayList<>();
        this.arrPemasok = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();   
    }
    
    public ArrayList<Pemasok> getDataPemasok() throws SQLException {
        this.arrPemasok.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM pemasok");
        while (rs.next()) {
            Pemasok pk = new Pemasok();
            pk.setId_pemasok(rs.getInt("id_pemasok"));
            pk.setNama_pemasok(rs.getString("nama_pemasok"));
            pk.setAlamat_pemasok(rs.getString("alamat_pemasok"));
            pk.setNomor_hp_pemasok(rs.getString("nomor_hp_pemasok"));
            
            this.arrPemasok.add(pk);
        }

        return this.arrPemasok;
    }
    
   
    public ArrayList<Barang>getDataBarang() throws SQLException {
        this.arrBarang.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM barang");
        while (rs.next()) {
            
            Barang br = new Barang();
            
            br.setId_barang(rs.getInt("id_barang"));           
            br.setNama_barang(rs.getString("nama_barang"));
            br.setKualitas_barang(rs.getString("kualitas_barang"));
            br.setHarga_barang(rs.getInt("harga_barang"));
            br.setStok_barang(rs.getInt("stok_barang"));
            br.setNama_pemasok(rs.getString("nama_pemasok"));
            br.setId_pemasok(rs.getInt("id_pemasok"));
            this.arrBarang.add(br);
        }

        return this.arrBarang;
    }
    
    
    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT pemasok.id_pemasok,pemasok.nama_pemasok,barang.id_barang, barang.nama_barang,barang.harga_barang,barang.stok_barang " 
                +"FROM barang JOIN transaksi ON barang.id_barang = pemasok.id_pemasok JOIN transaksi ON" 
                +"barang.id_barang = transaksi.id_transaksi");

        while (rs.next()) {
            Pemasok pk = new Pemasok();
            pk.setId_pemasok(rs.getInt("id_pemasok"));
            pk.setNama_pemasok(rs.getString("nama_pemasok"));
            pk.setAlamat_pemasok(rs.getString("alamat_pemasok"));
            pk.setNomor_hp_pemasok(rs.getString("nomor_hp_pemasok"));
            
            Barang br = new Barang();
            br.setId_barang(rs.getInt("id_barang"));           
            br.setNama_barang(rs.getString("nama_barang"));
            br.setKualitas_barang(rs.getString("kualitas_barang"));
            br.setHarga_barang(rs.getInt("harga_barang"));
            br.setStok_barang(rs.getInt("stok_barang"));
            br.setNama_pemasok(rs.getString("nama_pemasok"));
            br.setId_pemasok(rs.getInt("id_pemasok"));
            
            Transaksi trans = new Transaksi();
            trans.setId_transaksi(rs.getInt("id_transaksi"));
            trans.setNama_pemasok(rs.getString("nama_pemasok"));
            trans.setId_pemasok(rs.getInt("id_pemasok"));
            trans.setNama_pembeli(rs.getString("nama_pembeli"));
            trans.setId_barang(rs.getInt("id_barang"));
            trans.setNama_barang(rs.getString("nama_barang"));
            trans.setHarga_barang(rs.getInt("harga_barang"));
            trans.setStok_barang(rs.getInt("stok_barang"));
            trans.setTotal_harga(rs.getInt("total_harga"));

            ResultSet rsDetail_Transaksi = this.koneksi.GetData("create view data_transaksi" 
                    + "as select a.nama_pemasok, b.nama_barang, b.tgl_transaksi," 
                    + "b.total_harga from pemasok a join transaksi b on" 
                    + "a.id_pemasok = b.id_pemasok");
            
            ArrayList<Transaksi> dt = new ArrayList<>();
            while (rsDetail_Transaksi.next()) {
            Pemasok ps=new Pemasok();
            ps.setId_pemasok(rs.getInt("id_pemasok"));
            ps.setNama_pemasok(rs.getString("nama_pemasok"));
            ps.setNomor_hp_pemasok(rs.getString("nomor_hp_pemasok"));
            ps.setAlamat_pemasok(rs.getString("alamat_pemasok"));
            
            Transaksi tran = new Transaksi();
            tran.setId_transaksi(rs.getInt("id_transaksi"));
            tran.setNama_pemasok(rs.getString("nama_pemasok"));
            tran.setId_pemasok(rs.getInt("id_pemasok"));
            tran.setNama_pembeli(rs.getString("nama_pembeli"));
            tran.setId_barang(rs.getInt("id_barang"));
            tran.setNama_barang(rs.getString("nama_barang"));
            tran.setHarga_barang(rs.getInt("harga_barang"));
            tran.setStok_barang(rs.getInt("stok_barang"));
            tran.setTotal_harga(rs.getInt("total_harga"));
            dt.add(tran);
            } 
            trans.setArrTransaksi(dt);
            this.arrTransaksi.add(trans);
        }

        return this.arrTransaksi;
    }
    
    
        
        public void insertTransaksi(Transaksi trans) throws SQLException {
        
            this.koneksi.ManipulasiData("INSERT INTO transaksi VALUES" + trans.getId_transaksi()+ "," + trans.getNama_pemasok()+ 
                   "," + trans.getId_pemasok()+ ","+trans.getNama_pembeli()+ ","+trans.getId_barang()+ "," + trans.getNama_barang()+ ","+ trans.getHarga_barang() +
                    "," + trans.getStok_barang()+ ","+ trans.getTotal_harga());
    }
    }



