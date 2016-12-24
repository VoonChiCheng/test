package ui;

import control.OrderControl;

import domain.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.*;

public class MultipleOrderConfirmation extends JFrame{
    
    public Sale sale = null;
    private JButton jbtYes = new JButton("Payment");
    private JButton jbtNo = new JButton("More Order");
    private JLabel jlbConfirm = new JLabel("Process to payment or go to next order?");
    private Font largeFont = new Font("Serif", Font.PLAIN, 20);
    private JButton jbtBack = new JButton("Back");
     private Font font = new Font("Serif", Font.BOLD, 23);
     private OrderControl orderControl;
    public int seat = 0;
   
    
    public MultipleOrderConfirmation(Schedule Schedule,int Valid,String SaleID,int[] Array,ArrayList<Ticket> Ticket,String StaffID,String Position,ArrayList<VSchedule> VS){
        
        setIcon();
        final String position = Position;
        final ArrayList<VSchedule> vs = VS;
        final String staffID = StaffID;
       final String saleID = SaleID;
       final int valid = Valid;
       final Schedule schedule = Schedule;
       final int[] array = Array;
       final ArrayList<Ticket> ticket = Ticket;
       orderControl = new OrderControl();
        JPanel jpCenter = new JPanel();
        jpCenter.setLayout(new FlowLayout());
        jlbConfirm.setFont(font);
        jpCenter.add(jlbConfirm);
        add(jpCenter, BorderLayout.CENTER);
        
         
        
        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtYes);
        jpSouth.add(jbtNo);
        jpSouth.add(jbtBack);
        add(jpSouth, BorderLayout.SOUTH);
        jbtYes.setFont(largeFont);
        jbtNo.setFont(largeFont);
        jbtBack.setFont(largeFont);
        
        /*  jbtBack.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OrderFrame(valid,saleID,staffID);
            }
            
        });*/
        jbtYes.setMnemonic(KeyEvent.VK_P);
        jbtNo.setMnemonic(KeyEvent.VK_M);
        jbtBack.setMnemonic(KeyEvent.VK_B);
        
      
        jbtYes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                
                       boolean check = false;
                 if(valid == 0){
                  do{
                 sale = new Sale(staffID);
               check = orderControl.checkRepeatSaleID(sale.getSaleID());
                
              
                  }while(check);
                 }
                 
             if(valid == 0){
                   java.sql.Date sqlDate = new java.sql.Date(sale.getSaleDate().getTime());
             //  java.sql.Date sqlDate = new java.sql.Date(sale.getSaleDate().getTime());
                  orderControl.createSaleRecord(sale.getSaleID(),sale.getStaffID(),sqlDate);
                  if(array[0] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 0);
            seat ++;
           }
        if(array[1] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 1);
            seat ++;
        }
        if(array[2] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 2);
            seat ++;
        }
        if(array[3] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 3);
            seat ++;
        }
        if(array[4] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 4);
            seat ++;
        }
        if(array[5] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 5);
            seat ++;
        }
        if(array[6] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 6);
            seat ++;
        }
        if(array[7] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 7);
            seat ++;
        }
        if(array[8] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 8);
            seat ++;
        }
        if(array[9] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 9);
             seat ++;
        }
        if(array[10] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 10);
             seat ++;}
        if(array[11] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 11);
             seat ++;
        }
        if(array[12] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 12);
             seat ++;
        }
        if(array[13] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 13);
             seat ++;
        }
        if(array[14] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 14);
             seat ++;
        }
        if(array[15] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 15);
             seat ++;
        }
        if(array[16] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 16);
             seat ++;
        }
        if(array[17] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 17);
             seat ++;
        }
        if(array[18] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 18);
             seat ++;
        }
        if(array[19] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 19);
             seat ++;
        }
        if(array[20] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 20);
             seat ++;
        }
        if(array[21] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 21);
             seat ++;
        }
        if(array[22] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 22);
             seat ++;
        }
        if(array[23] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 23);
             seat ++;
        }
        if(array[24] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 24);
             seat ++;
        }
        if(array[25] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 25);
             seat ++;
        }
        if(array[26] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 26);
             seat ++;
        }
        if(array[27] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 27);
             seat ++;
        }
        if(array[28] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 28);
         seat ++;
        }
        if(array[29] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 29);
             seat ++;
        }
        if(array[30] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 30);
             seat ++;
        }
        if(array[31] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 31);
             seat ++;
        }
        
             int totalSeat = schedule.getAvailableSeat() - seat;
        orderControl.updateTicketSeat(totalSeat, schedule.getScheduleID());
                dispose();
