/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3.ruang;

import tugas3.bidang.PersegiPanjang;

/**
 *
 * @author VivoBook
 */
public class Balok extends PersegiPanjang{
    double tinggi;
    double hasil1;
    double hasil2;
    
    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        hasil1 = panjang*lebar*tinggi;
        hasil2 = 2*(panjang*lebar+panjang*tinggi+lebar*tinggi);
    } 
    
    public double volume() {
        return hasil1;
    }
    
    public double lp() {
        return hasil2;
    }
}
