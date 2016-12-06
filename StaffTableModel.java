package da;
import java.sql.*;
import javax.swing.table.*;

public class StaffTableModel extends AbstractTableModel{
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String host = "jdbc:derby://localhost:1527/finalyear";
    private String user = "finalyear";
    private String password = "finalyear";
    
    public StaffTableModel(){
        try{
            String query = "SELECT StaffID AS \"Staff ID\", Name AS \"Name\", position AS \"Position\", status AS \"Status\", IC AS \"IC\", gender AS \"Gender\", DOB AS \"Date of Birth\", Contactno AS \"Contact No\", email AS \"Email\", address AS \"Address\" FROM Staff";
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();
            rs.last();
            numberOfRows = rs.getRow();
            fireTableStructureChanged();
            
        }catch(SQLException ex){
            ex.printStackTrace();   
        }
    }
 public void refreshTable(){
    try{
            String query = "SELECT StaffID AS \"Staff ID\", Name AS \"Name\", position AS \"Position\", status AS \"Status\", IC AS \"IC\", gender AS \"Gender\", DOB AS \"Date of Birth\", Contactno AS \"Contact No\", email AS \"Email\", address AS \"Address\" FROM Staff";
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
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