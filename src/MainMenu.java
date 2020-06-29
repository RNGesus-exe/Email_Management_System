//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;

//==========================================> CLASS MAIN MENU <=========================================================

public class MainMenu extends JFrame implements ActionListener, KeyListener {

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

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(icon.getImage());

        Image img = icon.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel mainIcon = new JLabel(icon);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 500, 350);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Main Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(475, 15, 25, 22);
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
        minusLabel.setBounds(450, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));
        minusLabel.setToolTipText("Minimize");
        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Main Menu");
        mainLabel.setBounds(175, 50, 300, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 32));

//==========================================> INFO LABEL <==============================================================

        infoLabel = new JLabel("Learn More...!");
        infoLabel.setBounds(380, 10, 100, 20);
        infoLabel.setForeground(new Color(34, 167, 240));
        infoLabel.setToolTipText("Click to Read the Info of E.M.S");

        font = new Font("Arial", Font.BOLD, 16);
        infoLabel.setFont(font);

        Map attributes = font.getAttributes();
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
                JOptionPane.showMessageDialog(MainMenu.this, scrollPane, "About Us", -1, null);
            }
        });

//==========================================> SIGN UP BUTTON <==========================================================

        btn_SignUp = new JButton("Sign Up");
        btn_SignUp.setBounds(100, 175, 120, 30);
        btn_SignUp.setBackground(new Color(242, 38, 19));
        btn_SignUp.setForeground(new Color(243, 241, 239));
        btn_SignUp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_SignUp.setToolTipText("Click to Sign Up");
        btn_SignUp.setFont(font);
        btn_SignUp.addActionListener(this);
        btn_SignUp.addKeyListener(this);

//==========================================> LOG INN BUTTON <==========================================================

        btn_LogInn = new JButton("Log In");
        btn_LogInn.setBounds(275, 175, 120, 30);
        btn_LogInn.setBackground(new Color(34, 167, 240));
        btn_LogInn.setForeground(new Color(243, 241, 239));
        btn_LogInn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogInn.setToolTipText("Click to Log In");
        btn_LogInn.setFont(font);
        btn_LogInn.addActionListener(this);
        btn_LogInn.addKeyListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_SignUp) {
            dispose();
            new SignUpMenu();
        } else if (e.getSource() == btn_LogInn) {
            dispose();
            new LogInMenu();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (JOptionPane.showConfirmDialog (MainMenu.super.rootPane, "Do you want to Exit?","Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
            if (e.getSource() == btn_SignUp) { new SignUpMenu(); }
            else if (e.getSource() == btn_LogInn) { new LogInMenu(); }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }
}

//==========================================> END OF CODE <=============================================================