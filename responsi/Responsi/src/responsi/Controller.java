/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

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
public class Controller implements ActionListener {
    View view;
    Model model;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        if (model.getBanyakData() != 0){
            refreshTable();
        }

        view.bTambah.addActionListener(this);
        view.bUpdate.addActionListener(this);
        view.bDelete.addActionListener(this);
        view.bClear.addActionListener(this);
        
        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.table.getSelectedRow();
                String judul = view.table.getValueAt(row,0).toString();
                String alur = view.table.getValueAt(row,1).toString();
                String penokohan = view.table.getValueAt(row,2).toString();
                String akting = view.table.getValueAt(row,3).toString();

                view.tfJudul.setText(judul);
                view.tfAlur.setText(alur);
                view.tfPenokohan.setText(penokohan);
                view.tfAkting.setText(akting);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.bTambah){
            String judul = view.getJudul();
            String sAlur = view.getAlur();
            String sPenokohan = view.getPenokohan();
            String sAkting = view.getAkting();
            
            double alur, penokohan, akting;
            try {    
                alur = Double.parseDouble(sAlur);
                penokohan = Double.parseDouble(sPenokohan);
                akting = Double.parseDouble(sAkting);
            } catch (NumberFormatException ex){
                alur = 6;
                penokohan = 6;
                akting = 6;
            }
            if(verify(judul,alur,penokohan,akting)){
                model.tambahData(judul,alur,penokohan,akting);
                refreshTable();
            }
        } else if (e.getSource() == view.bUpdate){
            String judul = view.getJudul();
            String sAlur = view.getAlur();
            String sPenokohan = view.getPenokohan();
            String sAkting = view.getAkting();
            
            double alur, penokohan, akting;
            try {    
                alur = Double.parseDouble(sAlur);
                penokohan = Double.parseDouble(sPenokohan);
                akting = Double.parseDouble(sAkting);
            } catch (NumberFormatException ex){
                alur = 6;
                penokohan = 6;
                akting = 6;
            }
            if(verify(judul,alur,penokohan,akting)){
                model.updateData(judul,alur,penokohan,akting);
                refreshTable();
            }
        } else if (e.getSource() == view.bDelete){
            String judul = view.getJudul();
            if(judul.equals("")){
                JOptionPane.showMessageDialog(null, "Tidak ada yang bisa dihapus!");
            } else {
                model.deleteData(judul);
                refreshTable();
            }
        } else if (e.getSource() == view.bClear){
            view.tfJudul.setText("");
            view.tfAlur.setText("");
            view.tfPenokohan.setText("");
            view.tfAkting.setText("");
        } 
    }
    
    public void refreshTable(){
        String data[][] = model.bacaSemuaData();
        view.table.setModel(new JTable(data, view.coloumnName).getModel());
    }
    
    boolean verify(String judul, double alur, double penokohan, double akting){
        if (judul.equals("")){
            JOptionPane.showMessageDialog(null, "Judul masih kosong!");
            return false;
        } else if (alur < 0 || alur > 5) {
            JOptionPane.showMessageDialog(null, "Alur berisi nilai 0-5!");
            return false;
        } else if (penokohan < 0 || penokohan > 5) {
            JOptionPane.showMessageDialog(null, "Penokohan berisi nilai 0-5!");
            return false;
        } else if (akting < 0 || akting > 5) {
            JOptionPane.showMessageDialog(null, "Akting berisi nilai 0-5!");
            return false;
        } 
        return true;
    }
}
