//==========================================> IMPORTED FILES <==========================================================

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

//==========================================> CLASS MAIN MENU <=========================================================

public class Groups extends JFrame implements ActionListener, MouseListener {

//==========================================> PRIVATE DATA MEMBERS <====================================================

    private JPanel titleBar = new JPanel();
    private JPanel mainBody = new JPanel();

    private Font font;

    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minusLabel;
    private JLabel mainLabel;
    private JLabel groupNameLabel;
    private JLabel emailTextLabel;
    private JLabel groupDescriptionLabel;

    private JTextField groupNameField;
    private JPanel jTablePanel = new JPanel();
    private JTextArea emailTextArea;
    private JTextArea groupDescriptionArea;
    private JScrollPane scrollBar;

    private JTextField nameField = new JTextField();
    private JTextField mailField = new JTextField();
    private Object[] inputFields;

    private JButton btn_Return;
    private JButton btn_AddMember;

    private JTable jTable;
    private DefaultTableModel model;
    private TableCellRenderer tableRenderer;
    private JButton jButton = new JButton();
    private JScrollPane jScrollPane;
    private String[][] mails;

//==========================================> DEFAULT CONSTRUCTOR <=====================================================

    public Groups() {

//==========================================> MAIN J-FRAME <============================================================

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(350, 50, 800, 700);
        this.setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 800, 700, 30, 30));
        setLayout(null);

//==========================================> J-PANEL TITLE BAR <=======================================================

        titleBar.setBounds(0, 0, 800, 50);
        titleBar.setBackground(new Color(171, 183, 183));
        titleBar.setLayout(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);

//==========================================> J-PANEL MAIN ICON <=======================================================

        //-- Change the Path After shifting this code to Email Management System.
        ImageIcon icon = new ImageIcon("Icons/Main_Logo.png");
        setIconImage(icon.getImage());

        Image img = icon.getImage();
        img = img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel mainIcon = new JLabel(icon);
        mainIcon.setBounds(05,05,40,40);
        mainIcon.setLayout(null);

//==========================================> J-PANEL MAIN BODY <=======================================================

        mainBody.setBounds(0, 50, 800, 650);
        mainBody.setBackground(new Color(52, 73, 94));
        mainBody.setLayout(null);

//==========================================> TITLE LABEL <=============================================================

        titleLabel = new JLabel("Group Menu");
        titleLabel.setBounds(50, 13, 200, 30);
        titleLabel.setForeground(new Color(46, 46, 49));
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

//==========================================> CLOSE LABEL <=============================================================

        closeLabel = new JLabel("X");
        closeLabel.setBounds(775, 15, 25, 22);
        closeLabel.setForeground(new Color(255, 0, 0));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        closeLabel.setToolTipText("Close");
        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(this);

//==========================================> MINUS LABEL <=============================================================

        minusLabel = new JLabel("-");
        minusLabel.setBounds(750, 0, 25, 44);
        minusLabel.setForeground(new Color(0, 0, 0));
        minusLabel.setFont(new Font("Arial", Font.BOLD, 44));
        minusLabel.setToolTipText("Minimize");
        minusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minusLabel.addMouseListener(this);

//==========================================> MAIN LABEL <==============================================================

        mainLabel = new JLabel("Create Group Menu");
        mainLabel.setBounds(290, 10, 350, 50);
        mainLabel.setForeground(new Color(243, 241, 239));
        mainLabel.setFont(new Font("Arial", Font.BOLD, 26));

//==========================================> GROUP NAME TEXT LABEL <===================================================

        groupNameLabel = new JLabel("Group Name");
        groupNameLabel.setBounds(100, 350, 120, 30);
        groupNameLabel.setForeground(new Color(243, 241, 239));
        groupNameLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> GROUP NAME TEXT LABEL <===================================================

        groupNameField = new JTextField("");
        groupNameField.setBounds(225, 350, 300, 30);
        groupNameField.setBackground(new Color(60, 60, 60));
        groupNameField.setForeground(new Color(243, 241, 239));
        groupNameField.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> J-TABLE-PANEL <===========================================================

        jTablePanel.setBounds(100, 75, 600, 250);
        jTablePanel.setBackground(new Color(243, 241, 239));
        jTablePanel.setLayout(null);

//==========================================> J-TABLE EMAIL DISPLAY <===================================================

        jTableFunction();
        jTableCoordinatesFunction();
        jTable.addMouseListener(this);

