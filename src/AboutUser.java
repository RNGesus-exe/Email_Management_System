//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

//==========================================> CLASS SIGN UP MENU <======================================================

public class AboutUser extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JLabel genderLabel;
    private JLabel dobLabel;
    private JLabel accountDOBLabel;
    private JLabel phoneNoLabel;
    private JLabel addressLabel;
    private JTextField phoneNoField;
    private JTextArea addressTextArea;
    private JLabel securityQsLabel;
    private JLabel securityAsLabel;
    private JComboBox securityQsBox;
    private JTextField securityAnsField;          //REWORK OPTIONAL
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;            //REWORK NEEDED
    private JLabel returnIcon;

    private JButton btn_Edit;
    private JButton btn_Save;
    private Font font;
    private String [] securityQuestions = { "What is your favourite book?",
                                            "Who is your best friend?",
                                            "What is your pet's name?",
                                            "What is your hobby?" };
    private ImageIcon background;
    private Image img;
    private JLabel mainIcon;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public AboutUser() {

//==========================================> MAIN J-FRAME <============================================================

        setBounds(250, 75, 900, 650);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 900, 650, 30, 30));
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 900, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        background = new ImageIcon("Icons/Main_Logo.png");
        img = background.getImage();
        img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        mainIcon = new JLabel(background);
        mainIcon.setBounds(05, 05, 40, 40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 900, 600);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("About User Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(875, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 22));

        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.setToolTipText("Close");
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

//==========================================> MINUS LABEL <=============================================================

        minusLabel = new JLabel("-");
        minusLabel.setBounds(850, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));

        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AboutUser.this.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("About User");
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

//==========================================> FIRST NAME TEXT FIELD <===================================================

        font = new Font("Arial", Font.PLAIN, 16);

        firstnameField = new JTextField(Driver.mail.getUser().getFirstName());
        firstnameField.setBounds(175, 100, 250, 20);
        firstnameField.setBackground(new Color(46, 49, 49));
        firstnameField.setForeground(new Color(243, 241, 239));
        firstnameField.setCaretColor(Color.white);
        firstnameField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        firstnameField.setFont(font);
        firstnameField.setEditable(false);

//==========================================> LAST NAME TEXT FIELD <====================================================

        lastnameField = new JTextField(Driver.mail.getUser().getLastName());
        lastnameField.setBounds(600, 100, 250, 20);
        lastnameField.setBackground(new Color(46, 49, 49));
        lastnameField.setForeground(new Color(243, 241, 239));
        lastnameField.setCaretColor(Color.white);
        lastnameField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        lastnameField.setFont(font);
        lastnameField.setEditable(false);

//==========================================> GENDER LABEL <============================================================

        /**
         * Add Gender After Colon.
         **/
        genderLabel = new JLabel("Gender : "+Driver.mail.getUser().getGender());
        genderLabel.setBounds(50, 150, 200, 20);
        genderLabel.setForeground(new Color(243, 241, 239));
        genderLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> DATE OF BIRTH LABEL <=====================================================

        font = new Font("Arial", Font.BOLD, 18);

        /**
         * Add D.O.B After Colon.
         **/
        dobLabel = new JLabel("Date of Birth : "+Driver.mail.getUser().getBirthDate());
        dobLabel.setBounds(475, 150, 250, 20);
        dobLabel.setForeground(new Color(243, 241, 239));
        dobLabel.setFont(font);

//==========================================> ACCOUNT'S DATE OF BIRTH LABEL <===========================================

        /**
         * Add Account's D.O.B After Colon.
         **/

        accountDOBLabel = new JLabel("Account Created on Date : "+Driver.mail.getUser().getDateTime());
        accountDOBLabel.setBounds(50, 200, 600, 20);
        accountDOBLabel.setForeground(new Color(243, 241, 239));
        accountDOBLabel.setFont(font);

//==========================================> PHONE NO. LABEL <=========================================================

        phoneNoLabel = new JLabel("Phone no.");
        phoneNoLabel.setBounds(50, 250, 200, 20);
        phoneNoLabel.setForeground(new Color(243, 241, 239));
        phoneNoLabel.setFont(font);

//==========================================> PHONE NO. TEXT FIELD <====================================================

        phoneNoField = new JTextField(Driver.mail.getUser().getPhoneNumber());
        phoneNoField.setBounds(175, 250, 250, 20);
        phoneNoField.setBackground(new Color(46, 49, 49));
        phoneNoField.setForeground(new Color(243, 241, 239));
        phoneNoField.setCaretColor(Color.white);
        phoneNoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        phoneNoField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneNoField.setEditable(false);

//==========================================> ADDRESS LABEL <===========================================================

        font = new Font("Arial", Font.BOLD, 18);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 300, 100, 20);
        addressLabel.setForeground(new Color(243, 241, 239));
        addressLabel.setFont(font);

