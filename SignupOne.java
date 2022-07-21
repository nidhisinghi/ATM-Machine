package atm.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,pinTextField,stateTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried, other2;
    JDateChooser date;
    SignupOne(){
        setLayout(null);
        
        setSize(850,680);
        setLocation(250,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+ 1000L); 
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,10,600,30);
        add(formno);
        
        JLabel PersonalDetails = new JLabel("Page 1: Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290,50,400,30);
        add(PersonalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,100,100,30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        nameTextField.setBounds(300,100,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100,150,200,30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        fnameTextField.setBounds(300,150,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,200,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300, 200, 400, 30);
        date.setForeground(new Color(105,105,105));
        add(date);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100,250,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,250,80,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(430,250,80,30);
        female.setBackground(Color.WHITE);
        add(female);
        other = new JRadioButton("Other");
        other.setBounds(560,250,80,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel Email = new JLabel("Email Address: ");
        Email.setFont(new Font("Raleway", Font.BOLD, 22));
        Email.setBounds(100,300,200,30);
        add(Email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        emailTextField.setBounds(300,300,400,30);
        add(emailTextField);
        
        JLabel Married = new JLabel("Marital Status: ");
        Married.setFont(new Font("Raleway", Font.BOLD, 22));
        Married.setBounds(100,350,200,30);
        add(Married);   
        
        married = new JRadioButton("Married");
        married.setBounds(300,350,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430,350,80,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other2 = new JRadioButton("Other");
        other2.setBounds(560,350,80,30);
        other2.setBackground(Color.WHITE);
        add(other2);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other2);
        
        JLabel Address = new JLabel("Address: ");
        Address.setFont(new Font("Raleway", Font.BOLD, 22));
        Address.setBounds(100,400,200,30);
        add(Address); 
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        addressTextField.setBounds(300,400,400,30);
        add(addressTextField);
        
        JLabel City = new JLabel("City: ");
        City.setFont(new Font("Raleway", Font.BOLD, 22));
        City.setBounds(100,450,200,30);
        add(City);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        cityTextField.setBounds(300,450,400,30);
        add(cityTextField);
        
        
        JLabel State = new JLabel("State: ");
        State.setFont(new Font("Raleway", Font.BOLD, 22));
        State.setBounds(100,500,200,30);
        add(State);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        stateTextField.setBounds(300,500,400,30);
        add(stateTextField);
        
        
        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 22));
        pinCode.setBounds(100,550,200,30);
        add(pinCode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        pinTextField.setBounds(300,550,400,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);
  
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //converted into string
        String name = nameTextField.getText(); // setText to set the value, used in clear
        String fname = fnameTextField.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender="other";
        }
        String email = emailTextField.getText();
        String Married= null;
        if(married.isSelected()){
            Married="Married";
        }else if(unmarried.isSelected()){
            Married="Unmarried";
        }else if(other2.isSelected()){
            Married="other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query ="insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+Married+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupOne();
}
}
