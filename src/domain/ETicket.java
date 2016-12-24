package domain;

public class ETicket{
    private String ticketID;
    private String scheduleID;
    private String busID;
    private String seatID;
    private String status;
    private String destination;
    private String saleID;
    
    
      public ETicket(){
         
     }
      
         public ETicket(String ticketID,String scheduleID,String busID,String seatID,String status,String destination,String saleID){
         this.ticketID = ticketID;
         
          this.scheduleID = scheduleID;
          this.seatID = seatID;
          this.busID = busID;
          this.status = status;
          this.destination = destination;
          this.saleID = saleID;
     }
     
    
     
    
     
     public String getTicketID(){
         return ticketID;
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
     
     public String getDestination(){
         return destination;
     }
     
     public String getSaleID(){
         return saleID;
     }
     
     public void setTicketID(String ticketID){
         this.ticketID = ticketID;
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
      
     
}