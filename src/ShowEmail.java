//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

//==========================================> CLASS LOG IN MENU <=======================================================

public class ShowEmail extends JFrame implements ActionListener {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();
    private JFrame frame;

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;

    private JButton btn_Return;
    private JButton btn_ReplyMail;
    private JButton btn_StarMail;
    private JButton btn_DeleteMail;
    private JButton btn_ForwardMail;

    private JTextArea textArea;
    private JPanel textPane;

    private ImageIcon background;
    private Image img;
    private Font font;
    private short mailType = 0;
    /**
     * 1 : Inbox
     * 2 : Starred
     * 3 : Draft
     * 4 : Spam
     * 5 : All
     * 6 : Trash
     * 7 : Sent
     **/

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public ShowEmail(short btnPressChecker, int mailIndex) {

        mailType = btnPressChecker;

//==========================================> MAIN J-FRAME <============================================================

        setBounds(380,150,700,600);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 700, 600, 30, 30));
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

        JLabel mainIcon = new JLabel(background);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 700, 550);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("[Sender's Name] Email");
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
                dispose();
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
                ShowEmail.super.setState(JFrame.ICONIFIED);
            }
        });

        font = new Font("Arial", Font.BOLD, 16);

//==========================================> RETURN BUTTON <===========================================================

        btn_Return = new JButton("Return");
        btn_Return.setBounds(25, 490, 75, 30);
        btn_Return.setBackground(new Color(73, 79, 80));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Takes you back to previous Window");
        btn_Return.setFont(font);
        btn_Return.addActionListener(this);

//==========================================> REPLY MAIL BUTTON <=======================================================

        if (mailType == 3) {
            btn_ReplyMail = new JButton("Save Mail");
        } else {
            btn_ReplyMail = new JButton("Reply Mail");
        }
        btn_ReplyMail.setBounds(125, 490, 100, 30);
        btn_ReplyMail.setBackground(new Color(25, 181, 254));
        btn_ReplyMail.setForeground(new Color(243, 241, 239));
        btn_ReplyMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_ReplyMail.setToolTipText("Replies to Opened Email");
        btn_ReplyMail.setFont(font);
        btn_ReplyMail.addActionListener(this);

//==========================================> STAR MAIL BUTTON <========================================================

        if (mailType == 2) {
            btn_StarMail = new JButton("Un-Star Mail");
        } else if (mailType == 6) {
            btn_StarMail = new JButton("Restore Mail");
        } else {
            btn_StarMail = new JButton("Star Mail");
        }
        btn_StarMail.setBounds(250, 490, 100, 30);
        btn_StarMail.setBackground(new Color(243, 156, 18));
        btn_StarMail.setForeground(new Color(243, 241, 239));
        btn_StarMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_StarMail.setToolTipText("Stars the Opened Email");
        btn_StarMail.setFont(font);
        btn_StarMail.addActionListener(this);

//==========================================> DELETE MAIL BUTTON <======================================================

        btn_DeleteMail = new JButton("Delete Mail");
        btn_DeleteMail.setBounds(375, 490, 100, 30);
        btn_DeleteMail.setBackground(new Color(217, 30, 24));
        btn_DeleteMail.setForeground(new Color(243, 241, 239));
        btn_DeleteMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_DeleteMail.setToolTipText("Deletes the Opened Email");
        btn_DeleteMail.setFont(font);
        btn_DeleteMail.addActionListener(this);

//==========================================> FORWARD MAIL BUTTON <=====================================================

        if (mailType == 3) {
            btn_ForwardMail = new JButton("Send Mail");
        } else {
            btn_ForwardMail = new JButton("Forward Mail");
        }
        btn_ForwardMail.setBounds(500, 490, 100, 30);
        btn_ForwardMail.setBackground(new Color(38, 166, 91));
        btn_ForwardMail.setForeground(new Color(243, 241, 239));
        btn_ForwardMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_ForwardMail.setToolTipText("Forwards the Opened Email");
        btn_ForwardMail.setFont(font);
        btn_ForwardMail.addActionListener(this);