//==========================================> GROUP DESCRIPTION TEXT LABEL <============================================

        groupDescriptionLabel = new JLabel("Group Description");
        groupDescriptionLabel.setBounds(100, 400, 250, 20);
        groupDescriptionLabel.setForeground(new Color(243, 241, 239));
        groupDescriptionLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> TEXT AREA <===============================================================

        JPanel groupDescriptionPane = new JPanel(new BorderLayout());
        groupDescriptionPane.setBounds(100,430,600,70);
        groupDescriptionPane.setBackground(new Color(52, 73, 94));
        groupDescriptionPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        groupDescriptionArea = new JTextArea();
        groupDescriptionArea.setBounds(100, 430, 600, 70);
        groupDescriptionArea.setBackground(new Color(46, 49, 49));
        groupDescriptionArea.setForeground(new Color(243, 241, 239));
        groupDescriptionArea.setCaretColor(Color.white);
        groupDescriptionArea.setLineWrap(true);
        groupDescriptionArea.setFont(font);

        scrollBar = new JScrollPane(groupDescriptionArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        groupDescriptionPane.add(scrollBar);

//==========================================> TEXT LABEL <==============================================================

        emailTextLabel = new JLabel("Text");
        emailTextLabel.setBounds(100, 520, 60, 20);
        emailTextLabel.setForeground(new Color(243, 241, 239));
        emailTextLabel.setFont(new Font("Arial", Font.BOLD, 18));

//==========================================> TEXT AREA <===============================================================

        JPanel emailTextPane = new JPanel(new BorderLayout());
        emailTextPane.setBounds(100,550,600,70);
        emailTextPane.setBackground(new Color(52, 73, 94));
        emailTextPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        emailTextArea = new JTextArea();
        emailTextArea.setBounds(100, 550, 600, 70);
        emailTextArea.setBackground(new Color(46, 49, 49));
        emailTextArea.setForeground(new Color(243, 241, 239));
        emailTextArea.setCaretColor(Color.white);
        emailTextArea.setLineWrap(true);
        emailTextArea.setFont(font);

        scrollBar = new JScrollPane(emailTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        emailTextPane.add(scrollBar);

//==========================================> RETURN BUTTON <===========================================================

        font = new Font("Arial", Font.BOLD, 15);

        btn_Return = new JButton("Return");
        btn_Return.setBounds(10, 10, 60, 30);
        btn_Return.setBackground(new Color(60, 60, 60));
        btn_Return.setForeground(new Color(243, 241, 239));
        btn_Return.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_Return.setToolTipText("Click to Go Back");
        btn_Return.setFont(font);
        btn_Return.addActionListener(this);

//==========================================> SIGN UP BUTTON <==========================================================

        btn_AddMember = new JButton("Add New Member");
        btn_AddMember.setBounds(550, 350, 150, 30);
        btn_AddMember.setBackground(new Color(38, 166, 91));
        btn_AddMember.setForeground(new Color(243, 241, 239));
        btn_AddMember.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_AddMember.setToolTipText("Click to Sign Up");
        btn_AddMember.setFont(font);
        btn_AddMember.addActionListener(this);

//==========================================> ADD NEW MEMBER COMPONENTS <===============================================

        font = new Font("Arial", Font.PLAIN, 14);

        nameField.setBackground(new Color(60, 60, 60));
        nameField.setForeground(new Color(243, 241, 239));
        nameField.setCaretColor(Color.white);
        nameField.setFont(font);

        mailField.setBackground(new Color(60, 60, 60));
        mailField.setForeground(new Color(243, 241, 239));
        mailField.setCaretColor(Color.white);
        mailField.setFont(font);

//==========================================> ADDING FUNCTIONALITIES <==================================================

        titleBar.add(titleLabel);
        titleBar.add(mainIcon);
        titleBar.add(closeLabel);
        titleBar.add(minusLabel);

        mainBody.add(mainLabel);
        mainBody.add(groupNameLabel);
        mainBody.add(groupNameField);
        mainBody.add(jTablePanel);
        mainBody.add(groupDescriptionLabel);
        mainBody.add(groupDescriptionPane);
        mainBody.add(emailTextLabel);
        mainBody.add(emailTextPane);
        mainBody.add(btn_Return);
        mainBody.add(btn_AddMember);

        add(titleBar);
        add(mainBody);

//==========================================> SET VISIBLE TRUE <========================================================

        setVisible(true);
    }

//==========================================> ADD MEMBER DIALOG METHOD <==-=============================================

    private void addMemberDialog() {

        nameField.setText("");
        mailField.setText("");
        inputFields = new Object[] {"Member Name", nameField, "Member Email", mailField};
        if (JOptionPane.showConfirmDialog(this, inputFields, "Add Group Member", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
            /**
             * Check email here.
             **/
            if (nameField.getText().trim().equals("") || nameField.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Error! Name or Email Field cannot be empty!", "Invalid Name or Email", JOptionPane.ERROR_MESSAGE);
                addMemberDialog();
            } else {
                model.addRow(new Object[]{nameField.getText().trim(), mailField.getText().trim(), new JButton("Edit"), new JButton("Delete")});
            }
        }
    }

//==========================================> FUNCTION TO CREATE TABLE <================================================

    private void jTableFunction() {
        jScrollPane = new JScrollPane();
        jTable = new JTable(new JTableButtonModel());

        tableRenderer = jTable.getDefaultRenderer(JButton.class);
        jTable.setDefaultRenderer(JButton.class, new ButtonRenderer());
        JScrollPane scrollPane = new JScrollPane(jTable);
        jTablePanel.add(scrollPane, BorderLayout.CENTER);

        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(false);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);

        //-- Change 2 for no of mails.
        mails = new String[2][4];
        //-- Change 2 for no of mails.
        for (int i = 0; i < 2; i++) {
            mails[i][0] = "Name no. " + (i + 1);
            mails[i][1] = "Email_" + (i + 1) + "@notMail.com";
        }

        jTableDataFunction(mails);
        jButton.addActionListener(this);

    }

    private void jTableDataFunction(String[][] emails) {
        //-- JTable Data
        model = new DefaultTableModel(emails, new String[]{"Name", "Email", "Edit", "Delete"}) {

            Class[] types = new Class[] {String.class, String.class, Object.class, Object.class};
            boolean[] canEdit = new boolean[] {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return (columnIndex == 2 || columnIndex == 3);
            }
        };

        jTable.setModel(model);

        jTable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));

        //-- JTable Properties
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(200);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable.getColumnModel().getColumn(2).setMinWidth(50);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable.getColumnModel().getColumn(3).setMinWidth(50);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(3).setMaxWidth(50);
        }
        jTable.setRowHeight(25);
        model.fireTableDataChanged();
    }

    private void jTableCoordinatesFunction() {
        //-- Sets the location of the JTable in the JPanel.
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(0, Short.MAX_VALUE)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(325, 325, 325))
        );
    }

