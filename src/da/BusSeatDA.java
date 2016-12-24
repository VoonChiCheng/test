/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.BusSeat;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author user
 */
public class BusSeatDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "BusSeat";
    private Connection conn;
    private PreparedStatement stmt;
    
    public BusSeatDA() {
        createConnection();
    }
    
    public void addRecord(String SeatID,String BusID){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, SeatID);
            stmt.setString(2, BusID);
            
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
