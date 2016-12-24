package control;
import da.BusSeatDA;
import domain.BusSeat;
public class BusSeatControl {
    private BusSeatDA BusSeatDA;
    
    public BusSeatControl() {
        BusSeatDA = new BusSeatDA();
    }
    
    public void addRecord(String SeatID,String BusID) {
        BusSeatDA.addRecord(SeatID,BusID);
    }
    
   
}