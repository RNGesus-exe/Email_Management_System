//==========================================> IMPORTED FILES <==========================================================

import com.toedter.calendar.JDateChooser;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;
import java.util.Properties;

//==========================================> CLASS SIGN UP MENU <======================================================

public class SignUpMenu extends JFrame implements ActionListener {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;
    
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField  firstnameField;
    private JTextField  lastnameField;

    private JLabel genderLabel;
    private ButtonGroup genderGroup = new ButtonGroup();
    private JRadioButton btn_MaleOption;
    private JRadioButton btn_GirlOption;
    private JRadioButton btn_OthrOption;

    private JLabel dobLabel;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private JDateChooser dateSet;

    private JLabel phoneNoLabel;
    private JLabel addressLabel;
    private JTextField phoneNoField;
    private JTextArea addressTextArea;

    private JLabel securityQsLabel;
    private JLabel securityAsLabel;
    private JComboBox securityQsBox;
    private JPasswordField securityAnsField;

    private String [] securityQuestions = { "What is your favourite book?", "Who is your best friend?", 
                                            "What is your pet's name?"    , "What is your hobby?"    };
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel retypePassLabel;

    private JTextField     usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPassField;

    private JLabel returnIcon;
    private JButton btn_Resets;
    private JButton btn_SignUp;

    private Font font;
    private Date date = new Date();

    private ImageIcon icon;
    private Image img;
    private JLabel mainIcon;

    private String[] userData;
    /** Order Of Input:-
     *      0: First Name
     *      1: Last  Name
     *      2: Gender
     *      3: Date of Birth
     *      4: Phone no.
     *      5: Address
     *      6: Username
     *      7: Password
     *      8: Confirm Password
     *      9: Security Question
     *      10: Security Answer
     **/

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public SignUpMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 75, 900, 700);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 900, 700, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 900, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);
        
//==========================================> J-PANEL MAIN ICON <=======================================================

        this.icon = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(icon.getImage());

        img = this.icon.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(img);

        mainIcon = new JLabel(this.icon);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 900, 650);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Sign Up Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(875, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        closeLabel.setToolTipText("Close");
        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

//==========================================> MINUS LABEL <=============================================================

        minusLabel = new JLabel("-");
        minusLabel.setBounds(850, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));
        minusLabel.setToolTipText("Minimize");
        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUpMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Sign Up Menu");
        mainLabel.setBounds(350, 35, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 32));

//==========================================> FIRST NAME LABEL <========================================================

        font = new Font("Arial", Font.BOLD, 18);

        firstnameLabel = new JLabel("First Name ");
        firstnameLabel.setBounds(50, 100, 100, 20);
        firstnameLabel.setForeground(new Color(243, 241, 239));
        firstnameLabel.setFont(font);

//==========================================> LAST NAME LABEL <=========================================================

        lastnameLabel = new JLabel("Last Name ");
        lastnameLabel.setBounds(475, 100, 100, 20);
        lastnameLabel.setForeground(new Color(243, 241, 239));
        lastnameLabel.setFont(font);

//==========================================> GENDER LABEL <============================================================

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 150, 80, 20);
        genderLabel.setForeground(new Color(243, 241, 239));
        genderLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> DATE OF BIRTH LABEL <=====================================================

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(475, 150, 120, 20);
        dobLabel.setForeground(new Color(243, 241, 239));
        dobLabel.setFont(font);

//==========================================> ADDRESS LABEL <===========================================================

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 100, 20);
        addressLabel.setForeground(new Color(243, 241, 239));
        addressLabel.setFont(font);

//==========================================> ADDRESS TEXT AREA <=======================================================

        addressTextArea = new JTextArea();
        addressTextArea.setBounds(175, 250, 675, 50);
        addressTextArea.setBackground(new Color(46, 49, 49));
        addressTextArea.setForeground(new Color(243, 241, 239));
        addressTextArea.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        addressTextArea.setCaretColor(Color.white);
        addressTextArea.setDocument(new JTextFieldLimit(200));
        addressTextArea.setLineWrap(true);
        addressTextArea.setEditable(true);

//==========================================> SECURITY QUESTION LABEL <=================================================

        securityQsLabel = new JLabel("Security Question");
        securityQsLabel.setBounds(50, 360, 200, 20);
        securityQsLabel.setForeground(new Color(243, 241, 239));
        securityQsLabel.setFont(font);

