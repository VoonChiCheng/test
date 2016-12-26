package ui;
import domain.VSchedule;
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
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXSearchField;
public class DailySalesFrame extends JFrame{
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle=new JLabel("Daily Sales Details Report");
    private JLabel jlbDate1 = new JLabel("Date:");
    private JTextField jtfDate1=new JTextField();
    private JLabel jlbDate2 = new JLabel("Till Date  :");
    private JTextField jtfDate2=new JTextField();
    private JButton jbtGenerate=new JButton("Generate!");
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
     private JButton jbtRoute=new JButton("Route");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtExchange= new JButton("Ticket Exchange");
    private JButton jbtReport= new JButton("Report");
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private JXDatePicker datePick1=new JXDatePicker();
     private JXDatePicker datePick2=new JXDatePicker();
     private  Calendar cal = Calendar.getInstance();
 
 JPanel jpNorth =new JPanel(new BorderLayout());
 JPanel jpNorthCenter=new JPanel();
 JPanel jpNorthLogo =new JPanel();
 JPanel jpCenter =new JPanel(new BorderLayout());
 JPanel jpSouth=new JPanel();
 JPanel jpCenterTop=new JPanel();
 JPanel jpCenterCenter=new JPanel(new GridLayout(3,1));
 JPanel jpCenterCenter1 = new JPanel();
 JPanel jpCenterCenter2 = new JPanel();
 JPanel jpCenterCenter3 = new JPanel();
 JPanel jpCenterSouth=new JPanel();
 
 
public DailySalesFrame(String StaffID,String Position){
    setIcon();
    final String staffID = StaffID;
    final String position = Position;
    
     if(position.compareTo("Staff") == 0){
            jbtBus.setEnabled(false);
         //   jbtStaff.setEnabled(false);
            jbtRoute.setEnabled(false);
            jbtSchedule.setEnabled(false);
            jbtReport.setEnabled(false);
        }else{
            jbtOrder.setEnabled(false);
            jbtExchange.setEnabled(false);
            
        }
    
    jlbTitle.setFont(buttonFont);
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
    
    datePick1.setFormats(dateFormat);
    datePick2.setFormats(dateFormat);
    jpCenterCenter.add(jpCenterCenter1);
    jpCenterCenter.add(jpCenterCenter2);
    jpCenterCenter.add(jpCenterCenter3);
   // jpCenterCenter1.add(jlbDate1);
 //   jpCenterCenter1.add(datePick1);
    jpCenterCenter2.add(jlbDate1);
    jpCenterCenter2.add(datePick1);
    
    jtfDate2.setEditable(false);
    jtfDate2.setColumns(10);
    jpCenterCenter3.add(new JLabel(""));
    jpCenterSouth.add(jbtGenerate);
    jpCenter.add(jpCenterTop,BorderLayout.NORTH);
    jpCenter.add(jpCenterCenter,BorderLayout.CENTER);
    jpCenter.add(jpCenterSouth,BorderLayout.SOUTH);
    jpCenterTop.add(jlbTitle);
    jpCenterCenter1.setBackground(new Color(204,255,255));
    jpCenterCenter2.setBackground(new Color(204,255,255));
    jpCenterCenter3.setBackground(new Color(204,255,255));
    
    
    datePick1.setFont(smallFont);
    
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
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77, 195, 255));
        jbtSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(204, 255, 255));
        
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtGenerate.setFont(smallFont);
        jlbDate1.setFont(smallFont);
       jlbDate2.setFont(smallFont);
        setTitle("Generate Daily Sales Details Report");    
         addWindowListener(new WindowListener());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,550);
        setLocationRelativeTo(null);
        setVisible(true);
        
                     jbtHome.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               dispose();
//                   new HomepageFrame(position,staffID);
            }
            }
           
       });
       
        jbtBus.addActionListener(new ActionListener()
       {
  @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             dispose();
//                    new MaintainBus(position,staffID);
            }
            }
           
       });
         jbtStaff.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
              dispose();
                    new MaintainStaff(position,staffID);
            }
            }
           
       });
          jbtRoute.addActionListener(new ActionListener()
       {

             @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               dispose();
//                    new MaintainRoute(position,staffID);
            }
            }
           
       });
           jbtSchedule.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             dispose();
//                    new MaintainBusSchedule(position,staffID);
            }
            }
           
       });
            jbtOrder.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                 ArrayList<VSchedule> vs = null;
                   dispose();
                   new OrderLink(staffID,position);
              
            }
            }
           
       });
             jbtExchange.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             
                   dispose();
//                   new TicketExchange(staffID,position);
           
            }
            }
           
       });
              jbtReport.addActionListener(new ActionListener()
       {

         @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             dispose();
//                    new ReportFrame(position,staffID);
            }
            }
           
       });
        
        jbtGenerate.addActionListener(new ActionListener()
        {

        @Override
        public void actionPerformed(ActionEvent e) {
             String host = "jdbc:derby://localhost:1527/finalyear";
           String user = "finalyear";
            String password = "finalyear";
            Connection conn = null;
              String date1 = dateFormat.format(datePick1.getDate());
              JFileChooser chooser = new JFileChooser();
               chooser.setCurrentDirectory(new java.io.File("."));
               //System.out.println(chooser.getCurrentDirectory());
              // String reportSource ="./reportTemplates/DailySaleDetailReport.jrxml";
             //  String reportSource = chooser.getCurrentDirectory() + "\\src\\reportTemplates\\DailySaleDetailReport.jrxml";
             // String reportSource = "reportTemplates\\DailySaleDetailReport.jrxml";
            String reportSource ="D:\\FYP\\FYP\\src\\reportTemplates\\DailySaleDetailReport.jrxml";
              //String reportSource =".\\reportTemplates\\DailySaleDetailReport.jrxml";
             
           // String test;
           // test = ".\\reportTemplates\\DailySaleDetailReport";
            Map<String,Object> params = new HashMap<String,Object>();
            HashMap parameter = new HashMap();
            parameter.put("parameter1", date1);
            
            try {	 
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection(host, user, password);
               JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
      JasperViewer.viewReport(jasperPrint, false); 
      
            }catch (JRException jrex) {
            JOptionPane.showMessageDialog(null, "error in generating report");
  	      jrex.printStackTrace();
      }  catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Unble to generate report~!");
	      ex.printStackTrace();
      }


            
            
              
        }
            
        });
        
    
        
     
        
}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new DailySalesFrame("S002","Manager");
    }
 private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//                new LoginFrame();
            }
            
        }
    }
 private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}