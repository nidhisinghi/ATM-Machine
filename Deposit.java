
package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
     JButton deposit,back;
     JTextField amount;
     String pinNumber;
     Deposit(String pinNumber){  
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
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(180,230,400,20);
        label.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(180,280,280,25);
        label.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(340,370,140,25);
        deposit.addActionListener(this);
        add(deposit);
        
        back = new JButton("Back");
        back.setBounds(340,400,140,25);
        back.addActionListener(this);
        add(back);
    }
    
     public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == deposit){
         String damount = amount.getText();
         Date date = new Date(); 
         if(damount.equals("")||Integer.parseInt(damount)<0){
             JOptionPane.showMessageDialog(null,"Please enter a valid amount");
         }else{
             try{
                Conn conn = new Conn();
                String query1="select * from Balance where pin='"+pinNumber+"'";
                int balance=0;
                ResultSet rs = conn.s.executeQuery(query1);
                while(rs.next()){
                balance = rs.getInt("balance")+Integer.parseInt(damount);}
                String query2="insert into transactions values('"+pinNumber+"','"+date+"','Credited','"+damount+"','"+balance+"')";
                String query3="Update Balance set balance='"+balance+"' where pin='"+pinNumber+"'";
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Rs "+damount+" Deposited Successfully");
            
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
        new Deposit("");
    }
}
