//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.Map;

//==========================================> CLASS LOG IN MENU <=======================================================

public class ComposeMail extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;
    private JLabel infoLabel;

    private JLabel recipientLabel;
    private JLabel subjectLabel;
    private JLabel textLabel;

    private JTextField recipientField;
    private JTextField subjectField;
    private JTextArea textArea;

    private JButton btn_Discard;
    private JButton btn_Draft;
    private JButton btn_Send;

    private Font font;
    private Map attributes;

    private ImageIcon background;
    private Image img;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public ComposeMail(String username) {

//==========================================> MAIN J-FRAME <============================================================

        setBounds(380,150,600,500);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 600, 500, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 600, 50);
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

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 600, 450);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Compose Mail Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(575, 15, 25, 22);
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
        minusLabel.setBounds(550, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));

        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ComposeMail.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Compose Mail");
        mainLabel.setBounds(200, 10, 400, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));

//==========================================> INFO LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 14);
        infoLabel = new JLabel("Learn More!");
        infoLabel.setBounds(500, 10, 100, 20);
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
                textArea.setText("Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello \n" +
                        "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(ComposeMail.super.rootPane, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> RECIPIENT LABEL <==========================================================

        font = new Font("Arial", Font.BOLD, 18);

        recipientLabel = new JLabel("Recipient");
        recipientLabel.setBounds(20, 80, 100, 20);
        recipientLabel.setForeground(new Color(243, 241, 239));
        recipientLabel.setFont(font);

//==========================================> SUBJECT LABEL <===========================================================

        subjectLabel = new JLabel("Subject");
        subjectLabel.setBounds(20, 120, 300, 20);
        subjectLabel.setForeground(new Color(243, 241, 239));
        subjectLabel.setFont(font);

//==========================================> CONFIRM PASSWORD LABEL <==================================================

        textLabel = new JLabel("Text");
        textLabel.setBounds(20, 160, 100, 20);
        textLabel.setForeground(new Color(243, 241, 239));
        textLabel.setFont(font);

//==========================================> RECIPIENT TEXT FIELD <====================================================

        font = new Font("Arial", Font.PLAIN, 16);

        recipientField = new JTextField();
        recipientField.setBounds(120, 80, 250, 20);
        recipientField.setBackground(new Color(46, 49, 49));
        recipientField.setForeground(new Color(243, 241, 239));
        recipientField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        recipientField.setCaretColor(Color.white);
        recipientField.setFont(font);
        recipientField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> SUBJECT TEXT FIELD <======================================================

        subjectField = new JTextField();
        subjectField.setBounds(120, 120, 450, 20);
        subjectField.setBackground(new Color(46, 49, 49));
        subjectField.setForeground(new Color(243, 241, 239));
        subjectField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        subjectField.setCaretColor(Color.white);
        subjectField.setFont(font);
        subjectField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        logInCondition();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> TEXT AREA <===============================================================

        JPanel textPane = new JPanel(new BorderLayout());
        textPane.setBounds(120,160,450,200);
        textPane.setBackground(new Color(52, 73, 94));
        textPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        textArea = new JTextArea();
        textArea.setBounds(120, 160, 450, 200);
        textArea.setBackground(new Color(46, 49, 49));
        textArea.setForeground(new Color(243, 241, 239));
        textArea.setCaretColor(Color.white);
        textArea.setLineWrap(true);
        textArea.setFont(font);

        JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textPane.add(scrollBar);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> DISCARD BUTTON <===========================================================

        btn_Discard = new JButton("Discard");
        btn_Discard.setBounds(200, 400, 100, 30);
        btn_Discard.setBackground(new Color(242, 38, 19));
        btn_Discard.setForeground(new Color(243, 241, 239));
        btn_Discard.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Discard.setToolTipText("Discards Mail");
        btn_Discard.setFont(font);

        btn_Discard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Are you sure you want to discard the current mail?","Discard Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                    dispose();
                }
            }
        });
        btn_Discard.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Are you sure you want to discard the current mail?","Discard Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> DRAFT BUTTON <===========================================================

        btn_Draft = new JButton("Draft");
        btn_Draft.setBounds(325, 400, 100, 30);
        btn_Draft.setBackground(new Color(34, 167, 240));
        btn_Draft.setForeground(new Color(243, 241, 239));
        btn_Draft.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Draft.setToolTipText("Drafts Mail");
        btn_Draft.setFont(font);

        btn_Draft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(recipientField.getText().equals("") && textArea.getText().equals("") && subjectField.getText().equals(""))) {
                    //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                    //Driver.dataAgent.addMail(mailbody);
                    dispose();
                } else {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Are you sure you want to draft an empty mail?","Empty Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                        //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                        //Driver.dataAgent.addMail(mailbody);
                        dispose();
                    }
                }
            }
        });
        btn_Draft.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!(recipientField.getText().equals("") && textArea.getText().equals("") && subjectField.getText().equals(""))) {
                        //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                        //Driver.dataAgent.addMail(mailbody);
                        dispose();
                    } else {
                        if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Are you sure you want to draft an empty mail?","Empty Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                            //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                            //Driver.dataAgent.addMail(mailbody);
                            dispose();
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> SEND BUTTON <===========================================================

        btn_Send = new JButton("Send");
        btn_Send.setBounds(450, 400, 100, 30);
        btn_Send.setBackground(new Color(242, 38, 19));
        btn_Send.setForeground(new Color(243, 241, 239));
        btn_Send.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Send.setToolTipText("Send Mail");
        btn_Send.setFont(font);

        btn_Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (recipientField.getText().equals("")) {
                    JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"You cannot send a mail with no recipient!","Empty Recipient",JOptionPane.ERROR_MESSAGE);
                }
                else if (Driver.mail.checkMultipleUsers(recipientField.getText())!=null) {
                    JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"The entered recipient "+Driver.mail.checkMultipleUsers(recipientField.getText())+" doesn't exist!","Invalid Recipient",JOptionPane.ERROR_MESSAGE);
                } else {
                    //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,true,false,false,0,0);
                    //Driver.dataAgent.addMail(mailbody);
                    dispose();
                }
            }
        });
        btn_Send.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Do you want to Exit?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (recipientField.getText().equals("")) {
                        JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"You cannot send a mail with no recipient!","Empty Recipient",JOptionPane.ERROR_MESSAGE);
                    }
                    else if (Driver.mail.checkMultipleUsers(recipientField.getText())!=null) {
                        JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"The entered recipient "+Driver.mail.checkMultipleUsers(recipientField.getText())+" doesn't exist!","Invalid Recipient",JOptionPane.ERROR_MESSAGE);
                    } else {
                        //MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,true,false,false,0,0);
                        //Driver.dataAgent.addMail(mailbody);
                        dispose();
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
        mainBody.add(recipientLabel);
        mainBody.add(subjectLabel);
        mainBody.add(textLabel);
        mainBody.add(recipientField);
        mainBody.add(subjectField);
        mainBody.add(textPane);
        mainBody.add(btn_Discard);
        mainBody.add(btn_Draft);
        mainBody.add(btn_Send);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> LOG IN CONDITION <========================================================

    // You will check for the Correct Username and Password here.
    public void logInCondition() throws SQLException {
        if (Driver.mail.getId(recipientField.getText().trim(), subjectField.getText().trim())!=-1){
            Driver.mail.loadUserdata(Driver.mail.getId(recipientField.getText().trim()));
            dispose();
            //EmailMenu to be added here   --Shaheryar
        } else {
            JOptionPane.showMessageDialog(ComposeMail.super.rootPane, "Error! Either Username or Password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

//==========================================> END OF CODE <=============================================================