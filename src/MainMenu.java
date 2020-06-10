//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//==========================================> CLASS MAIN MENU <=========================================================

public class MainMenu extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private Font font;

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;

    private JLabel mainLabel;
    private JLabel infoLabel;

    private JButton btn_SignUp;
    private JButton btn_LogInn;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public MainMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(450, 200, 500, 400);
        this.setUndecorated(true);
        setLayout(null);

        //Test Images
        ImageIcon icon = new ImageIcon("Icons\\MainIcon.PNG");
        setIconImage(icon.getImage());

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 500, 50);
        titleBar.setBackground(new Color(252, 185, 65));
        titleBar.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Email Management System / Main Menu");
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
                MainMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 32);

        mainLabel = new JLabel("Main Menu");
        mainLabel.setBounds(175, 25, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(font);

//==========================================> INFO LABEL <==============================================================

        font = new Font("Arial", Font.BOLD, 18);

        infoLabel = new JLabel("About App!");
        infoLabel.setBounds(210, 75, 105, 50);
        infoLabel.setForeground(new Color(34, 167, 240));
        infoLabel.setToolTipText("Press this Text to Read the Information");
        infoLabel.setFont(font);

        infoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JTextArea textArea = new JTextArea(15, 50);
                font = new Font("Arial", Font.BOLD, 18);

                textArea.setText("Hello \n" +
                                 "Hello \n" +
                                 "Hello \n" +
                                 "Hello \n" +
                                 "Hello");
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> SIGN UP BUTTON <==========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_SignUp = new JButton("Sign Up");
        btn_SignUp.setBounds(100, 200, 120, 30);
        btn_SignUp.setBackground(new Color(242, 38, 19));
        btn_SignUp.setForeground(new Color(243, 241, 239));
        btn_SignUp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_SignUp.setToolTipText("This Button is Used to Sign up to our E.M.S");
        btn_SignUp.setFont(font);

        btn_SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Currently No SignUp Class is Made!");
            }
        });

        btn_SignUp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(null, "Currently No SignUp Class is Made!");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> LOG INN BUTTON <==========================================================

        font = new Font("Arial", Font.BOLD, 16);

        btn_LogInn = new JButton("Log In");
        btn_LogInn.setBounds(275, 200, 120, 30);
        btn_LogInn.setBackground(new Color(34, 167, 240));
        btn_LogInn.setForeground(new Color(243, 241, 239));
        btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogInn.setToolTipText("This Button is Used to Log In to our E.M.S");
        btn_LogInn.setFont(font);

        btn_LogInn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Currently No Log In Class is Made!");
            }
        });

        btn_LogInn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(null, "Currently No Log In Class is Made!");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(infoLabel);
        mainBody.add(btn_SignUp);
        mainBody.add(btn_LogInn);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }
}