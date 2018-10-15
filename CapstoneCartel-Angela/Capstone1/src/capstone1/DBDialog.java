import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;

public class DBDialog extends JDialog {
  private JTextField hostName;
  private JTextField dbName;
  private JTextField tableName;
  private JTextField username;
  private JPasswordField password;
  private JButton okButton;
  private JButton cancelButton;
  private boolean ok;
  
  public DBDialog(JFrame parent)
  {
    super(parent,"Database Information",true);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(5,2));
    hostName = new JTextField("198.252.11.102",30);
    dbName = new JTextField("cm335u04",20);
    tableName = new JTextField("student",20);
    username = new JTextField("cm335u04",20);
    password = new JPasswordField("kansas",20);
    mainPanel.add(new JLabel("Host Name/IP:"));
    mainPanel.add(hostName);
    mainPanel.add(new JLabel("Database Name:"));
    mainPanel.add(dbName);
    mainPanel.add(new JLabel("Table Name:"));
    mainPanel.add(tableName);
    mainPanel.add(new JLabel("Username:"));
    mainPanel.add(username);
    mainPanel.add(new JLabel("Password:"));
    mainPanel.add(password);
    add(mainPanel,BorderLayout.CENTER);
    
    JPanel buttonPanel = new JPanel();
    okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() 
      {
        public void actionPerformed(ActionEvent e) 
        {
          ok = true;
          setVisible(false);
        }
      }
    );
    buttonPanel.add(okButton);
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() 
      {
        public void actionPerformed(ActionEvent e) 
        {
          ok = false;
          setVisible(false);
        }
      }
    );
    buttonPanel.add(cancelButton);   
    add(buttonPanel,BorderLayout.SOUTH);
    setSize(300,200);
  } 
  
  public String getHostName()
  {
    return hostName.getText();
  }

  public String getDBName()
  {
    return dbName.getText();
  }

  public String getTableName()
  {
    return tableName.getText();
  }

  public String getUsername()
  {
    return username.getText();
  }
  
  public String getPassword()
  {
    return new String(password.getPassword());
  }

  public boolean getOK()
  {
    return ok;
  }
} 
