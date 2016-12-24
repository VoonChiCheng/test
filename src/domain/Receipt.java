package domain;

import domain.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;


public class Receipt{
    private String saleID;
    private Date date;
    private String paymentID;
    private int quantity;
    private double totalAmount;
    private double change;
    private String payMethod;
    private double amtPaid;
    
    public Receipt(){
        
    }
    
    public Receipt(String saleID,Date date,String paymentID,int quantity,double totalAmount,double change,String payMethod,double amtPaid){
        this.saleID = saleID;
        this.date = date;
        this.paymentID = paymentID;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.change = change;
        this.payMethod = payMethod;
        this.amtPaid = amtPaid;
        
    }
    
    public String getSaleID(){
        return saleID;
    }
    
   public Date getDate(){
       return date;
   }
   public String getPaymentID(){
       return paymentID;
    }
   public int getQuantity(){
       return quantity;
   }
   
   public double getTotalAmount(){
       return totalAmount;
   }
 
   public double getChange(){
       return change;
   }
   
   public String getPayMethod(){
       return payMethod;
   }
   
   public double getAmtPaid(){
       return amtPaid;
   }
} 