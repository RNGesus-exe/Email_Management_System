import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class EmailMenu extends JFrame implements ActionListener {

    private int button_id;
    /**
     1) Inbox
     2) Starred
     3) Draft
     4) Spam
     5) All Mail
     6) Trash
     7) Sent
     */

    private JPanel titleBar;
    private JPanel mainBody;

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;

    private ArrayList<MailBody> dataValues = new ArrayList<>();
    private String [][] mails = null;

    private JButton btn_Account;
    private JButton btn_LogOut;
    private JButton btn_Compose;
    private JButton btn_Inbox;
    private JButton btn_Starred;
    private JButton btn_Sent;
    private JButton btn_Draft;
    private JButton btn_AllMail;
    private JButton btn_Spam;
    private JButton btn_Trash;
    private JButton btn_Group;
    private JButton btn_Refresh;
    private JButton button = new JButton();  //Used in JTable

    private JScrollPane jScrollPane;
    private JTable jTable;
    private JPanel jTablePanel;
    private TableCellRenderer tableRenderer;
    private DefaultTableModel model;

    private int y_Axis = 135;
    private Font font;

    public EmailMenu() {

//==========================================> MAIN J-FRAME <============================================================

        setBounds(150, 50, 1200, 700);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 1200, 700, 30, 30));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar = new JPanel();
        titleBar.setBounds(0, 0, 1200, 50);
        titleBar.setBackground(new Color(34, 167, 240));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);

//==========================================> J-PANEL MAIN ICON <=======================================================

        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(icon.getImage());

        Image img = icon.getImage();
        img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel mainIcon = new JLabel(icon);
        mainIcon.setBounds(0,0,50,50);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody = new JPanel();
        mainBody.setBounds(0, 50, 1200, 650);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Main Menu");
        titleLabel.setBounds(50, 13, 350, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(1175, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 22));

        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.setToolTipText("Close");
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (JOptionPane.showConfirmDialog(EmailMenu.this, "Are you sure you want to exit?", "Exit Email System", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                    Driver.dataAgent.updateUserDataBase(Driver.mail.getUser().getId());
                    System.exit(0);
                }
                Driver.dataAgent.updateUserDataBase(Driver.mail.getUser().getId());
            }
        });

//==========================================> MINUS LABEL <=============================================================

        minusLabel = new JLabel("-");
        minusLabel.setBounds(1150, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));
        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.setToolTipText("Minimize");
        minusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EmailMenu.super.setState(JFrame.ICONIFIED);
            }
        });

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Welcome Back " + Driver.mail.getUser().getFirstName());
        mainLabel.setBounds(400, 50, 500, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 32));

//==========================================> ACCOUNTS INFO BUTTON <====================================================

        font = new Font("Arial", Font.BOLD, 14);

        btn_Account = new JButton("Account Info");
        btn_Account.setBounds(950, 15, 100, 30);
        btn_Account.setBackground(new Color(34, 167, 240));
        btn_Account.setForeground(new Color(243, 241, 239));
        btn_Account.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Account.setToolTipText("Information About the Account");
        btn_Account.setFont(font);
        btn_Account.addActionListener(e -> new AboutUser());

//==========================================> LOG OUT BUTTON <==========================================================

        btn_LogOut = new JButton("Log Out");
        btn_LogOut.setBounds(1075, 15, 100, 30);
        btn_LogOut.setBackground(new Color(34, 167, 240));
        btn_LogOut.setForeground(new Color(243, 241, 239));
        btn_LogOut.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_LogOut.setToolTipText("Logs Out from the Account");
        btn_LogOut.setFont(font);
        btn_LogOut.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(EmailMenu.this, "Are you sure you want to exit?", "Exit Email System", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                Driver.dataAgent.updateUserDataBase(Driver.mail.getUser().getId());
                dispose();
                Driver.mail.updateUserdata(Driver.mail.getUser().getId());
                new LogInMenu();
            }
            Driver.dataAgent.updateUserDataBase(Driver.mail.getUser().getId());
        });

//==========================================> Group Button <============================================================

        btn_Refresh = new JButton("Refresh");
        btn_Refresh.setBounds(100, 135, 100, 30);
        btn_Refresh.setBackground(new Color(34, 167, 240));
        btn_Refresh.setForeground(new Color(243, 241, 239));
        btn_Refresh.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Refresh.setToolTipText("Refreshes the Data");
        btn_Refresh.setFont(font);
        btn_Refresh.addActionListener(this);

