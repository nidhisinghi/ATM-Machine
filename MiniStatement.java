
package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(400,600);
        setLayout(null);      
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        //JLabel text = new JLabel();
       // add(text);
        
        JLabel bank = new JLabel("Your Bank");
        bank.setFont(new Font("System", Font.BOLD, 16)); 
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.BOLD, 16)); 
        card.setBounds(40,80,600,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,400,320,20);
        add(bal);
        
        back = new JButton("Back");
        back.setBounds(270,450,80,25);
        back.addActionListener(this);
        add(back);
        
        Conn c = new Conn();
        int balance=0;
        try{
            String query1 = "Select * from Balance where pin = '"+4477+"'";
            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                balance = rs.getInt("balance");}
            bal.setText("Your current account Balance is Rs " + balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn=new Conn();
            String query="select card_Number from login where pin = '"+4477+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("card_Number").substring(0,4)+"XXXXXXXX"+ rs.getString("card_Number").substring(12));
            }   
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn=new Conn();
            String query="select * from transactions where pin = '"+4477+"' order by date limit 5";
            ResultSet rs = conn.s.executeQuery(query);
            //&nbsp; introduce spaces
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }   
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
