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

public class TitlePage extends JFrame {
        
        private JLabel mafiaCig;
        //private JButton jButton1;
        private JButton aboutBtn;
        private JButton exitBtn;
        private JButton loginBtn;
        private JLabel cartelLabel;
        
    public TitlePage(){
        super("The Cartel");
        
        mafiaCig = new JLabel();
        aboutBtn = new JButton();
        exitBtn = new JButton();
        loginBtn = new JButton();
        cartelLabel = new JLabel();
        
        JPanel mainPanel = new JPanel();
        ActionHandler ah = new ActionHandler();
        
        setMinimumSize(new Dimension(1068, 600));
        setPreferredSize(new Dimension(1068, 600));
        setResizable(false);
       mainPanel.setLayout(new AbsoluteLayout());

        cartelLabel.setIcon(new ImageIcon(getClass().getResource("/The Cartel.png")));        
        mainPanel.add(cartelLabel, new AbsoluteConstraints(450, 430, 590, 140));
        
        
        loginBtn.setBackground(new Color(102, 102, 102));
        loginBtn.setFont(new Font("MS PGothic", 1, 18));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setText("Log-in");
        loginBtn.setBorder(null);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(ah);

        mainPanel.add(loginBtn, new AbsoluteConstraints(830, 90, 150, 60));
      
              
        aboutBtn.setBackground(new Color(102, 102, 102));
        aboutBtn.setFont(new Font("MS UI Gothic", 0, 18)); // NOI18N
        aboutBtn.setForeground(new Color(255, 255, 255));
        aboutBtn.setText("About the game");
        aboutBtn.addActionListener(ah);
        mainPanel.add(aboutBtn, new AbsoluteConstraints(400, 530, 150, 60));

        exitBtn.setBackground(new Color(102, 102, 102));
        exitBtn.setFont(new Font("MS UI Gothic", 1, 18)); // NOI18N
        exitBtn.setForeground(new Color(255, 255, 255));
        exitBtn.setText("Exit");
        exitBtn.addActionListener(ah);

        mainPanel.add(exitBtn, new AbsoluteConstraints(830, 360, 150, 60));

        mainPanel.add(aboutBtn, new AbsoluteConstraints(830, 320, 150, 60));
        
        
        mafiaCig.setIcon(new ImageIcon(getClass().getResource("/mafiacig.jpg"))); 

        mafiaCig.setMinimumSize(new Dimension(1060, 400));
        mafiaCig.setPreferredSize(new Dimension(1060, 400));
        mainPanel.add(mafiaCig, new AbsoluteConstraints(0, 0, 1060, 570));
        
        pack();
        add(mainPanel);
        setMinimumSize(new Dimension(1080, 600));
        setPreferredSize(new Dimension(1068, 600));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
        

   
       
    private class ActionHandler implements ActionListener{
        
   
    
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == loginBtn) {
             //UserLogin ul = new UserLogin();
             
             
        }
         else if (e.getSource() == aboutBtn) {
             
         }
         else if (e.getSource() == exitBtn) {
             System.exit(0);
         }
//         else if (e.getSource() == loginBtn) {
//             
//         }
    }
    
}
    
    public static void main(String[] args) {
        new TitlePage1();
    }
}
