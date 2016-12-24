package control;
import da.TicketDA;
import domain.Ticket;
public class TicketControl {
    private TicketDA TicketDA;
    
    public TicketControl() {
        TicketDA = new TicketDA();
    }
    
    public void addRecord(String ticketID,String saleID,String scheduleID,String seatID,String busID,String status) {
        TicketDA.addRecord(ticketID, saleID, scheduleID, seatID, busID, status);
    }
    public boolean checkRepeatTicketID(String ticketID){
        return TicketDA.checkRepeatTicketID(ticketID);
    }
   
}