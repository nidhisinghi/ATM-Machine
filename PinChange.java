
package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class PinChange extends JFrame implements ActionListener{
    JPasswordField pintextField,repintextField,oldpintextField;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);      
        setSize(850,700);
        setLocation(250,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,700);
        add(label);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(230,230,200,35);
        label.add(text);
        
        JLabel pintext = new JLabel("NEW PIN: ");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(155,280,180,20);
        label.add(pintext);
        
        pintextField = new JPasswordField();
        pintextField.setFont(new Font("Raleway", Font.BOLD, 22));
        pintextField.setBounds(310,280,160,25);
        label.add(pintextField);
        
        JLabel repintext = new JLabel("Re-Enter NEW PIN: ");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(155,320,180,20);
        label.add(repintext);
        
        repintextField = new JPasswordField();
        repintextField.setFont(new Font("Raleway", Font.BOLD, 22));
        repintextField.setBounds(310,320,160,25);
        label.add(repintextField);
        
        JLabel oldpin = new JLabel("Re-Enter OLD PIN: ");
        oldpin.setFont(new Font("System", Font.BOLD, 16));
        oldpin.setForeground(Color.WHITE);
        oldpin.setBounds(155,360,180,20);
        label.add(oldpin);
        
        oldpintextField = new JPasswordField();
        oldpintextField.setFont(new Font("Raleway", Font.BOLD, 22));
        oldpintextField.setBounds(310,360,160,25);
        label.add(oldpintextField);
        
        change = new JButton("CHANGE");
        change.setBounds(155,400,140,25);
        change.addActionListener(this);
        add(change);
        
        back = new JButton("BACK");
        back.setBounds(340,400,140,25);
        back.addActionListener(this);
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
             String npin=pintextField.getText();
             String repin=repintextField.getText();
             String oldpin=oldpintextField.getText();
             
             if(oldpin.equals(pinnumber)){
             if(!npin.equals(repin)){
                 JOptionPane.showMessageDialog(null,"Pin Does Not match");
             }
             if(npin.equals("")){
                 JOptionPane.showMessageDialog(null,"Invalid Pin");
             }  
             Conn conn= new Conn();
             String query1="Update transactions set pin='"+npin+"' where pin='"+pinnumber+"'";
             String query2="Update signupthree set pin='"+npin+"' where pin='"+pinnumber+"'";
             String query3="Update login set pin='"+npin+"' where pin='"+pinnumber+"'";
             
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
             JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
             setVisible(false);
             new Transactions(npin).setVisible(true);}
             else{
                 JOptionPane.showMessageDialog(null,"Incorrect Pin");
             }
             
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
      }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
