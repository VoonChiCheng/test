
package control;
import da.BusScheduleDA;
import domain.BusSchedule;
import java.util.ArrayList;
import java.util.Date;
public class MaintainBusScheduleControl {
    private BusScheduleDA BusScheduleDA;
    
    public MaintainBusScheduleControl() {
        BusScheduleDA = new BusScheduleDA();
    }
    
    public BusSchedule selectRecord(String scheduleID) {
        return BusScheduleDA.getRecord(scheduleID);
    }
    
    public void addRecord(String scheduleID,String busID,String destination,Integer availableseat,Date departDate,Double ticketprice,String rtype,String departTime) 
    {
        BusScheduleDA.addRecord(scheduleID, busID, destination, availableseat, departDate, ticketprice, rtype, departTime);
    }
    
    public void getRecord(String scheduleID){
        BusScheduleDA.getRecord(scheduleID);
    }
  public ArrayList<BusSchedule> getBusScheduleID(){
    return BusScheduleDA.getBusScheduleID();
}
  public ArrayList<String> selectBusIDbyDate(Date sameDepDate){
      return BusScheduleDA.selectBusIDbyDate(sameDepDate);
  }
}
