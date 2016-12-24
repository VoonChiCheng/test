
package control;
import da.BusDA;
import domain.Bus;
import java.util.ArrayList;
import java.util.Date;
public class MaintainBusControl {
    private BusDA BusDA;
    
    public MaintainBusControl() {
        BusDA = new BusDA();
    }
    
    public Bus selectRecord(String BusID) {
        return BusDA.getRecord(BusID);
    }
    
    public void addRecord(String BusID,String PlateNo,Integer Seat,String BusType,String Status,String Purchase) 
    {
        BusDA.addRecord(BusID, PlateNo, Seat, BusType, Status, Purchase);
    }
    
    public void updateRecord(Bus f) {
        BusDA.updateRecord(f);
    }
    public void getRecord(String BusID){
        BusDA.getRecord(BusID);
    }
  public ArrayList<Bus> getBusID(){
    return BusDA.getBusID();
}
  public ArrayList<Bus> getInServiceBusID(){
      return BusDA.getInServiceBusID();
  }
  public int getBusSeat(String BusID){
      return BusDA.getBusSeat(BusID);
  }
  public String getBusType(String BusID){
      return BusDA.getBusType(BusID);
  }
}