//==========================================> SECURITY QUESTION COMBO BOX <=============================================

        securityQsBox = new JComboBox(securityQuestions);
        securityQsBox.setBounds(250, 360, 500, 30);
        securityQsBox.setBackground(new Color(255, 255, 255));
        securityQsBox.setForeground(new Color(0, 0, 0));
        securityQsBox.setFont(new Font("Arial", Font.PLAIN, 16));

//==========================================> SECURITY ANSWER LABEL <===================================================

        securityAsLabel = new JLabel("Security Answer");
        securityAsLabel.setBounds(50, 400, 200, 20);
        securityAsLabel.setForeground(new Color(243, 241, 239));
        securityAsLabel.setFont(font);

//==========================================> USERNAME LABEL <==========================================================

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(50, 460, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> PASSWORD LABEL <==========================================================

        passwordLabel = new JLabel("Password ");
        passwordLabel.setBounds(50, 500, 100, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> RETYPE PASSWORD LABEL <===================================================

        retypePassLabel = new JLabel("Confirm Password");
        retypePassLabel.setBounds(50, 540, 180, 20);
        retypePassLabel.setForeground(new Color(243, 241, 239));
        retypePassLabel.setFont(font);

//==========================================> ADDING YEARS/MONTHS/DATES COMBO BOX <=====================================

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dateSet = new JDateChooser();
        dateSet.setBounds(600, 150, 250, 26);

//==========================================> PHONE NO. LABEL <=========================================================

        phoneNoLabel = new JLabel("Phone no.");
        phoneNoLabel.setBounds(50, 200, 200, 20);
        phoneNoLabel.setForeground(new Color(243, 241, 239));
        phoneNoLabel.setFont(font);

//==========================================> FIRST NAME TEXT FIELD <===================================================

        font = new Font("Arial", Font.PLAIN, 16);

        firstnameField = new JTextField();
        firstnameField.setBounds(175, 100, 250, 20);
        firstnameField.setBackground(new Color(46, 49, 49));
        firstnameField.setForeground(new Color(243, 241, 239));
        firstnameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        firstnameField.setCaretColor(Color.white);
        firstnameField.setFont(font);

//==========================================> LAST NAME TEXT FIELD <====================================================

        lastnameField = new JTextField();
        lastnameField.setBounds(600, 100, 250, 20);
        lastnameField.setBackground(new Color(46, 49, 49));
        lastnameField.setForeground(new Color(243, 241, 239));
        lastnameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        lastnameField.setCaretColor(Color.white);
        lastnameField.setFont(font);
        
//==========================================> MALE RADIO BUTTON <=======================================================

        btn_MaleOption = new JRadioButton("Male");
        btn_MaleOption.setBounds(180, 150, 60, 30);
        btn_MaleOption.setBackground(new Color(52, 73, 94));
        btn_MaleOption.setForeground(new Color(243, 241, 239));
        btn_MaleOption.setFont(font);
        btn_MaleOption.addActionListener(this);

//==========================================> FEMALE RADIO BUTTON <=====================================================

        btn_GirlOption = new JRadioButton("Female");
        btn_GirlOption.setBounds(260, 150, 80, 30);
        btn_GirlOption.setBackground(new Color(52, 73, 94));
        btn_GirlOption.setForeground(new Color(243, 241, 239));
        btn_GirlOption.setFont(font);
        btn_GirlOption.addActionListener(this);

//==========================================> OTHERS RADIO BUTTON <=====================================================

        btn_OthrOption = new JRadioButton("Other");
        btn_OthrOption.setBounds(350, 150, 80, 30);
        btn_OthrOption.setBackground(new Color(52, 73, 94));
        btn_OthrOption.setForeground(new Color(243, 241, 239));
        btn_OthrOption.setFont(font);
        btn_OthrOption.addActionListener(this);

//==========================================> PHONE NO. TEXT FIELD <====================================================

        phoneNoField = new JTextField();
        phoneNoField.setBounds(175, 200, 250, 20);
        phoneNoField.setBackground(new Color(46, 49, 49));
        phoneNoField.setForeground(new Color(243, 241, 239));
        phoneNoField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        phoneNoField.setCaretColor(Color.white);
        phoneNoField.setFont(new Font("Arial", Font.PLAIN, 16));
        
//==========================================> USERNAME TEXT FIELD <=====================================================

        securityAnsField = new JPasswordField();
        securityAnsField.setBounds(250, 400, 500, 20);
        securityAnsField.setBackground(new Color(46, 49, 49));
        securityAnsField.setForeground(new Color(243, 241, 239));
        securityAnsField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        securityAnsField.setCaretColor(Color.white);
        securityAnsField.setFont(font);
        
//==========================================> USERNAME TEXT FIELD <=====================================================

        usernameField = new JTextField();
        usernameField.setBounds(250, 460, 300, 20);
        usernameField.setBackground(new Color(46, 49, 49));
        usernameField.setForeground(new Color(243, 241, 239));
        usernameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        usernameField.setCaretColor(Color.white);
        usernameField.setFont(font);

//==========================================> PASSWORD TEXT FIELD <=====================================================

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 500, 300, 20);
        passwordField.setBackground(new Color(46, 49, 49));
        passwordField.setForeground(new Color(243, 241, 239));
        passwordField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(font);

//==========================================> RETYPE PASSWORD TEXT FIELD <==============================================

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(250, 540, 300, 20);
        confirmPassField.setBackground(new Color(46, 49, 49));
        confirmPassField.setForeground(new Color(243, 241, 239));
        confirmPassField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        confirmPassField.setCaretColor(Color.white);
        confirmPassField.setFont(font);

//==========================================> RETURN BUTTON <===========================================================

        this.icon = new ImageIcon("Icons/Return.png");
        img = this.icon.getImage();
        img = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(img);

        returnIcon = new JLabel(this.icon);
        returnIcon.setBounds(10,10,30,30);
        returnIcon.setLayout(null);
        returnIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new MainMenu();
            }
        });

