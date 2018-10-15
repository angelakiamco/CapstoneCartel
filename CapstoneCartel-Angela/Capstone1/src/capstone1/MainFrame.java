/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone1;

/**
 *
 * @author Aaron Spero
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

public class MainFrame extends JFrame {
    
    private JLabel mafiaCig;
    private JLabel cartelLabel;
    TitlePage1 mainPanel;
    UserLogin3 loginScreen;
    RegisterFrame regFrame;
    
    
    public MainFrame() {
        
        mainPanel = new TitlePage1(this);
      
        mafiaCig = new JLabel();
        cartelLabel = new JLabel();
        
        getContentPane().setLayout(new AbsoluteLayout());
        
        getContentPane().add(mainPanel, new AbsoluteConstraints(800, 30, 150, 600));
        
        cartelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/The Cartel.png")));        
        getContentPane().add(cartelLabel, new AbsoluteConstraints(450, 430, 590, 140));
        
        mafiaCig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mafiacig.jpg"))); 

        mafiaCig.setMinimumSize(new java.awt.Dimension(1060, 400));
        mafiaCig.setPreferredSize(new java.awt.Dimension(1060, 400));
        getContentPane().add(mafiaCig, new AbsoluteConstraints(0, 0, 1060, 570));
        
        
        setTitle("The Cartel");
        setSize(1068,600);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

    public void launchUserLogin() {
//        getContentPane().remove(mainPanel);
        loginScreen = new UserLogin3(this);
        loginScreen.setVisible(true);
        setVisible(false);
        
    }
    public void launchRegisterFrame(){
        regFrame = new RegisterFrame(this);
        regFrame.setVisible(true);
        loginScreen.setVisible(false);
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new MainFrame();
    }
    
}
