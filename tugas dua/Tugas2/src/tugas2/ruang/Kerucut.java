/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.ruang;

import tugas2.bidang.Lingkaran;

/**
 *
 * @author VivoBook
 */
public class Kerucut extends Lingkaran implements MenghitungRuang{
    int tinggi;
    double luas;
    double hasil1;
    double hasil2;
    
    public Kerucut(int jarijari, int tinggi){
        super(jarijari);
        hasil1 = 1/(float)3*Math.PI*jarijari*jarijari*tinggi;
        double s = Math.cbrt(jarijari*jarijari+tinggi*tinggi);
        hasil2 = (Math.PI*jarijari*jarijari) + (Math.PI*jarijari*s); 
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