//==========================================> RESETS BUTTON <===========================================================

        btn_Resets = new JButton("Reset");
        btn_Resets.setBounds(275, 600, 120, 30);
        btn_Resets.setBackground(new Color(242, 38, 19));
        btn_Resets.setForeground(new Color(243, 241, 239));
        btn_Resets.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Resets.setToolTipText("Empties all the Options");
        btn_Resets.setFont(font);
        btn_Resets.addActionListener(this);

//==========================================> SIGN UP BUTTON <==========================================================

        btn_SignUp = new JButton("Sign Up");
        btn_SignUp.setBounds(450, 600, 120, 30);
        btn_SignUp.setBackground(new Color(34, 167, 240));
        btn_SignUp.setForeground(new Color(243, 241, 239));
        btn_SignUp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_SignUp.setToolTipText("This Button is Used to Log In to our E.M.S");
        btn_SignUp.setFont(font);
        btn_SignUp.addActionListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(firstnameLabel);
        mainBody.add(firstnameField);
        mainBody.add(lastnameLabel);
        mainBody.add(lastnameField);

        mainBody.add(genderLabel);
        genderGroup.add(btn_MaleOption);
        genderGroup.add(btn_GirlOption);
        genderGroup.add(btn_OthrOption);
        mainBody.add(btn_MaleOption);
        mainBody.add(btn_GirlOption);
        mainBody.add(btn_OthrOption);

        mainBody.add(dobLabel);
        mainBody.add(datePicker);
        mainBody.add(dateSet);

        mainBody.add(phoneNoField);
        mainBody.add(phoneNoLabel);
        mainBody.add(addressLabel);
        mainBody.add(addressTextArea);

        mainBody.add(securityQsLabel);
        mainBody.add(securityQsBox);
        mainBody.add(securityAsLabel);
        mainBody.add(securityAnsField);

        mainBody.add(usernameLabel);
        mainBody.add(usernameField);
        mainBody.add(passwordLabel);
        mainBody.add(passwordField);
        mainBody.add(retypePassLabel);
        mainBody.add(confirmPassField);

        mainBody.add(returnIcon);
        mainBody.add(btn_Resets);
        mainBody.add(btn_SignUp);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> SIGN UP VALIDATIONS FUNCTION <============================================

    public void signUpValidations() {
        if ((firstnameField.getText().trim().equals("") && lastnameField.getText().trim().equals("")) || isContainsSpecialChar(firstnameField.getText().trim()) || isContainsSpecialChar(lastnameField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Enter your Name First!", "Invalid Name!", JOptionPane.ERROR_MESSAGE);
        }
        else if (btn_MaleOption.isSelected() == false && btn_GirlOption.isSelected() == false && btn_OthrOption.isSelected() == false) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Select a Gender First!", "Invalid Gender!", JOptionPane.ERROR_MESSAGE);
        }
        else if (phoneNoField.getText().trim().equals("") || isPhoneNoValid()) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Enter your Phone Number!", "Invalid Phone no.!", JOptionPane.ERROR_MESSAGE);
        }
        else if (addressTextArea.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Enter your Address First!", "Invalid Address!", JOptionPane.ERROR_MESSAGE);
        }
        else if (securityAnsField.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Enter an answer for your Security Question!", "Invalid Address!", JOptionPane.ERROR_MESSAGE);
        }
        else if (usernameField.getText().trim().equals("") || isContainsSpecialChar(usernameField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Enter Your Username First!", "Invalid Username!", JOptionPane.ERROR_MESSAGE);
        }
        else if (passwordField.getText().trim().equals("") || !(confirmPassField.getText().equals(passwordField.getText()))) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! Confirm Password should match your password!", "Invalid Password!", JOptionPane.ERROR_MESSAGE);
        }
        else if (!datePicker.isShowing()) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Error! No Date Selected!", "Invalid Date of Birth!", JOptionPane.ERROR_MESSAGE);
        }
        else if (Driver.dataAgent.checkUserRepetition(usernameField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "The entered username is already taken!", "Username Already Exists", JOptionPane.ERROR_MESSAGE);
        }
        else if (Driver.dataAgent.checkPhoneNumberRepetition(phoneNoField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.this, "The phone number has already been with an email!", "Phone Number Already In Use", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(SignUpMenu.this, "Your Account has been Successfully made!", "Success!", JOptionPane.PLAIN_MESSAGE);
            uploadBioToDatabase();
            dispose(); new MainMenu();
        }
    }

