package da;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import domain.*;
import java.util.Calendar;
import java.util.Date;

public class CustomTable extends AbstractTableModel{
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/finalyear";
//     private String host = "jdbc:derby://localhost:1527/affectedb";
   private String user = "finalyear";
    private String password = "finalyear";
private Date nowDate = new Date();
    
    
     public CustomTable(){
      
        try{
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
              java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
       
       //   java.sql.Date sqlDate = new java.sql.Date(now.getTime());
          String query = "SELECT S.ScheduleID,S.BusID,S.Destination,B.Bustype,S.DepartDate,S.DepartTime,S.TicketPrice,S.Availableseat FROM busschedule S, bus B where S.busid = B.busid AND S.departdate >= ?";
        //   String query = "SELECT* FROM busschedule";
       //     String query = "SELECT * FROM PAYMENT";
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setDate(1, sqlNowDate);
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();
            rs.last();
            numberOfRows = rs.getRow();
            fireTableStructureChanged();
           
            
        }catch(SQLException ex){
            ex.printStackTrace();   
        }
    }
     
       public void retrieveRecordsByDestination(String destination){
            try{
                   java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
                String query = " SELECT S.ScheduleID,S.BusID,S.Destination,B.Bustype,S.DepartDate,S.DepartTime,S.TicketPrice,S.Availableseat FROM busschedule S, bus B WHERE B.busid = S.busid AND S.Destination = ? AND S.departdate >= ? ";
                pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, destination);
                pstmt.setDate(2, sqlNowDate);
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }        
        }
       
      
       
       public void retreiveRecordsByBoth(String destination,String date) throws ParseException{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date parsed = format.parse(date);
       
          java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
             java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
         
           try{
               String query ="SELECT S.ScheduleID,S.BusID,S.Destination,B.Bustype,S.DepartDate,S.DepartTime,S.TicketPrice,S.Availableseat FROM busschedule S, bus B WHERE B.busid = S.busid AND Destination = ? AND DepartDate = ? AND S.departdate >= ?";
               pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, destination);
                pstmt.setDate(2,sqlDate);
                pstmt.setDate(3, sqlNowDate);
              
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
     
       public void getPreviousOrder(String saleID){
            //  java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
           String query = "SELECT T.ticketid,T.busid,S.destination,S.departdate,S.departtime,T.seatid "
                   + "FROM   BUSSCHEDULE S ,TICKET T "
                   + "WHERE S.scheduleid = T.scheduleid AND"
                   + " T.saleid = ? ";
           try{
                  pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, saleID);
                   rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
     
       public void getSaleDetail(String saleID){
              java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
           String query = "SELECT T.ticketid,S.scheduleid,T.busid,S.destination,S.departdate,S.departtime,T.seatid,S.ticketprice "
                   + "FROM   BUSSCHEDULE S ,TICKET T "
                   + "WHERE S.scheduleid = T.scheduleid AND"
                   + " T.saleid = ?";
           try{
                  pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, saleID);
                   rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
       
       public void retrieveExchangeTicket(String destination,String busType,String scheduleID){
              java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
               String query =" SELECT S.ScheduleID,S.BusID,S.Destination,B.Bustype,S.DepartDate,S.DepartTime,S.TicketPrice,S.Availableseat "
                       + "FROM BUSSCHEDULE S, BUS B "
                       + "WHERE B.BUSID = S.BUSID AND "
                       + "B.BUSTYPE = ? AND "
                       + "S.DESTINATION = ? AND S.departdate >= ? AND S.ScheduleID NOT IN(?) ";
                      
                    try{
           
               pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, busType);
                pstmt.setString(2,destination);
                pstmt.setDate(3, sqlNowDate);
                pstmt.setString(4, scheduleID);
              
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       
       }
       
        public void retrieveExchangeTicketByDate(String destination,String busType,String date,String scheduleID) throws ParseException{
               java.sql.Date sqlNowDate = new java.sql.Date(nowDate.getTime());
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date parsed = format.parse(date);
       
          java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
               String query =" SELECT S.ScheduleID,S.BusID,S.Destination,B.Bustype,S.DepartDate,S.DepartTime,S.TicketPrice,S.Availableseat "
                       + "FROM BUSSCHEDULE S, BUS B "
                       + "WHERE B.BUSID = S.BUSID AND "
                      + " B.BUSTYPE = ? AND "
                       + " S.DESTINATION = ? AND" 
                       + " S.DEPARTDATE = ? AND S.departdate >= ? AND S.ScheduleID NOT IN(?)";
                      
                    try{
           
               pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, busType);
                pstmt.setString(2,destination);
                pstmt.setDate(3, sqlDate);
                pstmt.setDate(4, sqlNowDate);
                pstmt.setString(5, scheduleID);
              
                rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       
       }
        
        public void testing(String date1,String date2) throws ParseException{
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date parsed1 = format.parse(date1);
            java.util.Date parsed2 = format.parse(date2);
       
          java.sql.Date sqlDate1 = new java.sql.Date(parsed1.getTime());
           java.sql.Date sqlDate2 = new java.sql.Date(parsed2.getTime());
          String query = "SELECT S.destination, S.busid, B.bustype, B.plateno, S.ticketprice, COUNT(T.ticketid) AS QUANTITY FROM BUS B,BUSSCHEDULE S,TICKET T,SALES A,PAYMENT P "
                  + "WHERE B.busid = S.busid AND S.scheduleid = T.scheduleid AND T.saleid = A.saleid AND A.saleid = P.saleid "
                  + "AND T.status = 'Sold' AND P.PAYDATE BETWEEN ? AND ? GROUP BY S.destination,S.busid,B.bustype,B.plateno,S.ticketprice ORDER BY S.destination";
                 try{
                  pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmt.setDate(1, sqlDate1);
                pstmt.setDate(2,sqlDate2);
                    rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                 }catch(SQLException ex){
               ex.printStackTrace();
           }
        }
        
          public void testing1(String date1,String date2) throws ParseException{
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date parsed1 = format.parse(date1);
            java.util.Date parsed2 = format.parse(date2);
       
          java.sql.Date sqlDate1 = new java.sql.Date(parsed1.getTime());
           java.sql.Date sqlDate2 = new java.sql.Date(parsed2.getTime());
       String query = "SELECT T.ticketid , S.destination , S.departdate , S.departtime , S.scheduleid , T.seatid , T.busid,S.ticketprice,B.plateno,COUNT(T.ticketid) FROM BUSSCHEDULE S,TICKET T,BUS B WHERE B.BUSID = S.BUSID AND S.SCHEDULEID = T.SCHEDULEID ";
                 try{
                  pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
         //       pstmt.setDate(1, sqlDate1);
            //    pstmt.setDate(2,sqlDate2);
                    rs = pstmt.executeQuery();
                metaData = rs.getMetaData();
                rs.last();
                numberOfRows = rs.getRow();
                fireTableStructureChanged();
                 }catch(SQLException ex){
               ex.printStackTrace();
           }
        }
       
       

        @Override
        public String getColumnName(int column){
            try{
                return metaData.getColumnName(column+1);
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }        
            return "";
        }
    
        @Override
        public int getRowCount(){
            return numberOfRows;
        
        }
   
        @Override
        public int getColumnCount(){
            try{
                return metaData.getColumnCount();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return 0;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            try{
                rs.absolute(rowIndex+1);
                return rs.getObject(columnIndex+1);
            }catch(SQLException ex){
            ex.printStackTrace();
            }
            return "";
        }
}
