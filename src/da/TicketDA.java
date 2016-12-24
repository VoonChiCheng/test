/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Ticket;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author user
 */
public class TicketDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "Ticket";
    private Connection conn;
    private PreparedStatement stmt;
    
    public TicketDA() {
        createConnection();
    }
    
    public void addRecord(String ticketID,String saleID,String scheduleID,String seatID,String busID,String status){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, ticketID);
            stmt.setString(2, saleID);
            stmt.setString(3, scheduleID);
            stmt.setString(4, seatID);
            stmt.setString(5, busID);
            stmt.setString(6, status);
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean checkRepeatTicketID(String ticketID){
         boolean valid = true;
         String query = "SELECT ticketID FROM TICKET WHERE ticketid = ?";
         ResultSet rs=null;
//         Ticket ticket = null;
         try{
             stmt = conn.prepareStatement(query);
             stmt.setString(1, ticketID);
             rs = stmt.executeQuery();
             if(rs.next()){
                 valid = true;
             }
             else{
                 valid = false;
             }
         }catch(SQLException ex){
             ex.getMessage();
         }
         return valid;
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
