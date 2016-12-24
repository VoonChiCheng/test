package domain;

import java.util.Date;

public class Payment{
  private IDGenerator idGenerator;
  private String paymentID;
  private String saleID;
  private String payType;
  private String ccNumber;
  private Date payDate;
  private double totalAmt;
    
public Payment(){
    
}

public Payment(String saleID,String payType,String ccNumber,double totalAmt){
     initIDGenerator();  
     this.paymentID = idGenerator.generateIDByDate();
     this.saleID = saleID;
     this.payType = payType;
     this.ccNumber = ccNumber;
     this.payDate = new Date();
     this.totalAmt = totalAmt;
}

public String getPaymentID(){
    return paymentID;
}

public String getSaleID(){
    return saleID;
}

public String getPayType(){
    return payType;
}

public String getCCNumber(){
    return ccNumber;
}

public Date getPayDate(){
    return payDate;
}

public double getTotalAmt(){
    return totalAmt;
}

public void setPaymentID(String paymentID){
    this.paymentID = paymentID;
}

public void setSaleID(String saleID){
    this.saleID = saleID;
}

public void setPayType(String payType){
    this.payType = payType;
}

public void setCCNumber(String ccNumber){
    this.ccNumber = ccNumber;
}

public void setPayDate(Date payDate){
    this.payDate = payDate;
}

public void setTotalAmt(double totalAmt){
    this.totalAmt = totalAmt;
}



private void initIDGenerator(){
        idGenerator = new IDGenerator("PA",4);
    } 

}
  
  
  

