package Controller;

import Model.*;
import Database.koneksi;
import java.sql.*;
import java.text.*;
import java.util.*;

public class Proses {
    koneksi koneksi;
    ArrayList<Barang> arrBarang;
    ArrayList<Pemasok> arrJenis_Barang;
    ArrayList<Transaksi> arrTransaksi;
    
    public Proses() throws SQLException {
        this.koneksi = new koneksi();
        this.arrBarang = new ArrayList<>();
        this.arrJenis_Barang = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();   
    }
    
   /* public ArrayList<Owner> getDataOwner() throws SQLException {
        this.arrOwner.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM OWNER");
        while (rs.next()) {
            Owner ow = new Owner();
            ow.setId_owner(rs.getInt("ID_OWNER"));
            ow.setNama_owner(rs.getString("NAMA_OWNER"));
            ow.setNo_hp(rs.getString("NO_HP"));
            this.arrOwner.add(ow);
        }

        return this.arrOwner;
    }
    */
    
    public ArrayList<Pemasok> getDataJenis_Barang() throws SQLException {
        this.arrJenis_Barang.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JENIS_BARANG");
        while (rs.next()) {
            Pemasok jb = new Pemasok();
            jb.setID_jenis_barang(rs.getInt("ID_JENIS_BARANG"));
            jb.setNama_jenis_barang(rs.getString("NAMA_JENIS_BARANG"));
            
            this.arrJenis_Barang.add(jb);
        }

        return this.arrJenis_Barang;
    }
    
   
    public ArrayList<Barang> getDataBarang() throws SQLException {
        this.arrBarang.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM BARANG");
        
        while (rs.next()) {
            
            Pemasok jb = new Pemasok();
            
            Barang b = new Barang();
            b.setID_barang(rs.getInt("ID_BARANG"));
            b.setNama_barang(rs.getString("NAMA_BARANG"));
            b.setHarga_barang(rs.getDouble("HARGA_BARANG"));
            b.setID_jenis_barang(jb);
            

            this.arrBarang.add(b);
        }

        return this.arrBarang;
    }
    
    
    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT OWNER.ID_OWNER, BARANG.ID_BARANG, BARANG.NAMA_BARANG,BARANG.HARGA_BARANG " 
                +"FROM OWNER JOIN TRANSAKSI ON OWNER.ID_OWNER = TRANSAKSI.ID_OWNER JOIN BARANG ON" 
                +"BARANG.ID_BARANG = TRANSAKSI.ID_BARANG");

        while (rs.next()) {
            Owner ow = new Owner();
            ow.setId_owner(rs.getInt("ID_OWNER"));
            ow.setNama_owner(rs.getString("NAMA_OWNER"));
            ow.setNo_hp(rs.getString("NO_HP"));
            
            Pemasok jb = new Pemasok();
            Barang b = new Barang();
            b.setID_barang(rs.getInt("ID_BARANG"));
            b.setNama_barang(rs.getString("NAMA_BARANG"));
            b.setHarga_barang(rs.getDouble("HARGA_BARANG"));
            b.setID_jenis_barang(jb); 
            
            Transaksi trans = new Transaksi();
            trans.setID_transaksi(rs.getInt("ID_TRANSAKSI"));
            trans.setOwner(ow);
            trans.setbarang(b);
            trans.setNama_barang(b);
            trans.setTgl_transaksi(rs.getDate("TANGGAL_TRANSAKSI"));
            trans.setJumlah_barang(rs.getInt("JUMLAH_BARANG"));
            trans.setTotal_harga(rs.getDouble("TOTAL_HARGA")); 
            trans.setBayar(rs.getDouble("BAYAR"));
            trans.setKembalian(rs.getDouble("KEMBALIAN"));

            ResultSet rsDetail_Transaksi = this.koneksi.GetData("create view data_transaksi" 
                    + "as select a.nama_owner, b.nama_barang, b.tgl_transaksi," 
                    + "b.total_harga from owner a join transaksi b on" 
                    + "a.id_owner = b.id_owner");
            
            ArrayList<Transaksi> dt = new ArrayList<>();
            while (rsDetail_Transaksi.next()) {
            Owner own = new Owner();
            own.setId_owner(rs.getInt("ID_OWNER"));
            own.setNama_owner(rs.getString("NAMA_OWNER"));
            own.setNo_hp(rs.getString("NO_HP"));
            
            

            Transaksi tran = new Transaksi();
            tran.setID_transaksi(rs.getInt("ID_TRANSAKSI"));
            tran.setOwner(ow);
            tran.setbarang(b);
            tran.setNama_barang(b);
            tran.setTgl_transaksi(rs.getDate("TANGGAL_TRANSAKSI"));
            tran.setJumlah_barang(rs.getInt("JUMLAH_BARANG"));
            tran.setTotal_harga(rs.getDouble("TOTAL_HARGA")); 
            tran.setBayar(rs.getDouble("BAYAR"));
            tran.setKembalian(rs.getDouble("KEMBALIAN"));

            dt.add(tran);
            } 
            trans.setArrTransaksi(dt);
            this.arrTransaksi.add(trans);
        }

        return this.arrTransaksi;
    }
    
    
        
        public void insertTransaksi(Transaksi trans) throws SQLException {
        
            this.koneksi.ManipulasiData("INSERT INTO DATA_TRANSAKSI VALUES(" + trans.getOwner().getNama_owner()+ 
                    "," + "'" + trans.getNama_barang()+ "'" + "," + "'" + trans.getTgl_transaksi()+ "'" + 
                    "," + trans.getTotal_harga().toString() + ")");
    }
    }



