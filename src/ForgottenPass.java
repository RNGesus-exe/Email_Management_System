//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

class ForgottenPass extends JFrame implements ActionListener {

//==========================================> FUNCTION'S DATA MEMBERS <=================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;

    private JLabel usernameLabel;
    private JLabel securityQstLabel;
    private JLabel securityAnsLabel;
    private JTextField usernameField;
    private JTextField securityQstField;
    private JTextField securityAnsField;

    private JButton btn_Return;
    private JButton btn_Enter;
    private JButton btn_Check;

    private Font font;
    private ImageIcon background;
    private Image img;

    public ForgottenPass() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(450, 200, 500, 400);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 500, 400, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        this.setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        background = new ImageIcon("Icons/Main_Logo.png");
        img = background.getImage();
        img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(5, 5, 40, 40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Forgotten Password Menu");
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
                setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Forgotten Password");
        mainLabel.setBounds(150, 35, 400, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 16);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(25, 110, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> SECURITY QUEStION LABEL <=================================================

        /** Security Question Comes here -----> -----> ----> \|*/
        securityQstLabel = new JLabel("Question");
        securityQstLabel.setBounds(25, 150, 100, 20);
        securityQstLabel.setForeground(new Color(243, 241, 239));
        securityQstLabel.setFont(font);

//==========================================> SECURITY ANSWER LABEL <===================================================

        securityAnsLabel = new JLabel("Answer");
        securityAnsLabel.setBounds(25, 190, 100, 20);
        securityAnsLabel.setForeground(new Color(243, 241, 239));
        securityAnsLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField();
        usernameField.setBounds(125, 110, 250, 20);
        usernameField.setBackground(new Color(46, 49, 49));
        usernameField.setForeground(new Color(243, 241, 239));
        usernameField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        usernameField.setCaretColor(Color.white);
        usernameField.setFont(font);

//==========================================> SECURITY QUESTION TEXT FIELD <============================================

        securityQstField = new JTextField("Press the check button after entering username");
        securityQstField.setBounds(125, 150, 350, 20);
        securityQstField.setBackground(new Color(46, 49, 49));
        securityQstField.setForeground(new Color(243, 241, 239));
        securityQstField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        securityQstField.setCaretColor(Color.white);
        securityQstField.setFont(font);
        securityQstField.setEnabled(false);

//==========================================> SECURITY ANSWER TEXT FIELD <==============================================

        securityAnsField = new JTextField();
        securityAnsField.setBounds(125, 190, 350, 20);
        securityAnsField.setBackground(new Color(46, 49, 49));
        securityAnsField.setForeground(new Color(243, 241, 239));
        securityAnsField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        securityAnsField.setCaretColor(Color.white);
        securityAnsField.setFont(font);

//==========================================> RETURN BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_Return = new JButton("Return");
        btn_Return.setBounds(100, 275, 120, 30);
        btn_Return.setBackground(new Color(242, 38, 19));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_Return.setToolTipText("Press this button to Go Back");
        btn_Return.setFont(font);
        btn_Return.addActionListener(this);

//==========================================> ENTER BUTTON <============================================================

        btn_Enter = new JButton("Enter");
        btn_Enter.setBounds(275, 275, 120, 30);
        btn_Enter.setBackground(new Color(34, 167, 240));
        btn_Enter.setForeground(new Color(243, 241, 239));
        btn_Enter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_Enter.setToolTipText("Resets Password");
        btn_Enter.setFont(font);
        btn_Enter.addActionListener(this);

//==========================================> ADDING USERNAME CHECK BUTTON <============================================

        btn_Check = new JButton("Check");
        btn_Check.setBounds(400, 110, 75, 20);
        btn_Check.setBackground(new Color(34, 167, 240));
        btn_Check.setForeground(new Color(243, 241, 239));
        btn_Check.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_Check.setToolTipText("Checks if username exists");
        btn_Check.setFont(font);
        btn_Check.addActionListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(usernameLabel);
        mainBody.add(securityQstLabel);
        mainBody.add(securityAnsLabel);
        mainBody.add(usernameField);
        mainBody.add(securityQstField);
        mainBody.add(securityAnsField);
        mainBody.add(btn_Return);
        mainBody.add(btn_Enter);
        mainBody.add(btn_Check);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

    public void resetPassCondition() throws SQLException {
        /** Update Password here. */
        new LogInMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Return) {
            dispose();
            new LogInMenu();
        } else if (e.getSource() == btn_Check) {
            if ((Driver.dataAgent.getId(usernameField.getText().trim())) != -1) {
                securityQstField.setText(Driver.dataAgent.getUserSecurityQuestion(Driver.dataAgent.getId(usernameField.getText().trim())));
            } else {
                JOptionPane.showMessageDialog(null, "The entered username doesn't exist", "Incorrect Username", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btn_Enter) {
            if (securityAnsField.getText().toLowerCase().trim().equals(Driver.dataAgent.getUserSecurityQuestionAnswer(Driver.dataAgent.getId(usernameField.getText().trim())).toLowerCase())) {
                dispose();
                new ResetPass(usernameField.getText().trim());
            } else if (usernameField.getText().trim().equals("") || securityAnsField.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "User Field or Answer Field is empty", "Invalid Arguments", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The Answer was not correct !", "Invalid Answer", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

class ResetPass extends JFrame implements ActionListener {

//==========================================> FUNCTION'S DATA MEMBERS <=================================================

        private JPanel titleBar = new JPanel();
        private JPanel mainBody = new JPanel();

        private JLabel titleLabel;
        private JLabel closeLabel;
        private JLabel minusLabel;
        private JLabel mainLabel;
        private JLabel passwordLabel;
        private JLabel confirmPassLabel;

        private String usernameData;
        private JPasswordField passwordField;
        private JPasswordField confirmPassField;

        private JButton btn_Return;
        private JButton btn_LogInn;

        private ImageIcon background;
        private Image img;
        private Font font;

        public ResetPass(String username) {

//==========================================> MAIN J-FRAME <============================================================

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBounds(450, 200, 500, 350);
            setUndecorated(true);
            setShape(new RoundRectangle2D.Double(0, 0, 500, 350, 30, 30));
            setLayout(null);
            usernameData = username;

//==========================================> J-PANEL TITLE BAR <=======================================================

            titleBar.setBounds(0, 0, 500, 50);
            titleBar.setBackground(new Color(171, 183, 183));
            titleBar.setLayout(null);

            FrameDragListener frameDragListener = new FrameDragListener(this);
            this.addMouseListener(frameDragListener);
            this.addMouseMotionListener(frameDragListener);

            ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
            setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

            background = new ImageIcon("Icons/Main_Logo.png");
            img = background.getImage();
            img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            background = new ImageIcon(img);

            JLabel mainIcon = new JLabel(background);
            mainIcon.setBounds(05, 05, 40, 40);
            mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

            mainBody.setBounds(0, 50, 500, 300);
            mainBody.setBackground(new Color(52, 73, 94));
            mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

            titleLabel = new JLabel("Reset Password Menu");
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
                    setState(JFrame.ICONIFIED);
                }
            });

//==========================================> MAIN LABEL <==============================================================

            mainLabel = new JLabel("Reset Password");
            mainLabel.setBounds(150, 35, 400, 50);
            mainLabel.setForeground(new Color(243, 241, 239));
            mainLabel.setFont(new Font("Arial", Font.BOLD, 28));

//==========================================> PASSWORD LABEL <==========================================================

            font = new Font("Arial", Font.BOLD, 16);

            passwordLabel = new JLabel("New Password");
            passwordLabel.setBounds(50, 125, 120, 20);
            passwordLabel.setForeground(new Color(243, 241, 239));
            passwordLabel.setFont(font);

//==========================================> CONFIRM PASSWORD LABEL <==================================================

            confirmPassLabel = new JLabel("Confirm Pass");
            confirmPassLabel.setBounds(50, 160, 120, 20);
            confirmPassLabel.setForeground(new Color(243, 241, 239));
            confirmPassLabel.setFont(font);

//==========================================> PASSWORD TEXT FIELD <=====================================================

            passwordField = new JPasswordField();
            passwordField.setBounds(200, 125, 250, 20);
            passwordField.setBackground(new Color(46, 49, 49));
            passwordField.setForeground(new Color(243, 241, 239));
            passwordField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            passwordField.setCaretColor(Color.white);
            passwordField.setFont(font);

//==========================================> CONFIRM PASSWORD TEXT FIELD <=============================================

            confirmPassField = new JPasswordField();
            confirmPassField.setBounds(200, 160, 250, 20);
            confirmPassField.setBackground(new Color(46, 49, 49));
            confirmPassField.setForeground(new Color(243, 241, 239));
            confirmPassField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            confirmPassField.setCaretColor(Color.white);
            confirmPassField.setFont(font);

//==========================================> RETURN BUTTON <===========================================================

            font = new Font("Arial", Font.BOLD, 16);

            btn_Return = new JButton("Return");
            btn_Return.setBounds(100, 250, 120, 30);
            btn_Return.setBackground(new Color(242, 38, 19));
            btn_Return.setForeground(new Color(243, 241, 239));
            btn_Return.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            btn_Return.setToolTipText("Press this button to Go Back");
            btn_Return.setFont(font);
            btn_Return.addActionListener(this);

//==========================================> LOG IN BUTTON <===========================================================

            btn_LogInn = new JButton("Reset Pass");
            btn_LogInn.setBounds(275, 250, 120, 30);
            btn_LogInn.setBackground(new Color(34, 167, 240));
            btn_LogInn.setForeground(new Color(243, 241, 239));
            btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            btn_LogInn.setToolTipText("Resets Password");
            btn_LogInn.setFont(font);
            btn_LogInn.addActionListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

            titleBar.add(titleLabel);
            titleBar.add(mainIcon);
            titleBar.add(closeLabel);
            titleBar.add(minusLabel);

            mainBody.add(mainLabel);
            mainBody.add(passwordLabel);
            mainBody.add(confirmPassLabel);
            mainBody.add(passwordField);
            mainBody.add(confirmPassField);
            mainBody.add(btn_Return);
            mainBody.add(btn_LogInn);

            add(titleBar);
            add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_Return) {
                dispose();
                new MainMenu();
            } else if (e.getSource() == btn_LogInn) {
                if (passwordField.getText().trim().equals(confirmPassField.getText().trim()) && (!passwordField.getText().equals(""))) {
                    try {
                        Driver.dataAgent.changeUserPassword(usernameData, passwordField.getText().trim());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Password has been successfully changed!", "Password Changed", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LogInMenu();
                } else if (passwordField.getText().trim().equals("") || confirmPassField.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "A field has been left empty!", "Invalid Argument", JOptionPane.ERROR_MESSAGE);
                } else if (!(passwordField.getText().trim().equals(confirmPassField.getText().trim()))) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

//==========================================> END OF CODE <=============================================================