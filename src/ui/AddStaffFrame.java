package ui;
import da.*;
import domain.*;
import control.MaintainStaffControl;
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
public class AddStaffFrame extends JFrame{
    private AddStaffFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    private ButtonGroup bG =new ButtonGroup();
    private ButtonGroup bG2 =new ButtonGroup();
    private ButtonGroup bG3 =new ButtonGroup();
    private JXDatePicker datePick=new JXDatePicker();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfId= new JTextField();
    private JTextField jtfName= new JTextField();
    private JTextField jtfIc= new JTextField(16);
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
    private JTextField jtfStatus=new JTextField();
    private JTextField jtfType=new JTextField();
    private JLabel jl1 =new JLabel("Please enter the new Staff's Information");
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
    
    private JLabel jlSecurity =new JLabel("Security Answer:");
    private JLabel jlQuestion=new JLabel("Security Question:");
    private DefaultComboBoxModel dcbomQuestionList=new DefaultComboBoxModel();
    private JComboBox jcbQuestion= new JComboBox(dcbomQuestionList);
    private ArrayList<String> QuestionList=new ArrayList<String>();
   private String position;
   private String staffID;
   public AddStaffFrame(){}
public AddStaffFrame(String position,String staffID){
    PromptSupport.setForeground(Color.LIGHT_GRAY, jtfIc);
PromptSupport.setPrompt("Example:123456121234",jtfIc);
PromptSupport.setForeground(Color.LIGHT_GRAY, jtfTel);
PromptSupport.setPrompt("Example:0165521128",jtfTel);
PromptSupport.setForeground(Color.LIGHT_GRAY, jtfEmail);
PromptSupport.setPrompt("Example:ABC@gmail.com",jtfEmail);
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
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
    JPanel jpCenter = new JPanel(new GridLayout(13, 2));
    jpCenter.add(jlStaffId);
    jpCenter.add(jtfId);
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
    jpCenter.add(jtfStatus);
     QuestionList.add("What is your pet name?");
    QuestionList.add("What is your dad name?");
    QuestionList.add("What is your mom name?");
    for(int i=0;i<QuestionList.size();i++){
        dcbomQuestionList.addElement(QuestionList.get(i));
    }

    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    jtfId.setEditable(false);
    jtfStatus.setEditable(false);
    jtfStatus.setText("Working");
    jtfId.setText(automatedCode());

    jtfSecurity.setText("Null");
    jcbQuestion.setSelectedIndex(0);
setIcon();
        setTitle("Create New Staff");
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
    jbtConfirm.addActionListener(new ConfirmListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jrbManager.addActionListener(new TypeListener());
    jrbStaff.addActionListener(new TypeListener());
    jrbWorking.addActionListener(new StatusListener());
    jrbRetired.addActionListener(new StatusListener());
    jrbMale.addActionListener(new GenderListener());
    jrbFemale.addActionListener(new GenderListener());
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jlStaffId.setFont(smallFont);
jlName.setFont(smallFont);
jlIc.setFont(smallFont);
jlGender.setFont(smallFont);
    jldob.setFont(smallFont);
     jlAddress.setFont(smallFont);
    jlContactNo.setFont(smallFont);
    jlEmail.setFont(smallFont);
    jlQuestion.setFont(smallFont);
     jlPosition.setFont(smallFont);
    jlStatus.setFont(smallFont);
     
    jlSecurity.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
   
}
public String automatedCode(){
    String automatedCode="";
    automatedCode=staffDA.displayAutomatedCode();
    return automatedCode;
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
 private class TypeListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfType.setText(radioButton.getText());
            }
        }
        
            
    }
}
    private class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            
            String StaffID = jtfId.getText();
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

}



            if(jtfName.getText().equals("")){
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
            else if(jtfType.getText().equals("")){
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
            else if(jtfPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your password.");
            }
            else if(jtfSecurity.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter you security answer.");
            }
            else if(jtfGender.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose your gender.");
            }
            else{
            staffControl.addRecord(StaffID,jtfName.getText(),jtfIc.getText(),jtfGender.getText(),datePick.getDate(),jtfAddress.getText(),jtfTel.getText(),jtfEmail.getText(),jtfType.getText(),jtfStatus.getText(),jtfIc.getText(),jtfSecurity.getText(),jcbQuestion.getSelectedIndex());
                
            
                
                JOptionPane.showMessageDialog(null, "New Staff Record added.");
                
                thisFrame.dispose();
            }

        
            }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in purchase year and seat text field");
        }}}
 private void clearText() {
      jtfName.setText("");
      jtfIc.setText("");
      jtfTel.setText("");
      jtfAddress.setText("");
      jtfEmail.setText("");
      jtfPassword.setText("");
      jtfSecurity.setText("");
      jtfName.requestFocusInWindow();
      datePick.setDate(null);
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

public static void main(String[] args) {
    try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new AddStaffFrame("","");
}}