//==========================================> USER DATA FUNCTIONS <=====================================================

    public void setUserData() {
        userData = new String[11];
        userData[0] = firstnameField.getText().toLowerCase().trim();
        userData[1] = lastnameField.getText().toLowerCase().trim();

        if (btn_MaleOption.isEnabled()) { userData[2] = "male"; }
        else if (btn_GirlOption.isEnabled()) { userData[2] = "female"; }
        else { userData[2] = "other"; }

        userData[3] = String.valueOf(date.getDay() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900));
        userData[4] = phoneNoField.getText().toLowerCase().trim();
        userData[5] = addressTextArea.getText().toLowerCase().trim();
        userData[6] = usernameField.getText().trim();
        userData[7] = passwordField.getText().trim();
        userData[8] = confirmPassField.getText().trim();   //Not needed remove in next patch
        userData[9] = String.valueOf(securityQsBox.getSelectedItem());
        userData[10] = securityAnsField.getText().trim();
    }

    public void uploadBioToDatabase() {
        setUserData();
        userData = getUserData();
        Driver.dataAgent.addUser(userData[6],userData[7],userData[0],userData[1],userData[2],userData[5],userData[9],userData[10],userData[4],userData[3]);
    }

    public String[] getUserData() { return this.userData; }

//==========================================> PHONE NO. VALIDATIONS FUNCTION <==========================================

    public Boolean isPhoneNoValid() {
        for (int i = 0; i < phoneNoField.getText().length(); i++) {
            if (phoneNoField.getText().charAt(i) < '0' || phoneNoField.getText().charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

//==========================================> NAMES VALIDATIONS FUNCTION <==============================================

    public Boolean isContainsSpecialChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || (str.charAt(i) > '9' && str.charAt(i) < 'A') || (str.charAt(i) > 'Z' && str.charAt(i) < 'a') || str.charAt(i) > 'z') {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_MaleOption) { btn_MaleOption.setEnabled(true); }
        else if (e.getSource() == btn_GirlOption) { btn_GirlOption.setEnabled(true); }
        else if (e.getSource() == btn_OthrOption) { btn_OthrOption.setEnabled(true); }
        else if (e.getSource() == btn_Resets) { dispose(); new SignUpMenu(); }
        else if (e.getSource() == btn_SignUp) { signUpValidations(); }
    }
}

//==========================================> END OF LINE HERE <========================================================