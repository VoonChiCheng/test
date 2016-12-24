
package control;
import da.RouteDA;
import domain.Route;
import java.util.ArrayList;
public class MaintainRouteControl {
    private RouteDA RouteDA;
    
    public MaintainRouteControl() {
        RouteDA = new RouteDA();
    }
    
    public Route selectRecord(String Destination) {
        return RouteDA.getRecord(Destination);
    }
    
    public void addRecord(String Destination,String rtype,Double Price) 
    {
        RouteDA.addRecord(Destination, rtype, Price);
    }
    
    public void updateRecord(Route f) {
        RouteDA.updateRecord(f);
    }
    public void updateRecord2(Route f){
        RouteDA.updateRecord2(f);
    }
    public void getRecord(String Destination){
        RouteDA.getRecord(Destination);
    }
  public ArrayList<Route> getDestination(){
    return RouteDA.getDestination();
}
  public ArrayList<Route> getDestination2(){
    return RouteDA.getDestination2();
}
   public double getPrice(String destination,String rtype){
      return RouteDA.getPrice(destination,rtype);
  }
}
