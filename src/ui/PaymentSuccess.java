package ui;

import domain.Receipt;
import control.*;
import domain.TicketP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class PaymentSuccess extends JFrame{
    
       private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
     PaymentControl paymentControl;
         private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle = new JLabel("Payment Success!! Choose the following option : ");
    private JButton jbtReceipt = new JButton("Generate Receipt");
    private JButton jbtTicket = new JButton("Generate Bus Ticket");
    private JButton jbtHome = new JButton("Back to Home Page");
    private JPanel jpTop = new JPanel(new BorderLayout());
    private JPanel jpTopTop = new JPanel( );
    private JPanel jpTopCenter = new JPanel();
    private JPanel jpCenter = new JPanel(new GridLayout(5,1));
    private JPanel jpWest = new JPanel(new GridLayout(1,6));
    private JPanel jpEast = new JPanel(new GridLayout(1,6));
    private JPanel jpSouth = new JPanel(new GridLayout(6,1));
    private JLabel space = new JLabel(" ");
     private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    
    public PaymentSuccess(Receipt R,ArrayList<TicketP> T,String StaffID,String Position){
        setIcon();
        paymentControl = new PaymentControl();
        final ArrayList<TicketP> t = T;
        final Receipt r = R;
        final String staffID = StaffID;
    final String position = Position;
        add(jpTop,BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
        add(jpWest,BorderLayout.WEST);
        add(jpEast,BorderLayout.EAST);
        add(jpSouth,BorderLayout.SOUTH);
        jpTop.add(jpTopTop,BorderLayout.NORTH);
        jpTop.add(jpTopCenter,BorderLayout.CENTER);
        jpTopTop.add(jlblogo);
        jpTopCenter.add(jlbTitle);
        jpCenter.add(jbtReceipt);
        jpCenter.add(new JLabel(" "));
        jpCenter.add(jbtTicket);
        jpCenter.add(new JLabel(" "));
        jpCenter.add(jbtHome);
        jpWest.add(new JLabel("                                                                               "));
        jpEast.add(new JLabel("                                                                                "));
        jpSouth.add(space);
       // space.setFont(smallFont);
        jlbTitle.setFont(largeFont);
        jbtReceipt.setFont(smallFont);
        jbtTicket.setFont(smallFont);
        jbtHome.setFont(smallFont);
        jpTopTop.setBackground(new Color(204,255,255));
        jpTopCenter.setBackground(new Color(204,255,255));
        jpCenter.setBackground(new Color(204,255,255));
        jpEast.setBackground(new Color(204,255,255));
        jpWest.setBackground(new Color(204,255,255));
        jpSouth.setBackground(new Color(204,255,255));
        
        jbtReceipt.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                  JFrame frame = new JFrame();
//              PaymentReceipt p = new PaymentReceipt(r,t);
//               JScrollPane scrollpane1  = new JScrollPane(p);
//             frame.add(scrollpane1);
              //   frame.add(p);
                 
             frame.setTitle("Payment Receipt");
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           
     
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
            }
            
        });
        
           jbtTicket.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
               JFrame frame1 = new JFrame();
//           TicketFrame f = new TicketFrame(t);
           
//          JScrollPane scrollpane = new JScrollPane(f);
//           frame1.add(f);
//           frame1.add(scrollpane);
         frame1.setTitle("Ticket");
           frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame1.setSize(700,800);
         frame1.setLocationRelativeTo(null);
          frame1.setVisible(true);
            }
            
        });
        
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
        addWindowListener(new WindowListener());
        setTitle("Success Payment");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args){
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
             // new PaymentSuccess();
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
       
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
       private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//                new LoginFrame();
                paymentControl.closeDB();
            }
            
        }
    }
}