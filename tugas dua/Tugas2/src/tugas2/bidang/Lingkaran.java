/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.bidang;

/**
 *
 * @author VivoBook
 */
public class Lingkaran implements MenghitungBidang {
    private int jarijari;

    public Lingkaran(int jarijari) {
        this.jarijari = jarijari;
    }
    
    public void setJarijari(int jarijari) {
        this.jarijari = jarijari;
    }
    
    @Override
    public double luas(){
        return Math.PI*jarijari*jarijari;
    }

    @Override
    public double keliling() {
        return 2*Math.PI*jarijari;
    }     
}
