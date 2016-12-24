
package control;
import da.StaffDA;
import domain.Staff;
import java.util.ArrayList;
import java.util.Date;

public class MaintainStaffControl {
    private StaffDA StaffDA;
    
    public MaintainStaffControl() {
        StaffDA = new StaffDA();
    }
    
    public Staff selectRecord(String StaffID) {
        return StaffDA.getRecord(StaffID);
    }
    
    public void addRecord(String StaffID,String Name,String IC,String Gender,Date DOB,String Address,String ContactNo,String Email,String Position,String Status,String Password,String Security,Integer QuestionNo) 
    {
        StaffDA.addRecord(StaffID,Name,IC,Gender,DOB,Address,ContactNo,Email,Position,Status,Password,Security,QuestionNo);
    }
    
    public void updateRecord(Staff f) {
        StaffDA.updateRecord(f);
    }
    public void updateStaffPasswordAndSecurity(Staff f){
        StaffDA.updateStaffPassowrdAndSecurity(f);
    }
    public void getRecord(String StaffID){
        StaffDA.getRecord(StaffID);
    }
    public void updateStaffPassword(Staff f){
        StaffDA.updateStaffPassowrd(f);
    }
  public ArrayList<Staff> getStaffID(){
    return StaffDA.getsStaffID();
}
}
