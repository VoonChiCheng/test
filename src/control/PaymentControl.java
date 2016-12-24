package control;

import da.*;
import domain.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class PaymentControl{
    private PaymentDA paymentDA;
    
    public PaymentControl(){
        paymentDA = new PaymentDA();
    }
    
    public double calTotalAmt(String saleID){
        return paymentDA.calTotalAmt(saleID);
    }
    
    public void createPaymentRecord(Payment pay){
        paymentDA.createPaymentRecord(pay);
    }
    
    public boolean checkRepeatPaymentID(String paymentID){
        return paymentDA.checkRepeatPaymentID(paymentID);
    }
    
    public double calChange(double totalAmt,double cash){
        return paymentDA.calChange(totalAmt, cash);
    }
    
    public int getQuantity(String saleID){
        return paymentDA.getQuantity(saleID);
    }
    
    public ArrayList<TicketP> getTicket(String saleID){
        return paymentDA.getTicket(saleID);
    }
    
    public void reverseSchedule(int seat,String scheduleID){
         paymentDA.reverseSchedule(seat,scheduleID);
     }
    
    public void reverseTicket(String saleID){
         paymentDA.reverseTicket(saleID);
     }
     public void deleteSale(String saleID){
        paymentDA.deleteSale(saleID);
     }
     
     public void closeDB(){
         paymentDA.shutDown();
     }
}