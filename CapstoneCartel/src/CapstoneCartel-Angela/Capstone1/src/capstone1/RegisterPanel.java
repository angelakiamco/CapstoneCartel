/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone1;

/**
 *
 * @author angel
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.netbeans.lib.awtextra.*;

public class RegisterPanel extends JPanel {
    MainFrame parent;
    private JLabel screenName;
    private JLabel passLabel; 
    private JLabel emailLabel;
    private JLabel userLabel;
  //  private JLabel backgroundLabel = new JLabel();

    private JButton backLog;  
    private JButton regButton;

    private JTextField emailField;
    private JTextField screenNameField;
    private JPasswordField passField;
    private JTextField userField;
    
    public RegisterPanel(MainFrame parent){
        
        this.parent = parent;
        setOpaque(false);
        //setLayout(new AbsoluteLayout());
        
        screenName = new JLabel("Screen Name:");
        this.add(screenName);
        screenNameField = new JTextField();
        this.add(screenNameField);
                
        userLabel = new JLabel("Username:");
        this.add(userLabel);
        userField = new JTextField();
        userField.setBounds(700,120,250,30);
        this.add(userField);
        
        passLabel = new JLabel("Password:");
        this.add(passLabel);
        passField = new JPasswordField();
        this.add(passField);
        
        emailLabel = new JLabel("Email:");
        this.add(emailLabel);   
        emailField = new JTextField();
        this.add(emailField);
        
        backLog = new JButton("Back to Login");
        backLog.setBounds(830,420,120,30);
        regButton= new JButton("Create Account");
        regButton.setBounds(830,330,120,50);
        this.add(backLog);
        this.add(regButton);
        
        ActionHandler ah = new ActionHandler();
        //parent.setupBackground();

        userLabel.setFont(new Font("MS Gothic", 1, 24)); // NOI18N
        userLabel.setText("Username:");
        userLabel.setBounds(550, 130, 140, 60);
        userField.addActionListener(ah);
        
        screenName.setFont(new Font("MS Gothic", 1, 24)); // NOI18N
        screenName.setText("Name:");
        screenName.setBounds(550, 70, 140, 60);
        
        emailLabel.setFont(new Font("MS Gothic", 1,24));
        emailLabel.setText("Email:");
        emailLabel.setBounds(550, 230,180,80);
        
        passLabel.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
        passLabel.setText("Password:");
        passLabel.setBounds(550, 180, 180, 80);
        //parent.launchRegisterFrame();
    }
    
    private class ActionHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if( e.getSource() == regButton)
                try {
                    createUser();
                    //throw new UnsupportedOperationException("Not supported yet.");
                } catch (SQLException ex) {
                    System.out.print("SQL Fail");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Fail");
                }
            else if(e.getSource() == backLog){
                parent.launchUserLogin();
            }
        }
}
    private void createUser() throws SQLException, ClassNotFoundException{
        if(screenNameField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Name Field" + "is empty", "Name Required", JOptionPane.ERROR_MESSAGE);
        }
        String query = "Insert into Account(Name, Username, Password, EmailAddress)" +
                   "Values " + "(" + screenNameField.getText() + "," 
                             + userField.getText() + "," 
                             + passField.getPassword()+ "," 
                             + emailField.getText() + ");";         
        Statement stmt = null;
        String Username = "CapstoneCartel";
        String Password = "thisissupersecure";
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbconn = "jdbc:sqlserver://172.18.53.128, 49171\\SQLEXPRESS database=Capstone"; //
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //connecting to the database
        //String dbconn = "jdbc:sqlserver://172.18.53.128,49171"; //
        Connection conn = DriverManager.getConnection(dbconn, Username, Password);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
      	ResultSet rset = stmt.executeQuery(query);
        
        
    }
}
