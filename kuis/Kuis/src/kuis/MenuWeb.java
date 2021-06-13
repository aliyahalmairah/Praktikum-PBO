/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis;

/**
 *
 * @author VivoBook
 */
public class MenuWeb implements Menu {
    String nik, nama;
    double nilaiTulis, nilaiCoding, nilaiWawancara, total;
    
    MenuWeb(String nik, String nama, double nilaiTulis, double nilaiCoding, double nilaiWawancara) {
        this.nik = nik;
        this.nama = nama;
        this.nilaiTulis = nilaiTulis;
        this.nilaiCoding = nilaiCoding;
        this.nilaiWawancara = nilaiWawancara;
    }

    @Override
    public double nilaiAkhir() {
        total = 0.3*nilaiTulis + 0.35*nilaiCoding + 0.25*nilaiWawancara;
        return total;
    }

    @Override
    public String keterangan() {
        if (total < 85) {
            return "GAGAL";
        }
        
        else{
            return "LOLOS";
        }
    }

    @Override
    public String hasil() {
        if (total < 85) {
            return "Mohon maaf kepada " + nama + " telah ditolak sebagai karyawan Web";
        }
        
        else{
            return "Selamat kepada " + nama + " telah diterima sebagai karyawan Web";
        }
    }
}
