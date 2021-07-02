package Model;

public class Barang {
    private Integer id_barang,id_pemasok,harga_barang,stok_barang;
    private String nama_barang,nama_pemasok,kualitas_barang;

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

    public String getKualitas_barang(){
        return kualitas_barang;
    }
    
    public void setKualitas_barang(String kualitas_barang){
        this.kualitas_barang = kualitas_barang;
    }
    
     public Integer getStok_barang() {
        return stok_barang;
    }

    public void setStok_barang(Integer stok_barang) {
        this.stok_barang = stok_barang;
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


   
    
}
