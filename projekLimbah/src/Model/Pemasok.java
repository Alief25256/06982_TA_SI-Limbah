package Model;

public class Pemasok {
    private Integer id_pemasok;
    private String nama_pemasok,alamat_pemasok,nomor_hp_pemasok;
  
    public Integer getId_pemasok() {
        return id_pemasok;
    }

    public void setId_pemasok(Integer id_pemasok) {
        this.id_pemasok = id_pemasok;
    }
    
     public String getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok(String nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }

    public String getAlamat_pemasok() {
        return alamat_pemasok;
    }

    public void setAlamat_pemasok(String alamat_pemasok) {
        this.alamat_pemasok = alamat_pemasok;
    }
    
    public String getNomor_hp_pemasok() {
        return nomor_hp_pemasok;
    }

    public void setNomor_hp_pemasok(String nomor_hp_pemasok) {
        this.nomor_hp_pemasok = nomor_hp_pemasok;
    }
    
    
}
