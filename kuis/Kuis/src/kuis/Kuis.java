/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis;

import java.util.Scanner;

/**
 *
 * @author VivoBook
 */
public class Kuis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int pilihan;
        String nik, nama;
        double nilaiTulis, nilaiCoding, nilaiWawancara;
        
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        
        System.out.println("Form Pendaftaran PT. Udin");
        System.out.println("1. Android Development");
        System.out.println("2. Web Development");
        
        System.out.print("Pilih Jenis Form : ");
        pilihan = input.nextInt();
        
        switch (pilihan){
            case 1:
                System.out.print("\nInput NIK : ");
                nik = input.next();
                input.nextLine();
                System.out.print("Input Nama : ");
                nama = input.nextLine();
                System.out.print("Input Nilai Tes Tulis : ");
                nilaiTulis = input.nextDouble();
                System.out.print("Input Nilai Tes Coding : ");
                nilaiCoding = input.nextDouble();
                System.out.print("Input Nilai Tes Wawancara : ");
                nilaiWawancara = input.nextDouble();
                
                Menu(nik, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
                break;
                
            case 2:
                break;
        }
    }

    private static void Menu(String nik, String nama, double nilaiTulis, double nilaiCoding, double nilaiWawancara) {
        int pilihan;
        
        MenuAndroid menuandroid = new MenuAndroid(nik, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
            
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("\nMenu");
            System.out.println("1. Edit");
            System.out.println("2. Tampil");
            System.out.println("3. Edit");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();

            switch(pilihan){
                case 1:
                    System.out.println("FORM EDIT");
                    System.out.print("Input Nilai Tes Tulis : ");
                    nilaiTulis = input.nextDouble();
                    System.out.print("Input Nilai Tes Coding : ");
                    nilaiCoding = input.nextDouble();
                    System.out.print("Input Nilai Tes Wawancara : ");
                    nilaiWawancara = input.nextDouble();
                    Menu(nik, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
                   break;

                case 2:
                    System.out.println("Nilai Akhir : " + menuandroid.nilaiAkhir());
                    System.out.println("Keterangan : " + menuandroid.keterangan());
                    System.out.println(menuandroid.hasil());
                    break;

                case 3:
                    System.exit(0);
            }
        }while (true);
    }
}