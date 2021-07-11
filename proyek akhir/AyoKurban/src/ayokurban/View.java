/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayokurban;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VivoBook
 */
public class View extends JFrame {
    JLabel title;
    
    JLabel lnama = new JLabel("Nama");
    final JTextField fnama = new JTextField();
    JLabel ltipe = new JLabel("Tipe Hewan");
    final JTextField ftipe = new JTextField();
    JLabel ltanggal = new JLabel("Tanggal");
    final JTextField ftanggal = new JTextField();
    
    JButton bsimpan = new JButton("Simpan");
    JButton breset = new JButton("Reset");
    JButton brefresh = new JButton("Refresh");
    
    JTable table1;
    DefaultTableModel tableModel1;
    JScrollPane scrollPane1;
    
    JTable table2;
    DefaultTableModel tableModel2;
    JScrollPane scrollPane2;
    
    Object coloumnName1[] = {"No.", "Nama", "Tipe Hewan", "Tanggal"};
    Object coloumnName2[] = {"Tipe","Nama","Berat","Harga","Kuota"};
    
    public View(){
        tableModel1 = new DefaultTableModel(coloumnName1, 0);
        table1 = new JTable(tableModel1);
        scrollPane1 = new JScrollPane(table1);
        
        tableModel2 = new DefaultTableModel(coloumnName2, 0);
        table2 = new JTable(tableModel2);
        scrollPane2 = new JScrollPane(table2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(650, 400);

        title = new JLabel("Program Ayo Kurban");
        add(title);
        title.setBounds(260,20,200,15);
        title = new JLabel("Bersama Masjid Jami' Al Barkah");
        add(title);
        title.setBounds(240,40,200,15);
        
        add(scrollPane1); 
        scrollPane1.setBounds(270,230,350,110);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scrollPane2);
        scrollPane2.setBounds(95,75,450,105);
        
        add(lnama); //x,y,lebar,tinggi
        lnama.setBounds(20,230,80,20);
        add(ltipe);
        ltipe.setBounds(20,253,80,20);
        add(ltanggal);
        ltanggal.setBounds(20,276,80,20);

        add(fnama);
        fnama.setBounds(108,230,130,20);
        add(ftipe);
        ftipe.setBounds(108,253,130,20);
        add(ftanggal);
        ftanggal.setBounds(108,276,130,20);

        add(bsimpan);
        bsimpan.setBounds(137,307,80,20);
        add(breset);
        breset.setBounds(37,307,80,20);
        add(brefresh);
        brefresh.setBounds(270,200,100,20);
    }
    
    public String getNama(){ return fnama.getText();}
    public String getTipe(){ return ftipe.getText();}
    public String getTanggal(){ return ftanggal.getText();}
}
