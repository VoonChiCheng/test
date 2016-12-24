package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import domain.*;
import java.util.ArrayList;


public class PaymentDA{
    private Connection conn;
    private PreparedStatement pstmt;
     private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/finalyear";
   private String user = "finalyear";
    private String password = "finalyear";
    
    public PaymentDA(){
        createConnection();
        
    }
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double calTotalAmt(String saleID){
        String query = "SELECT S.TICKETPRICE FROM BUSSCHEDULE S,TICKET T WHERE S.SCHEDULEID = T.SCHEDULEID AND T.SALEID = ?";
        double totalAmt = 0;
        try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, saleID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                totalAmt += rs.getDouble("ticketprice");
            }
        }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
          }
          return totalAmt;
    }
    
    public void createPaymentRecord(Payment pay){
        String query = "INSERT INTO PAYMENT VALUES( ?, ?, ?, ?, ?, ?)";
          java.sql.Date sqlDate = new java.sql.Date(pay.getPayDate().getTime());
          
          try{
              pstmt =conn.prepareStatement(query);
              pstmt.setString(1, pay.getPaymentID());
              pstmt.setString(2, pay.getSaleID());
              pstmt.setString(3, pay.getPayType());
              pstmt.setString(4, pay.getCCNumber());
              pstmt.setDate(5, sqlDate);
              pstmt.setDouble(6, pay.getTotalAmt());
              pstmt.executeUpdate();
              
          }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
          }
    }
    
    public boolean checkRepeatPaymentID(String paymentID){
         boolean valid = true;
         String query = "SELECT paymentid FROM PAYMENT WHERE paymentid = ?";
      //   Sale sale = null;
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, paymentID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                 valid = true;
             }
             else{
                 valid = false;
             }
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
         return valid;
     }
    
    public double calChange(double totalAmt,double cash){
        double change = 0;
      
              if(cash >= totalAmt){
                  change =cash - totalAmt;
              }
              else{
                  JOptionPane.showMessageDialog(null, "Unsufficient amount of money entered");
              }
              return change;
    }
    
  public int getQuantity(String saleID){
      int quantity = 0;
      String query = "SELECT * FROM TICKET WHERE SALEID = ?";
      try{
            pstmt = conn.prepareStatement(query);
             pstmt.setString(1, saleID);
             rs = pstmt.executeQuery();
             while(rs.next()){
               quantity += 1;
             }
      }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
      return quantity;
  }
 //   private String destination;
  //  private Date departDate;
  //  private String departTime;
  //  private String scheduleID;
  //  private String seatID;
 //   private String busID;  
  
  public ArrayList<TicketP> getTicket(String saleID){
      String query = "SELECT T.ticketid , S.destination , S.departdate , S.departtime , S.scheduleid , T.seatid , T.busid,S.ticketprice,B.plateno FROM BUSSCHEDULE S,TICKET T,BUS B WHERE B.BUSID = S.BUSID AND S.SCHEDULEID = T.SCHEDULEID AND T.SALEID = ? ";
      ArrayList<TicketP> t = new ArrayList<TicketP>();
      ResultSet rs = null;
      try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, saleID);
             rs = pstmt.executeQuery();
             while(rs.next()){
                 t.add(new TicketP(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9)));
             }
      }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }finally{
                if(rs !=null){
                    try{
                        rs.close();                        
                    }catch(SQLException ex){
                        showErrorDialog(ex.toString());
                    }
                }
            }
    return t;
  }
  
  public void reverseSchedule(int seat,String scheduleID){
        String query = "UPDATE BUSSCHEDULE SET availableseat = ? WHERE scheduleid = ?";
       
         try{
                pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, seat);
             pstmt.setString(2,scheduleID);
             int result = pstmt.executeUpdate();
             
              if(result >0)
                 pstmt.executeUpdate();
              
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
         
        
     }
  
   public void reverseTicket(String saleID){
         String query = "UPDATE TICKET SET STATUS = ?,SALEID = ? WHERE SALEID = ?";
       try{
                pstmt = conn.prepareStatement(query);
             pstmt.setString(1, "Available");
             pstmt.setString(2,"0");
             pstmt.setString(3, saleID);
             int result = pstmt.executeUpdate();
             
              if(result >0)
                 pstmt.executeUpdate();
              
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
     
     public void deleteSale(String saleID){
         String query = "DELETE FROM SALES WHERE SALEID = ?";
       try{
                pstmt = conn.prepareStatement(query);
            
             pstmt.setString(1, saleID);
             int result = pstmt.executeUpdate();
             
              if(result >0)
                 pstmt.executeUpdate();
              
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
    
    
    private void showErrorDialog(String message){
                JOptionPane.showMessageDialog(null, message,"DB ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    public void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
