package capstone1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.sql.*;
/**
 *
 * @author angel
 */
//private UserLogin UsLogin = new UserLogin;
public class TitleScreen extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public TitleScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        Register = new javax.swing.JButton();
        Aboutbt = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        LoginBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Cartel");
        setMinimumSize(new java.awt.Dimension(1068, 600));
        setPreferredSize(new java.awt.Dimension(1068, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/The Cartel.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 590, 140));

        Register.setBackground(new java.awt.Color(102, 102, 102));
        Register.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        getContentPane().add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 150, 60));

        Aboutbt.setBackground(new java.awt.Color(102, 102, 102));
        Aboutbt.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        Aboutbt.setForeground(new java.awt.Color(255, 255, 255));
        Aboutbt.setText("About the game");
        Aboutbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutbtActionPerformed(evt);
            }
        });
        getContentPane().add(Aboutbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 150, 60));

        Exit.setBackground(new java.awt.Color(102, 102, 102));
        Exit.setFont(new java.awt.Font("MS UI Gothic", 1, 18)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 150, 60));

        LoginBt.setBackground(new java.awt.Color(102, 102, 102));
        LoginBt.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        LoginBt.setForeground(new java.awt.Color(255, 255, 255));
        LoginBt.setText("Log-in");
        LoginBt.setBorder(null);
        LoginBt.setBorderPainted(false);
        LoginBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 150, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mafiacig.jpg"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1060, 400));
        jLabel1.setPreferredSize(new java.awt.Dimension(1060, 400));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 570));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("About the game");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 150, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
       
    }//GEN-LAST:event_RegisterActionPerformed

    private void LoginBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtActionPerformed
     logrun();  // TODO add your handling code here:
    }//GEN-LAST:event_LoginBtActionPerformed
       
    private void AboutbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutbtActionPerformed
     instrun();   // TODO add your handling code here:
    }//GEN-LAST:event_AboutbtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

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
            java.util.logging.Logger.getLogger(TitleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TitleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TitleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TitleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TitleScreen().setVisible(true);
            }
        });
    }
    public void logrun(){
        UserLogin log = new UserLogin();
    }
    public void instrun(){
        JFrame instframe = new JFrame("About the game");
        JPanel instpanel = new JPanel();
        instframe.setSize(400,600);
        
        JTextArea instinfo = new JTextArea(30,20); 
        instinfo.setText("BLEH");
        //instinfo.seta
        instinfo.setEditable(false);
      
        instframe.add(instpanel);
        instpanel.add(instinfo);
        
        instframe.setLocationRelativeTo(null);
        instframe.setVisible(true);
        instframe.setResizable(false);
        this.pack();
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aboutbt;
    private javax.swing.JButton Exit;
    private javax.swing.JButton LoginBt;
    private javax.swing.JButton Register;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

//DATABSE, LOGIN.LOGOUT, MULTIPLE USER, REGISTER, SERVER
