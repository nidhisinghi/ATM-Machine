package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,mini,Withdraw,pinChange,Balance,Exit,transfer;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);      
        setSize(850,700);
        setLocation(250,0);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,700);
        add(label);
        
        JLabel text = new JLabel(" Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(200,230,700,35);
        label.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160,320,140,25);
        deposit.addActionListener(this);
        add(deposit);
        
        Withdraw = new JButton("Cash Withdrawl");
        Withdraw.setBounds(340,320,140,25);
        Withdraw.addActionListener(this);
        add(Withdraw);
        
        transfer = new JButton("Transfer Cash");
        transfer.setBounds(160,350,140,25);
        transfer.addActionListener(this);
        add(transfer);
        
        mini = new JButton("Mini Statement");
        mini.setBounds(340,350,140,25);
        mini.addActionListener(this);
        add(mini);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160,380,140,25);
        pinChange.addActionListener(this);
        add(pinChange);
        
        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(340,380,140,25);
        Balance.addActionListener(this);
        add(Balance);
        
        Exit = new JButton("Exit");
        Exit.setBounds(340,410,140,17);
        Exit.addActionListener(this);
        add(Exit);
 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==Exit){
          System.exit(0);
      }else if(ae.getSource()==deposit){
          setVisible(false);
          new Deposit(pinNumber).setVisible(true);
      }else if(ae.getSource()==Withdraw){
          setVisible(false);
          new Withdraw(pinNumber).setVisible(true);
      }else if(ae.getSource()==pinChange){
          setVisible(false);
          new PinChange(pinNumber).setVisible(true);
      }else if(ae.getSource()==Balance){
          setVisible(false);
          new BalanceEnquiry(pinNumber).setVisible(true);
      }else if(ae.getSource()==mini){
          setVisible(false);
          new MiniStatement(pinNumber).setVisible(true);
      }else if(ae.getSource()==transfer){
          setVisible(false);
          new Transfer(pinNumber).setVisible(true);
      }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
