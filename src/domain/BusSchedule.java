package domain;


import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class BusSchedule implements Serializable{
    private String scheduleID;
    private String busID;
    private String destination;
    private Integer availableseat;
    private Date departDate;
    private String departTime;
    private Double ticketPrice;
    private String rtype;
    
    public BusSchedule(){
        
    }
    public BusSchedule(String scheduleID){
        this.scheduleID=scheduleID;
    }
    public BusSchedule(
     String scheduleID,
     String busID,
     String destination,
     Integer availableseat,
     Date departDate,
      Double ticketPrice,
      String rtype,
    String departTime
    ){
        this.scheduleID=scheduleID;
        this.busID=busID;
        this.destination=destination;
        this.availableseat=availableseat;
        this.departDate=departDate;
        this.departTime=departTime;
        this.ticketPrice=ticketPrice;
        this.rtype=rtype;
        
    }
    public String getScheduleID(){
        return scheduleID;
    }
    public void setScheduleID(String scheduleID){
        this.scheduleID=scheduleID;
    }
    public String getBusID(){
        return busID;
    }
    public void setBusID(String busID){
        this.busID=busID;
    }
    public String getrtype(){
        return rtype;
    }
    public void setrtype(String rtype){
        this.rtype=rtype;
    }
   
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }
    public Integer getAvailableSeat(){
        return availableseat;
    }
    public void setAvailableSeat(Integer availableseat){
        this.availableseat=availableseat;
    }
    public Date getdepartDate(){
    return departDate;
    }
    public void setdepartDate(Date departDate){
        this.departDate=departDate;
    }
    public String getdepartTime(){
        return departTime;
    }
    public void setdepartTime(String departTime){
        this.departTime=departTime;
    }
    public Double getticketPrice(){
        return ticketPrice;
    }
    public void setticketPrice(Double ticketPrice){
        this.ticketPrice=ticketPrice;
    }
}