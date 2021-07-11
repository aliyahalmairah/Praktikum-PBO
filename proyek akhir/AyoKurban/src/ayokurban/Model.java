/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayokurban;

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
    static final String DB_URL = "jdbc:mysql://localhost/ayokurban";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;
    
    private String nama;
    private String tipe;
    private String waktu;
    
    public Model(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int dapatBanyakData(){
        try{
            int banyakData = 0;
            String query = "SELECT * FROM pendaftar";
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
    
    public String[][] bacaDataPendaftar(){
        try{
            int banyakData = 0;
            String data[][] = new String[dapatBanyakData()][4];
            String query = "SELECT * FROM pendaftar";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next() && banyakData < dapatBanyakData()){
                data[banyakData][0] = "" + (banyakData+1);
                data[banyakData][1] = resultSet.getString("nama");
                data[banyakData][2] = resultSet.getString("tipe");
                data[banyakData][3] = resultSet.getString("tanggal");
                banyakData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String[][] bacaDataHewanKurban(){
        try{
            int banyakData = 0;
            String data[][] = new String[5][5];
            String query = "SELECT * FROM hewan_kurban";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next() && banyakData < 6){
                data[banyakData][0] = resultSet.getString("tipe");
                data[banyakData][1] = resultSet.getString("nama");
                data[banyakData][2] = resultSet.getString("berat");
                data[banyakData][3] = resultSet.getString("harga");
                data[banyakData][4] = resultSet.getString("kuota");
                banyakData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void insertData(String nama, String tipe, String tanggal){
        try{
            String query = "INSERT INTO pendaftar VALUES " +
                    "('"+ nama +"','"+ tipe +"','"+ tanggal +"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Insert Successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Insert Failed!");
        }
    }
}
