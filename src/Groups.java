//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

//==========================================> CLASS LOG IN MENU <=======================================================

public class Groups extends JFrame {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;
    private JLabel textLabel;

    private JTextArea textArea;

    private JButton btn_Create;
    private JButton btn_Back;

    private Font font;

    private ImageIcon background;
    private Image img;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public Groups() {

//==========================================> MAIN J-FRAME <============================================================

        setBounds(380, 150, 600, 500);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 600, 500, 30, 30));
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
        img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(05, 05, 40, 40);
        mainIcon.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Groups Menu");
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
                dispose();
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
                Groups.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Groups List");
        mainLabel.setBounds(200, 10, 400, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));

//==========================================> Recipient LABEL <============================================================

        textLabel = new JLabel("Recipients :");
        textLabel.setBounds(20, 300, 200, 20);
        textLabel.setForeground(new Color(243, 241, 239));
        textLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> TEXT AREA <===============================================================

        JPanel textPane = new JPanel(new BorderLayout());
        textPane.setBounds(150, 300, 400, 80);
        textPane.setBackground(new Color(52, 73, 94));
        textPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textArea = new JTextArea();
        textArea.setBackground(new Color(46, 49, 49));
        textArea.setForeground(new Color(243, 241, 239));
        textArea.setCaretColor(Color.white);
        textArea.setLineWrap(true);
        textArea.setFont(font);

        JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textPane.add(scrollBar);

//==========================================> Go Back BUTTON <===========================================================

        btn_Back = new JButton("Go Back");
        btn_Back.setBounds(325, 400, 100, 30);
        btn_Back.setBackground(new Color(242, 38, 19));
        btn_Back.setForeground(new Color(243, 241, 239));
        btn_Back.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_Back.setToolTipText("Go Back to Email Menu");
        btn_Back.setFont(font);
        btn_Back.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(Groups.super.rootPane, "Are you sure you want to discard the current Text?", "Discard Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                dispose();
            }
        });

//==========================================> Create group BUTTON <===========================================================

        btn_Create = new JButton("Create");
        btn_Create.setBounds(450, 400, 100, 30);
        btn_Create.setBackground(new Color(242, 38, 19));
        btn_Create.setForeground(new Color(243, 241, 239));
        btn_Create.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_Create.setToolTipText("Create a Group");
        btn_Create.setFont(font);
        btn_Create.addActionListener(e -> System.out.println("Create Group"));

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(textPane);
        mainBody.add(textLabel);

        mainBody.add(btn_Back);
        mainBody.add(btn_Create);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }   //===========================END OF CONSTRUCTOR
}

//==========================================> END OF CODE <=============================================================