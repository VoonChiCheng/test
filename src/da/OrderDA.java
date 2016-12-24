package da;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class OrderDA{
     private Connection conn;
    private PreparedStatement pstmt;
     private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/finalyear";
   private String user = "finalyear";
    private String password = "finalyear";
    
    public OrderDA(){
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
     
   

     public ArrayList<Route> getRouteList(){
         String query = "SELECT * FROM ROUTE WHERE RTYPE = ? ORDER BY DESTINATION";
         ArrayList<Route> routeList = new ArrayList<Route>();
        ResultSet rs = null;
         try{
              pstmt = conn.prepareStatement(query);
              pstmt.setString(1, "Normal");
                  rs = pstmt.executeQuery();
                  while(rs.next()){
                     routeList.add(new Route(rs.getString("DESTINATION"), rs.getString("RTYPE"),rs.getDouble("PRICE")));
                     
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
        
         return routeList;
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
          //   System.out.println("Sohai");
            
         }
         return schedule;
     }
     
     public Sale getSale(String saleID){
         String query = "SELECT * FROM SALES WHERE saleid = ?";
         Sale sale = null;
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, saleID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                 sale = (new Sale(rs.getString(1),rs.getString(2),rs.getDate(3)));
             }
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
            
         }
         return sale;
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
     
     public void updateTicket(String saleID,ArrayList<Ticket> ticket,int i){
         String query = "UPDATE TICKET SET STATUS = ?  ,SALEID = ? WHERE TICKETID = ?";
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, "Sold");
             pstmt.setString(2, saleID);
             pstmt.setString(3,ticket.get(i).getTicketID() );
             int result = pstmt.executeUpdate();
             
             if(result >0)
                 pstmt.executeUpdate();
             
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
     
     public boolean checkRepeatSaleID(String saleID){
         boolean valid = true;
         String query = "SELECT saleid FROM SALES WHERE saleid = ?";
    
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, saleID);
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
     
     public Bus checkBusType(String busID){
         String query = "SELECT * FROM BUS WHERE BUSID = ?";
         Bus bus = null;
         try{
             pstmt = conn.prepareStatement(query);
             pstmt.setString(1, busID);
             rs = pstmt.executeQuery();
             if(rs.next()){
                bus = new Bus(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
             }
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
             //System.out.println("Sohai");
         }
         return bus;
     }
     
     public void updateTicketSeat(int availableSeat,String scheduleID){
         String query = "UPDATE BUSSCHEDULE SET availableseat = ? WHERE scheduleid = ?";
         try{
                pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, availableSeat);
             pstmt.setString(2,scheduleID );
             int result = pstmt.executeUpdate();
             
              if(result >0)
                 pstmt.executeUpdate();
              
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
     
     public void createSaleRecord(String saleID,String staffID,Date date){
         String query = "INSERT INTO SALES VALUES(?,?,?)" ;
           java.sql.Date sqlDate = new java.sql.Date(date.getTime());
           try{
               pstmt = conn.prepareStatement(query);
               pstmt.setString(1, saleID);
               pstmt.setString(2, staffID);
               pstmt.setDate(3, sqlDate);
               pstmt.executeUpdate();
           }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }
     
     public ArrayList<VSchedule> getVSchedule(){
         ArrayList<VSchedule> vs = new ArrayList<VSchedule>();
         String query = "SELECT SCHEDULEID,AVAILABLESEAT FROM BUSSCHEDULE";
          try{
              pstmt = conn.prepareStatement(query);
             
                  rs = pstmt.executeQuery();
                  while(rs.next()){
                     vs.add(new VSchedule(rs.getString(1), rs.getInt(2)));
                     
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
         
         return vs;
     }
     
    /* public void updateTicketSeat(int availableSeat,String scheduleID){
         String query = "UPDATE BUSSCHEDULE SET availableseat = ? WHERE scheduleid = ?";
         try{
                pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, availableSeat);
             pstmt.setString(2,scheduleID );
             int result = pstmt.executeUpdate();
             
              if(result >0)
                 pstmt.executeUpdate();
              
         }catch(SQLException ex){
             showErrorDialog(ex.toString());
         }
     }*/
     
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