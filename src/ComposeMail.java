import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ComposeMail extends JFrame implements ActionListener,KeyListener {

    private JTextField recipientField;
    private JTextField subjectField;
    private JButton sendButton;
    private JButton discardButton;
    private JButton draftButton;
    private JTextArea textBox;
    private String username;

    public ComposeMail(String username) {
        this.username = username;
        setBounds(380,150,600,500);
        setTitle("Compose Mail");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon logo = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(153, 235,255));

        setLayout(null);

        Font font = new Font("Arial",Font.BOLD,14);       //Font for labels

        JLabel recipientLabel = new JLabel("Recipient : ");
        recipientLabel.setBounds(10,10,80,30);
        recipientLabel.setFont(font);

        recipientField = new JTextField();
        recipientField.setBounds(100,10,200,30);
        recipientField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) { }
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) { recipientField.transferFocus(); }
                else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) { dispose(); }
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) { }
        });

        JLabel subjectLabel = new JLabel("Subject : ");
        subjectLabel.setBounds(10,50,80,30);
        subjectLabel.setFont(font);

        subjectField = new JTextField();
        subjectField.setBounds(100,50,450,30);
        subjectField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) { }
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) { subjectField.transferFocus(); }
                else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) { dispose(); }
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) { }
        });

        JLabel textBoxLabel = new JLabel("Text :");
        textBoxLabel.setFont(font);
        textBoxLabel.setBounds(10,100,100,30);

        JPanel textPane = new JPanel(new BorderLayout());
        textPane.setBounds(100,100,450,300);
        textBox = new JTextArea();
        textBox.setLineWrap(true);
        JScrollPane scrollBar = new JScrollPane(textBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textPane.add(scrollBar);

        sendButton = new JButton("Send");
        sendButton.setBounds(470,420,80,30);
        sendButton.setFont(font);
        sendButton.addActionListener(this);

        draftButton = new JButton("Draft");
        draftButton.setBounds(380,420,80,30);
        draftButton.setFont(font);

        discardButton = new JButton("Discard");
        discardButton.setBounds(280,420,90,30);
        discardButton.setFont(font);
        discardButton.addActionListener (this);

        add(sendButton);
        add(draftButton);
        add(discardButton);
        add(textBoxLabel);
        add(textPane);
        add(recipientLabel);
        add(recipientField);
        add(subjectLabel);
        add(subjectField);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==discardButton)
        {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to discard the current mail?","Discard Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                dispose();
            }
        }
        else if(e.getSource()==sendButton)
        {
            if(recipientField.getText().equals("")) {
                JOptionPane.showMessageDialog(this,"You cannot send a mail with no recipient!","Empty Recipient",JOptionPane.ERROR_MESSAGE);
            }
            else if(Driver.mail.checkMultipleUsers(recipientField.getText())!=null) {
                JOptionPane.showMessageDialog(this,"The entered recipient "+Driver.mail.checkMultipleUsers(recipientField.getText())+" doesn't exist!","Invalid Recipient",JOptionPane.ERROR_MESSAGE);
            }
            else {
                MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,true,false,false,0,0);
                Driver.dataAgent.addMail(mailbody);
                dispose();
            }
        }
        else if(e.getSource()==draftButton)
        {
            if(!(recipientField.getText().equals("") && textBox.getText().equals("") && subjectField.getText().equals("")))
            {
                MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                Driver.dataAgent.addMail(mailbody);
                dispose();
            }
            else
            {
                if (JOptionPane.showConfirmDialog(this, "Are you sure you want to draft an empty mail?","Empty Mail", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
                    MailBody mailbody = new MailBody(recipientField.getText(),username,textBox.getText(),subjectField.getText(),false,false,false,true,false,0,0);
                    Driver.dataAgent.addMail(mailbody);
                    dispose();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
