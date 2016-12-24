package ui;
import da.*;
import domain.*;
import control.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.JComponent;
import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;
import java.text.SimpleDateFormat;
import org.jdesktop.swingx.prompt.PromptSupport;
public class UpdateStaffFrame extends JFrame{
    private UpdateStaffFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    private ArrayList<Staff> staffList=new ArrayList<Staff>();
    private DefaultComboBoxModel dcbomStaffList=new DefaultComboBoxModel();
    private JComboBox jcbStaffID=new JComboBox(dcbomStaffList);
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    private ButtonGroup bG =new ButtonGroup();
    private ButtonGroup bG2 =new ButtonGroup();
    private ButtonGroup bG3 =new ButtonGroup();
    private JXDatePicker datePick=new JXDatePicker();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JButton jbtRetrieve=new JButton("Retrieve");
    private JTextField jtfId= new JTextField();
    private JTextField jtfName= new JTextField();
    private JTextField jtfIc= new JTextField();
    private JRadioButton jrbMale= new JRadioButton("Male");
    private JRadioButton jrbFemale= new JRadioButton("Female");
    private JRadioButton jrbManager= new JRadioButton("Manager");
    private JRadioButton jrbStaff= new JRadioButton("Staff");
    private JRadioButton jrbRetired= new JRadioButton("Retired");
    private JRadioButton jrbWorking= new JRadioButton("Working");
    private JTextField jtfGender=new JTextField();
    private JTextField jtfTel=new JTextField();
    private JTextField jtfAddress= new JTextField();
    private JTextField jtfEmail= new JTextField();
    private JTextField jtfPassword= new JTextField();
    private JTextField jtfSecurity= new JTextField();
    private JTextField jtfPosition=new JTextField();
    private JTextField jtfStatus=new JTextField();
    private JLabel jl1 =new JLabel("Please select the Staff ID");
    private JLabel jlStaffId =new JLabel("Staff ID:");
    private JLabel jlName =new JLabel("Name:");
    private JLabel jlIc =new JLabel("IC:");
    private JLabel jlGender =new JLabel("Gender:");
    private JLabel jldob =new JLabel("Date of Birth:");
    private JLabel jlAddress =new JLabel("Address:");
    private JLabel jlContactNo =new JLabel("Contact No:");
    private JLabel jlEmail =new JLabel("Email:");
    private JLabel jlPosition =new JLabel("Position:");
    private JLabel jlStatus =new JLabel("Status:");
   // private JLabel jlPassword =new JLabel("Password:");
  //  private JLabel jlSecurity =new JLabel("Security Answer:");
   private String position;
   private String staffID;
   public UpdateStaffFrame(){}
public UpdateStaffFrame(String position,String staffID){
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
    intiStaffComboBox();
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    datePick.setFormats(dateFormat);
    bG.add(jrbMale);
    bG.add(jrbFemale);
    bG2.add(jrbManager);
    bG2.add(jrbStaff);
    bG3.add(jrbWorking);
    bG3.add(jrbRetired);
    JPanel jpGender=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpGender.add(jrbMale);
    jpGender.add(jrbFemale);
     JPanel jpPosition=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpPosition.add(jrbManager);
    jpPosition.add(jrbStaff);
     JPanel jpStatus=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpStatus.add(jrbWorking);
    jpStatus.add(jrbRetired);
    JPanel jpCenter = new JPanel(new GridLayout(14, 2));
    jpCenter.add(jlStaffId);
    jpCenter.add(jcbStaffID);
    jpCenter.add(new JLabel(""));
    jpCenter.add(jbtRetrieve);
    jpCenter.add(jlName);
    jpCenter.add(jtfName);
    jpCenter.add(jldob);
    jpCenter.add(datePick);
    jpCenter.add(jlIc);
    jpCenter.add(jtfIc);
    jpCenter.add(jlGender);
    jpCenter.add(jpGender);
    jpCenter.add(jlContactNo);
    jpCenter.add(jtfTel);
    jpCenter.add(jlAddress);
    jpCenter.add(jtfAddress);
    jpCenter.add(jlEmail);
    jpCenter.add(jtfEmail);
    jpCenter.add(jlPosition);
    jpCenter.add(jpPosition);
    jpCenter.add(jlStatus);
    jpCenter.add(jpStatus);
   // jpCenter.add(jlPassword);
    //jpCenter.add(jtfPassword);
   // jpCenter.add(jlSecurity);
   // jpCenter.add(jtfSecurity);
   

    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtUpdate);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    
setIcon();
        setTitle("Update Staff Information");
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
         jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    jpStatus.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
    jpGender.setBackground(new Color(204,255,255));
    jpPosition.setBackground(new Color(204,255,255));
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jlStaffId.setFont(smallFont);
jlName.setFont(smallFont);
jlIc.setFont(smallFont);
jlGender.setFont(smallFont);
    jldob.setFont(smallFont);
     jlAddress.setFont(smallFont);
    jlContactNo.setFont(smallFont);
    jlEmail.setFont(smallFont);
     jlPosition.setFont(smallFont);
    jlStatus.setFont(smallFont);
   //  jlPassword.setFont(smallFont);
   // jlSecurity.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtUpdate.setFont(smallFont);
    jbtBack.setFont(smallFont);
     jbtRetrieve.setFont(smallFont);
     jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jbtRetrieve.addActionListener(new RetrieveListener());
 jbtUpdate.addActionListener(new UpdateListener());
  jrbManager.addActionListener(new TypeListener());
    jrbStaff.addActionListener(new TypeListener());
    jrbWorking.addActionListener(new StatusListener());
    jrbRetired.addActionListener(new StatusListener());
    jrbMale.addActionListener(new GenderListener());
    jrbFemale.addActionListener(new GenderListener());
}
private void clearText() {
     
      jtfName.setText("");
      jtfIc.setText("");
      jtfTel.setText("");
      jtfAddress.setText("");
      jtfEmail.setText("");
      jtfPassword.setText("");
      jtfSecurity.setText("");
      jtfId.requestFocusInWindow();
      jtfStatus.setText("");
      jtfPosition.setText("");
      jtfGender.setText("");
     datePick.setDate(null);
   bG.clearSelection();
   bG2.clearSelection();
   bG3.clearSelection();
    }
