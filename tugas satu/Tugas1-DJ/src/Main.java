/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VivoBook
 */
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        String nama, nim;
        int usia, uts, uas, pilih;
        
        System.out.println("\nInput data============");
        System.out.print("Nama\t: "); 
        nama = input.next();
        System.out.print("NIM\t: "); 
        nim = input.next();
        System.out.print("Usia\t: "); 
        usia = input.nextInt();
        System.out.print("UTS\t: "); 
        uts = input.nextInt();
        System.out.print("UAS\t: "); 
        uas = input.nextInt();
        Mahasiswa mhs = new Mahasiswa(nama, nim, usia, uts, uas);
        
        do {
            System.out.println("\nOpsi============");
            System.out.println("1. Tampilkan data");
            System.out.println("2. Edit data");
            System.out.println("3. Exit");
            System.out.print("Pilih : "); pilih = input.nextInt();
            
            switch(pilih){
                case 1 :
                    System.out.println("\nPerkenalkan nama saya " + mhs.nama + " NIM " + mhs.nim);
                    System.out.println("Usia\t: " + mhs.usia);
                    System.out.println("Nilai akhir\t: " + mhs.hitungNilai());
                    break;

                case 2 :
                    System.out.println("\nEdit ============");
                    System.out.print("Nama\t: "); 
                    mhs.nama = input.next();
                    System.out.print("NIM\t: "); 
                    mhs.nim = input.next();
                    System.out.print("Usia\t: "); 
                    mhs.usia = input.nextInt();
                    System.out.print("UTS\t: "); 
                    mhs.uts = input.nextInt();
                    System.out.print("UAS\t: ");
                    mhs.uas = input.nextInt();
                   break;

                case 3:
                    System.exit(0);
            }  
        } while (true);
    }
}
