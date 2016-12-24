package ui;
import da.*;
import domain.*;
import control.*;
import control.MaintainBusScheduleControl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Calendar;
import javax.swing.JComponent;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;
import java.text.SimpleDateFormat;
import org.jdesktop.swingx.prompt.PromptSupport;


public class AddBusScheduleFrame extends JFrame{
    public static int count=0;
    public static String now(String dateformat){
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
        return sdf.format(cal.getTime());
    }
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    IDGenerator2 idGenerator = new IDGenerator2("T",4);
    private AddBusScheduleFrame thisFrame;
    BusScheduleDA scheduleDA=new BusScheduleDA();
    MaintainBusScheduleControl scheduleControl=new MaintainBusScheduleControl();
   MaintainRouteControl routeControl=new MaintainRouteControl();
    private ArrayList<Bus> busList=new ArrayList<Bus>();
    MaintainBusControl busControl=new MaintainBusControl();
    private DefaultComboBoxModel dcbomBusList=new DefaultComboBoxModel();
    private JComboBox jcbBusID=new JComboBox(dcbomBusList);
    
    private ArrayList<Route> routeList=new ArrayList<Route>();
//    private ArrayList<Route> routeList2=new ArrayList<Route>();
 
    private DefaultComboBoxModel dcbomRouteList=new DefaultComboBoxModel();
    JComboBox jcbDestination=new JComboBox(dcbomRouteList);
    
    
    TicketControl ticketControl=new TicketControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JXDatePicker datePick=new JXDatePicker();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfType=new JTextField();
    private JTextField jtfSchedule= new JTextField();
    private JTextField jtfTime= new JTextField();
    private JTextField jtfSeat= new JTextField();
    private JTextField jtfPrice= new JTextField();
//    private JTimeButton jtbTime=new JTimeButton();
    private JLabel jl1 =new JLabel("Please enter the new Bus Schedule Information");
    private JLabel jl2 =new JLabel("Schedule ID:");
    private JLabel jl3 =new JLabel("Bus ID:");
    private JLabel jl4 =new JLabel("Destination:");
    private JLabel jl5 =new JLabel("Available Seat:");
    private JLabel jl6 =new JLabel("Departure Date:");
    private JLabel jl7 =new JLabel("Departure Time(12-hour format):");
    private JLabel jl8 =new JLabel("Ticket Price(RM):");
    private JLabel jl9 =new JLabel("Bus Type");
    private DefaultComboBoxModel dcbomTimeList=new DefaultComboBoxModel();
    private JComboBox jcbTime= new JComboBox(dcbomTimeList);
    private ArrayList<String> TimeList=new ArrayList<String>();
    private ArrayList<String> busIDOnsameDate= new ArrayList<String>();
     private String position;
   private String staffID;
   public AddBusScheduleFrame(){}
public AddBusScheduleFrame(String position,String staffID){
    
     intiRouteComboBox();
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
    datePick.setFormats(dateFormat);
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(8, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfSchedule);
    jpCenter.add(jl4);
    jpCenter.add(jcbDestination);
    jpCenter.add(jl6);
   jpCenter.add(datePick);
    TimeList.add("06:00AM");
    TimeList.add("07:00AM");
    TimeList.add("08:00AM");
    TimeList.add("09:00AM");
    TimeList.add("10:00AM");
    TimeList.add("11:00AM");
    TimeList.add("12:00PM");
    TimeList.add("01:00PM");
    TimeList.add("02:00PM");
    TimeList.add("03:00PM");
    TimeList.add("04:00PM");
    TimeList.add("05:00PM");
    TimeList.add("06:00PM");
    TimeList.add("07:00PM");
    TimeList.add("08:00PM");
    TimeList.add("09:00PM");
    
     for(int i=0;i<TimeList.size();i++){
        dcbomTimeList.addElement(TimeList.get(i));
    } 
    
    jpCenter.add(jl7);
    jpCenter.add(jcbTime); 
    jpCenter.add(jl3);
    jpCenter.add(jcbBusID);
    jpCenter.add(jl9);
    jpCenter.add(jtfType);
    jpCenter.add(jl5);
    jpCenter.add(jtfSeat);
    jpCenter.add(jl8);
    jpCenter.add(jtfPrice);
//    jpCenter.add(new JLabel(""));
//    jpCenter.add(jtbTime);
    jtfSeat.setEditable(false);
    jtfSchedule.setEditable(false);
    jtfSchedule.setText(automatedCode());
   
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    
    jpNorth.setBackground(new Color(204,255,255));
 
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
    jl4.setFont(smallFont);
    jl5.setFont(smallFont);
    jl6.setFont(smallFont);
    jl7.setFont(smallFont);
    jl8.setFont(smallFont);
    jl9.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
    jtfPrice.setEditable(false);
    jtfType.setEditable(false);
    jbtConfirm.addActionListener(new ConfirmListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jcbBusID.addActionListener(new SeatListener());
   jcbBusID.addActionListener(new BusListener());
   jcbBusID.addActionListener(new TypeListener());
   jcbDestination.addActionListener(new PriceListener());
   datePick.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
if(datePick.getDate()==null)
{
    JOptionPane.showMessageDialog(null, "Please select date first before choose the bus.","WARNING",JOptionPane.WARNING_MESSAGE);
}else{
    if(count>=1){
        dcbomBusList.removeAllElements();
        jcbBusID.removeAllItems();
    }
     intiBusComboBox();
          count++;
}

}
});
   setTitle("Add New Bus Schedule");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
        setIcon();
      
}
 private void clearText() {
     jtfTime.setText("");
     jtfSeat.setText("");
     datePick.setDate(null);
     
    }
