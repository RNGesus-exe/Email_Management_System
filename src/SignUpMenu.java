//==========================================> IMPORTED FILES <==========================================================

import com.toedter.calendar.JDateChooser;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

//==========================================> CLASS SIGN UP MENU <======================================================

public class SignUpMenu extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;

    private JLabel mainLabel;
    private JLabel infoLabel;

    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField  firstnameField;
    private JTextField  lastnameField;

    private JLabel genderLabel;
    private ButtonGroup genderGroup = new ButtonGroup();
    private JRadioButton btn_MaleOption;
    private JRadioButton btn_GirlOption;

    private JLabel dobLabel;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private JDateChooser dateSet;

    private JLabel phoneNoLabel;
    private JLabel addressLabel;
    private JTextField phoneNoField;
    private JTextArea addressTextArea;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel retypePassLabel;

    private JTextField     usernameField;
    private JPasswordField passwordField;
    private JPasswordField retypePassField;

    private JLabel returnIcon;
    private JButton btn_Resets;
    private JButton btn_SignUp;

    private Font font;
    private Map attributes;
    private Date date = new Date();

    private ImageIcon background;
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
     **/

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public SignUpMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(350, 100, 700, 650);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 700, 650, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 700, 50);
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
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        mainIcon = new JLabel(background);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 700, 600);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Sign Up Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(675, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 22));

        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.setToolTipText("Close");
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

//==========================================> MINUS LABEL <=============================================================

        minusLabel = new JLabel("-");
        minusLabel.setBounds(650, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));

        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUpMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Register");
        mainLabel.setBounds(300, 35, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 32));

//==========================================> FIRST NAME LABEL <========================================================

        font = new Font("Arial", Font.BOLD, 18);

        firstnameLabel = new JLabel("First Name ");
        firstnameLabel.setBounds(50, 110, 100, 20);
        firstnameLabel.setForeground(new Color(243, 241, 239));
        firstnameLabel.setFont(font);

//==========================================> LAST NAME LABEL <=========================================================

        lastnameLabel = new JLabel("Last Name ");
        lastnameLabel.setBounds(350, 110, 100, 20);
        lastnameLabel.setForeground(new Color(243, 241, 239));
        lastnameLabel.setFont(font);

//==========================================> FIRST NAME TEXT FIELD <===================================================

        font = new Font("Arial", Font.PLAIN, 16);

        firstnameField = new JTextField();
        firstnameField.setBounds(150, 110, 180, 20);
        firstnameField.setBackground(new Color(46, 49, 49));
        firstnameField.setForeground(new Color(243, 241, 239));
        firstnameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        firstnameField.setCaretColor(Color.white);
        firstnameField.setFont(font);
        firstnameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> LAST NAME TEXT FIELD <====================================================

        lastnameField = new JTextField();
        lastnameField.setBounds(450, 110, 180, 20);
        lastnameField.setBackground(new Color(46, 49, 49));
        lastnameField.setForeground(new Color(243, 241, 239));
        lastnameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        lastnameField.setCaretColor(Color.white);
        lastnameField.setFont(font);
        lastnameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> GENDER LABEL <============================================================

        genderLabel = new JLabel("Gender           | ");
        genderLabel.setBounds(50, 150, 150, 20);
        genderLabel.setForeground(new Color(243, 241, 239));
        genderLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> MALE RADIO BUTTON <=======================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_MaleOption = new JRadioButton("Male");
        btn_MaleOption.setBounds(200, 150, 100, 30);
        btn_MaleOption.setBackground(new Color(52, 73, 94));
        btn_MaleOption.setForeground(new Color(243, 241, 239));
        btn_MaleOption.setFont(font);

        btn_MaleOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_MaleOption.setEnabled(true);
            }
        });

//==========================================> FEMALE RADIO BUTTON <=====================================================

        btn_GirlOption = new JRadioButton("Female");
        btn_GirlOption.setBounds(300, 150, 100, 30);
        btn_GirlOption.setBackground(new Color(52, 73, 94));
        btn_GirlOption.setForeground(new Color(243, 241, 239));
        btn_GirlOption.setFont(font);

        btn_GirlOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_GirlOption.setEnabled(true);
            }
        });

//==========================================> DATE OF BIRTH LABEL <=====================================================

        font = new Font("Arial", Font.BOLD, 18);

        dobLabel = new JLabel("Date of Birth | ");
        dobLabel.setBounds(50, 200, 150, 20);
        dobLabel.setForeground(new Color(243, 241, 239));
        dobLabel.setFont(font);

