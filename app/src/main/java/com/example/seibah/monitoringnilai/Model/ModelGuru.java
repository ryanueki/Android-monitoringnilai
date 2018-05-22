package com.example.seibah.monitoringnilai.Model;

public class ModelGuru {
    private String nama_guru;
    private String alamat_guru;
    private String no_telepon_guru;
    private String mata_pelajaran;

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getAlamat_guru() {
        return alamat_guru;
    }

    public void setAlamat_guru(String alamat_guru) {
        this.alamat_guru = alamat_guru;
    }

    public String getNo_telepon_guru() {
        return no_telepon_guru;
    }

    public void setNo_telepon_guru(String no_telepon_guru) {
        this.no_telepon_guru = no_telepon_guru;
    }

    public String getMata_pelajaran() {
        return mata_pelajaran;
    }

    public void setMata_pelajaran(String mata_pelajaran_diambil) {
        this.mata_pelajaran = mata_pelajaran_diambil;
    }

    public ModelGuru(String nama_guru, String alamat_guru, String no_telepon_guru, String mata_pelajaran_diambil) {
        this.nama_guru = nama_guru;
        this.alamat_guru = alamat_guru;
        this.no_telepon_guru = no_telepon_guru;
        this.mata_pelajaran = mata_pelajaran_diambil;

    }
    public  ModelGuru(){

    }
}
