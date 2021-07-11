/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayokurban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author VivoBook
 */
public class Controller implements ActionListener{
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        if (model.dapatBanyakData() != 0){
            refreshTablePendaftar();
        }
        
        if (true){
            refreshTableHewanKurban();
        }

        view.bsimpan.addActionListener(this);
        view.breset.addActionListener(this);
        view.brefresh.addActionListener(this);

        view.table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.table1.getSelectedRow();
                String nama = view.table1.getValueAt(row,1).toString();
                String tipe = view.table1.getValueAt(row,2).toString();
                String tanggal = view.table1.getValueAt(row,3).toString();

                view.fnama.setText(nama);
                view.ftipe.setText(tipe);
                view.ftanggal.setText(tanggal);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource() == view.bsimpan){
               String nama = view.getNama();
               String tipe = view.getTipe();
               String tanggal = view.getTanggal();

               if (nama.equals("")){
                   JOptionPane.showMessageDialog(null, "Field Nama Is Empty!");
               } else {
                   model.insertData(nama, tipe, tanggal);
                   refreshTablePendaftar();
               }
           } else if (e.getSource() == view.breset){
               view.fnama.setText("");
               view.ftipe.setText("");
               view.ftanggal.setText("");
           } else if (e.getSource() == view.brefresh){
               refreshTablePendaftar();
           }
    }

    public void refreshTablePendaftar(){
        String data[][] = model.bacaDataPendaftar();
        view.table1.setModel(new JTable(data, view.coloumnName1).getModel());
    }
    
    public void refreshTableHewanKurban(){
        String data[][] = model.bacaDataHewanKurban();
        view.table2.setModel(new JTable(data, view.coloumnName2).getModel());
    }
}
