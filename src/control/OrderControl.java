package control;

import da.*;
import domain.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class OrderControl{
    private OrderDA orderDA;
    
    public OrderControl(){
        orderDA = new OrderDA();
    }
  
    public ArrayList<Route> getRouteList(){
        return orderDA.getRouteList();
    }
    
    public Schedule getSchedule(String scheduleID){
        return orderDA.getSchedule(scheduleID);
    }
    
    public String getBusPlateNo(String busID){
        return orderDA.getBusPlateNo(busID);
    }
    
    public ArrayList<Ticket> checkSeatAvailability(String scheduleID){
        return orderDA.checkSeatAvailablity(scheduleID);
    }
    
    public void updateTicket(String saleID,ArrayList<Ticket> ticket,int i){
        orderDA.updateTicket(saleID,ticket,i);
    }
    
    public boolean checkRepeatSaleID(String saleID){
        return orderDA.checkRepeatSaleID(saleID);
    }
    public void updateTicketSeat(int availableSeat,String scheduleID){
        orderDA.updateTicketSeat(availableSeat, scheduleID);
    }
    public void createSaleRecord(String saleID,String staffID,Date date ){
        orderDA.createSaleRecord(saleID, staffID, date);
    }
    public Sale getSale(String saleID){
       return  orderDA.getSale(saleID);
    }
    public Bus checkBusType(String busID){
        return orderDA.checkBusType(busID);
    }
    
     public ArrayList<VSchedule> getVSchedule(){
         return orderDA.getVSchedule();
     }
     
     public void reverseSchedule(int seat,String scheduleID){
         orderDA.reverseSchedule(seat,scheduleID);
     }
     public void reverseTicket(String saleID){
         orderDA.reverseTicket(saleID);
     }
     public void deleteSale(String saleID){
         orderDA.deleteSale(saleID);
     }
     
     public void closeDB(){
         orderDA.shutDown();
     }
}
