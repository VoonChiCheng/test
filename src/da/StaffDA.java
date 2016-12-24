/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Staff;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author user
 */
public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    
    public StaffDA() {
        createConnection();
    }
    
  public ArrayList<Staff> getsStaffID(){
      String query = "SELECT * FROM Staff ORDER BY StaffID";
      ArrayList<Staff> staffList=new ArrayList<Staff>();
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          rs = stmt.executeQuery();
          while(rs.next()){
              staffList.add(new Staff(rs.getString("STAFFID"),rs.getString("NAME"),rs.getString("IC"),rs.getString("GENDER"),rs.getDate("DOB"),rs.getString("ADDRESS"),rs.getString("CONTACTNO"),rs.getString("EMAIL"),rs.getString("POSITION"),rs.getString("STATUS"),rs.getString("PASSWORD"),rs.getString("SECURITYANS"),rs.getInt("QUESTIONNO")));
              
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
      System.out.println(staffList);
      return staffList;
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
                lastRowCode=rs.getString("staffid");
                
                break;
            }
            subString=lastRowCode.substring(1,lastRowCode.length());
            int convertedSubString=Integer.parseInt(subString)+1;
            newAutomatedCode="S"+String.format("%03d",convertedSubString);
          
             
            } catch (SQLException ex) {
                ex.getMessage();
                
            }
         return newAutomatedCode;
     }

    public void addRecord(String StaffID,String Name,String IC,String Gender,Date DOB,String Address,String ContactNo,String Email,String Position,String Status,String Password,String Security,Integer QuestionNo) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, StaffID);
            stmt.setString(2, Name);
            stmt.setString(3, IC);
            stmt.setString(4, Gender);
            stmt.setDate(5, new java.sql.Date (DOB.getTime()));
            stmt.setString(6, Address);
            stmt.setString(7, ContactNo);
            stmt.setString(8, Email);
            stmt.setString(9, Position);
            stmt.setString(10, Status);
            stmt.setString(11, Password);
            stmt.setString(12, Security);
            stmt.setInt(13, QuestionNo);
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Staff getRecord(String StaffID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE StaffID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, StaffID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staff = new Staff(StaffID,rs.getString("NAME"),rs.getString("IC"),rs.getString("GENDER"),rs.getDate("DOB"),rs.getString("ADDRESS"),rs.getString("CONTACTNO"),rs.getString("EMAIL"),rs.getString("POSITION"),rs.getString("STATUS"),rs.getString("PASSWORD"),rs.getString("SECURITYANS"),rs.getInt("QUESTIONNO") );
            }
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    public void updateRecord(Staff staff) {
        try {
            String updateStr = "UPDATE " + tableName + " SET Name = ?, IC = ?, GENDER= ?, DOB= ?, ADDRESS= ?, CONTACTNO= ?, EMAIL= ?, POSITION= ?, STATUS= ?" + " WHERE STAFFID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getIC());
            stmt.setString(3, staff.getGender());
            stmt.setDate(4, new java.sql.Date (staff.getDOB().getTime()));
            stmt.setString(5, staff.getAddress());
            stmt.setString(6, staff.getContactno());
            stmt.setString(7, staff.getEmail());
            stmt.setString(8, staff.getPosition());
            stmt.setString(9, staff.getStatus());
            stmt.setString(10,staff.getStaffID());
            
            stmt.executeUpdate();
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateStaffPassowrdAndSecurity(Staff staff){
        try{
            String updateStr = "UPDATE " + tableName + " SET Password = ?, SecurityAns = ?, Questionno= ? " + " WHERE STAFFID = ?";
             stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, staff.getPassword());
            stmt.setString(2, staff.getSecurity());
            stmt.setInt(3, staff.getQuestionno());
            stmt.setString(4, staff.getStaffID());
             stmt.executeUpdate();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateStaffPassowrd(Staff staff){
        try{
            String updateStr = "UPDATE " + tableName + " SET Passowrd = ?" + " WHERE STAFFID = ?";
             stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, staff.getPassword());
            stmt.setString(2, staff.getStaffID());
    }catch(NumberFormatException ex){
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
