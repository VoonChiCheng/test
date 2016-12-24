package ui;
import da.StaffTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.JXSearchField;
public class MaintainStaff extends JFrame{
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle=new JLabel("Maintain Staff");
    private JLabel jlbSearch=new JLabel("Search by Criteria:");
    private JButton jbtRetrieve=new JButton("Check In Detail");
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtRoute=new JButton("Route");
    private JButton jbtSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtExchange= new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtSearch = new JButton("Search");
    private JXSearchField jtfSearch=new JXSearchField();
     private JButton jbtRefresh = new JButton("Refresh");
    private TableRowSorter sorter;
    private StaffTableModel staffTable;
    private JTable tablemodel;
 JPanel jpNorth =new JPanel(new BorderLayout());
 JPanel jpNorthCenter=new JPanel();
 JPanel jpNorthLogo =new JPanel();
 JPanel jpCenter =new JPanel(new BorderLayout());
 JPanel jpSouth=new JPanel();
 JPanel jpCenterTop=new JPanel();
 JPanel jpCenterCenter=new JPanel();
 JPanel jpCenterSouth=new JPanel();
 private AddStaffFrame addFrame= null;
 private UpdateStaffFrame updateFrame=null;
// private RetrieveStaffFrame retrieveFrame=null;
// private MaintainBusSchedule scheduleFrame=null;
//   private MaintainRoute routeFrame=null;
//   private MaintainStaff thisFrame;
//   private ReportFrame reportFrame=null;
//   private TicketExchange ticketFrame=null;
//   private HomepageFrame homeFrame=null;
//   private MaintainBus busFrame=null;
 private String position;
   private String staffID;
   public MaintainStaff(){
     
 }
public MaintainStaff(String position,String staffID){
//           thisFrame=this;
    this.position=position;
    this.staffID=staffID;
     if(position.compareTo("Staff")==0){
        jbtBus.setEnabled(false);
        jbtStaff.setEnabled(true);
        jbtAdd.setEnabled(false);
        jbtUpdate.setEnabled(false);
        jbtRetrieve.setEnabled(true);
        jbtRoute.setEnabled(false);
        jbtSchedule.setEnabled(false);
        jbtReport.setEnabled(false);
    }else{
        jbtBus.setEnabled(true);
        jbtStaff.setEnabled(true);
        jbtRoute.setEnabled(true);
        jbtSchedule.setEnabled(true);
        jbtReport.setEnabled(true);
        jbtOrder.setEnabled(false);
        jbtExchange.setEnabled(false);
    }
    staffTable=new StaffTableModel();
    tablemodel=new JTable(staffTable);
    sorter = new TableRowSorter(staffTable);
    tablemodel.setRowSorter(sorter);
 
    jlbTitle.setFont(buttonFont);
    jlbSearch.setFont(buttonFont);
    jtfSearch.setPreferredSize(new Dimension(300,25));
    jpNorth.add(jpNorthLogo,BorderLayout.NORTH);
    jpNorth.add(jpNorthCenter,BorderLayout.CENTER);
    jpNorthLogo.add(jlblogo);
    jpNorthCenter.add(jbtHome);
    jpNorthCenter.add(jbtBus);
    jpNorthCenter.add(jbtStaff);
    jpNorthCenter.add(jbtRoute);
    jpNorthCenter.add(jbtSchedule);
    jpNorthCenter.add(jbtOrder);
    jpNorthCenter.add(jbtExchange);
    jpNorthCenter.add(jbtReport);
    jpCenter.add(jpCenterTop,BorderLayout.NORTH);
    jpCenter.add(jpCenterCenter,BorderLayout.CENTER);
    jpCenter.add(jpCenterSouth,BorderLayout.SOUTH);
    jpCenterTop.add(jlbTitle);
    jpCenterSouth.add(jbtRetrieve);
    jpCenterSouth.add(jbtAdd);
    jpCenterSouth.add(jbtUpdate);
     jpCenterSouth.add(jbtRefresh);

    
        tablemodel.setPreferredScrollableViewportSize(new Dimension(800, 150));
        tablemodel.setFillsViewportHeight(true);
        
        tablemodel.setBackground(new Color(204,255,255));
    JScrollPane scrollPane = new JScrollPane(tablemodel);
    jpCenterCenter.add(scrollPane);
    jpSouth.add(jlbSearch);
    jpSouth.add(jtfSearch);
    jpSouth.add(jbtSearch);
    
    jlbSearch.setHorizontalAlignment(JLabel.RIGHT);
    jpSouth.setBackground(new Color(204,255,255));
    jpCenter.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
    jpNorthCenter.setBackground(new Color(204,255,255));
    jpNorthLogo.setBackground(new Color(204,255,255));
    jpCenterTop.setBackground(new Color(204,255,255));
    jpCenterCenter.setBackground(new Color(204,255,255));
    jpCenterSouth.setBackground(new Color(204,255,255));
    add(jpNorth,BorderLayout.NORTH);
    add(jpCenter,BorderLayout.CENTER);
    add(jpSouth,BorderLayout.SOUTH);
    
        jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(204, 255, 255));
        jbtRoute.setBackground(new Color(77, 195, 255));
        jbtSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtAdd.setFont(smallFont);
        jbtUpdate.setFont(smallFont);
        jbtSearch.setFont(smallFont);
      jbtRetrieve.setFont(smallFont);
      jbtSearch.setFont(smallFont);
      jbtRefresh.setFont(smallFont);
      jbtRefresh.addActionListener(new RefreshListener());
     jbtAdd.addActionListener(new CreateListener());
   jbtUpdate.addActionListener(new UpdateListener());
   jbtRetrieve.addActionListener(new RetrieveListener());
   jbtSearch.addActionListener(new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        String text = jtfSearch.getText();
        if (text.trim().length() == 0)
          sorter.setRowFilter(null);
        else
          sorter.setRowFilter(RowFilter.regexFilter(text));
      }
    });   
      jbtBus.addActionListener(new BusListener());
