package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JFrame;

public class Transfer  extends JFrame implements ActionListener{
    JButton transfer,back;
    JTextField cardtextField,amounttextField;
    String pinnumber;
    
    Transfer(String pinnumber){
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
        
        JLabel text = new JLabel("TRANSFER FUNDS");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(240,230,400,20);
        label.add(text);
        
        JLabel card = new JLabel("CARD NUMBER: ");
        card.setFont(new Font("System", Font.BOLD, 16));
        card.setForeground(Color.WHITE);
        card.setBounds(155,280,180,20);
        label.add(card);
        
        cardtextField = new JTextField();
        cardtextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardtextField.setBounds(310,280,160,25);
        label.add(cardtextField);
        
        JLabel amount = new JLabel("AMOUNT: ");
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setForeground(Color.WHITE);
        amount.setBounds(155,320,180,20);
        label.add(amount);
        
        amounttextField = new JTextField();
        amounttextField.setFont(new Font("Arial", Font.BOLD, 14));
        amounttextField.setBounds(310,320,160,25);
        label.add(amounttextField);
        
        transfer = new JButton("Transfer");
        transfer.setBounds(340,370,140,25);
        transfer.addActionListener(this);
        add(transfer);
        
        back = new JButton("Back");
        back.setBounds(340,400,140,25);
        back.addActionListener(this);
        add(back);
    }
    public void deposit(String pin, String amount,int currbalance){
        Date date = new Date();
        Conn conn = new Conn();
        try{
            currbalance +=Integer.parseInt(amount);
            String query2="insert into transactions values('"+pin+"','"+date+"','Credited','"+amount+"','"+currbalance+"')";
            String query3="Update Balance set balance='"+currbalance+"' where pin='"+pin+"'";
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void withdraw(String pin, String amount,int currbalance){
         Date date = new Date();
         Conn conn = new Conn();
         
             try{
                currbalance-=Integer.parseInt(amount);
                String query2="insert into transactions values('"+pin+"','"+date+"','Withdraw','"+amount+"','"+currbalance+"')";
                String query3="Update Balance set balance='"+currbalance+"' where pin='"+pin+"'";
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
             }catch(Exception e){
                 System.out.println(e);
             }
         }
    public void actionPerformed(ActionEvent ae){
        Conn conn=new Conn();
        if(ae.getSource() == transfer){
            try{
                String pin="";
                String card = cardtextField.getText();
                String amount = amounttextField.getText();
                String query="select * from login where card_Number = '"+card+"'";
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    pin = rs.getString("pin");
                }
                
                String query1="select * from balance where pin='"+pinnumber+"'";
                int currbalance1=0;
                ResultSet rs2 = conn.s.executeQuery(query1);
                while(rs2.next()){
                    currbalance1 = rs2.getInt("balance");}
                
                String query2="select * from balance where pin='"+pin+"'";
                int currbalance2=0;
                ResultSet rs3 = conn.s.executeQuery(query2);
                while(rs3.next()){
                    currbalance2 = rs3.getInt("balance");}
                
                if(amount.equals("")||Integer.parseInt(amount)<0){
                    JOptionPane.showMessageDialog(null,"Please enter a valid amount");
                }else if(Integer.parseInt(amount)>currbalance1){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }else{
                    deposit(pin,amount,currbalance2);
                    withdraw(pinnumber,amount,currbalance1);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Transfer Successfull");
                    setVisible(false);
                     new Transactions(pinnumber).setVisible(true);}
            }catch(Exception e){
                System.out.println(e);
            }
            
      }else if(ae.getSource()==back){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
      }
    }
    
    public static void main(String args[]){
        new Transfer("");
    }
}
