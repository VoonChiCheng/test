package domain;

import java.io.Serializable;
import java.util.Objects;
import java.text.DateFormat;
import java.util.Date;

public class Staff implements Serializable {
private String StaffID;
private String Name;
private String IC;
private String gender;
private Date DOB;
private String address;
private String contactno;
private String email;
private String position;
private String status;
private String password;
private String security;
private Integer questionno;

public Staff(){
}
public Staff(String StaffID){
     this.StaffID = StaffID;
}
public Staff(String StaffID,String Name,String IC,String gender,Date DOB,String address,String contactno,String email,String position,String status,String password,String security,Integer questionno){
    this.StaffID=StaffID;
    this.Name=Name;
    this.IC=IC;
    this.gender=gender;
    this.DOB=DOB;
    this.address=address;
    this.contactno=contactno;
    this.email=email;
    this.position=position;
    this.status=status;
    this.password=password;
    this.security=security;
    this.questionno=questionno;
}
public String getStaffID(){
    return StaffID;
}
public void setStaffID(String StaffID){
    this.StaffID=StaffID;
}
public String getName(){
    return Name;
}
public void setName(String Name){
    this.Name=Name;
}
public String getIC(){
    return IC;
}
public void setIC(String IC){
    this.IC=IC;
}
public String getGender(){
    return gender;
}
public void setGender(String gender){
    this.gender=gender;
}
public Date getDOB(){
    return DOB;
}
public void setDOB(Date DOB){
    this.DOB=DOB;
}
public String getAddress(){
    return address;
}
public void setAddress(String address){
    this.address=address;
}
public String getContactno(){
    return contactno;
}
public void setContactno(String contactno){
    this.contactno=contactno;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email=email;
}
public String getPosition(){
    return position;
}
public void setPosition(String position){
    this.position=position;
}
public String getStatus(){
    return status;
}
public void setStatus(String status){
    this.status=status;
}
public String getPassword(){
    return password;
}
public void setPassword(String password){
    this.password=password;
}
public String getSecurity(){
    return security;
}
public void setSecurity(String security){
    this.security=security;
}
public Integer getQuestionno(){
    return questionno;
}
public void setQuestionno(Integer questionno){
    this.questionno=questionno;
}
}