//==========================================> TEXT AREA <===============================================================

        textPane = new JPanel(new BorderLayout());
        textPane.setBounds(25,25,650,450);
        textPane.setBackground(new Color(52, 73, 94));
        textPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        String data = "Sender: " + Driver.mail.getInbox().get(mailIndex).getSender() + "\nSubject: " + Driver.mail.getInbox().get(mailIndex).getSubject() +
                "\nText: " + Driver.mail.getInbox().get(mailIndex).getText().toString();
        textArea = new JTextArea(data);
        textArea.setBounds(25, 25, 650, 450);
        textArea.setBackground(new Color(46, 49, 49));
        textArea.setForeground(new Color(243, 241, 239));
        textArea.setCaretColor(Color.white);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textPane.add(scrollPane);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(btn_Return);
        mainBody.add(btn_ReplyMail);
        mainBody.add(btn_StarMail);
        mainBody.add(btn_DeleteMail);
        mainBody.add(btn_ForwardMail);
        mainBody.add(textPane);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * 1 : Inbox
         * 2 : Starred
         * 3 : Draft
         * 4 : Spam
         * 5 : All
         * 6 : Trash
         * 7 : Sent
         **/

        if (e.getSource() == btn_Return) {
            dispose();
        } else if (e.getSource() == btn_ReplyMail) {
            if (mailType == 3) {
                textArea.setEditable(true);
            } else {
                replyMailFunction();
            }
        } else if (e.getSource() == btn_StarMail) {
            if (mailType == 2) {
                //-- UnStar Mail
            } else {
                //-- Star Mail
            }
        } else if (e.getSource() == btn_DeleteMail) {
            if (mailType == 6) {
                //-- Permanently Delete Mail
                //-- Restore Deleted Mail
            } else {
                //-- Delete Mail
            }
        } else if (e.getSource() == btn_ForwardMail) {
            if (mailType == 3) {
                textArea.setEditable(false);
                //-- Save Mail
            } else {
                new ComposeMail();
            }
        }
        mainBody.updateUI();

    }

    private void replyMailFunction() {

        frame  = new JFrame();

        JPanel frameTitleBar;
        JPanel frameMainBody;
        JPanel frameTextPane;
        JLabel frameTitleLabel;
        JLabel frameCloseLabel;
        JLabel frameMinusLabel;
        JTextArea frameTextArea;
        JButton btn_frameDraftMail;
        JButton btn_frameSendMail;
        JButton btn_frameDiscard;

//==========================================> MAIN J-FRAME <============================================================

        frame.setBounds(700,350,500,400);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 400, 30, 30));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//==========================================> J-PANEL TITLE BAR <=======================================================

        frameTitleBar = new JPanel();
        frameTitleBar.setBounds(0, 0, 500, 50);
        frameTitleBar.setBackground(new Color(171, 183, 183));
        frameTitleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        frame.setIconImage(icon.getImage());

//==========================================> J-PANEL MAIN ICON <=======================================================

        background = new ImageIcon("Icons/Main_Logo.png");
        img = background.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel frameMainIcon = new JLabel(background);
        frameMainIcon.setBounds(5,5,40,40);
        frameMainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        frameMainBody = new JPanel();
        frameMainBody.setBounds(0, 50, 500, 350);
        frameMainBody.setBackground(new Color(52, 73, 94));
        frameMainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        frameTitleLabel = new JLabel("Reply to [Sender's Name] Email");
        frameTitleLabel.setBounds(50, 13, 450, 30);
        frameTitleLabel.setForeground(new Color(46, 46, 49));
        frameTitleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        frameCloseLabel = new JLabel("X");
        frameCloseLabel.setBounds(475, 15, 25, 22);
        frameCloseLabel.setForeground(new Color(255, 0, 0));
        frameCloseLabel.setFont(new Font("Arial", Font.BOLD, 22));

        frameCloseLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frameCloseLabel.setToolTipText("Close");
        frameCloseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });

//==========================================> MINUS LABEL <=============================================================

        frameMinusLabel = new JLabel("-");
        frameMinusLabel.setBounds(450, 0, 25, 44);
        frameMinusLabel.setForeground(new Color(0, 0, 0));
        frameMinusLabel.setFont(new Font("Arial", Font.BOLD, 44));

        frameMinusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frameMinusLabel.setToolTipText("Minimize");
        frameMinusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });

        font = new Font("Arial", Font.BOLD, 16);

