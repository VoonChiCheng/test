package domain;

import java.util.Date;

public class Sale{
    private IDGenerator idGenerator;
    private String saleID;
    private String staffID;
    private Date saleDate;
    
    public Sale(){
        
    }
    
  public Sale(String saleID,String staffID,Date saleDate){
      this.saleID = saleID;
      this.staffID = staffID;
      this.saleDate = saleDate;
  }
    
   public Sale (String staffID){
         initIDGenerator();  
         this.saleID = idGenerator.generateIDByDate();
         this.staffID = staffID;
         this.saleDate = new Date();
    }
   
   public String getSaleID(){
       return saleID;
   }
   
   public String getStaffID(){
       return staffID;
   }
   
   public Date getSaleDate(){
       return saleDate;
   }
   
   public void setSaleID(String saleID){
       this.saleID = saleID;
   }
   
   public void setStaffID(String staffID){
       this.saleID = staffID;
   }
   
   public void setSaleDate(Date saleDate){
       this.saleDate = saleDate;
   }
    
   public void setAutoSaleID(){
       this.saleID = idGenerator.generateIDByDate();
   }
    
    
    private void initIDGenerator(){
        idGenerator = new IDGenerator("SA",4);
    } 
}