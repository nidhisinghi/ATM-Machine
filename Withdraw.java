
package atm.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import java.sql.ResultSet;
public class Withdraw extends JFrame implements ActionListener{
     JButton Withdrawal,back;
     JTextField amount;
     String pinNumber;
     Withdraw(String pinNumber){  
        this.pinNumber=pinNumber;
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
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(180,230,400,20);
        label.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(180,280,280,25);
        label.add(amount);
        
        Withdrawal = new JButton("Withdraw");
        Withdrawal.setBounds(340,370,140,25);
        Withdrawal.addActionListener(this);
        add(Withdrawal);
        
        back = new JButton("Back");
        back.setBounds(340,400,140,25);
        back.addActionListener(this);
        add(back);
    }
    
     public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == Withdrawal){
         String damount = amount.getText();
         Date date = new Date();
         Conn conn = new Conn();
         String query1="select * from balance where pin='"+pinNumber+"'";
         int currbalance=0;
         try{
            ResultSet rs = conn.s.executeQuery(query1);
            while(rs.next()){
            currbalance = rs.getInt("balance");}
         }catch(Exception e){
             System.out.println(e);
         }
         if(damount.equals("")||Integer.parseInt(damount)<0){
             JOptionPane.showMessageDialog(null,"Please enter a valid amount");
         }else if(Integer.parseInt(damount)>currbalance){
             JOptionPane.showMessageDialog(null,"Insufficient Balance");
         }else{
             try{
                currbalance-=Integer.parseInt(damount);
                String query2="insert into transactions values('"+pinNumber+"','"+date+"','Withdraw','"+damount+"','"+currbalance+"')";
                String query3="Update Balance set balance='"+currbalance+"' where pin='"+pinNumber+"'";
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Rs "+damount+" Withdraw Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
             
             }catch(Exception e){
                 System.out.println(e);
             }
         }
      }else if(ae.getSource()==back){
          setVisible(false);
           new Transactions(pinNumber).setVisible(true);
      }
    }
    
    public static void main(String args[]){
        new Withdraw("");
    }
}
