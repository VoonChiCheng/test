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

public class ExchangeDA{
     private Connection conn;
    private PreparedStatement pstmt;
     private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/finalyear";
   private String user = "finalyear";
    private String password = "finalyear";
    
    public ExchangeDA(){
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
      
      public boolean checkTicketID(String ticketID){
          boolean valid = false;
          String query = "SELECT TICKETID FROM TICKET WHERE TICKETID = ?";
          try{
                pstmt = conn.prepareStatement(query);
             pstmt.setString(1, ticketID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                 valid = true;
             }
          }catch(SQLException ex){
               showErrorDialog(ex.toString());
          }
          
        
          
          return valid;
      }
    
      public ETicket getTicketExchangeDetail(String ticketID){
          ETicket et = new ETicket();
          String query = "SELECT T.TICKETID,T.SCHEDULEID,T.BUSID,T.SEATID,T.STATUS,S.DESTINATION,T.SALEID FROM TICKET T,BUSSCHEDULE S WHERE S.SCHEDULEID = T.SCHEDULEID AND TICKETID = ?";
        try{
                pstmt = conn.prepareStatement(query);
             pstmt.setString(1, ticketID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                et = new ETicket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
             }
          }catch(SQLException ex){
               showErrorDialog(ex.toString());
          }
          
          return et;
      }
    
      public String getBusType(String busID){
          String busType = null;
          String query = "SELECT BUSTYPE FROM BUS WHERE BUSID = ?";
            try{
                pstmt = conn.prepareStatement(query);
             pstmt.setString(1, busID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                busType = rs.getString(1);
             }
          }catch(SQLException ex){
               showErrorDialog(ex.toString());
          }
          return busType;
      }
      
        public Schedule getSchedule(String scheduleID){
         String query = "SELECT * FROM BUSSCHEDULE WHERE SCHEDULEID = ?";
         Schedule schedule = null;
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, scheduleID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                 schedule = (new Schedule(rs.getString("scheduleid"),rs.getString("busid"),rs.getString("destination"),rs.getInt("availableseat"),rs.getDate("departdate"),rs.getString("departtime"),rs.getDouble("ticketprice")));
                
             }
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
            
         }
         return schedule;
     }
        
        public String getBusPlateNo(String busID){
         String query = "SELECT PLATENO FROM BUS WHERE BUSID = ? ";
         String busPlateNo = null;
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, busID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                 busPlateNo = rs.getString("plateno");
             }
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
             ex.toString();
         }
         return busPlateNo;
     }
        
        public void updateExchangeTicketOld(String ticketID){
         String query = "UPDATE TICKET SET STATUS = ?  ,SALEID = ? WHERE TICKETID = ?";
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, "Available");
             pstmt.setString(2, "0");
             pstmt.setString(3,ticketID );
             int result = pstmt.executeUpdate();
             
             if(result >0)
                 pstmt.executeUpdate();
             
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
        
        public void updateExchangeTicketNew(String saleID,String ticketID){
         String query = "UPDATE TICKET SET STATUS = ?  ,SALEID = ? WHERE TICKETID = ?";
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, "Sold");
             pstmt.setString(2, saleID);
             pstmt.setString(3,ticketID );
             int result = pstmt.executeUpdate();
             
             if(result >0)
                 pstmt.executeUpdate();
             
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
        
         public ArrayList<Ticket> checkSeatAvailablity(String scheduleID){
         String query = "SELECT * FROM TICKET where scheduleid = ? ORDER BY SEATID";
         ArrayList<Ticket> ticket = new ArrayList<Ticket>();
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, scheduleID);
             rs = pstmt.executeQuery();
             while(rs.next()){
                 ticket.add(new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
         return ticket;
     }
    
         public String getSaleID(String ticketID){
             String query = "SELECT SALEID FROM TICKET WHERE TICKETID = ?";
             String saleID = null;
             try{
                 pstmt = conn.prepareStatement(query);
                 pstmt.setString(1,ticketID );
                 rs = pstmt.executeQuery();
                 if(rs.next()){
                     saleID = rs.getString(1);
                 }
                         
             }catch(SQLException ex){
                        showErrorDialog(ex.toString());
                    }
             return saleID;
         }
         
         public ArrayList<TicketP> getTicket(String saleID){
      String query = "SELECT T.ticketid , S.destination , S.departdate , S.departtime , S.scheduleid , T.seatid , T.busid,S.ticketprice,B.plateno FROM BUSSCHEDULE S,TICKET T,BUS B WHERE B.BUSID = S.BUSID AND S.SCHEDULEID = T.SCHEDULEID AND T.ticketid = ? ";
      ArrayList<TicketP> t = new ArrayList<TicketP>();
      ResultSet rs = null;
      try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, saleID);
             rs = pstmt.executeQuery();
             if(rs.next()){
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
      /*   public void updateScheduleSeat(String saleID,String ticketID){
         String query = "UPDATE BUSSCHEDULE SET AVAILABLESEAT = ?  WHERE SCHEDULEID = ?";
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, "Sold");
             pstmt.setString(2, saleID);
             pstmt.setString(3,ticketID );
             int result = pstmt.executeUpdate();
             
             if(result >0)
                 pstmt.executeUpdate();
             
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }*/
         
         public int getOldSeatAvailability(String scheduleID){
             String query = "SELECT availableseat FROM BUSSCHEDULE WHERE SCHEDULEID = ?";
             int seat = 0;
             try{
                 pstmt = conn.prepareCall(query);
                 pstmt.setString(1, scheduleID);
                 rs = pstmt.executeQuery();
                 if(rs.next()){
                     seat = rs.getInt(1);
                 }
             }catch(SQLException ex){
             showErrorDialog(ex.toString());
             
         }
             return seat;
         }
         
         public int getNewSeatAvailability(String ticketID){
             String query = "SELECT availableseat FROM BUSSCHEDULE S,TICKET T WHERE S.SCHEDULEID = T.SCHEDULEID AND T.TICKETID = ?";
             int seat = 0;
              try{
                 pstmt = conn.prepareCall(query);
                 pstmt.setString(1, ticketID);
                 rs = pstmt.executeQuery();
                 if(rs.next()){
                     seat = rs.getInt(1);
                 }
             }catch(SQLException ex){
             showErrorDialog(ex.toString());
             
         }
             return seat;
         }
         
         public void updateOldSeat(int seat,String scheduleID){
             String query = "UPDATE BUSSCHEDULE SET AVAILABLESEAT = ?  WHERE SCHEDULEID = ?";
              try{
             pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, seat);
             pstmt.setString(2, scheduleID);
           
             int result = pstmt.executeUpdate();
             
             if(result >0)
                 pstmt.executeUpdate();
             
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
         }
         
            public void updateNewSeat(int seat,String scheduleID){
             String query = "UPDATE BUSSCHEDULE SET AVAILABLESEAT = ?  WHERE SCHEDULEID = ?";
              try{
             pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, seat);
             pstmt.setString(2, scheduleID);
           
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