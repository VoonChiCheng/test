package domain;

public class Ticket{
     private IDGenerator idGenerator;
     private String ticketID;
     private String saleID;
     private String scheduleID;
     private String seatID;
     private String busID;
     private String status;
     
     public Ticket(){
         
     }
     
     public Ticket(String ticketID,String saleID,String scheduleID,String seatID,String busID,String status){
         this.ticketID = ticketID;
           this.saleID = saleID;
          this.scheduleID = scheduleID;
          this.seatID = seatID;
          this.busID = busID;
          this.status = status;
     }
     
     public Ticket(String saleID,String scheduleID,String seatID,String busID,String status){
          initIDGenerator();  
          this.ticketID = idGenerator.generateIDByDate();
          this.saleID = saleID;
          this.scheduleID = scheduleID;
          this.seatID = seatID;
          this.busID = busID;
          this.status = status;
     }
     
    
     
     public String getTicketID(){
         return ticketID;
     }
     
     public String getSaleID(){
         return saleID;
     }
     
     public String getScheduleID(){
         return scheduleID;
     }
     
     public String getSeatID(){
         return seatID;
     }
     
     public String getStatus(){
         return status;
     }
     
     public String getBusID(){
         return busID;
     }
     
     public void setTicketID(String ticketID){
         this.ticketID = ticketID;
     }
     
     public void setAutoTicketID(){
         this.ticketID = idGenerator.generateIDByDate();
     }
     
     public void setSaleID(String saleID){
         this.saleID = saleID;
     }
     
     public void setScheduleID(String scheduleID){
         this.scheduleID = scheduleID;
     }
     
     public void setSeatID(String seatID){
         this.seatID = seatID;
     }
     
     public void setStatus(String status){
         this.status = status;
     }
     
     public void setBusID(String busID){
         this.busID = busID;
     }
     
       private void initIDGenerator(){
        idGenerator = new IDGenerator("T",4);
    } 
}