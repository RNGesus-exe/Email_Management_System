//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.Map;

//==========================================> CLASS LOG IN MENU <=======================================================

/** GET THE DATA AND UPDATE THE PASSWORD */

public class ForgottenPass{

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JFrame frame1 = new JFrame();
    private JFrame frame2 = new JFrame();

    private String [] securityQuestions = { "Security Question no. 1",
                                            "Security Question no. 2",
                                            "Security Question no. 3",
                                            "Security Question no. 4"};

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public ForgottenPass() {
        frame_1();
    }

//==========================================> LOG IN CONDITION <========================================================

    // You will check for the Correct Username and Password here.
    public void resetPassCondition() throws SQLException {
        /** Update Password here. */
        new LogInMenu();
    }

    public void frame_1() {

//==========================================> FUNCTION'S DATA MEMBERS <=================================================

        JPanel titleBar = new JPanel();
        JPanel mainBody = new JPanel();

        JLabel titleLabel;
        JLabel closeLabel;
        JLabel minusLabel;
        JLabel mainLabel;
        JLabel infoLabel;

        JLabel usernameLabel;
        JLabel securityQstLabel;
        JLabel securityAnsLabel;
        JTextField usernameField;
        JTextField securityAnsField;

        JButton btn_Return;
        JButton btn_ResetPass;

        Font font;
        Map attributes;

        ImageIcon background;
        Image img;

//==========================================> MAIN J-FRAME <============================================================

        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setBounds(400, 150, 500, 400);
        frame1.setUndecorated(true);
        frame1.setShape(new RoundRectangle2D.Double(0, 0, 500, 400, 30, 30));
        frame1.setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(frame1);
        frame1.addMouseListener(frameDragListener);
        frame1.addMouseMotionListener(frameDragListener);

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        frame1.setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        background = new ImageIcon("Icons/Main_Logo.png");
        img = background.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(05,05,40,40);
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
                frame1.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Forgotten Password");
        mainLabel.setBounds(150, 35, 400, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));

//==========================================> INFO LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 14);
        infoLabel = new JLabel("Learn More!");
        infoLabel.setBounds(400, 10, 100, 20);
        infoLabel.setForeground(new Color(34, 167, 240));
        infoLabel.setToolTipText("Press this Text to Read the Information");
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
                textArea.setText("Hello \n" + "Hello \n" + "Hello \n" + "Hello \n" + "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(frame1, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 16);

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(50, 110, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> SECURITY QUEStION LABEL <=================================================

        /** Security Question Comes here -----> -----> ----> \|*/
        securityQstLabel = new JLabel("Security Question: ");
        securityQstLabel.setBounds(50, 150, 450, 20);
        securityQstLabel.setForeground(new Color(243, 241, 239));
        securityQstLabel.setFont(font);

//==========================================> SECURITY ANSWER LABEL <===================================================

        securityAnsLabel = new JLabel("Answer");
        securityAnsLabel.setBounds(50, 190, 120, 20);
        securityAnsLabel.setForeground(new Color(243, 241, 239));
        securityAnsLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField();
        usernameField.setBounds(200, 110, 250, 20);
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
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> SECURITY ANSWER TEXT FIELD <==============================================

        securityAnsField = new JTextField();
        securityAnsField.setBounds(200, 190, 250, 20);
        securityAnsField.setBackground(new Color(46, 49, 49));
        securityAnsField.setForeground(new Color(243, 241, 239));
        securityAnsField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        securityAnsField.setCaretColor(Color.white);
        securityAnsField.setFont(font);
        securityAnsField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        resetPassCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> RETURN BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_Return = new JButton("Return");
        btn_Return.setBounds(100, 275, 120, 30);
        btn_Return.setBackground(new Color(242, 38, 19));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Press this button to Go Back");
        btn_Return.setFont(font);

        btn_Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  |Username|   |Security Q|  |His Answer|
//                if (   true   &&     true    &&    true   ) {
//                      frame1.dispose();
//                      frame_2();
//                } else {
//                    JOptionPane.showMessageDialog(frame2, "Error! Invalid Username or Answer Entered", "Invalid username or Answer!", JOptionPane.ERROR_MESSAGE);
//                }
            }
        });
        btn_Return.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //  |Username|   |Security Q|  |His Answer|
//                    if (   true   &&     true    &&    true   ) {
//                        frame1.dispose();
//                        frame_2();
//                    } else {
//                        JOptionPane.showMessageDialog(frame2, "Error! Invalid Username or Answer Entered", "Invalid username or Answer!", JOptionPane.ERROR_MESSAGE);
//                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> ENTER BUTTON <============================================================

        btn_ResetPass = new JButton("Enter");
        btn_ResetPass.setBounds(275, 275, 120, 30);
        btn_ResetPass.setBackground(new Color(34, 167, 240));
        btn_ResetPass.setForeground(new Color(243, 241, 239));
        btn_ResetPass.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_ResetPass.setToolTipText("Resets Password");
        btn_ResetPass.setFont(font);

        btn_ResetPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resetPassCondition();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_ResetPass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        resetPassCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
        mainBody.add(usernameLabel);
        mainBody.add(securityQstLabel);
        mainBody.add(securityAnsLabel);
        mainBody.add(usernameField);
        mainBody.add(securityAnsField);
        mainBody.add(btn_Return);
        mainBody.add(btn_ResetPass);

        frame1.add(titleBar);
        frame1.add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        frame1.setVisible(true);