//=========================================>  J-TABLE HELPER CLASSES <==================================================

    static class JTableButtonModel extends AbstractTableModel {

        private Object[][] rows = {{"Edit", new JButton("Edit")},{"Delete", new JButton("Delete")}};
        private String[] columns = {"Name", "Email", "Edit", "Delete"};

        public String getColumnName(int column) {
            return columns[column];
        }

        public int getRowCount() {
            return rows.length;
        }

        public int getColumnCount() {
            return columns.length;
        }

        public Object getValueAt(int row, int column) {
            return rows[row][column];
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }

        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(column == 2) {
                //-- Change Path once copied this whole code to original Groups Class.
                ImageIcon img_icon =  new ImageIcon("Icons/Add.png");
                Image img = img_icon.getImage();
                img = img.getScaledInstance(25,25,Image.SCALE_SMOOTH);
                img_icon = new ImageIcon(img);
                setIcon(img_icon);
                setBackground(new Color(255, 255, 255));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            } else if(column == 3) {
                //-- Change Path once copied this whole code to original Groups Class.
                ImageIcon img_icon =  new ImageIcon("Icons/Remove.png");
                Image img = img_icon.getImage();
                img = img.getScaledInstance(25,25,Image.SCALE_SMOOTH);
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
            jButton.setText(label);
            return jButton;
        }

        public Object getCellEditorValue() {
            return label;
        }
    }

//==========================================> ACTION LISTENER <=========================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Return) {
            dispose();
        } else if (e.getSource() == btn_AddMember) {
            addMemberDialog();
        } else if (e.getSource() == jButton) {
            if (jTable.getSelectedColumn() == 2) {
                nameField.setText(jTable.getModel().getValueAt(jTable.getSelectedRow(), 0).toString());
                mailField.setText(jTable.getModel().getValueAt(jTable.getSelectedRow(), 1).toString());
                inputFields = new Object[]{"Member Name", nameField, "Member Email", mailField};
                if (JOptionPane.showConfirmDialog(this, inputFields, "Add Group Member", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /**
                     * Check email here.
                     **/
                    if (nameField.getText().trim().equals("") || nameField.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(this, "Error! Name or Email Field cannot be empty!", "Invalid Name or Email", JOptionPane.ERROR_MESSAGE);
                        addMemberDialog();
                    } else {
                        jTable.setValueAt(nameField.getText().trim(), jTable.getSelectedRow(), 0);
                        jTable.setValueAt(mailField.getText().trim(), jTable.getSelectedRow(), 1);
                        model.fireTableDataChanged();
                    }
                }
            }
            else if (jTable.getSelectedColumn() == 3) {
                model.removeRow(jTable.getSelectedRow());
            }
            model.fireTableDataChanged();
        }
    }

//==========================================> MOUSE LISTENER <==========================================================

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == closeLabel) {
            dispose();
        } else if (e.getSource() == minusLabel) {
            Groups.super.setState(JFrame.ICONIFIED);
        } else if (e.getSource() == jTable) {
            JTable table =(JTable) e.getSource();
            Point point = e.getPoint();
            int row = table.rowAtPoint(point);

            if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {

            }
            model.fireTableDataChanged();
        }
    }
    //-- The rest are not being used but still needs to be overload.
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

}

//==========================================> END OF CODE <=============================================================