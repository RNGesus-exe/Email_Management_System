import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    public void createTables() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS user (id int primary key unique auto_increment,username varchar(55)" +
                    ",password varchar(55),dateTime timestamp,firstName varchar(55),lastName varchar(55),gender int,address varchar(55)" +
                    ",securityQuestion varchar(70),securityQuestionAnswer varchar(55))");
            statement.execute("CREATE TABLE IF NOT EXISTS mail (id int primary key unique auto_increment,recipient_id int,subject varchar(100)" +
                    ",body mediumtext,sender_id int,status int,recipient_starred boolean,dateTime timestamp,child_mail int,permaTrash int,sender_starred boolean)");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addUser(String username,String password,String firstName,String lastName,String gender,String address,String securityQuestion,String securityQuestionAnswer) {
        String query = "INSERT INTO user(username,password,firstName,lastName,gender,address,securityQuestion,securityQuestionAnswer)VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1,username);
            ppStatement.setString(2,password);
            ppStatement.setString(3,firstName);
            ppStatement.setString(4,lastName);
            int gender_id;
            /*
               1 - Male
               2 - Female
               3 - Other
            */
            if(gender.toLowerCase().equals("male"))
            {
                gender_id=1;
            }
            else if(gender.toLowerCase().equals("female"))
            {
                gender_id=2;
            }
            else
            {
                gender_id = 3;
            }
            ppStatement.setInt(5,gender_id);
            ppStatement.setString(6,address);
            ppStatement.setString(7,securityQuestion);
            ppStatement.setString(8,securityQuestionAnswer);
            ppStatement.execute();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addMail(MailBody mail) {
        String query = "INSERT INTO mail(recipient_id,subject,body,sender_id,status,recipient_starred,child_mail,permaTrash,sender_starred)VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            StringTokenizer recipients = new StringTokenizer(mail.getRecipient(),",");
            while(recipients.hasMoreTokens())
            {
                ppStatement.setInt(1,getId(recipients.nextToken()));
                ppStatement.setString(2,mail.getSubject());
                ppStatement.setString(3,mail.getText());
                ppStatement.setInt(4,getId(mail.getSender()));
                int status;
            /*
            1-UnRead - Inbox
            2-Read - Inbox   //The mail cannot be read until it isn't in unread form first
            3-Draft
            4-Trash
            5-Spam
             */
                if(mail.isUnread()) {
                    status = 1;
                }
                else if (mail.isDraft()) { status = 3; }
                else if (mail.isTrash()) { status = 4; }
                else if (mail.isSpam()) { status = 5; }
                else { status = 2; }

                ppStatement.setInt(5, status);
                ppStatement.setBoolean(6,mail.isRecipient_starred());
                ppStatement.setInt(7,0);
                ppStatement.setInt(8,0);
                ppStatement.setBoolean(9,mail.isSender_starred());
                ppStatement.execute();
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public int getId(String username,String password) {
        String query = "SELECT * FROM user where username = ? and password = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1,username);
            ppStatement.setString(2,password);

            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) { return rs.getInt(1); }
            else { return -1; }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    public String getUsername (int id) {
        String query = "SELECT * FROM user where id = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,id);
            ResultSet rs = ppStatement.executeQuery();
            rs.absolute(1);
            if (rs.last()) { return rs.getString(2) ; }
        } catch(SQLException e) { e.printStackTrace(); }
        return null;
    }

    public int getId (String username) {
        String query = "SELECT * FROM user where username = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1,username);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) { return rs.getInt(1); }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    public int checkUserRepetition(String username) {
        String query = "SELECT * FROM user where username = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setString(1,username);

            ResultSet rs = ppStatement.executeQuery();
            if (rs.last()) { return rs.getRow(); }
            else { return -1; }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    public String getUserSecurityQuestion(int id) {
        String query = "SELECT * FROM user where id = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getString(9);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public String getUserSecurityQuestionAnswer(int id) {
        String query = "SELECT * FROM user where id = ?";
        try {
            PreparedStatement ppStatement = connection.prepareStatement(query);
            ppStatement.setInt(1,id);
            ResultSet rs = ppStatement.executeQuery();
            if (rs.next()) {
                return rs.getString(10);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public ArrayList<String> getAllUsers() throws SQLException {
        String query = "SELECT * FROM user";
        PreparedStatement ppStatement = connection.prepareStatement(query);
        ArrayList<String> users = new ArrayList<>();
        ResultSet rs = ppStatement.executeQuery();
        while (rs.next()) {
            users.add(rs.getString(2));
        }
        return users;
    }

    public User loadUserInfoFromDataBase(int id) throws SQLException {
        //-----------------------------------------------user-MAIL is loaded--------------------------------------------------
        PreparedStatement ppStatement = connection.prepareStatement("SELECT * FROM user where id=?");
        ppStatement.setInt(1, id);
        ResultSet rs = ppStatement.executeQuery();

        User user = new User();
        if(rs.next()) {
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setDateTime(rs.getTimestamp(4));
            user.setFirstName(rs.getString(5));
            user.setLastName(rs.getString(6));
        /*
               1 - Male
               2 - Female
               3 - Other
            */
            if (rs.getInt(7) == 1) {
                user.setGender("Male");
            } else if (rs.getInt(7) == 2) {
                user.setGender("Female");
            } else {
                user.setGender("Other");
            }
            user.setAddress(rs.getString(8));
            user.setSecurityQuestion(rs.getString(9));
            user.setSecurityQuestionAnswer(rs.getString(10));
            return user;
        }
        else
        {
            return null;
        }
    }

    public ArrayList<MailBody> loadUserMailsFromDataBase(int id) throws SQLException {
        ArrayList<MailBody> mails = new ArrayList<>();
        //--------------------------------------mails-MAIL is laoded---------------------------------------------------
        PreparedStatement ppStatement = connection.prepareStatement("SELECT * FROM mail where recipient_id=?");
        ppStatement.setInt(1, id);
        ResultSet rs = ppStatement.executeQuery();
        while (rs.next()) {
            MailBody mailBody = new MailBody();
            mailBody.setId(id);
            mailBody.setRecipient(getUsername(id));
            mailBody.setSubject(rs.getString(3));
            mailBody.setText(rs.getString(4));
            mailBody.setSender(getUsername(rs.getInt(5)));
             /*
            1-UnRead - Inbox
            2-Read - Inbox   //The mail cannot be read until it isn't in unread form first
            3-Draft
            4-Trash
            5-Spam
             */
            if (rs.getInt(6) == 1) {
                mailBody.setUnread(true);
            } else if (rs.getInt(6) == 3) {
                mailBody.setDraft(true);
            } else if (rs.getInt(6) == 4) {
                mailBody.setTrash(true);
            } else if (rs.getInt(6) == 5) {
                mailBody.setSpam(true);
            }

            //If all conditions fail it is read by default

            mailBody.setRecipient_starred(rs.getBoolean(7));
            mailBody.setDateTime(rs.getDate(8));
            mailBody.setChild_mail(rs.getInt(9));
            mailBody.setPermaTrash(rs.getInt(10));
            mailBody.setSender_starred(rs.getBoolean(11));
            mails.add(mailBody);
        }
        return mails;
    }

    public ArrayList<MailBody> loadUserSentMailsFromDataBase(int id) throws SQLException {
        ArrayList<MailBody> mails = new ArrayList<>();
        //-----------------------------------------sent-MAIL is loaded------------------------------------
        PreparedStatement ppStatement = connection.prepareStatement("SELECT * FROM mail where sender_id=?");
        ppStatement.setInt(1, id);
        ResultSet rs = ppStatement.executeQuery();
        MailBody sentMail = new MailBody();
        while (rs.next()) {
            sentMail.setId(id);
            sentMail.setRecipient(getUsername(rs.getInt(5)));
            sentMail.setSubject(rs.getString(3));
            sentMail.setText(rs.getString(4));
            sentMail.setSender(getUsername(id));
             /*
            1-UnRead - Inbox
            2-Read - Inbox   //The mail cannot be read until it isn't in unread form first
            3-Draft
            4-Trash
            5-Spam
             */
            if (rs.getInt(6) == 1) {
                sentMail.setUnread(true);
            } else if (rs.getInt(6) == 3) {
                sentMail.setDraft(true);
            } else if (rs.getInt(6) == 4) {
                sentMail.setTrash(true);
            } else if (rs.getInt(6) == 5) {
                sentMail.setSpam(true);
            }

            //If all conditions fail it is read by default

            sentMail.setRecipient_starred(rs.getBoolean(7));
            sentMail.setDateTime(rs.getDate(8));
            sentMail.setChild_mail(rs.getInt(9));
            sentMail.setPermaTrash(rs.getInt(10));
            sentMail.setSender_starred(rs.getBoolean(11));
        }
        return mails;
    }

    public void loadUserDataFromDataBase(int id) throws SQLException {
        Driver.mail.setUser(loadUserInfoFromDataBase(id));
        Driver.mail.setMails(loadUserMailsFromDataBase(id));
        Driver.mail.setSent(loadUserSentMailsFromDataBase(id));
    }

    private void setChild(int parent_id,int child_id ) throws SQLException {
        PreparedStatement ppsStatement = connection.prepareStatement("UPDATE mail SET child_mail = ? WHERE recipient_id = ?");
        ppsStatement.setInt(1,child_id);
        ppsStatement.setInt(1,parent_id);
        ppsStatement.executeQuery();
    }

    public void permaDelMail(int id) throws SQLException {
        PreparedStatement ppsStatement = connection.prepareStatement("DELETE from mail where recipient_id = ? ");
        ppsStatement.setInt(1,id);
        ppsStatement.executeQuery();
    }

    public void updateUserDataBase(int id){
        //To be made
    }

    public void updateUserInfo() throws SQLException {
        PreparedStatement ppsStatement = connection.prepareStatement("UPDATE mail SET username = ?,password = ?,firstName=?,lastName=?,gender=?,address=?,securityQuestion=?,securityQuestionAnswer=? WHERE id = ?");
        ppsStatement.setString(1,Driver.mail.getUser().getUsername());
        ppsStatement.setString(2,Driver.mail.getUser().getPassword());
        ppsStatement.setString(3,Driver.mail.getUser().getFirstName());
        ppsStatement.setString(4,Driver.mail.getUser().getLastName());
        ppsStatement.setString(5,Driver.mail.getUser().getGender());
        ppsStatement.setString(6,Driver.mail.getUser().getAddress());
        ppsStatement.setString(7,Driver.mail.getUser().getSecurityQuestion());
        ppsStatement.setString(8,Driver.mail.getUser().getSecurityQuestionAnswer());
        ppsStatement.setInt(9,Driver.mail.getUser().getId());
        ppsStatement.executeQuery();
    }

    public void updateUserMails() throws SQLException {
        PreparedStatement ppsStatement = connection.prepareStatement("UPDATE mail SET subject=?,body=?,status=?,recipient_starred =?,dateTime=?,permaTrash=?,sender_id=? WHERE recipient_id = ?");
        for(int i=0;i<Driver.mail.getSent().size();i++) {
            ppsStatement.setString(1, Driver.mail.getInbox().get(i).getSubject());
            ppsStatement.setString(2, Driver.mail.getInbox().get(i).getText());
            int status;
            /*
            1-UnRead - Inbox
            2-Read - Inbox   //The mail cannot be read until it isn't in unread form first
            3-Draft
            4-Trash
            5-Spam
             */
            if(Driver.mail.getInbox().get(i).isUnread()) {
                status = 1;
            }
            else if (Driver.mail.getInbox().get(i).isDraft()) { status = 3; }
            else if (Driver.mail.getInbox().get(i).isTrash()) { status = 4; }
            else if (Driver.mail.getInbox().get(i).isSpam()) { status = 5; }
            else { status = 2; }
            ppsStatement.setInt(3,status );
            ppsStatement.setBoolean(4,Driver.mail.getInbox().get(i).isRecipient_starred());
            ppsStatement.setDate(5,Driver.mail.getInbox().get(i).getDateTime());
            ppsStatement.setInt(6,Driver.mail.getInbox().get(i).getPermaTrash());
            ppsStatement.setInt(7,getId(Driver.mail.getInbox().get(i).getSender()));
            ppsStatement.executeQuery();
        }
    }

    public void updateUserSentMails() throws SQLException {
        PreparedStatement ppsStatement = connection.prepareStatement("UPDATE mail SET sender_starred = ?,permaTrash = ? WHERE sender_id = ?");
        for(int i=0;i<Driver.mail.getSent().size();i++) {
            ppsStatement.setBoolean(1, Driver.mail.getSent().get(i).isSender_starred());
            ppsStatement.setInt(2, Driver.mail.getSent().get(i).getPermaTrash());;
            ppsStatement.setInt(3,getId(Driver.mail.getSent().get(i).getSender()));
            ppsStatement.executeQuery();
        }
    }

}