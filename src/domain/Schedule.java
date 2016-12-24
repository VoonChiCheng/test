package domain;

import java.util.Date;

public class Schedule{
    private String scheduleID;
    private String busID;
    private String destination;
    private Date departDate;
    private String departTime;
    private double ticketPrice;
    private int availableSeat;
    
    public Schedule(){
        this("xxx","xxx","xxx",0,new Date(),"xxx",0.00);
    }
    
    public Schedule(String scheduleID,String busID,String destination,int availableSeat,Date departDate,String departTime,double ticketPrice){
        this.scheduleID = scheduleID;
        this.busID = busID;
        this.destination = destination;
        this.departDate = departDate;
        this.departTime = departTime;
        this.ticketPrice = ticketPrice;
        this.availableSeat = availableSeat;
    }
    
    public String getScheduleID(){
        return scheduleID;
    }
    
    public String getBusID(){
        return busID;
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
    
    public double getTicketPrice(){
        return ticketPrice;
    }
    
    public int getAvailableSeat(){
        return availableSeat;
    }
    
    public void setScheduleID(String scheduleID){
        this.scheduleID = scheduleID;
    }
    
    public void setBusID(String busID){
        this.busID = busID;
    }
    
    public void setDestination(String destination){
        this.destination = destination;
    }
    
    public void setDepartDate(Date departDate){
        this.departDate = departDate;
    }
    
    public void setDepartTime(String departTime){
        this.departTime = departTime;
    }
    
    public void setTicketPrice(double ticketPrice){
        this.ticketPrice = ticketPrice;
    }
    
    public void setAvailableSeat(int availableSeat){
        this.availableSeat = availableSeat;
    }
}