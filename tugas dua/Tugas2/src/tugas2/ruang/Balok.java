/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.ruang;

import tugas2.bidang.PersegiPanjang;


/**
 *
 * @author VivoBook
 */
public class Balok extends PersegiPanjang implements MenghitungRuang{
    int tinggi;
    int hasil1;
    int hasil2;
    
    public Balok(int panjang, int lebar, int tinggi) {
        super(panjang, lebar);
        hasil1 = panjang*lebar*tinggi;
        hasil2 = 2*(panjang*lebar+panjang*tinggi+lebar*tinggi);
    } 
    
    @Override
    public double volume() {
        return hasil1;
    }

    @Override
    public double lp() {
        return hasil2;
    }
}
