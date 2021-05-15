/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import tugas3.bidang.PersegiPanjang;
import tugas3.ruang.Balok;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author VivoBook
 */
public class Tugas3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI(); 
    }
}

class GUI extends JFrame implements ActionListener{
    JLabel ljudul = new JLabel("KALKULATOR BALOK");
    JLabel lpanjang = new JLabel("Panjang");
    JTextField fpanjang = new JTextField();
    
    JLabel llebar = new JLabel("Lebar");
    final JTextField flebar = new JTextField();
    
    JLabel ltinggi = new JLabel("Tinggi");
    final JTextField ftinggi = new JTextField();
    
    JLabel lhasil = new JLabel("Hasil :");
    JLabel lluas = new JLabel();
    JLabel lkeliling = new JLabel();
    JLabel lvolume = new JLabel();
    JLabel llp = new JLabel();
            
    JButton bhitung = new JButton("Hitung");
    JButton breset = new JButton("Reset");
    
    public GUI(){
        setSize(500, 400);
        
        setLayout(null);
        add(ljudul);
        add(lpanjang);
        add(fpanjang);
        add(llebar);
        add(flebar);
        add(ltinggi);
        add(ftinggi);
        add(lhasil);
        add(bhitung);
        add(lluas);
        add(lkeliling);
        add(lvolume);
        add(llp);
        add(breset);
       
        //lnama.setBounds(10,10,120,20);
        ljudul.setBounds(180,20,200,10);
        lpanjang.setBounds(60,60,50,20);
        fpanjang.setBounds(170,60,200,20);
        llebar.setBounds(60,100,50,20);
        flebar.setBounds(170,100,200,20);
        ltinggi.setBounds(60,140,50,20);
        ftinggi.setBounds(170,140,200,20);
        lhasil.setBounds(60,185,50,20);
        lluas.setBounds(60,205,200,20);
        lkeliling.setBounds(60,225,200,20);
        lvolume.setBounds(60,245,200,20);
        llp.setBounds(60,265,200,20);
        bhitung.setBounds(150,310,100,20);
        breset.setBounds(255,310,100,20);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        breset.addActionListener(this);
        bhitung.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        double panjang = 0, lebar = 0, tinggi = 0;
        int x = 1;
        
        if(e.getSource() == bhitung){
            String a = fpanjang.getText();
            String b = flebar.getText();
            String c = ftinggi.getText();
           
            try{
                panjang = (int) Double.parseDouble(a);
                lebar = (int) Double.parseDouble(b);
                tinggi = (int) Double.parseDouble(c);
                
            } catch(Exception error){
                JOptionPane.showMessageDialog(this, error.getMessage());
                x = 0;
            }
            
            if(x==1){
                PersegiPanjang persegipanjang = new PersegiPanjang(panjang, lebar);
                    Balok balok = new Balok(panjang, lebar, tinggi);

                    lluas.setText("Luas persegi : " + persegipanjang.luas());
                    lkeliling.setText("Keliling persegi : " + persegipanjang.keliling());
                    lvolume.setText("Volume Balok : " + balok.volume());
                    llp.setText("Luas Permukaan Balok : " + balok.lp());     
            }
        } 
        if(e.getSource() == breset){
            fpanjang.setText("");
            flebar.setText("");
            ftinggi.setText("");
            lluas.setText("");
            lkeliling.setText("");
            lvolume.setText("");
            llp.setText("");
        }
    } 
}