//==========================================> TEXT AREA <===============================================================

        frameTextPane = new JPanel(new BorderLayout());
        frameTextPane.setBounds(25,25,450,250);
        frameTextPane.setBackground(new Color(52, 73, 94));
        frameTextPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        frameTextArea = new JTextArea();
        frameTextArea.setBounds(25, 25, 450, 250);
        frameTextArea.setBackground(new Color(46, 49, 49));
        frameTextArea.setForeground(new Color(243, 241, 239));
        frameTextArea.setCaretColor(Color.white);
        frameTextArea.setLineWrap(true);
        frameTextArea.setFont(font);
        JScrollPane scrollPanel = new JScrollPane(frameTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frameTextPane.add(scrollPanel);

//==========================================> DRAFTS REPLY MAIL BUTTON <===[[[==========================================

        btn_frameDraftMail = new JButton("Drafts Reply");
        btn_frameDraftMail.setBounds(50, 300, 125, 30);
        btn_frameDraftMail.setBackground(new Color(25, 181, 254));
        btn_frameDraftMail.setForeground(new Color(243, 241, 239));
        btn_frameDraftMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_frameDraftMail.setToolTipText("Saves the Reply Mail in Drafts");
        btn_frameDraftMail.setFont(font);
        btn_frameDraftMail.addActionListener(this);

//==========================================> DISCARD REPLY MAIL BUTTON <===============================================

        btn_frameSendMail = new JButton("Send Reply");
        btn_frameSendMail.setBounds(200, 300, 125, 30);
        btn_frameSendMail.setBackground(new Color(243, 156, 18));
        btn_frameSendMail.setForeground(new Color(243, 241, 239));
        btn_frameSendMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_frameSendMail.setToolTipText("Sends the Reply Mail");
        btn_frameSendMail.setFont(font);
        btn_frameSendMail.addActionListener(this);

//==========================================> SEND REPLY MAIL BUTTON <==================================================

        btn_frameDiscard = new JButton("Discard Reply");
        btn_frameDiscard.setBounds(350, 300, 125, 30);
        btn_frameDiscard.setBackground(new Color(217, 30, 24));
        btn_frameDiscard.setForeground(new Color(243, 241, 239));
        btn_frameDiscard.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_frameDiscard.setToolTipText("Discards the Reply Email");
        btn_frameDiscard.setFont(font);
        btn_frameDiscard.addActionListener(this);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        frameTitleBar.add(frameTitleLabel);
        frameTitleBar.add(frameMainIcon);
        frameTitleBar.add(frameCloseLabel);
        frameTitleBar.add(frameMinusLabel);

        frameMainBody.add(frameTextPane);
        frameMainBody.add(btn_frameDraftMail);
        frameMainBody.add(btn_frameSendMail);
        frameMainBody.add(btn_frameDiscard);

        frame.add(frameTitleBar);
        frame.add(frameMainBody);

        frame.setVisible(true);

        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_frameDraftMail) {
                    /**
                     * Send the Written Email To Drafts.
                     *
                        if (!(recipientField.getText().equals("") && textArea.getText().equals("") && subjectField.getText().equals(""))) {
                            MailBody mailbody = new MailBody(recipientField.getText(),Driver.mail.getUser().getUsername(),textArea.getText(),subjectField.getText(),false,false,false,false,true,false,0,0);
                            Driver.dataAgent.addMail(mailbody);
                            dispose();
                        }
                        else if (JOptionPane.showConfirmDialog(ComposeMail.super.rootPane, "Some Fields of mail are empty, Do you till want to save as draft?","Empty Fields in Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                            MailBody mailbody = new MailBody(recipientField.getText(),Driver.mail.getUser().getUsername(),textArea.getText(),subjectField.getText(),false,false,false,false,true,false,0,0);
                            Driver.dataAgent.addMail(mailbody);
                            dispose();
                        }
                    */
                } else if (e.getSource() == btn_frameSendMail) {
                    /**
                     * Send the Written Email To Recipient.
                     *
                        if (recipientField.getText().equals("")) {
                            JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"You cannot send a mail with no recipient!","Empty Recipient",JOptionPane.ERROR_MESSAGE);
                        }
                        else if (Driver.mail.checkMultipleUsers(recipientField.getText())!=null) {
                            JOptionPane.showMessageDialog(ComposeMail.super.rootPane,"The entered recipient "+Driver.mail.checkMultipleUsers(recipientField.getText())+" doesn't exist!","Invalid Recipient",JOptionPane.ERROR_MESSAGE);
                        } else {
                            MailBody mailbody = new MailBody(recipientField.getText(),Driver.mail.getUser().getUsername(),textArea.getText(),subjectField.getText(),false,false,false,true,false,false,0,0);
                            Driver.dataAgent.addMail(mailbody);
                            dispose();
                        }
                     */
                } else if (e.getSource() == btn_frameDiscard) {
                    /**
                     * Discards the Written Email.
                     */
                    if (JOptionPane.showConfirmDialog(ShowEmail.this, "Are you sure you want to discard the current mail?","Discard Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                        dispose();
                    }
                }
            }
        };
    }
}

//==========================================> END OF CODE <=============================================================