//==========================================> ADDRESS TEXT AREA <=======================================================

        addressTextArea = new JTextArea(Driver.mail.getUser().getAddress());
        addressTextArea.setBounds(175, 300, 675, 50);
        addressTextArea.setBackground(new Color(46, 49, 49));
        addressTextArea.setForeground(new Color(243, 241, 239));
        addressTextArea.setCaretColor(Color.white);
        addressTextArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addressTextArea.setLineWrap(true);
        addressTextArea.setEditable(false);

//==========================================> SECURITY QUESTION LABEL <=================================================

        securityQsLabel = new JLabel("Security Question : ");
        securityQsLabel.setBounds(50, 375, 175, 20);
        securityQsLabel.setForeground(new Color(243, 241, 239));
        securityQsLabel.setFont(font);

//==========================================> SECURITY QUESTION COMBO BOX <=============================================

        securityQsBox = new JComboBox(securityQuestions);
        securityQsBox.setBounds(250, 375, 300, 30);
        securityQsBox.setBackground(new Color(255, 255, 255));
        securityQsBox.setForeground(new Color(0, 0, 0));
        securityQsBox.setFont(new Font("Arial", Font.PLAIN, 16));
        securityQsBox.setEnabled(false);

//==========================================> SECURITY ANSWER LABEL <===================================================

        securityAsLabel = new JLabel("Security Answer");
        securityAsLabel.setBounds(50, 420, 200, 20);
        securityAsLabel.setForeground(new Color(243, 241, 239));
        securityAsLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        securityAnsField = new JTextField(Driver.mail.getUser().getSecurityQuestionAnswer());
        securityAnsField.setBounds(250, 420, 300, 20);
        securityAnsField.setBackground(new Color(46, 49, 49));
        securityAnsField.setForeground(new Color(243, 241, 239));
        securityAnsField.setCaretColor(Color.white);
        securityAnsField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        securityAnsField.setFont(font);
        securityAnsField.setEditable(false);

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 18);

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(50, 470, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> PASSWORD LABEL <==========================================================

        passwordLabel = new JLabel("Password ");
        passwordLabel.setBounds(50, 500, 100, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField(Driver.mail.getUser().getUsername());
        usernameField.setBounds(250, 470, 300, 20);
        usernameField.setBackground(new Color(46, 49, 49));
        usernameField.setForeground(new Color(243, 241, 239));
        usernameField.setCaretColor(Color.white);
        usernameField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        usernameField.setFont(font);
        usernameField.setEditable(false);

//==========================================> PASSWORD TEXT FIELD <=====================================================

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 500, 300, 20);
        passwordField.setBackground(new Color(46, 49, 49));
        passwordField.setForeground(new Color(243, 241, 239));
        passwordField.setCaretColor(Color.white);
        passwordField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        passwordField.setFont(font);
        passwordField.show(true);
        passwordField.setEditable(false);

//==========================================> RETURN BUTTON <===========================================================

        background = new ImageIcon("Icons/Return.png");
        img = background.getImage();
        img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        returnIcon = new JLabel(background);
        returnIcon.setBounds(10, 10, 30, 30);
        returnIcon.setLayout(null);
        returnIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

//==========================================> EDIT BUTTON <=============================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_Edit = new JButton("Edit");
        btn_Edit.setBounds(300, 550, 150, 30);
        btn_Edit.setBackground(new Color(242, 38, 19));
        btn_Edit.setForeground(new Color(243, 241, 239));
        btn_Edit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Edit.setToolTipText("Allows to Edit all the Options");
        btn_Edit.setFont(font);
        btn_Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionEditor(true);
            }
        });

//==========================================> SAVE BUTTON <=============================================================

        btn_Save = new JButton("Save");
        btn_Save.setBounds(500, 550, 150, 30);
        btn_Save.setBackground(new Color(34, 167, 240));
        btn_Save.setForeground(new Color(243, 241, 239));
        btn_Save.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Save.setToolTipText("Saves updated Options");
        btn_Save.setFont(font);
        btn_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Driver.mail.getUser().setFirstName(firstnameField.getText().trim());
                Driver.mail.getUser().setLastName(lastnameField.getText().trim());
                Driver.mail.getUser().setPhoneNumber(phoneNoField.getText().trim());
                Driver.mail.getUser().setSecurityQuestion((String) securityQsBox.getSelectedItem());
                Driver.mail.getUser().setSecurityQuestionAnswer(securityAnsField.getText().trim());
                Driver.mail.getUser().setAddress(addressTextArea.getText().trim());
                Driver.mail.updateUserdata(Driver.mail.getUser().getId());
                optionEditor(false);
            }
        });

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
        mainBody.add(dobLabel);
        mainBody.add(accountDOBLabel);
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
        mainBody.add(returnIcon);
        mainBody.add(btn_Edit);
        mainBody.add(btn_Save);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

    public void optionEditor(Boolean flag) {
        firstnameField.setEditable(flag);
        lastnameField.setEditable(flag);
        phoneNoField.setEditable(flag);
        addressTextArea.setEditable(flag);
        securityQsBox.setEnabled(flag);
        securityAnsField.setEditable(flag);
       //passwordField.setEditable(flag);        //Need to attach frame2() of forgotten pass
        mainBody.updateUI();
    }

}

//==========================================> END OF LINE HERE <========================================================