package atm.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    //Mysql is an external entity so to reduce the chances of run time errors we use try catch statement
    public Conn(){
        try{
            //class of name class containing a method forName
            c=DriverManager.getConnection("jdbc:mysql:///ATMSystem", "root", "Outlook@0326");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
