/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author VivoBook
 */
public class View extends JFrame{
    JLabel title;

    JLabel lJudul = new JLabel("Judul");
    JTextField tfJudul = new JTextField();
    JLabel lAlur = new JLabel("Alur");
    JTextField tfAlur = new JTextField();
    JLabel lPenokohan = new JLabel("Penokohan");
    JTextField tfPenokohan = new JTextField();
    JLabel lAkting = new JLabel("Akting");
    JTextField tfAkting = new JTextField();

    JButton bTambah = new JButton("Tambah");
    JButton bUpdate = new JButton("Update");
    JButton bDelete = new JButton("Delete");
    JButton bClear = new JButton("Clear");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    Object coloumnName[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public View(){
        tableModel = new DefaultTableModel(coloumnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,400);

        add(scrollPane);
        scrollPane.setBounds(20,20,560,300);

        add(lJudul);
        lJudul.setBounds(600,20,100,20);
        add(lAlur);
        lAlur.setBounds(600,65,50,20);
        add(lPenokohan);
        lPenokohan.setBounds(600,110,70,20);
        add(lAkting);
        lAkting.setBounds(600,155,50,20);

        add(tfJudul);
        tfJudul.setBounds(600,40,150,20);
        add(tfAlur);
        tfAlur.setBounds(600,85,150,20);
        add(tfPenokohan);
        tfPenokohan.setBounds(600,130,150,20);
        add(tfAkting);
        tfAkting.setBounds(600,175,150,20);

        add(bTambah);
        bTambah.setBounds(600,205,100,20);
        add(bUpdate);
        bUpdate.setBounds(600,235,100,20);
        add(bDelete);
        bDelete.setBounds(600,265,100,20);
        add(bClear);
        bClear.setBounds(600,295,100,20);
    }
    
    public String getJudul(){ return tfJudul.getText();}
    public String getAlur(){ return tfAlur.getText();}
    public String getPenokohan(){ return tfPenokohan.getText();}
    public String getAkting(){ return tfAkting.getText();}
}
