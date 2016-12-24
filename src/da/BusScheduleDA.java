/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.BusSchedule;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author user
 */
public class BusScheduleDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "BusSchedule";
    private Connection conn;
    private PreparedStatement stmt;
    
    public BusScheduleDA() {
        createConnection();
    }
    
  public ArrayList<BusSchedule> getBusScheduleID(){
      String query = "SELECT * FROM BUSSCHEDULE ORDER BY SCHEDULEID";
      ArrayList<BusSchedule> scheduleList=new ArrayList<BusSchedule>();
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          rs = stmt.executeQuery();
          while(rs.next()){
              scheduleList.add(new BusSchedule(rs.getString("SCHEDULEID"),rs.getString("BUSID"),rs.getString("DESTINATION"),rs.getInt("AVAILABLESEAT"),rs.getDate("DEPARTDATE"),rs.getDouble("TICKETPRICE"),rs.getString("RTYPE"),rs.getString("DEPARTTIME")));
              
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
      System.out.println(scheduleList);
      return scheduleList;
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
                lastRowCode=rs.getString("scheduleid");
                
                break;
            }
            subString=lastRowCode.substring(2,lastRowCode.length());
            int convertedSubString=Integer.parseInt(subString)+1;
            newAutomatedCode="BS"+String.format("%03d",convertedSubString);
          
             
            } catch (SQLException ex) {
                ex.getMessage();
                
            }
         return newAutomatedCode;
     }
public ArrayList<String>selectBusIDbyDate(Date sameDepDate){
    String queryStr="SELECT t.busid FROM BUSSCHEDULE t,BUS b WHERE departdate = ? AND t.busid=b.busid";
    ArrayList<String> busIDOnsameDate=new ArrayList<String>();
    try{
        stmt=conn.prepareStatement(queryStr);
        stmt.setDate(1, new java.sql.Date(sameDepDate.getTime()));
        ResultSet rs= stmt.executeQuery();
        
        while(rs.next()){
            busIDOnsameDate.add(rs.getString("busid"));
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    return busIDOnsameDate;
}
    public void addRecord(String scheduleID,String busID,String destination,Integer availableseat,Date departDate,Double ticketprice,String rtype,String departTime) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, scheduleID);
            stmt.setString(2, busID);
            stmt.setString(3, destination);
            stmt.setInt(4, availableseat);
            stmt.setDate(5, new java.sql.Date (departDate.getTime()));
            stmt.setDouble(6, ticketprice);
            stmt.setString(7, rtype);
            stmt.setString(8, departTime);
            
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusSchedule getRecord(String scheduleID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE scheduleID = ?";
        BusSchedule schedule = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, scheduleID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                schedule = new BusSchedule(scheduleID,rs.getString("BUSID"),rs.getString("DESTINATION"),rs.getInt("AVAILABLESEAT"),rs.getDate("DEPARTDATE"),rs.getDouble("TICKETPRICE"),rs.getString("RTYPE"),rs.getString("DEPARTTIME"));
            }
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }

//    public void updateRecord(BusSchedule schedule) {
//        try {
//            String updateStr = "UPDATE " + tableName + " SET BUSID = ?, Status= ? " + " WHERE SHCDULEID = ?";
//            stmt = conn.prepareStatement(updateStr);
//            stmt.setString(1, schedule.getBusID());
//            stmt.setString(2, schedule.getstatus());
//            stmt.setString(3, schedule.getScheduleID());
//           
//            
//            stmt.executeUpdate();
//        } catch(NumberFormatException ex){
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
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
