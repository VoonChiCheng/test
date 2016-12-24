package ui;
import domain.*;
import control.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jdesktop.swingx.JXDatePicker;

public class OrderLink{
     public ArrayList<VSchedule> vs = new ArrayList<VSchedule>();
  
private OrderControl orderControl;
    public OrderLink(String StaffID,String Position){
        final String staffID = StaffID;
        final String position = Position;
        orderControl = new OrderControl();
        vs = orderControl.getVSchedule();
        new OrderFrame(0,"SA0",staffID,position,vs);
    }

    public static void main(String [] args){
       
         try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            OrderLink o = new OrderLink("S002","Staff");
          // new OrderLink("S002","Staff");
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
    }
}