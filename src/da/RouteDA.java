/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Route;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author user
 */
public class RouteDA {
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    private String tableName = "Route";
    private Connection conn;
    private PreparedStatement stmt;
    
    public RouteDA() {
        createConnection();
    }
    
  public ArrayList<Route> getDestination(){
      String query = "SELECT * FROM ROUTE WHERE RTYPE = ? ORDER BY DESTINATION";
      ArrayList<Route> routeList=new ArrayList<Route>();
      
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          stmt.setString(1, "Normal");
          rs = stmt.executeQuery();
          while(rs.next()){
              routeList.add(new Route(rs.getString("Destination"),rs.getString("rtype"),rs.getDouble("PRICE")));
              
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
      System.out.println(routeList);
      return routeList;
  }
  public ArrayList<Route> getDestination2(){
      String query = "SELECT * FROM ROUTE WHERE RTYPE = ? ORDER BY DESTINATION";
      ArrayList<Route> routeList=new ArrayList<Route>();
      
      ResultSet rs =null;
      try{
          stmt=conn.prepareStatement(query);
          stmt.setString(1, "Exclusive");
          rs = stmt.executeQuery();
          while(rs.next()){
              routeList.add(new Route(rs.getString("Destination"),rs.getString("rtype"),rs.getDouble("PRICE")));
              
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
      System.out.println(routeList);
      return routeList;
  }
      public double getPrice(String destination,String rtype){
        String query="SELECT PRICE FROM ROUTE WHERE destination= ? AND RTYPE = ? ";
        ResultSet rs =null;
        double price =0;
        try{
            stmt=conn.prepareStatement(query);
            stmt.setString(1, destination);
            stmt.setString(2, rtype);
            rs =stmt.executeQuery();
            if(rs.next()){
                price=rs.getDouble("price");
                System.out.println(price);
            }
        }catch(SQLException ex){
            ex.getMessage();
        }
        return price;
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
//     public String displayAutomatedCode()
//     {
//         String lastRowCode="";
//         String subString="";
//         String newAutomatedCode="";
//         
//         try {
//            ResultSet rs=selectRecord();
//            rs.afterLast();
//            while(rs.previous())
//            {
//                lastRowCode=rs.getString("busid");
//                
//                break;
//            }
//            subString=lastRowCode.substring(1,lastRowCode.length());
//            int convertedSubString=Integer.parseInt(subString)+1;
//            newAutomatedCode="B"+String.format("%03d",convertedSubString);
//          
//             
//            } catch (SQLException ex) {
//                ex.getMessage();
//                
//            }
//         return newAutomatedCode;
//     }

    public void addRecord(String Destination,String rtype,Double price) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, Destination);
            stmt.setString(2, rtype);
            stmt.setDouble(3, price);
            
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Route getRecord(String Destination) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Destination = ? AND RTYPE = ? ";
        Route route = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, Destination);
            stmt.setString(2, "Normal");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                route = new Route(Destination, rs.getString("rtype"),rs.getDouble("PRICE"));
            }
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return route;
    }

    public void updateRecord(Route route) {
        try {
            String updateStr = "UPDATE " + tableName + " SET Price = ?" + " WHERE Destination = ? AND RTYPE = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setDouble(1, route.getprice());
            stmt.setString(2, route.getdestination());
            stmt.setString(3, "Normal");
            
            stmt.executeUpdate();
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void updateRecord2(Route route) {
        try {
            String updateStr = "UPDATE " + tableName + " SET Price = ?" + " WHERE Destination = ? AND RTYPE = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setDouble(1, route.getprice());
            stmt.setString(2, route.getdestination());
            stmt.setString(3, "Exclusive");
            
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
