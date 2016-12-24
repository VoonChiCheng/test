package domain;

public class Bus{
  private String BusID;
  private String PlateNo;
  private Integer TotalSeat;
  private String BusType;
  private String Purchase;
  private String status;
  
public Bus(){
  }

public Bus(String BusID){
    this.BusID=BusID;
}
public Bus( String BusID,
   String PlateNo,
   Integer TotalSeat,
  String BusType,
   String Purchase,String status){
    this.BusID=BusID;
    this.PlateNo=PlateNo;
    this.TotalSeat=TotalSeat;
    this.BusType=BusType;
    this.Purchase=Purchase;
    this.status=status;
}
public String getBusID(){
    return BusID;
}
public void setBusID(String BusID){
    this.BusID=BusID;
}
public String getPlateNo(){
    return PlateNo;
}
public void setPlateNo(String PlateNo){
    this.PlateNo=PlateNo;
}
public Integer getTotalSeat(){
    return TotalSeat;
}
public void setTotalSeat(Integer TotalSeat){
    this.TotalSeat=TotalSeat;
}
public String getBusType(){
    return BusType;
}
public void setBusType(String BusType){
    this.BusType=BusType;
}
public String getPurchase(){
    return Purchase;
}
public void setPurchase(String Purchase){
    this.Purchase=Purchase;
}
public String getStatus(){
    return status;
}
public void setStatus(String status){
    this.status=status;
}

}