//                new PaymentFrame(schedule,valid,sale.getSaleID(),array,ticket,staffID,position,vs);
            }
              else if(valid ==1){
                 Sale sale1 = orderControl.getSale(saleID);
                if(array[0] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 0);
            seat ++;
           }
        if(array[1] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 1);
            seat ++;
        }
        if(array[2] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 2);
            seat ++;
        }
        if(array[3] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 3);
            seat ++;
        }
        if(array[4] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 4);
            seat ++;
        }
        if(array[5] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 5);
            seat ++;
        }
        if(array[6] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 6);
            seat ++;
        }
        if(array[7] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 7);
            seat ++;
        }
        if(array[8] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 8);
            seat ++;
        }
        if(array[9] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 9);
             seat ++;
        }
        if(array[10] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 10);
             seat ++;}
        if(array[11] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 11);
             seat ++;
        }
        if(array[12] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 12);
             seat ++;
        }
        if(array[13] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 13);
             seat ++;
        }
        if(array[14] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 14);
             seat ++;
        }
        if(array[15] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 15);
             seat ++;
        }
        if(array[16] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 16);
             seat ++;
        }
        if(array[17] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 17);
             seat ++;
        }
        if(array[18] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 18);
             seat ++;
        }
        if(array[19] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 19);
             seat ++;
        }
        if(array[20] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 20);
             seat ++;
        }
        if(array[21] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 21);
             seat ++;
        }
        if(array[22] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 22);
             seat ++;
        }
        if(array[23] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 23);
             seat ++;
        }
        if(array[24] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 24);
             seat ++;
        }
        if(array[25] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 25);
             seat ++;
        }
        if(array[26] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 26);
             seat ++;
        }
        if(array[27] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 27);
             seat ++;
        }
        if(array[28] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 28);
         seat ++;
        }
        if(array[29] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 29);
             seat ++;
        }
        if(array[30] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 30);
             seat ++;
        }
        if(array[31] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 31);
             seat ++;
        }
        
           int totalSeat = schedule.getAvailableSeat() - seat;
        orderControl.updateTicketSeat(totalSeat, schedule.getScheduleID());
        dispose();
//          new PaymentFrame(schedule,valid,/*sale.getSaleID()*/saleID,array,ticket,staffID,position,vs);
             
              }}
        });
        
        jbtNo.addActionListener(new ActionListener()
        {
               public void actionPerformed(ActionEvent e){
                   
                       boolean check = false;
                 if(valid == 0){
                  do{
                 sale = new Sale(staffID);
               check = orderControl.checkRepeatSaleID(sale.getSaleID());
                
              
                  }while(check);
                 }
                 
             if(valid == 0){
                   java.sql.Date sqlDate = new java.sql.Date(sale.getSaleDate().getTime());
             //  java.sql.Date sqlDate = new java.sql.Date(sale.getSaleDate().getTime());
                  orderControl.createSaleRecord(sale.getSaleID(),sale.getStaffID(),sqlDate);
             
           
           if(array[0] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 0);
            seat ++;
           }
        if(array[1] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 1);
            seat ++;
        }
        if(array[2] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 2);
            seat ++;
        }
        if(array[3] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 3);
            seat ++;
        }
        if(array[4] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 4);
            seat ++;
        }
        if(array[5] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 5);
            seat ++;
        }
        if(array[6] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 6);
            seat ++;
        }
        if(array[7] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 7);
            seat ++;
        }
        if(array[8] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 8);
            seat ++;
        }
        if(array[9] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 9);
             seat ++;
        }
        if(array[10] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 10);
             seat ++;}
        if(array[11] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 11);
             seat ++;
        }
        if(array[12] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 12);
             seat ++;
        }
        if(array[13] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 13);
             seat ++;
        }
        if(array[14] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 14);
             seat ++;
        }
        if(array[15] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 15);
             seat ++;
        }
        if(array[16] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 16);
             seat ++;
        }
        if(array[17] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 17);
             seat ++;
        }
        if(array[18] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 18);
             seat ++;
        }
        if(array[19] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 19);
             seat ++;
        }
        if(array[20] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 20);
             seat ++;
        }
        if(array[21] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 21);
             seat ++;
        }
        if(array[22] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 22);
             seat ++;
        }
        if(array[23] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 23);
             seat ++;
        }
        if(array[24] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 24);
             seat ++;
        }
        if(array[25] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 25);
             seat ++;
        }
        if(array[26] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 26);
             seat ++;
        }
        if(array[27] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 27);
             seat ++;
        }
        if(array[28] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 28);
         seat ++;
        }
        if(array[29] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 29);
             seat ++;
        }
        if(array[30] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 30);
             seat ++;
        }
        if(array[31] == 1){
            orderControl.updateTicket(sale.getSaleID(),ticket, 31);
             seat ++;
        }
        
             int totalSeat = schedule.getAvailableSeat() - seat;
        orderControl.updateTicketSeat(totalSeat, schedule.getScheduleID());
        dispose();
