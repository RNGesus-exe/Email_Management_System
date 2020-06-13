import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_system","root","");
            if (connection!=null) {
                DatabaseManager helper = new DatabaseManager(connection);
                helper.createTables();
            }
            else { System.out.println("Not Connected with Data base!"); }
        } catch (Exception e) { e.printStackTrace(); }
        return connection;
    }

}