//==========================================> Group Button <============================================================

        btn_Group = new JButton("Groups");
        btn_Group.setBounds(100, 185, 100, 30);
        btn_Group.setBackground(new Color(34, 167, 240));
        btn_Group.setForeground(new Color(243, 241, 239));
        btn_Group.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Group.setToolTipText("Create/Edit/Delete Groups");
        btn_Group.setFont(font);
        btn_Group.addActionListener(e -> new Groups());

//==========================================> COMPOSE BUTTON <==========================================================

        btn_Compose = new JButton("Compose");
        btn_Compose.setBounds(100, 235, 100, 30);
        btn_Compose.setBackground(new Color(34, 167, 240));
        btn_Compose.setForeground(new Color(243, 241, 239));
        btn_Compose.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Compose.setFont(font);
        btn_Compose.addActionListener(e -> new ComposeMail());

//==========================================> INBOX BUTTON <============================================================

        btn_Inbox = new JButton("Inbox : " + Driver.mail.getAmountOfInboxMails());
        btn_Inbox.setBounds(100, 285, 100, 30);
        btn_Inbox.setBackground(new Color(34, 167, 240));
        btn_Inbox.setForeground(new Color(243, 241, 239));
        btn_Inbox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Inbox.setToolTipText("Shows Inbox & Read Mails");
        btn_Inbox.setFont(font);
        btn_Inbox.addActionListener(this);

//==========================================> STARRED BUTTON <==========================================================

        btn_Starred = new JButton("Starred : " + Driver.mail.getAmountOfStarredMails());
        btn_Starred.setBounds(100, 335, 100, 30);
        btn_Starred.setBackground(new Color(34, 167, 240));
        btn_Starred.setForeground(new Color(243, 241, 239));
        btn_Starred.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Starred.setToolTipText("Shows Starred Mails");
        btn_Starred.setFont(font);
        btn_Starred.addActionListener(this);

//==========================================> SENT BUTTON <=============================================================

        btn_Sent = new JButton("Sent : " + Driver.mail.getAmountOfSentMails());
        btn_Sent.setBounds(100, 385, 100, 30);
        btn_Sent.setBackground(new Color(34, 167, 240));
        btn_Sent.setForeground(new Color(243, 241, 239));
        btn_Sent.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Sent.setToolTipText("Shows Sent Mails");
        btn_Sent.setFont(font);
        btn_Sent.addActionListener(this);

//==========================================> DRAFTS BUTTON <===========================================================

        btn_Draft = new JButton("Drafts : " + Driver.mail.getAmountOfDraftMails());
        btn_Draft.setBounds(100, 435, 100, 30);
        btn_Draft.setBackground(new Color(34, 167, 240));
        btn_Draft.setForeground(new Color(243, 241, 239));
        btn_Draft.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Draft.setToolTipText("Shows Draft Mails");
        btn_Draft.setFont(font);
        btn_Draft.addActionListener(this);

//==========================================> ALL MAIN BUTTON <=========================================================

        btn_AllMail = new JButton("All Main : " + Driver.mail.getAllMails().size());
        btn_AllMail.setBounds(100, 485, 100, 30);
        btn_AllMail.setBackground(new Color(34, 167, 240));
        btn_AllMail.setForeground(new Color(243, 241, 239));
        btn_AllMail.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_AllMail.setToolTipText("Shows All Mails");
        btn_AllMail.setFont(font);
        btn_AllMail.addActionListener(this);

//==========================================> SPAM BUTTON <=============================================================

        btn_Spam = new JButton("Spam : " + Driver.mail.getSpam().size());
        btn_Spam.setBounds(100, 535, 100, 30);
        btn_Spam.setBackground(new Color(34, 167, 240));
        btn_Spam.setForeground(new Color(243, 241, 239));
        btn_Spam.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Spam.setToolTipText("Shows Spam Mails");
        btn_Spam.setFont(font);
        btn_Spam.addActionListener(this);

//==========================================> TRASH BUTTON <============================================================

        btn_Trash = new JButton("Trash " + Driver.mail.getAmountOfTrashMails());
        btn_Trash.setBounds(100, 585, 100, 30);
        btn_Trash.setBackground(new Color(34, 167, 240));
        btn_Trash.setForeground(new Color(243, 241, 239));
        btn_Trash.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Trash.setToolTipText("Shows Trash Mails");
        btn_Trash.setFont(font);
        btn_Trash.addActionListener(this);

