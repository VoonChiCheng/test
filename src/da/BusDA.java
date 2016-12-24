/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Bus;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author user
 */
public class BusDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "Bus";
    private Connection conn;
    private PreparedStatement stmt;
    
    public BusDA() {
        createConnection();
    }
    
  public ArrayList<Bus> getBusID(){
      String query = "SELECT * FROM BUS ORDER BY BusID";
      ArrayList<Bus> busList=new ArrayList<Bus>();
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          rs = stmt.executeQuery();
          while(rs.next()){
              busList.add(new Bus(rs.getString("BUSID"),rs.getString("PlateNo"),rs.getInt("TotalSeat"),rs.getString("BusType"),rs.getString("Status"),rs.getString("PurchaseDate")));
              
          }
      }catch(SQLException ex){
        ex.getMessage();
      }finally{
          if(rs!=null){
              try{
                  rs.close();
              }catch(SQLException ex){
                  ex.getMessage();
              }
          }
      }
      System.out.println(busList);
      return busList;
  }
     public ResultSet selectRecord() {
        String queryStr = "SELECT * FROM " + tableName ;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
           
            ex.getMessage();
        }
        return rs;
    }
     public String displayAutomatedCode()
     {
         String lastRowCode="";
         String subString="";
         String newAutomatedCode="";
         
         try {
            ResultSet rs=selectRecord();
            rs.afterLast();
            while(rs.previous())
            {
                lastRowCode=rs.getString("busid");
                
                break;
            }
            subString=lastRowCode.substring(1,lastRowCode.length());
            int convertedSubString=Integer.parseInt(subString)+1;
            newAutomatedCode="B"+String.format("%03d",convertedSubString);
          
             
            } catch (SQLException ex) {
                ex.getMessage();
                
            }
         return newAutomatedCode;
     }

    public void addRecord(String BusID,String PlateNo,Integer Seat,String BusType,String Status,String Purchase) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, BusID);
            stmt.setString(2, PlateNo);
            stmt.setInt(3, Seat);
            stmt.setString(4, BusType);
            stmt.setString(5, Status);
            stmt.setString(6, Purchase);
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int getBusSeat(String BusID){
        String query="SELECT TOTALSEAT FROM BUS WHERE BUSID= ?";
        ResultSet rs =null;
        int totalseat =0;
        try{
            stmt=conn.prepareStatement(query);
            stmt.setString(1, BusID);
            rs =stmt.executeQuery();
            if(rs.next()){
                totalseat=rs.getInt("TOTALSEAT");
                System.out.println(totalseat);
            }
        }catch(SQLException ex){
            ex.getMessage();
        }
        return totalseat;
    }
        public String getBusType(String BusID){
        String query="SELECT BUSTYPE FROM BUS WHERE BUSID= ?";
        ResultSet rs =null;
        String bustype =null;
        try{
            stmt=conn.prepareStatement(query);
            stmt.setString(1, BusID);
            rs =stmt.executeQuery();
            if(rs.next()){
                bustype=rs.getString("BUSTYPE");
                System.out.println(bustype);
            }
        }catch(SQLException ex){
            ex.getMessage();
        }
        return bustype;
    }
public ArrayList<Bus> getInServiceBusID(){
      String query = "SELECT * FROM BUS WHERE STATUS =? ORDER BY BusID";
      ArrayList<Bus> busList=new ArrayList<Bus>();
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          stmt.setString(1, "In Service");
          rs = stmt.executeQuery();
          while(rs.next()){
              busList.add(new Bus(rs.getString("BUSID"),rs.getString("PlateNo"),rs.getInt("TotalSeat"),rs.getString("BusType"),rs.getString("Status"),rs.getString("PurchaseDate")));
              
          }
      }catch(SQLException ex){
        ex.getMessage();
      }finally{
          if(rs!=null){
              try{
                  rs.close();
              }catch(SQLException ex){
                  ex.getMessage();
              }
          }
      }
      System.out.println(busList);
      return busList;
  }
    public Bus getRecord(String BusID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BusID = ?";
        Bus bus = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, BusID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                bus = new Bus(BusID, rs.getString("PlateNo"), rs.getInt("TotalSeat"),rs.getString("BusType"),rs.getString("Status"),rs.getString("PurchaseDate"));
            }
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bus;
    }

    public void updateRecord(Bus bus) {
        try {
            String updateStr = "UPDATE " + tableName + " SET PlateNo = ?, Status= ? " + " WHERE BusID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, bus.getPlateNo());
            stmt.setString(2, bus.getStatus());
            stmt.setString(3, bus.getBusID());
            
            stmt.executeUpdate();
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
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
