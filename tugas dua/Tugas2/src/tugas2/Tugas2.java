/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import java.util.Scanner;
import tugas2.bidang.Lingkaran;
import tugas2.bidang.PersegiPanjang;
import tugas2.ruang.Balok;
import tugas2.ruang.Kerucut;

/**
 *
 * @author VivoBook
 */
public class Tugas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int pilihan;
        int panjang;
        int lebar;
        int tinggi1;
        int tinggi2;
        int jarijari;
        
        do {
            System.out.println("_______INPUT_______");
            System.out.println("1. BALOK");
            System.out.println("2. KERUCUT");
            System.out.println("3. EXIT");
            System.out.print("PILIH : ");
            pilihan = input.nextInt();
        
        switch (pilihan){
            case 1:
                System.out.print("PANJANG\t= ");
                panjang = input.nextInt();
                System.out.print("LEBAR\t= ");
                lebar = input.nextInt();
                System.out.print("TINGGI\t= ");
                tinggi1 = input.nextInt();
                
                PersegiPanjang persegipanjang = new PersegiPanjang(panjang, lebar);
                Balok balok = new Balok(panjang, lebar, tinggi1);
                
                System.out.println("_______OUTPUT_______");
                System.out.println("LUAS PERSEGI\t\t: " + persegipanjang.luas()); 
                System.out.println("KELILING PERSEGI\t\t: " + persegipanjang.keliling());
                System.out.println("VOLUME BALOK\t\t: " + balok.volume());
                System.out.println("LUAS PERMUKAAN BALOK\t: " + balok.lp());
                break;
                    
            case 2:
                System.out.print("JARI-JARI\t= ");
                jarijari = input.nextInt();
                System.out.print("TINGGI\t\t= ");
                tinggi2 = input.nextInt();
                
                Lingkaran lingkaran = new Lingkaran(jarijari);
                Kerucut kerucut = new Kerucut(jarijari, tinggi2);
                
                System.out.println("_______OUTPUT_______");
                System.out.println("LUAS LINGKARAN\t\t: " + lingkaran.luas()); 
                System.out.println("KELILING LINGKARAN\t: " + lingkaran.keliling());
                System.out.println("VOLUME KERUCUT\t\t: " + kerucut.volume());
                System.out.println("LUAS PERMUKAAN KERUCUT\t: " + kerucut.lp());
                break;
                
            case 3:
                System.exit(0);
        }
        
        } while (true);
    }
}