//           new OrderFrame(1,sale.getSaleID(),staffID,position,vs);
        
             }
               else if(valid ==1){
                 Sale sale1 = orderControl.getSale(saleID);
                if(array[0] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 0);
            seat ++;
           }
        if(array[1] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 1);
            seat ++;
        }
        if(array[2] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 2);
            seat ++;
        }
        if(array[3] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 3);
            seat ++;
        }
        if(array[4] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 4);
            seat ++;
        }
        if(array[5] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 5);
            seat ++;
        }
        if(array[6] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 6);
            seat ++;
        }
        if(array[7] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 7);
            seat ++;
        }
        if(array[8] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 8);
            seat ++;
        }
        if(array[9] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 9);
             seat ++;
        }
        if(array[10] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 10);
             seat ++;}
        if(array[11] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 11);
             seat ++;
        }
        if(array[12] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 12);
             seat ++;
        }
        if(array[13] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 13);
             seat ++;
        }
        if(array[14] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 14);
             seat ++;
        }
        if(array[15] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 15);
             seat ++;
        }
        if(array[16] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 16);
             seat ++;
        }
        if(array[17] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 17);
             seat ++;
        }
        if(array[18] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 18);
             seat ++;
        }
        if(array[19] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 19);
             seat ++;
        }
        if(array[20] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 20);
             seat ++;
        }
        if(array[21] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 21);
             seat ++;
        }
        if(array[22] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 22);
             seat ++;
        }
        if(array[23] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 23);
             seat ++;
        }
        if(array[24] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 24);
             seat ++;
        }
        if(array[25] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 25);
             seat ++;
        }
        if(array[26] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 26);
             seat ++;
        }
        if(array[27] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 27);
             seat ++;
        }
        if(array[28] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 28);
         seat ++;
        }
        if(array[29] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 29);
             seat ++;
        }
        if(array[30] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 30);
             seat ++;
        }
        if(array[31] == 1){
            orderControl.updateTicket(sale1.getSaleID(),ticket, 31);
             seat ++;
        }
        
           int totalSeat = schedule.getAvailableSeat() - seat;
        orderControl.updateTicketSeat(totalSeat, schedule.getScheduleID());
        dispose();
//          new OrderFrame(1,sale1.getSaleID(),staffID,position,vs);
             }
        
              
                   
               }
        });
        
        jbtBack.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               
                Bus bus = orderControl.checkBusType(schedule.getBusID());
                  if(bus.getBusType().equals("Normal")){
                 dispose();
//                  new SeatSelection(schedule,valid,saleID,staffID,position,vs);
                }
              else if(bus.getBusType().equals("Exclusive")){
                  dispose();
//             new SeatSelectionE(schedule,valid,saleID,staffID,position,vs);
        
         }
            
           }
       });{
      
    }
        
        jpCenter.setBackground(new Color(204,255,255));
        jpSouth.setBackground(new Color(204,255,255));
      
      
     
        
        
        
        
      addWindowListener(new WindowListener());
        setTitle("Multiple Order Confirmation");
        setSize(550,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    
    
    
   

    
    
    public static void main(String[] args){
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            // new MultipleOrderConfirmation();
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
                orderControl.closeDB();
            }
            
        }
    }
            
}