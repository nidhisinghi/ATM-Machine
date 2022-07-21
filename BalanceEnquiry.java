
package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        JButton back;
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
        
        back = new JButton("Back");
        back.setBounds(340,400,140,25);
        back.addActionListener(this);
        add(back);
        
        Conn c = new Conn();
        int balance=0;
        try{
            String query1 = "Select * from transactions where pin = '"+pinnumber+"'";
            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                balance = rs.getInt("balance");}
            JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
            text.setFont(new Font("System", Font.BOLD, 16));
            text.setForeground(Color.WHITE);
            text.setBounds(150,280,400,20);
             label.add(text);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