//==========================================> ADDING YEARS/MONTHS/DATES COMBO BOX <=====================================

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dateSet = new JDateChooser();
        dateSet.setBounds(200, 200, 200, 26);

//==========================================> PHONE NO. LABEL <=========================================================

        phoneNoLabel = new JLabel("Phone no.      | ");
        phoneNoLabel.setBounds(50, 250, 150, 20);
        phoneNoLabel.setForeground(new Color(243, 241, 239));
        phoneNoLabel.setFont(font);

//==========================================> PHONE NO. TEXT FIELD <====================================================

        phoneNoField = new JTextField();
        phoneNoField.setBounds(200, 250, 250, 20);
        phoneNoField.setBackground(new Color(46, 49, 49));
        phoneNoField.setForeground(new Color(243, 241, 239));
        phoneNoField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        phoneNoField.setCaretColor(Color.white);
        phoneNoField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneNoField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> ADDRESS LABEL <===========================================================

        font = new Font("Arial", Font.BOLD, 18);

        addressLabel = new JLabel("Address         | ");
        addressLabel.setBounds(50, 300, 150, 20);
        addressLabel.setForeground(new Color(243, 241, 239));
        addressLabel.setFont(font);

//==========================================> ADDRESS TEXT AREA <=======================================================

        addressTextArea = new JTextArea();
        addressTextArea.setBounds(200, 300, 450, 70);
        addressTextArea.setBackground(new Color(46, 49, 49));
        addressTextArea.setForeground(new Color(243, 241, 239));
        addressTextArea.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        addressTextArea.setCaretColor(Color.white);
        addressTextArea.setDocument(new JTextFieldLimit(150));
        addressTextArea.setLineWrap(true);
        addressTextArea.setEditable(true);

