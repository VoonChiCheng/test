package domain;

public class VSchedule{
    private String scheduleID;
    private int totalSeat;
    
    public VSchedule(){
        this("xxx",0);
    }
    
    public VSchedule(String scheduleID,int totalSeat){
        this.scheduleID = scheduleID;
        this.totalSeat = totalSeat;
    }
    
    public String getScheduleID(){
        return scheduleID;
    }
    
    public int getTotalSeat(){
        return totalSeat;
    }
}