//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.Map;

//==========================================> CLASS LOG IN MENU <=======================================================

public class LogInMenu extends JFrame implements ActionListener, KeyListener {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;

    private JLabel mainLabel;
    private JLabel signUpLabel;
    private JLabel signUpsLink;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel forgottenPassword = new JLabel("Forgotten Password?");

    private JTextField     usernameField;
    private JPasswordField passwordField;

    private JButton btn_Return;
    private JButton btn_LogInn;

    private Font font;
    private Map attributes;
    private Boolean flag = false;

    private ImageIcon icon;
    private Image img;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public LogInMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(450, 200, 500, 400);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 500, 400, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
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

        JLabel mainIcon = new JLabel(this.icon);
        mainIcon.setBounds(5,5,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Log In Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(475, 15, 25, 22);
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
        minusLabel.setBounds(450, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));
        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Log In");
        mainLabel.setBounds(200, 35, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 32));

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 18);

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(75, 110, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> PASSWORD LABEL <==========================================================

        passwordLabel = new JLabel("Password ");
        passwordLabel.setBounds(75, 150, 100, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.BOLD, 16);

        usernameField = new JTextField();
        usernameField.setBounds(175, 110, 250, 20);
        usernameField.setBackground(new Color(46, 49, 49));
        usernameField.setForeground(new Color(243, 241, 239));
        usernameField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        usernameField.setCaretColor(Color.white);
        usernameField.setFont(font);
        usernameField.addKeyListener(this);

//==========================================> PASSWORD TEXT FIELD <=====================================================

        passwordField = new JPasswordField();
        passwordField.setBounds(175, 150, 250, 20);
        passwordField.setBackground(new Color(46, 49, 49));
        passwordField.setForeground(new Color(243, 241, 239));
        passwordField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(font);
        passwordField.addKeyListener(this);

//==========================================> SIGN UP LABEL / SIGN UP LINK <============================================

        signUpLabel = new JLabel("Don't have an Account? Click Here to ");
        signUpLabel.setBounds(75, 300, 295, 20);
        signUpLabel.setForeground(new Color(243, 241, 239));

        signUpsLink = new JLabel("Sign Up!");
        signUpsLink.setBounds(365, 300, 70, 20);
        signUpsLink.setForeground(new Color(34, 167, 240));
        signUpLabel.setFont(font);
        signUpsLink.setFont(font);

        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        signUpsLink.setFont(font.deriveFont(attributes));
        signUpsLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpsLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SignUpMenu();
            }
        });

//==========================================> RETURN BUTTON <===========================================================

        btn_Return = new JButton("Return");
        btn_Return.setBounds(100, 235, 120, 30);
        btn_Return.setBackground(new Color(242, 38, 19));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Click to Go Back");
        btn_Return.setFont(font);
        btn_Return.addActionListener(this);
        btn_Return.addKeyListener(this);

//==========================================> LOG IN BUTTON <===========================================================

        btn_LogInn = new JButton("Log In");
        btn_LogInn.setBounds(275, 235, 120, 30);
        btn_LogInn.setBackground(new Color(34, 167, 240));
        btn_LogInn.setForeground(new Color(243, 241, 239));
        btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogInn.setToolTipText("Click to Log into E.M.S");
        btn_LogInn.setFont(font);
        btn_LogInn.addActionListener(this);
        btn_LogInn.addKeyListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(signUpLabel);
        mainBody.add(signUpsLink);
        mainBody.add(usernameLabel);
        mainBody.add(passwordLabel);
        mainBody.add(usernameField);
        mainBody.add(passwordField);
        mainBody.add(forgottenPassword);
        mainBody.add(btn_Return);
        mainBody.add(btn_LogInn);

        forgottenPass();
        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> FORGOTTEN PASSWORD <======================================================

    public void forgottenPass() {

        forgottenPassword.setBounds(275, 180, 180, 20);
        forgottenPassword.setForeground(new Color(34, 167, 240));
        forgottenPassword.setToolTipText("Press this Text to Read the Information");

        font = new Font("Arial", Font.BOLD, 14);
        forgottenPassword.setFont(font);
        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        forgottenPassword.setFont(font.deriveFont(attributes));

        forgottenPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgottenPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (true) {
                    dispose();
                    new ForgottenPass();
                } else {
                    JOptionPane.showMessageDialog(LogInMenu.super.rootPane, "", "Invalid Answer", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

//==========================================> LOG IN CONDITION <========================================================

    public void logInCondition() throws SQLException {
        if (Driver.dataAgent.getId(usernameField.getText().trim(),passwordField.getText().trim())!=-1){
            Driver.mail.loadUserdata(Driver.mail.getId(usernameField.getText().trim()));
            dispose();
            Driver.mail.loadUserdata(Driver.dataAgent.getId(usernameField.getText().trim()));
            new EmailMenu();
        } else {
            JOptionPane.showMessageDialog(LogInMenu.super.rootPane, "Error! Either Username or Password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_LogInn) {
            try { logInCondition(); }
            catch (SQLException ex) { ex.printStackTrace(); }
        } else if (e.getSource() == btn_Return) {
            dispose(); new MainMenu();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == passwordField || e.getSource() == btn_LogInn) {
                try { logInCondition(); }
                catch (SQLException ex) { ex.printStackTrace(); }
            } else if (e.getSource() == btn_Return) {
                dispose(); new MainMenu();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }
}

//==========================================> END OF CODE <=============================================================