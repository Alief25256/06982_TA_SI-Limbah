package Model;

public class Barang {
    private Integer id_barang;
    private String nama_barang;
    private String kualitas_barang;
    private Integer harga_barang;
    private Integer stok_barang;
    private Pemasok nama_pemasok;
    private Pemasok id_pemasok;
    

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


   
    
}
