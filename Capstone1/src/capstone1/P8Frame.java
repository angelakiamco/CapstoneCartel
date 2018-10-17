/** Project 08 - Frame Code
 * November 28, 2016
 * @author Aaron Spero
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.InetAddress;

public class P8Frame extends JFrame {
    
    private P8Panel interfacePanel; 
    private JButton previousButton;
    private JButton nextButton;
    private JButton exitButton;
    private JButton updateButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton newButton;
    private JMenuItem openItem;
    private JMenuItem closeItem;
    private DBDialog dialogBox;
    private ResultSet rset;
    private Connection conn;
    private Statement stmt;
    private boolean exists;
    
    
    public P8Frame() {
        
        interfacePanel = new P8Panel(this);
        add(interfacePanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        ActionHandler ah = new ActionHandler();
        exists = true;
        
        previousButton = new JButton("<-");
        previousButton.setEnabled(false);
        buttonPanel.add(previousButton);
        previousButton.addActionListener(ah);
        
        nextButton = new JButton("->");
        nextButton.setEnabled(false);
        buttonPanel.add(nextButton);
        nextButton.addActionListener(ah);
        
        updateButton = new JButton("Update");
        updateButton.setEnabled(false);
        buttonPanel.add(updateButton);
        updateButton.addActionListener(ah);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(ah);
        
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        buttonPanel.add(deleteButton);
        deleteButton.addActionListener(ah);
        
        newButton = new JButton("New");
        newButton.setEnabled(false);
        buttonPanel.add(newButton);
        newButton.addActionListener(ah);
        
        exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);
        exitButton.addActionListener(ah);
        
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        
        JMenu database = new JMenu("Database");
        jmb.add(database);
        database.setMnemonic('D');
        
        openItem = new JMenuItem("Open");
        database.add(openItem);
        openItem.setMnemonic('O');
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
                KeyEvent.CTRL_MASK));
        openItem.addActionListener(ah);
        
        closeItem = new JMenuItem("Close");
        database.add(closeItem);
        closeItem.setMnemonic('C');
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 
                KeyEvent.CTRL_MASK));
        closeItem.setEnabled(false);
        closeItem.addActionListener(ah);
        
        setTitle("Project 8");
        setSize(525,300);
        setLocation(250,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void updateNotification() {
        previousButton.setEnabled(false);
        nextButton.setEnabled(false);
        deleteButton.setEnabled(false);
        newButton.setEnabled(false);
        exitButton.setEnabled(false);
        updateButton.setEnabled(true);
        cancelButton.setEnabled(true);
    }
    
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == previousButton) {
                try {
                    rset.previous();
                    String[] entry = new String[8];
                    entry[0] = rset.getString("lastName");
                    entry[1] = rset.getString("firstName");
                    entry[2] = rset.getString("major");
                    entry[3] = rset.getString("degree");
                    entry[4] = rset.getString("year");
                    entry[5] = rset.getString("onFinAid");
                    entry[6] = rset.getString("fullTime");
                    entry[7] = rset.getString("outOfSt");
                    
                    interfacePanel.setUIData(entry);
                    
                    if(rset.isFirst()) {
                        previousButton.setEnabled(false);
                    }
                    else {
                        previousButton.setEnabled(true);
                    }
                    
                    updateButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                    nextButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    newButton.setEnabled(true);
                    exitButton.setEnabled(true);
                    
                } catch(SQLException sqle) {
                    System.out.println(sqle);
                }
            }
            else if(e.getSource() == nextButton) {
                try { 
                    rset.next();
                    String[] entry = new String[8];
                    entry[0] = rset.getString("lastName");
                    entry[1] = rset.getString("firstName");
                    entry[2] = rset.getString("major");
                    entry[3] = rset.getString("degree");
                    entry[4] = rset.getString("year");
                    entry[5] = rset.getString("onFinAid");
                    entry[6] = rset.getString("fullTime");
                    entry[7] = rset.getString("outOfSt");
                    
                    interfacePanel.setUIData(entry);
                    
                    if(rset.isLast()) {
                        nextButton.setEnabled(false);
                    }
                    else {
			nextButton.setEnabled(true);
                    }

                    updateButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                    previousButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    newButton.setEnabled(true);
                    exitButton.setEnabled(true);
                } catch (SQLException sqle) {
                    System.out.println(sqle);
                }
            }
            else if(e.getSource() == exitButton) {
                if(closeItem.isEnabled())
                {
                    try {
                        rset.close();
                        stmt.close();
                        conn.close();
                    } catch(SQLException sqle) {}                   
                }
                System.exit(0);
            }
            else if(e.getSource() == openItem) {
                dialogBox = new DBDialog(P8Frame.this);
                dialogBox.setVisible(true);
                if(dialogBox.getOK()) {
                    try {
                        Class.forName("org.gjt.mm.mysql.Driver");
                        String dbconn = "jdbc:mysql://" + dialogBox.getHostName() + ":3306" +
                                "/" + dialogBox.getDBName();
                        conn = DriverManager.getConnection(dbconn,
                                dialogBox.getUsername(),dialogBox.getPassword());
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
      			String query1 = "select * from " + dialogBox.getTableName();
      			rset = stmt.executeQuery(query1);

			rset.next();

			String[] entry = new String[8];
			entry[0] = rset.getString("lastName");
       			entry[1] = rset.getString("firstName");
  			entry[2] = rset.getString("major");
                        entry[3] = rset.getString("degree");
                        entry[4] = rset.getString("year");
                        entry[5] = rset.getString("onFinAid");
                        entry[6] = rset.getString("fullTime");
  			entry[7] = rset.getString("outOfSt");
					  
			interfacePanel.setUIData(entry);
                        
                        openItem.setEnabled(false);
                        closeItem.setEnabled(true);
                        deleteButton.setEnabled(true);
                        newButton.setEnabled(true);
			updateButton.setEnabled(false);
			cancelButton.setEnabled(false);
			exitButton.setEnabled(true);
                        
			if(!rset.isLast()) {
                            nextButton.setEnabled(true);
			}  
                    } catch(ClassNotFoundException cnfe) {
             	         System.out.println(cnfe);
              	    } catch(SQLException sqle) {
              	        System.out.println(sqle);
              	    } 
		}
            }
            else if(e.getSource() == closeItem) {
                try {
                    rset.close();
                    stmt.close();
                    conn.close();
                } catch(SQLException sqle) { 
                }
		interfacePanel.clearUI();
                previousButton.setEnabled(false);
                nextButton.setEnabled(false);
                openItem.setEnabled(true);
                closeItem.setEnabled(false);
                deleteButton.setEnabled(false);
                newButton.setEnabled(false);
                exitButton.setEnabled(true);
		updateButton.setEnabled(false);
		cancelButton.setEnabled(false);
            }
            else if(e.getSource() == updateButton) {

				int outcome = interfacePanel.validateUI();
                
                if(outcome == P8Panel.UI_INVALID_NO_FIRST_NAME) {
                    JOptionPane.showMessageDialog(P8Frame.this, "You must " + 
                            "provide a first name.", "First Name Required", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(outcome == P8Panel.UI_INVALID_NO_LAST_NAME) {
                    JOptionPane.showMessageDialog(P8Frame.this, "You must " + 
                            "provide a last name.", "Last Name Required", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(outcome == P8Panel.UI_INVALID_NO_MAJOR_SELECTED) {
                    JOptionPane.showMessageDialog(P8Frame.this, "You must " + 
                            "select a major.", "Major Selection Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(outcome == P8Panel.UI_INVALID_NO_DEGREE_SELECTED) {
                    JOptionPane.showMessageDialog(P8Frame.this, "You must " + 
                            "select a degree plan.", "Degree Selection Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(outcome == P8Panel.UI_INVALID_NO_YEAR_SELECTED) {
                    JOptionPane.showMessageDialog(P8Frame.this, "You must " + 
                            "select a year.", "Year Selection Error", 
                            JOptionPane.ERROR_MESSAGE);
                } 
				else {
            	    try{

            	        String[] s = interfacePanel.getData();
            	        rset.updateString(2, s[0]);
            	        rset.updateString(3, s[1]);
            	        rset.updateString(4, s[2]);
            	        rset.updateString(5, s[3]);
            	        rset.updateString(6, s[4]);
            	        rset.updateString(7, s[5]);
            	        rset.updateString(8, s[6]);
            	        rset.updateString(9, s[7]);
                    
            	        if(exists) {
            	            rset.updateRow();
            	        }
            	        else {
            	            rset.insertRow();
            	            exists = true;
				rset.moveToCurrentRow();

				String[] entry = new String[8];
                    		entry[0] = rset.getString("lastName");
                    		entry[1] = rset.getString("firstName");
                    		entry[2] = rset.getString("major");
                    		entry[3] = rset.getString("degree");
                    		entry[4] = rset.getString("year");
                    		entry[5] = rset.getString("onFinAid");
                    		entry[6] = rset.getString("fullTime");
                    		entry[7] = rset.getString("outOfSt");
					  
                    		interfacePanel.setUIData(entry);

                	    }                    
                    
                	    updateButton.setEnabled(false);
                	    cancelButton.setEnabled(false);
                	    deleteButton.setEnabled(true);
                	    newButton.setEnabled(true);
                	    exitButton.setEnabled(true);
                	    if(!rset.isFirst()) {
                	        previousButton.setEnabled(true);
                	    }
                	    else {
				previousButton.setEnabled(false);
                	    }
                	    if(!rset.isLast()) {
                	        nextButton.setEnabled(true);
                	    }
                	    else {
				nextButton.setEnabled(false);
            	        }
            	        
            	    } catch(SQLException sqle) { }
            	}
			}
            else if(e.getSource() == cancelButton) {
                try{
                    if(!exists) {
                        rset.moveToCurrentRow();
                        exists = true;
                    }
                        
                    String[] entry = new String[8];
                    entry[0] = rset.getString("lastName");
                    entry[1] = rset.getString("firstName");
                    entry[2] = rset.getString("major");
                    entry[3] = rset.getString("degree");
                    entry[4] = rset.getString("year");
                    entry[5] = rset.getString("onFinAid");
                    entry[6] = rset.getString("fullTime");
                    entry[7] = rset.getString("outOfSt");
					  
                    interfacePanel.setUIData(entry);
                    
                    updateButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                    deleteButton.setEnabled(true);
                    newButton.setEnabled(true);
                    exitButton.setEnabled(true);
                    
                    if(!rset.isFirst()) {
                        previousButton.setEnabled(true);
                    }
                    if(!rset.isLast()) {
                        nextButton.setEnabled(true);
                    }
                    
                } catch(SQLException sqle) { }
            }
            else if(e.getSource() == deleteButton) {
                try{
                    if(!rset.isLast()) {
                        rset.deleteRow();
                        rset.next();
                        rset.previous();
                    }
                    else {
                        rset.deleteRow();
                        rset.previous();
                    }
                    
                    String[] entry = new String[8];
                    entry[0] = rset.getString("lastName");
                    entry[1] = rset.getString("firstName");
                    entry[2] = rset.getString("major");
                    entry[3] = rset.getString("degree");
                    entry[4] = rset.getString("year");
                    entry[5] = rset.getString("onFinAid");
                    entry[6] = rset.getString("fullTime");
                    entry[7] = rset.getString("outOfSt");
					  
                    interfacePanel.setUIData(entry);

                    if(!rset.isFirst()) {
			previousButton.setEnabled(true);
                    }
                    else {
			previousButton.setEnabled(false);
                    }
                    if(!rset.isLast()) {
			nextButton.setEnabled(true);
                    }
                    else {
			nextButton.setEnabled(false);
                    }
                    updateButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                    deleteButton.setEnabled(true);
                    newButton.setEnabled(true);
                    exitButton.setEnabled(true);
                } catch(SQLException sqle) { }
                
            }
            else if(e.getSource() == newButton) {
                try{
                    rset.moveToInsertRow();
                    interfacePanel.clearUI();
                    exists = false;
                    updateButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                    previousButton.setEnabled(false);
                    nextButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    newButton.setEnabled(false);
                    exitButton.setEnabled(false);
                } catch(SQLException sqle) { }
            }
        }
    }
    
    public static void main(String[] args) {
        new P8Frame();
    }
}
