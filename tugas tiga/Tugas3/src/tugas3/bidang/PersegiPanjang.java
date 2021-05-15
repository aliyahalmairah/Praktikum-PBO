/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3.bidang;

/**
 *
 * @author VivoBook
 */
public class PersegiPanjang {
    double panjang;
    double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    public double luas() {
        return panjang*lebar;
    }
    
    public double keliling() {
        return 2*panjang+2*lebar;
    }
}