//       jbtStaff.addActionListener(new StaffListener());
       jbtRoute.addActionListener(new RouteListener());
    jbtSchedule.addActionListener(new ScheduleListener());
       jbtReport.addActionListener(new ReportListener());
       jbtOrder.addActionListener(new OrderListener());
       jbtExchange.addActionListener(new ExchangeListener());
     jbtHome.addActionListener(new HomeListener());
   setIcon();
        setTitle("Maintain Staff");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
         addWindowListener(new WindowListener());

}
public void refreshTable(){
    staffTable.refreshTable();
}
private class RefreshListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        
        refreshTable();}}
 private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
//               thisFrame.dispose();
//                new LoginFrame();
//              
            }
            
        }
    }
private class CreateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtAdd){
                if(addFrame==null)
                    addFrame=new AddStaffFrame( position,staffID);
                if(!addFrame.isVisible())
                    addFrame.setVisible(true);
        }}}
private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtUpdate){
                if(updateFrame==null)
                    updateFrame=new UpdateStaffFrame( position, staffID);
                if(!updateFrame.isVisible())
                    updateFrame.setVisible(true);
        }}}
private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtRetrieve){
//                if(retrieveFrame==null)
//                    retrieveFrame=new RetrieveStaffFrame(position, staffID);
//                if(!retrieveFrame.isVisible())
//                    retrieveFrame.setVisible(true);
        }}}
private class BusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtBus){
//                if(busFrame==null)
//                    busFrame=new MaintainBus(position,staffID);
//                thisFrame.dispose();
//                if(!busFrame.isVisible())
//                    busFrame.setVisible(true);
        }}}
//private class StaffListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {                        
//            if(e.getSource()==jbtStaff){
//                if(staffFrame==null)
//                    staffFrame=new MaintainStaff(position,staffID);
//                thisFrame.dispose();
//                if(!staffFrame.isVisible())
//                    staffFrame.setVisible(true);
//        }}}
private class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtHome){
//                if(homeFrame==null)
//                    homeFrame=new HomepageFrame(position,staffID);
//                    thisFrame.dispose();
//                if(!homeFrame.isVisible())
//                    homeFrame.setVisible(true);
        }}}
private class RouteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtRoute){
//                if(routeFrame==null)
//                    routeFrame=new MaintainRoute(position,staffID);
//                thisFrame.dispose();
//                if(!routeFrame.isVisible())
//                    routeFrame.setVisible(true);
        }}}
private class ScheduleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtSchedule){
//                if(scheduleFrame==null)
//                    scheduleFrame=new MaintainBusSchedule(position,staffID);
//                thisFrame.dispose();
//                if(!scheduleFrame.isVisible())
//                    scheduleFrame.setVisible(true);
        }}}
private class ReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtReport){
//                if(reportFrame==null)
//                    reportFrame=new ReportFrame(position,staffID);
//                thisFrame.dispose();
//                if(!reportFrame.isVisible())
//                    reportFrame.setVisible(true);
        }}}
private class OrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            
//                new OrderLink(position,staffID);
//                thisFrame.dispose();
               
        }}
private class ExchangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtExchange){
//                if(ticketFrame==null)
//                    ticketFrame=new TicketExchange(position,staffID);
//                    thisFrame.dispose();
//                if(!ticketFrame.isVisible())
//                    ticketFrame.setVisible(true);
        }}}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new MaintainStaff("","");
    }
}