public String automatedCode(){
    String automatedCode="";
    automatedCode=scheduleDA.displayAutomatedCode();
    return automatedCode;
}
  private class ResetListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
    }}
  private class  BackListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
        thisFrame.dispose();
       
    }}
  private class BusListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          if(jcbBusID.getSelectedItem()!=null){
          String str=jcbBusID.getSelectedItem().toString();
          Bus bus=null;
          bus=busControl.selectRecord(str);
             intiRouteComboBox();
           }   
          }}
          

  private void intiRouteComboBox(){
    routeList=routeControl.getDestination();
    dcbomRouteList.removeAllElements();
//     int routeSize=routeList.size();
//     for(int i=0;i<routeSize;i++){
//    dcbomRouteList.removeElementAt(i);
//    }
    
    for(int j=0;j<routeList.size();j++){
        
        dcbomRouteList.addElement(routeList.get(j).getdestination());
    }
}

  private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
  private void intiBusComboBox(){
  
    Date sameDepDate=datePick.getDate();
    if(datePick.getDate()!=null)
    System.out.println(sameDepDate);
    java.sql.Date sqlDate =new java.sql.Date(sameDepDate.getTime());
    busIDOnsameDate=scheduleControl.selectBusIDbyDate(sqlDate);
    System.out.println(busIDOnsameDate);
    busList=busControl.getInServiceBusID();
    System.out.print(busList);
   
    for(int j=0;j<busList.size();j++){
        dcbomBusList.addElement(busList.get(j).getBusID());
        for(int i=0;i<busIDOnsameDate.size();i++){
            if(busIDOnsameDate.get(i).compareTo(busList.get(j).getBusID())==0){
                String str=busIDOnsameDate.get(i);
                Object obj=str;
                
                int index=dcbomBusList.getIndexOf(obj);
                System.out.println(index);
                if(index!=-1)
                {
                  dcbomBusList.removeElementAt(index);
                }
            }
        }
        
        
    }
   
} 
//  private class DateListener implements ActionListener{
//      public void actionPerforemd(ActionEvent e){
//         intiBusComboBox();
//     }
// }
   private class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String scheduleID = jtfSchedule.getText();
           SimpleDateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd");
           Date convertedDate =dateformat.parse(AddBusScheduleFrame.now("yyyy/MM/dd"));
            if(datePick.getDate() == null){
                 JOptionPane.showMessageDialog(null, "Please select the date.");
            }
            else if(datePick.getDate().compareTo(convertedDate)<0){
                JOptionPane.showMessageDialog(null, "Please select current or future date.","WARNING",JOptionPane.WARNING_MESSAGE);
            }
          
            else if(jcbBusID.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the bus ID.");
            }
            else if(jtfType.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the bus ID.");
            }
            else if(jcbDestination.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the destination.");
            }
            else if(jcbTime.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the time.");
            }
            else{
               scheduleControl.addRecord(scheduleID,jcbBusID.getSelectedItem().toString(),jcbDestination.getSelectedItem().toString(),Integer.parseInt(jtfSeat.getText()),datePick.getDate(),Double.parseDouble(jtfPrice.getText()),jtfType.getText(),jcbTime.getSelectedItem().toString());
           DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
           String ticketID="";
           String saleid="0";
           String schedule=jtfSchedule.getText();
           String ticketdate=dateFormat.format(datePick.getDate());
           
           String seatAlpha="A";
           String seatID="";
           String bus=jcbBusID.getSelectedItem().toString();
           for(int i=1;i<=Integer.parseInt(jtfSeat.getText());i++)
                {
              
                    String id=idGenerator.generateID();
                    seatID=seatAlpha+String.format("%02d", i);
                    ticketID=id+ticketdate;
//                  boolean valid=   
//                  boolean check = false;
//                  if(valid == true){
//                  do{
//                 Ticket ticket=new Ticket(ticketID,saleid,schedule,seatID,bus,"Available");
//               check = ticketControl.checkRepeatTicketID(ticketID);
//                
//              
//                  }while(check);
//                 }
                    ticketControl.addRecord(ticketID, saleid, schedule, seatID,bus,"Available");
                }
           
           JOptionPane.showMessageDialog(null, "New Bus Schedule added.");
              
           thisFrame.dispose();
            }

        }
    
        catch(ParseException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }}}
   private class SeatListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           if(jcbBusID.getSelectedItem()!=null){
           int i=0;
           i=busControl.getBusSeat(jcbBusID.getSelectedItem().toString());
           System.out.println(i);
           jtfSeat.setText(i+"");
       }}
   }
   private class TypeListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
          if(jcbBusID.getSelectedItem()!=null){ 
          String type=busControl.getBusType(jcbBusID.getSelectedItem().toString());
           jtfType.setText(type);
   }}}
   private class PriceListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           try{
           String str1=jcbDestination.getSelectedItem().toString();
           String str2="Normal";
           Route route=null;
           route=routeControl.selectRecord(str1);
           String str=jcbBusID.getSelectedItem().toString();
            double i=0;
            double j=20;
           i=routeControl.getPrice(str1,str2);
           System.out.println(i);
           
           if(busControl.selectRecord(str).getBusType().compareTo("Normal")==0){
               jtfPrice.setText(String.format("%.2f",i));
           }else{
                jtfPrice.setText(String.format("%.2f",i+j));
           }
       }catch(Exception ex){
           ex.getMessage();
       }
   }}
 
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new AddBusScheduleFrame();
}}