//==========================================> USERNAME LABEL <==========================================================

    }

    public void frame_2() {

//==========================================> FUNCTION'S DATA MEMBERS <=================================================

        JPanel titleBar = new JPanel();
        JPanel mainBody = new JPanel();

        JLabel titleLabel;
        JLabel closeLabel;
        JLabel minusLabel;
        JLabel mainLabel;
        JLabel infoLabel;

        JLabel usernameLabel;
        JLabel passwordLabel;
        JLabel confirmPassLabel;

        JTextField     usernameField;
        JPasswordField passwordField;
        JPasswordField confirmPassField;

        JButton btn_Return;
        JButton btn_LogInn;

        Font font;
        Map attributes;

        ImageIcon background;
        Image img;

//==========================================> MAIN J-FRAME <============================================================

        frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
        frame2.setBounds(400, 150, 500, 400);
        frame2.setUndecorated(true);
        frame2.setShape(new RoundRectangle2D.Double(0, 0, 500, 400, 30, 30));
        frame2.setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(frame2);
        frame2.addMouseListener(frameDragListener);
        frame2.addMouseMotionListener(frameDragListener);

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        frame2.setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        background = new ImageIcon("Icons/Main_Logo.png");
        img = background.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
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
                frame2.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Reset Password");
        mainLabel.setBounds(150, 35, 400, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 28));

//==========================================> INFO LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 14);
        infoLabel = new JLabel("Learn More!");
        infoLabel.setBounds(400, 10, 100, 20);
        infoLabel.setForeground(new Color(34, 167, 240));
        infoLabel.setToolTipText("Press this Text to Read the Information");
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
                textArea.setText("Hello \n" + "Hello \n" + "Hello \n" + "Hello \n" + "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(frame2, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> USERNAME LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 16);

        usernameLabel = new JLabel("Username ");
        usernameLabel.setBounds(50, 110, 100, 20);
        usernameLabel.setForeground(new Color(243, 241, 239));
        usernameLabel.setFont(font);

//==========================================> PASSWORD LABEL <==========================================================

        passwordLabel = new JLabel("New Password");
        passwordLabel.setBounds(50, 150, 120, 20);
        passwordLabel.setForeground(new Color(243, 241, 239));
        passwordLabel.setFont(font);

//==========================================> CONFIRM PASSWORD LABEL <==================================================

        confirmPassLabel = new JLabel("Confirm Pass");
        confirmPassLabel.setBounds(50, 190, 120, 20);
        confirmPassLabel.setForeground(new Color(243, 241, 239));
        confirmPassLabel.setFont(font);

//==========================================> USERNAME TEXT FIELD <=====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        usernameField = new JTextField();
        usernameField.setBounds(200, 110, 250, 20);
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
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> PASSWORD TEXT FIELD <=====================================================

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 250, 20);
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
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        resetPassCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> CONFIRM PASSWORD TEXT FIELD <=============================================

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(200, 190, 250, 20);
        confirmPassField.setBackground(new Color(46, 49, 49));
        confirmPassField.setForeground(new Color(243, 241, 239));
        confirmPassField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        confirmPassField.setCaretColor(Color.white);
        confirmPassField.setFont(font);
        confirmPassField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        resetPassCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> RETURN BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_Return = new JButton("Return");
        btn_Return.setBounds(100, 275, 120, 30);
        btn_Return.setBackground(new Color(242, 38, 19));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Press this button to Go Back");
        btn_Return.setFont(font);

        btn_Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                new MainMenu();
            }
        });
        btn_Return.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    frame2.dispose();
                    new MainMenu();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> LOG IN BUTTON <===========================================================

        btn_LogInn = new JButton("Reset Pass");
        btn_LogInn.setBounds(275, 275, 120, 30);
        btn_LogInn.setBackground(new Color(34, 167, 240));
        btn_LogInn.setForeground(new Color(243, 241, 239));
        btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogInn.setToolTipText("Resets Password");
        btn_LogInn.setFont(font);

        btn_LogInn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resetPassCondition();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_LogInn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(frame2, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        frame2.dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        resetPassCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
        mainBody.add(usernameLabel);
        mainBody.add(passwordLabel);
        mainBody.add(confirmPassLabel);
        mainBody.add(usernameField);
        mainBody.add(passwordField);
        mainBody.add(confirmPassField);
        mainBody.add(btn_Return);
        mainBody.add(btn_LogInn);

        frame2.add(titleBar);
        frame2.add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        frame2.setVisible(true);
    }

}

//==========================================> END OF CODE <=============================================================