private void intiStaffComboBox(){
    staffList=staffControl.getStaffID();
    System.out.print(staffList);
    for(int j=0;j<staffList.size();j++){
        dcbomStaffList.addElement(staffList.get(j).getStaffID());
    }
}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
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
   private class RetrieveListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
            String StaffID = jcbStaffID.getSelectedItem().toString();
            Staff staff = staffControl.selectRecord(StaffID);
            if (staff != null) {
                jtfName.setText(staff.getName());
                jtfIc.setText(staff.getIC());
                jtfTel.setText(staff.getContactno());
                jtfStatus.setText(staff.getStatus());
                jtfAddress.setText(staff.getAddress());
                jtfEmail.setText(staff.getEmail());
                jtfPosition.setText(staff.getPosition());
                jtfGender.setText(staff.getGender());
                datePick.setDate(staff.getDOB());
               
                
            } else {
                JOptionPane.showMessageDialog(null, "No such Member ID.Please enter correct Staff ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
           if(jtfStatus.getText().equals("Working")){
               jrbWorking.setSelected(true);
           }else{
               jrbRetired.setSelected(true);
           }
           if(jtfPosition.getText().equals("Manager")){
               jrbManager.setSelected(true);
           }else{
               jrbStaff.setSelected(true);
           }
           if(jtfGender.getText().equals("Male")){
               jrbMale.setSelected(true);
           }else{
               jrbFemale.setSelected(true);
           }
           
        }
        }

 private class GenderListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfGender.setText(radioButton.getText());
            }
        }
        
            
    }
}
  private class StatusListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfStatus.setText(radioButton.getText());
              
            }
        }
        
            
    }
}
 private class TypeListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfPosition.setText(radioButton.getText());
            }
        }
        
            
    }
}
   private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String staffID = jcbStaffID.getSelectedItem().toString();
//            int tel=Integer.parseInt(jtfTel.getText());
//            int ic=Integer.parseInt(jtfIc.getText());
            Staff staff = staffControl.selectRecord(staffID);
            if (staff != null) {
                String ic=jtfIc.getText();
            String email=jtfEmail.getText();
int countAlpha=0;
if(ic.length()==16)
{
for(int i=0;i<ic.length();i++)
{
char ch=ic.charAt(i);
if(Character.isAlphabetic(ch))
{
countAlpha++;
}
}
}
int count=0;
for(int j=0;j<email.length();j++)
{
char ch=email.charAt(j);
if(Character.compare(ch,'@')==0)
{
count++;
}

}           if(jtfName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your name.");
            }
            else if(jtfIc.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your IC.");
            }
            else if(countAlpha>0){
               JOptionPane.showMessageDialog(null, "Please enter the correct IC.");
            }
            else if(jtfTel.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your tel number.");
            }
            else if(jtfPosition.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose your position.");
            }
            else if(jtfStatus.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose your status.");
            }
            else if(jtfAddress.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your address.");
            }
            else if(jtfEmail.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your email.");
            }
            else if(count!=1){
                JOptionPane.showMessageDialog(null, "Please enter the correct format of email.");
            }
            else if(jtfGender.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose your gender.");
            }else{
                staff.setName(jtfName.getText());
                staff.setGender(jtfGender.getText());
                staff.setAddress(jtfAddress.getText());
                staff.setContactno((jtfTel.getText()));
                staff.setIC(jtfIc.getText());
                staff.setDOB(datePick.getDate());
                staff.setEmail(jtfEmail.getText());
                staff.setPosition(jtfPosition.getText());
                staff.setStatus(jtfStatus.getText());
                staffControl.updateRecord(staff);
                JOptionPane.showMessageDialog(null, "Record updated.");
            }
               } else {
                JOptionPane.showMessageDialog(null, "No such Staff ID ", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }}catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in Ic , Tel and text field");
        }}}
public static void main(String[] args) {
    try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new UpdateStaffFrame();
}}



