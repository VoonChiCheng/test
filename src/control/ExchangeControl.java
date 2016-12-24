package control;

import da.ExchangeDA;
import domain.*;
import java.util.ArrayList;

public class ExchangeControl{
    private ExchangeDA exchangeDA;
    
    public ExchangeControl(){
        exchangeDA = new ExchangeDA();
    }
    
    public boolean checkTicketID(String ticketID){
        return exchangeDA.checkTicketID(ticketID);
    }
    
    public ETicket getTicketExchangeDetail(String ticketID){
        return exchangeDA.getTicketExchangeDetail(ticketID);
    }
    
    public String getBusType(String busID){
        return exchangeDA.getBusType(busID);
    }
    
     public Schedule getSchedule(String scheduleID){
         return exchangeDA.getSchedule(scheduleID);
     }
     
      public String getBusPlateNo(String busID){
        return exchangeDA.getBusPlateNo(busID);
    }
      
       public ArrayList<Ticket> checkSeatAvailablity(String scheduleID){
           return exchangeDA.checkSeatAvailablity(scheduleID);
       }
       
       public void updateExchangeTicketOld(String ticketID){
           exchangeDA.updateExchangeTicketOld(ticketID);
       }
       
       public void updateExchangeTicketNew(String saleID,String ticketID){
           exchangeDA.updateExchangeTicketNew(saleID, ticketID);
       }
       public String getSaleID(String ticketID){
           return exchangeDA.getSaleID(ticketID);
       }
       
        public ArrayList<TicketP> getTicket(String saleID){
            return exchangeDA.getTicket(saleID);
        }
        
        public int getOldSeatAvailability(String scheduleID){
            return exchangeDA.getOldSeatAvailability(scheduleID);
        }
         public int getNewSeatAvailability(String ticketID){
             return exchangeDA.getNewSeatAvailability(ticketID);
         }
         public void updateOldSeat(int seat,String scheduleID){
             exchangeDA.updateOldSeat(seat, scheduleID);
         }
         public void updateNewSeat(int seat,String scheduleID){
             exchangeDA.updateNewSeat(seat, scheduleID);
         }
         
         public void closeDB(){
             exchangeDA.shutDown();
         }
}