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

public class TitlePage1 extends JPanel {
        private JLabel mafiaCig;
        private JButton aboutBtn;
        private JButton exitBtn;
        private JButton loginBtn;
        private JLabel bGLabel;
        private MainFrame parent;
        
    public TitlePage1(MainFrame parent){
        
        this.parent = parent;
        
        
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));


        
        aboutBtn = new JButton();
        exitBtn = new JButton();
        loginBtn = new JButton();
        
        ActionHandler ah = new ActionHandler();
 
        loginBtn.setBackground(new Color(102, 102, 102));
        loginBtn.setFont(new Font("MS PGothic", 1, 18)); 
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setText("Log-in");
        loginBtn.setBorder(null);
        loginBtn.setBorderPainted(false);
        loginBtn.setPreferredSize(new Dimension(175, 70));
        loginBtn.addActionListener(ah);

        this.add(loginBtn);
      
              
        aboutBtn.setBackground(new Color(102, 102, 102));
        aboutBtn.setFont(new Font("MS UI Gothic", 0, 18));
        aboutBtn.setForeground(new Color(255, 255, 255));
        aboutBtn.setText("About the game");
        aboutBtn.setPreferredSize(new Dimension(175, 70));
        aboutBtn.addActionListener(ah);
        this.add(aboutBtn);

        exitBtn.setBackground(new Color(102, 102, 102));
        exitBtn.setFont(new Font("MS UI Gothic", 1, 18)); 
        exitBtn.setForeground(new Color(255, 255, 255));
        exitBtn.setText("Exit");
        exitBtn.setPreferredSize(new Dimension(175, 70));
        exitBtn.addActionListener(ah);

        this.add(exitBtn);
    }
        

   
       
    private class ActionHandler implements ActionListener{
        
   
    
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == loginBtn) {
             parent.launchUserLogin();
             
             
        }
         else if (e.getSource() == aboutBtn) {
             
         }
         else if (e.getSource() == exitBtn) {
             System.exit(0);
         }
    }
    
}
}