//==========================================> ADDING ICONS <============================================================

        addIcons("Icons/Refresh.png");
        addIcons("Icons/Group_Icon.png");
        addIcons("Icons/Compose.png");
        addIcons("Icons/Inbox.png");
        addIcons("Icons/Starred.png");
        addIcons("Icons/Sent.png");
        addIcons("Icons/Drafts.png");
        addIcons("Icons/AllMail.png");
        addIcons("Icons/Spam.png");
        addIcons("Icons/Trash.png");

//==========================================> J-TABLE EMAIL DISPLAY <===================================================

        jTablePanel = new JPanel();
        jTablePanel.setBounds(225, 125, 950, 500);
        jTablePanel.setBackground(new Color(52, 73, 94));
        jTablePanel.setLayout(new BorderLayout());

//==========================================> J-TABLE EMAIL DISPLAY <===================================================

        jTableFunction();
        jTableCoordinatesFunction();
        jTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {

                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    new ShowEmail((short)button_id, table.getSelectedRow());
                }
            }
        });

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(btn_Account);
        mainBody.add(btn_LogOut);
        mainBody.add(btn_Refresh);
        mainBody.add(btn_Group);
        mainBody.add(btn_Compose);
        mainBody.add(btn_Inbox);
        mainBody.add(btn_Starred);
        mainBody.add(btn_Sent);
        mainBody.add(btn_Draft);
        mainBody.add(btn_AllMail);
        mainBody.add(btn_Spam);
        mainBody.add(btn_Trash);

        mainBody.add(jTablePanel);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);

    }

//==========================================> SET BUTTON ICONS <========================================================

    public void addIcons(String iconPath)   {
        ImageIcon background = new ImageIcon(iconPath);
        Image img = background.getImage();
        img = img.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        background = new ImageIcon(img);

        JLabel icon = new JLabel(background);
        icon.setBounds(50,y_Axis,30,30);
        icon.setLayout(null);
        mainBody.add(icon);
        y_Axis += 50;
    }

