package atm.system;
import javax.swing.*; //swing is extended package of java
import java.awt.*;
import java.awt.event.*;// for Action Listener
import java.sql.*;

//JFrame used for creating desktop based application
public class Login extends JFrame implements ActionListener{
    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setSize(800,480);
        setVisible(true);
        setLocation(250,100);
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null); 
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        //converted image into image icon to use in Jlabel
        //Image in awt package
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel Pin = new JLabel("Pin:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));
        Pin.setBounds(120,220,150,30);
        add(Pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signin){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where card_Number='"+cardnumber+"' and pin = '"+pinNumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin ");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
