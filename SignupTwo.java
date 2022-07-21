package atm.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category, income,Education,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setSize(850,680);
        setLocation(250,10);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290,50,400,30);
        add(AdditionalDetails);
        
        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,100,100,30);
        add(name);
        String valReligion[] ={"Hindu", "Muslim", "Jain", "Sikh", "Christian","Others"};       
        religion = new JComboBox(valReligion);
        religion.setBounds(300,100,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100,150,200,30);
        add(fname);
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,150,400,30);
        category.setBackground(Color.WHITE);
        add(category);
      
        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,200,200,30);
        add(dob);
        String incomeCategory[] = {"Null","< 1 LAKH","<5 LAKH","Upto 10 LAKH"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,200,400,30);
        income.setBackground(Color.WHITE);
        add(income);        
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100,250,200,30);
        add(education);
            
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100,285,200,30);
        add(qualification);
        String educationCategory[] = {"Non-Graduation","Graduate","Post-Graduate","Higher","Other"};
        Education = new JComboBox(educationCategory);
        Education.setBounds(300,270,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);
        
        JLabel Married = new JLabel("Occupation: ");
        Married.setFont(new Font("Raleway", Font.BOLD, 22));
        Married.setBounds(100,350,200,30);
        add(Married);   
        String occupationCategory[] = {"Salaried","Self-Employeed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationCategory);
        occupation.setBounds(300,350,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel pannumber = new JLabel("PAN Number: ");
        pannumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pannumber.setBounds(100,400,200,30);
        add(pannumber); 
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD, 14));
        pan.setBounds(300,400,400,30);
        add(pan);
        
        JLabel aadharnumber = new JLabel("Aadhar Number: ");
        aadharnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharnumber.setBounds(100,450,200,30);
        add(aadharnumber);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD, 14));
        aadhar.setBounds(300,450,400,30);
        add(aadhar);
        
        
        JLabel State = new JLabel("Senior Citizen: ");
        State.setFont(new Font("Raleway", Font.BOLD, 22));
        State.setBounds(100,500,200,30);
        add(State);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,500,80,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(430,500,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
   
        JLabel pinCode = new JLabel("Existing Account: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 22));
        pinCode.setBounds(100,550,200,30);
        add(pinCode);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,550,80,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(430,550,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);
  
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem(); // setText to set the value, used in clear
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) Education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen= null;
        if(syes.isSelected()){
            seniorCitizen="Yes";
        }else if(sno.isSelected()){
            seniorCitizen="No";
        }
        String ExistingAccount= null;
        if(eyes.isSelected()){
            ExistingAccount="Yes";
        }else if(eno.isSelected()){
            ExistingAccount="No";
        }
       
        String saadhar = aadhar.getText();
        String span = pan.getText();
        
        try{
                Conn c = new Conn();
                String query ="insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorCitizen+"','"+ExistingAccount+"','"+saadhar+"','"+span+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
}
}
