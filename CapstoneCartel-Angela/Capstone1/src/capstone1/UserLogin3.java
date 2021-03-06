/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone1;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout; 

/**
 *
 * @author Aaron Spero
 */
public class UserLogin3 extends javax.swing.JFrame {

    /**
     * Creates new form UserLogin3
     */
    MainFrame parent;
    
    public UserLogin3(MainFrame parent) {
        this.parent = parent;
        initComponents();
        JLabel mafiaCig = new JLabel();
        JLabel bGLabel = new JLabel();
        
        
        setTitle("The Cartel");
        setSize(1068,600);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
    }
    
    public UserLogin3() {
        initComponents();
        
    }

    private void verifyLogin() throws SQLException, ClassNotFoundException {
        System.out.println(new String(passField.getPassword()));
        if(userField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Username Field" + 
                            " is empty.", "Username Required", 
                            JOptionPane.ERROR_MESSAGE);
        }
        else if(new String(passField.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Password Field" + 
                            " is empty.", "Password Required", 
                            JOptionPane.ERROR_MESSAGE);
        }
        String query = "Select Username, Password " +
                   "From Account " +
                   "Where Username = " + userField.getText() +
                   " And Password = " + new String(passField.getPassword()) + ";";
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
        
         try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(!rset.next()) {
            JOptionPane.showMessageDialog(this, "Incorrect Username/Password", 
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this, "Congratulations! Logged in", 
                    "Success!", JOptionPane.PLAIN_MESSAGE);
        }
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        theCartelLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        userLabel.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
        userLabel.setText("Username:");
        getContentPane().add(userLabel);
        userLabel.setBounds(550, 100, 140, 60);

        passLabel.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
        passLabel.setText("Password:");
        getContentPane().add(passLabel);
        passLabel.setBounds(550, 180, 180, 80);

        registerLabel.setText("NEW USER? :");
        getContentPane().add(registerLabel);
        registerLabel.setBounds(570, 300, 80, 20);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(820, 280, 130, 50);

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonClicked(evt);
            }
        });
        getContentPane().add(registerButton);
        registerButton.setBounds(670, 293, 80, 30);

        backButton.setText("Back -->");
        getContentPane().add(backButton);
        backButton.setBounds(2683, 639, 81, 25);

        userField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernamePressed(evt);
            }
        });
        getContentPane().add(userField);
        userField.setBounds(700, 120, 250, 30);

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        passField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordPressed(evt);
            }
        });
        getContentPane().add(passField);
        passField.setBounds(700, 200, 250, 30);

        theCartelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/The Cartel.png"))); // NOI18N
        getContentPane().add(theCartelLabel);
        theCartelLabel.setBounds(420, 420, 650, 180);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mafiacig.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1068, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       try{
           verifyLogin();
       } catch(SQLException e) {
           System.out.println("SQL FAIL");
       } catch(ClassNotFoundException e) {
           System.out.println("Class Not Found.");
       }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void registerButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonClicked
//        getContentPane().removeAll();
//        getContentPane().setLayout(new AbsoluteLayout());
//        
//        theCartelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/The Cartel.png")));        
//        getContentPane().add(theCartelLabel, new AbsoluteConstraints(450, 430, 590, 140));
//        
//        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mafiacig.jpg"))); 
//
//        backgroundLabel.setMinimumSize(new java.awt.Dimension(1060, 400));
//        backgroundLabel.setPreferredSize(new java.awt.Dimension(1060, 400));
//        getContentPane().add(backgroundLabel, new AbsoluteConstraints(0, 0, 1060, 570));
//        
//        this.repaint();
        parent.launchRegisterFrame();
    }//GEN-LAST:event_registerButtonClicked

    private void usernamePressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernamePressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           passField.requestFocus();
                                     
    }//GEN-LAST:event_usernamePressed

    private void passwordPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPressed
                                    
       if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           try {
           verifyLogin();
           } catch(SQLException e) {
               
           } catch(ClassNotFoundException e) {
               
           }
    }//GEN-LAST:event_passwordPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLogin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel theCartelLabel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
