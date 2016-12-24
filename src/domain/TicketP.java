package domain;

import java.util.Date;

public class TicketP{
    private String ticketID;
    private String destination;
    private Date departDate;
    private String departTime;
    private String scheduleID;
    private String seatID;
    private String busID;
    private double price;
    private String plateNo;
   
    
    public TicketP(){
        
    }
    
    public TicketP(String ticketID,String destination,Date departDate,String departTime,String scheduleID,String seatID,String busID,double price,String plateNo){
        this.ticketID = ticketID;
        this.destination = destination;
        this.departDate = departDate;
        this.departTime = departTime;
        this.scheduleID = scheduleID;
        this.seatID = seatID;
        this.busID = busID;
        this.price = price;
        this.plateNo = plateNo;
      
    }
    
    public String getTicketID(){
        return ticketID;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public Date getDepartDate(){
        return departDate;
    }
    
    public String getDepartTime(){
        return departTime;
    }
    
    public String getScheduleID(){
        return scheduleID;
    }
    
    public String getSeatID(){
        return seatID;
    }
    
    public String getBusID(){
        return busID;
    }
            
    public double getPrice(){
        return price;
    }
            
            
    public String getPlateNo(){
        return plateNo;
    }
    
    
}