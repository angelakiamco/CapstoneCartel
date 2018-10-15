/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Aaron Spero
 */
public class UserLogin1 extends JPanel {
    
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;
    JButton registerBtn;
    JButton backBtn;
    JLabel userLabel;
    JLabel passLabel;
    JLabel newUserLabel;
    MainFrame parent;
    
    public UserLogin1(MainFrame parent) {
        
        this.parent = parent;
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        setOpaque(false);
        
        userField = new JTextField();
        passField = new JPasswordField();
        loginBtn = new JButton("Log In");
        registerBtn = new JButton("Register");
        backBtn = new JButton("Back To Title Screen");
        userLabel = new JLabel("Username");
        passLabel = new JLabel("Password");
        newUserLabel = new JLabel("NEW USER? ");
        
        loginBtn.setBackground(new Color(102, 102, 102));
        loginBtn.setFont(new Font("MS PGothic", 1, 18)); 
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBorder(null);
        loginBtn.setBorderPainted(false);
        loginBtn.setPreferredSize(new Dimension(175, 70));
        
        registerBtn.setBorder(null);
        registerBtn.setBorderPainted(false);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(newUserLabel);
        add(registerBtn);
        
        setVisible(true);
    }
    
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginBtn) {
               
        }
         else if (e.getSource() == registerBtn) {
             
         }
        }
    }
}
