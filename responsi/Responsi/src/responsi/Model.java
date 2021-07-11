/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VivoBook
 */
public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;
    
    public Model(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getBanyakData(){
        try{
            int banyakData = 0;
            String query = "SELECT * FROM movie";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                banyakData++;
            }
            return banyakData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public String[][] bacaSemuaData(){
        try{
            int banyakData = 0;
            String data[][] = new String[getBanyakData()][5];
            String query = "SELECT * FROM movie";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next() && banyakData < getBanyakData()){
                data[banyakData][0] = resultSet.getString("judul");
                data[banyakData][1] = resultSet.getString("alur");
                data[banyakData][2] = resultSet.getString("penokohan");
                data[banyakData][3] = resultSet.getString("akting");
                data[banyakData][4] = resultSet.getString("nilai");
                banyakData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void tambahData(String judul, double alur, double penokohan, double akting){
        double nilai = (alur+penokohan+akting)/3;
        try{
            String query = "INSERT INTO movie VALUES " +
                    "('"+ judul +"','"+ alur +"',"+ penokohan +",'"+ akting +"','"+ nilai +"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil ditambah!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal ditambah!" + "\n" + e.getMessage());
        }
    }
    
    public void updateData(String judul, double alur, double penokohan, double akting){
        double nilai = (alur+penokohan+akting)/3;
        try{
            String query = "UPDATE movie SET " +
            "judul = '"+ judul +"', alur= "+ alur +", penokohan= "+ penokohan +", akting= "+ akting +", nilai= "+ nilai +"" +
                     "WHERE judul = '"+ judul +"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Update berhasil!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update gagal!" + "\n" + e.getMessage());
        }
    }
    
    public void deleteData(String judul){
        try{
            String query = "DELETE FROM movie WHERE judul = '" + judul + "'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal dihapus!" + "\n" + e.getMessage());
        }
    }
}
