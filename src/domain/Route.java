package domain;

import java.io.Serializable;

public class Route implements Serializable{
    private String destination;
    private String rtype;
    private Double price;
    public Route(){
        
    }
    
    public Route(String destination){
        this.destination=destination;
    }
    public Route(String destination,String rtype,Double price){
        this.destination=destination;
        this.rtype=rtype;
        this.price=price;
    }
    public String getdestination(){
        return destination;
    }
    public void setdestination(String destination){
        this.destination=destination;
    }
    public String getrtype(){
        return rtype;
    }
    public void setrtype(String rtype){
        this.rtype=rtype;
    }
    public Double getprice(){
        return price;
    }
    public void setprice(Double price){
        this.price=price;
    }
}