//==========================================> USERNAME LABEL <==========================================================

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(50, 400, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> PASSWORD LABEL <==========================================================

        passwordLabel = new JLabel("Password ");
        passwordLabel.setBounds(50, 450, 100, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> RETYPE PASSWORD LABEL <===================================================

        retypePassLabel = new JLabel("Retype Pass ");
        retypePassLabel.setBounds(50, 500, 120, 20);
        retypePassLabel.setForeground(new Color(243, 241, 239));
        retypePassLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField();
        usernameField.setBounds(175, 400, 250, 20);
        usernameField.setBackground(new Color(46, 49, 49));
        usernameField.setForeground(new Color(243, 241, 239));
        usernameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        usernameField.setCaretColor(Color.white);
        usernameField.setFont(font);
        usernameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> PASSWORD TEXT FIELD <=====================================================

        passwordField = new JPasswordField();
        passwordField.setBounds(175, 450, 250, 20);
        passwordField.setBackground(new Color(46, 49, 49));
        passwordField.setForeground(new Color(243, 241, 239));
        passwordField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(font);
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> RETYPE PASSWORD TEXT FIELD <==============================================

        retypePassField = new JPasswordField();
        retypePassField.setBounds(175, 500, 250, 20);
        retypePassField.setBackground(new Color(46, 49, 49));
        retypePassField.setForeground(new Color(243, 241, 239));
        retypePassField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        retypePassField.setCaretColor(Color.white);
        retypePassField.setFont(font);
        retypePassField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> INFO LABEL <==============================================================

        infoLabel = new JLabel("Learn More!");
        infoLabel.setBounds(600, 10, 100, 20);
        infoLabel.setForeground(new Color(34, 167, 240));
        infoLabel.setToolTipText("Press this Text to Read the Information");

        font = new Font("Arial", Font.BOLD, 14);
        infoLabel.setFont(font);

        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        infoLabel.setFont(font.deriveFont(attributes));

//==========================================> ABOUT SECTION <===========================================================

        infoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JTextArea textArea = new JTextArea(15, 50);
                textArea.setLineWrap(true);
                textArea.setText("Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, scrollPane, "About Us", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

//==========================================> RETURN BUTTON <===========================================================

        background = new ImageIcon("Icons/Return.png");
        img = background.getImage();
        img = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        returnIcon = new JLabel(background);
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

        font = new Font("Arial", Font.BOLD, 16);

        btn_Resets = new JButton("Reset");
        btn_Resets.setBounds(200, 550, 120, 30);
        btn_Resets.setBackground(new Color(242, 38, 19));
        btn_Resets.setForeground(new Color(243, 241, 239));
        btn_Resets.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Resets.setToolTipText("This Button will cancel the process");
        btn_Resets.setFont(font);

        btn_Resets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUpMenu();
            }
        });

        btn_Resets.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                    new LogInMenu();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> SIGN UP BUTTON <==========================================================

        btn_SignUp = new JButton("Sign Up");
        btn_SignUp.setBounds(375, 550, 120, 30);
        btn_SignUp.setBackground(new Color(34, 167, 240));
        btn_SignUp.setForeground(new Color(243, 241, 239));
        btn_SignUp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_SignUp.setToolTipText("This Button is Used to Log In to our E.M.S");
        btn_SignUp.setFont(font);

        btn_SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpValidations();
            }
        });

        btn_SignUp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(SignUpMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    signUpValidations();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(infoLabel);
        mainBody.add(firstnameLabel);
        mainBody.add(firstnameField);
        mainBody.add(lastnameLabel);
        mainBody.add(lastnameField);

        mainBody.add(genderLabel);
        genderGroup.add(btn_MaleOption);
        genderGroup.add(btn_GirlOption);
        mainBody.add(btn_MaleOption);
        mainBody.add(btn_GirlOption);

        mainBody.add(dobLabel);
        mainBody.add(datePicker);
        mainBody.add(dateSet);

        mainBody.add(phoneNoField);
        mainBody.add(phoneNoLabel);
        mainBody.add(addressLabel);
        mainBody.add(addressTextArea);

        mainBody.add(usernameLabel);
        mainBody.add(usernameField);
        mainBody.add(passwordLabel);
        mainBody.add(passwordField);
        mainBody.add(retypePassLabel);
        mainBody.add(retypePassField);

        mainBody.add(returnIcon);
        mainBody.add(btn_Resets);
        mainBody.add(btn_SignUp);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> SIGN UP VALIDATIONS FUNCTION <============================================
    // It was not getting the date values for me so one condition is not working properly.
    public void signUpValidations() {
        if ((firstnameField.getText().equals("") && lastnameField.getText().equals("")) || isContainsSpecialChar(firstnameField.getText().trim()) || isContainsSpecialChar(lastnameField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Enter your Name First!", "Incorrect Name!", JOptionPane.ERROR_MESSAGE);
        }
        else if (btn_MaleOption.isSelected() == false && btn_GirlOption.isSelected() == false) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Select a Gender First!", "Incorrect Gender!", JOptionPane.ERROR_MESSAGE);
        }
        else if (phoneNoField.getText().equals("") || isPhoneNoValid()) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Enter your Phone Number!", "Incorrect Phone no.!", JOptionPane.ERROR_MESSAGE);
        }
        else if (addressTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Enter your Address First!", "Incorrect Address!", JOptionPane.ERROR_MESSAGE);
        }
        else if (usernameField.getText().equals("") || isContainsSpecialChar(usernameField.getText().trim())) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Enter Your Username First!", "Incorrect Username!", JOptionPane.ERROR_MESSAGE);
        }
        else if (passwordField.getText().equals("") || !(retypePassField.getText().equals(passwordField.getText()))) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! Confirm Password should match your password!", "Incorrect Password!", JOptionPane.ERROR_MESSAGE);
        }
        else if (datePicker.isShowing() == false) {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Error! No Date Selected!", "Incorrect Date of Birth!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(SignUpMenu.super.rootPane, "Your Account has been Successfully made!", "Success!", JOptionPane.PLAIN_MESSAGE);
            setUserData();
            dispose();
            new MainMenu();
        }
    }

//==========================================> USER DATA FUNCTIONS <=====================================================

    /**Order Of Input:
     *  0: First Name
     *  1: Last  Name
     *  2: Gender
     *  3: Date of Birth
     *  4: Phone no.
     *  5: Address
     *  6: Username
     *  7: Password
     *  8: Confirm Password
    **/

    public void setUserData() {
        userData = new String[9];
        userData[0] = firstnameField.getText().toLowerCase().trim();
        userData[1] = lastnameField.getText().toLowerCase().trim();
        if (btn_MaleOption.isEnabled()) {
            userData[2] = "male";
        } else {
            userData[2] = "female";
        }
        userData[3] = String.valueOf(date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900));
        userData[4] = phoneNoField.getText().toLowerCase().trim();
        userData[5] = addressTextArea.getText().toLowerCase().trim();
        userData[6] = usernameField.getText().toLowerCase().trim();
        userData[7] = passwordField.getText().trim();
        userData[8] = retypePassField.getText().trim();
    }

    public String[] getUserData() {
        return this.userData;
    }

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
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
                    if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                        if (str.charAt(i) != '_') {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

//==========================================> END OF LINE HERE <========================================================