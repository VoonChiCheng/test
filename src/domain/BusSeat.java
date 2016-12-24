package domain;

import java.io.Serializable;

public class BusSeat implements Serializable{
    private String seatID;
    private String busID;
    
    public BusSeat(){
        
    }
    public BusSeat(String seatID){
        this.seatID=seatID;
    }
  
    public BusSeat(String seatID,String busID){
        this.seatID=seatID;
        this.busID=busID;
    }
    public String getseatID(){
        return seatID;
    }
    public void setseatID(String seatID){
        this.seatID=seatID;
                
    }
    public String getbusID(){
        return busID;
    }
    public void setbusID(String busID){
        this.busID=busID;
    }
    
}