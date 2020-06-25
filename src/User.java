import java.sql.Timestamp;

public class User {

    //-------------------------------------DATA MEMBERS--------------------------------------------------------
    private int id;
    private String username;
    private String password;
    private Timestamp dateTime;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String securityQuestion;
    private String securityQuestionAnswer;
    private String phoneNumber;
    private String birthDate;


//-------------------------------------CONSTRUCTORS---------------------------------------------------------

    public User() {}

    public User(String username, String password, String firstName, String lastName, String gender, String address,String securityQuestion,String securityQuestionAnswer) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.securityQuestion=securityQuestion;
        this.securityQuestionAnswer=securityQuestionAnswer;
    }

    //-------------------------------------SETTERS/GETTERS-------------------------------------------------------


    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }
    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername () {
        return username;
    }
    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }
    public void setPassword (String password) {
        this.password = password;
    }
}