//==========================================> FUNCTION TO CREATE TABLE <================================================

    private void jTableFunction() {
        jScrollPane = new JScrollPane();
        jTable = new JTable(new HelperClasses.JTableButtonModel());

        tableRenderer = jTable.getDefaultRenderer(JButton.class);
        jTable.setDefaultRenderer(JButton.class, new HelperClasses.ButtonRenderer());
        JScrollPane scrollPane = new JScrollPane(jTable);
        jTablePanel.add(scrollPane, BorderLayout.CENTER);

        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(false);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);

        dataValues = Driver.mail.getInbox();
        mails = new String[dataValues.size()][5];

        for (int i = 0; i < dataValues.size(); i++) {
            mails[i][0] = dataValues.get(i).getSender();
            mails[i][1] = dataValues.get(i).getSubject();
            mails[i][2] = dataValues.get(i).getDateTime().toString();
        }
        button_id = 1;

        jTableDataFunction(mails);

        button.addActionListener(e -> {
            if(jTable.getSelectedColumn() == 3) {
                switch(button_id) {
                    case 1:
                        Driver.mail.getMails().get(Driver.mail.getIndexOfMail(Driver.mail.getInbox().get(jTable.getSelectedRow()))).changeRecipientStarred();
                        break;
                    case 2:
                        Driver.mail.getMails().get(Driver.mail.getIndexOfMail(Driver.mail.getStarred().get(jTable.getSelectedRow()))).changeRecipientStarred();
                        break;
                    case 3:
                        Driver.mail.getDraft().get(jTable.getSelectedRow()).changeRecipientStarred();
                        break;
                    case 4:
                        Driver.mail.getMails().get(Driver.mail.getIndexOfMail(Driver.mail.getSpam().get(jTable.getSelectedRow()))).changeRecipientStarred();
                        break;
                    case 5:
                        Driver.mail.getMails().get(Driver.mail.getIndexOfMail(Driver.mail.getAllMails().get(jTable.getSelectedRow()))).changeRecipientStarred();
                        break;
                    case 6:
                        Driver.mail.getMails().get(Driver.mail.getIndexOfMail(Driver.mail.getTrash().get(jTable.getSelectedRow()))).changeRecipientStarred();
                        break;
                    case  7:
                        Driver.mail.getSent().get(jTable.getSelectedRow()).changeSenderStarred();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "If you see this message then your program is most likely screwed up", "Bhai asay mazak nahi mera", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(jTable.getSelectedColumn()==4){
                switch(button_id) {
                    case 1:
                        Driver.mail.getInbox().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case 2:
                        Driver.mail.getStarred().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case 3:
                        Driver.mail.getDraft().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case 4:
                        Driver.mail.getSpam().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case 5:
                        Driver.mail.getAllMails().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case 6:    //Permanent Delete
                        Driver.mail.getTrash().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    case  7:
                        Driver.mail.getSent().get(jTable.getSelectedRow()).setTrash(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "If you see this message then your program is most likely screwed up", "Bhai asay mazak nahi mera", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private void jTableDataFunction(String[][] emails) {
        //-- JTable Data
        model = new DefaultTableModel(emails, new String[]{"Sender", "Subject", "Date", "Star", "Trash"}) {

            Class[] types = new Class[]{String.class, String.class, String.class, Object.class, Object.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {

                return columnIndex==3 || columnIndex==4;
            }
        };


        jTable.setModel(model);

        jTable.getColumn("Star").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Star").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable.getColumn("Trash").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Trash").setCellEditor(new ButtonEditor(new JCheckBox()));

        //-- JTable Properties
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(200);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable.getColumnModel().getColumn(2).setMinWidth(100);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable.getColumnModel().getColumn(3).setMinWidth(70);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable.getColumnModel().getColumn(4).setMinWidth(70);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jTable.setRowHeight(25);
    }

//=========================================>  JTable Button Helper Functions <==========================================

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            if(column==3)
            {
                ImageIcon img_icon =  new ImageIcon("Icons/Starred.png");
                Image img = img_icon.getImage();
                img = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
                img_icon = new ImageIcon(img);
                setIcon(img_icon);
                setBackground(new Color(255, 255, 255));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            else if(column == 4)
            {
                ImageIcon img_icon =  new ImageIcon("Icons/Trash.png");
                Image img = img_icon.getImage();
                img = img.getScaledInstance(30,25,Image.SCALE_SMOOTH);
                img_icon = new ImageIcon(img);
                setIcon(img_icon);
                setBackground(new Color(255,255,255));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label = null;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return label;
        }
    }

    private void jTableCoordinatesFunction() {
        //-- Sets the location of the JTable in the JPanel.
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(0, Short.MAX_VALUE)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
    }

//==========================================> ACTION LISTENER <=========================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        Driver.mail.loadUserdata(Driver.mail.getUser().getId());
        if (e.getSource() == btn_Refresh) {

            this.invalidate();
            this.validate();
            this.repaint();

        }
        else if (e.getSource() == btn_Inbox) {
            button_id = 1;
            dataValues = Driver.mail.getInbox();
            mails = new String[dataValues.size()][5];
            for(int i = 0; i < dataValues.size() ; i++) {

                if (dataValues.get(i).isUnread()) {
                    jTable.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
                }

                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        } else if (e.getSource() == btn_Starred) {
            button_id = 2;
            dataValues = Driver.mail.getStarred();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
                System.out.println(mails[i][0]+":"+mails[i][1]+":"+mails[i][2]);
            }
        } else if (e.getSource() == btn_Sent) {
            button_id = 7;
            dataValues = Driver.mail.getSent();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        } else if (e.getSource() == btn_Draft) {
            button_id = 3;
            dataValues = Driver.mail.getDraft();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        } else if (e.getSource() == btn_AllMail) {
            button_id = 5;
            dataValues = Driver.mail.getAllMails();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        } else if (e.getSource() == btn_Spam) {
            button_id = 4;
            dataValues = Driver.mail.getSpam();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        } else if (e.getSource() == btn_Trash) {
            button_id = 6;
            dataValues = Driver.mail.getTrash();
            mails = new String[dataValues.size()][5];
            for(int i=0;i<dataValues.size() ;i++) {
                mails[i][0] = dataValues.get(i).getSender();
                mails[i][1] = dataValues.get(i).getSubject();
                mails[i][2] = dataValues.get(i).getDateTime().toString();
            }
        }  else {
            JOptionPane.showMessageDialog(null, "I don't know how you did this but pls teach me also.", "Legal Error! A.K.A Jahanzaib Error!", JOptionPane.ERROR_MESSAGE);
        }
        Driver.mail.updateUserdata(Driver.mail.getUser().getId());
        Driver.mail.loadUserdata(Driver.mail.getUser().getId());
        model.fireTableDataChanged();
        jTableDataFunction(mails);
    }
}