//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

//==========================================> CLASS LOG IN MENU <=======================================================

public class LogInMenu extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private String tempUsername = "Mehroz Mustafa"; // Temp variable - Delete them after adding back end.
    private String tempPassword = "123456";         // Temp variable - Delete them after adding back end.

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private Font font;

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;

    private JLabel mainLabel;
    private JLabel infoLabel;
    private JLabel signUpLabel;
    private JLabel signUpsLink;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel forgottenPassword = new JLabel("Forgotten Password?");

    private JTextField     usernameField;
    private JPasswordField passwordField;

    private JButton btn_Return;
    private JButton btn_Cancel;
    private JButton btn_LogInn;

    private Map attributes;
    private Boolean flag = false;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public LogInMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(450, 200, 500, 400);
        this.setUndecorated(true);
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
        titleBar.setBackground(new Color(34, 167, 240));
        titleBar.setLayout(null);

        ImageIcon icon = new ImageIcon("Icons/Main_Icon.png");
        setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        ImageIcon background = new ImageIcon("Icons/Main_Icon.png");
        Image img = background.getImage();
        img = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(10,10,30,30);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Log In Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));

        font = new Font("Calibri", Font.BOLD, 20);
        titleLabel.setFont(font);

//==========================================> CLOSE LABEL <=============================================================

        font = new Font("Arial", Font.BOLD, 22);

        closeLabel = new JLabel("X");
        closeLabel.setBounds(475, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(font);

        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.setToolTipText("Close");
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

//==========================================> MINUS LABEL <=============================================================

        font = new Font("Arial", Font.BOLD, 44);

        minusLabel = new JLabel("-");
        minusLabel.setBounds(450, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(font);

        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 32);

        mainLabel = new JLabel("Log In");
        mainLabel.setBounds(200, 35, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(font);

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 18);

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(75, 110, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField();
        usernameField.setBounds(175, 110, 250, 20);
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
                    if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> PASSWORD LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 18);

        passwordLabel = new JLabel("Password ");
        passwordLabel.setBounds(75, 150, 100, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> PASSWORD TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        passwordField = new JPasswordField();
        passwordField.setBounds(175, 150, 250, 20);
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
                    if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logInCondition();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> INFO LABEL <==============================================================

        infoLabel = new JLabel("Learn More!");
        infoLabel.setBounds(400, 10, 100, 20);
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
                font = new Font("Arial", Font.BOLD, 18);
                textArea.setLineWrap(true);
                textArea.setText("Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(LogInMenu.super.rootPane, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> SIGN UP LABEL / SIGN UP LINK <============================================

        signUpLabel = new JLabel("Don't have an Account? Click Here to ");
        signUpLabel.setBounds(75, 300, 295, 20);
        signUpLabel.setForeground(new Color(243, 241, 239));

        signUpsLink = new JLabel("Sign Up!");
        signUpsLink.setBounds(365, 300, 70, 20);
        signUpsLink.setForeground(new Color(34, 167, 240));

        font = new Font("Arial", Font.BOLD, 16);
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

        font = new Font("Arial", Font.BOLD, 14);

        btn_Return = new JButton("Go Back");
        btn_Return.setBounds(10, 10, 80, 16);
        btn_Return.setBackground(new Color(108, 122, 137));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Goes Back To Main Menu");
        btn_Return.setFont(font);

        btn_Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });

        btn_Return.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                    new MainMenu();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> CANCEL BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_Cancel = new JButton("Cancel");
        btn_Cancel.setBounds(100, 235, 120, 30);
        btn_Cancel.setBackground(new Color(242, 38, 19));
        btn_Cancel.setForeground(new Color(243, 241, 239));
        btn_Cancel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Cancel.setToolTipText("This Button will cancel the process");
        btn_Cancel.setFont(font);

        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LogInMenu();
            }
        });

        btn_Cancel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
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

//==========================================> LOG IN BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_LogInn = new JButton("Log In");
        btn_LogInn.setBounds(275, 235, 120, 30);
        btn_LogInn.setBackground(new Color(34, 167, 240));
        btn_LogInn.setForeground(new Color(243, 241, 239));
        btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogInn.setToolTipText("This Button is Used to Log In to our E.M.S");
        btn_LogInn.setFont(font);

        btn_LogInn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInCondition();
            }
        });

        btn_LogInn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(LogInMenu.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logInCondition();
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
        mainBody.add(signUpLabel);
        mainBody.add(signUpsLink);
        mainBody.add(usernameLabel);
        mainBody.add(passwordLabel);
        mainBody.add(usernameField);
        mainBody.add(passwordField);
        mainBody.add(forgottenPassword);
        mainBody.add(btn_Return);
        mainBody.add(btn_Cancel);
        mainBody.add(btn_LogInn);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> FORGOTTEN PASSWORD <======================================================

    public void forgottenPass() {

        forgottenPassword.setBounds(275, 180, 150, 20);
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

            }
        });
    }

//==========================================> LOG IN CONDITION <========================================================

    public void logInCondition() {
        if (usernameField.getText().equals(tempUsername) && passwordField.getText().equals(tempPassword)) {
            flag = false;
            JOptionPane.showMessageDialog(LogInMenu.super.rootPane, "Successfully Logged In");
        } else {
            if (!flag) {
                flag = true;
            } else {
                forgottenPass();
            }
            JOptionPane.showMessageDialog(LogInMenu.super.rootPane, "Error! Either Username or Password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

//==========================================> END OF CODE <=============================================================