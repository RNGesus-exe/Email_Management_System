import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;


public class Driver {

    public static Mail mail = new Mail();                  //Handles all Users Data in RAM
    public static DatabaseManager dataAgent = null;        //This agent helps in managing database

    public static void main(String[] args) throws SQLException {
        Connection connectionAgent = ConnectionManager.getConnection();  //Connects to MySql through Xampp
        if(connectionAgent != null) {
            dataAgent = new DatabaseManager(connectionAgent);
            new ComposeMail("Shaheryar333");
            //System.out.println(mail.checkMultipleUsers("Shaheryar333,Mehroz69,Azan69"));
            //new ComposeMail("Shaheryar333");
            //mail.addUser("Mehroz123","123","Mehroz","Mustafa","Male","N/A","What is your favourite Anime?","All");
        }
        else {
            JOptionPane.showMessageDialog(null,"Connection was not established!","Database connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}