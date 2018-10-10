/** Project 08 - Panel Code
 * November 28, 2016
 * @author Aaron Spero
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P8Panel extends JPanel {
    
    public static final int UI_VALID = 0;
    public static final int UI_INVALID_NO_FIRST_NAME = 1;
    public static final int UI_INVALID_NO_LAST_NAME = 2;
    public static final int UI_INVALID_NO_MAJOR_SELECTED = 3;
    public static final int UI_INVALID_NO_DEGREE_SELECTED = 4;
    public static final int UI_INVALID_NO_YEAR_SELECTED = 5;
    
    private JTextField fNameTF;
    private JTextField lNameTF;
    private JComboBox majorCB;
    private JComboBox yearCB;
    private JRadioButton aaRB;
    private JRadioButton baRB;
    private JRadioButton bsRB;
    private JRadioButton dummyRB;
    private JCheckBox fAidCHK;
    private JCheckBox fTimeCHK;
    private JCheckBox outOfStateCHK;
    private P8Frame parent;
    
    
    public P8Panel(P8Frame parent) {
        this.parent = parent;
        this.setLayout(new GridLayout(5,1));
        
        JPanel fNamePanel = new JPanel();
        JPanel lNamePanel = new JPanel();
        JPanel majorPanel = new JPanel();
        JPanel degreePanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        
        this.add(fNamePanel);
        this.add(lNamePanel);
        this.add(majorPanel);
        this.add(degreePanel);
        this.add(optionsPanel);
        
        ActionHandler ah = new ActionHandler();
        KeyHandler kh = new KeyHandler();
        ItemHandler ih = new ItemHandler();
        
        JLabel fNameLabel = new JLabel("First Name:");
        fNameTF = new JTextField(20);
        fNamePanel.add(fNameLabel);
        fNamePanel.add(fNameTF);
        fNameTF.addKeyListener(kh);
        
        JLabel lNameLabel = new JLabel("Last Name:");
        lNameTF = new JTextField(20);
        lNamePanel.add(lNameLabel);
        lNamePanel.add(lNameTF);
        lNameTF.addKeyListener(kh);
        
        JLabel majorLabel = new JLabel("Major Dept:");
        majorCB = new JComboBox();
        String[] majors = {"(Select one)","Art","Biology","Business","Chemistry",
            "CIS","Economics","History","Kinesiology","Mathematics",
            "Political Science"};
        
        for(int i = 0; i < majors.length; i++) {
            majorCB.addItem(majors[i]);
        }
        
        majorPanel.add(majorLabel);
        majorPanel.add(majorCB);
        majorCB.addItemListener(ih);
        
        JLabel degreeLabel = new JLabel("Degree:");
        aaRB = new JRadioButton("AA");
        baRB = new JRadioButton("BA");
        bsRB = new JRadioButton("BS");
        dummyRB = new JRadioButton();
        JLabel yearLabel = new JLabel("  Year:");
        yearCB = new JComboBox();
        
        ButtonGroup degreeTypeBG = new ButtonGroup();
        degreeTypeBG.add(aaRB);
        degreeTypeBG.add(baRB);
        degreeTypeBG.add(bsRB);
        degreeTypeBG.add(dummyRB);
        dummyRB.setSelected(true);
        
        yearCB.addItem("(Select One)");
        for(int i = 2003;i<2013;i++) {
            yearCB.addItem("" + i);
        }
        
        degreePanel.add(degreeLabel);
        degreePanel.add(aaRB);
        degreePanel.add(baRB);
        degreePanel.add(bsRB);
        degreePanel.add(yearLabel);
        degreePanel.add(yearCB);
        
        aaRB.addActionListener(ah);
        baRB.addActionListener(ah);
        bsRB.addActionListener(ah);
        yearCB.addItemListener(ih);
                
        fAidCHK = new JCheckBox("On Financial Aid");
        fTimeCHK = new JCheckBox("Full Time");
        outOfStateCHK = new JCheckBox("Out of State");

        optionsPanel.add(fAidCHK);
        optionsPanel.add(fTimeCHK);
        optionsPanel.add(outOfStateCHK);
        
        fAidCHK.addActionListener(ah);
        fTimeCHK.addActionListener(ah);
        outOfStateCHK.addActionListener(ah);
    }
    
    public int validateUI() {
        if(fNameTF.getText().trim().equals("")) {
            fNameTF.requestFocus();
            return UI_INVALID_NO_FIRST_NAME;
        }
        else if(lNameTF.getText().trim().equals("")) {
            lNameTF.requestFocus();
            return UI_INVALID_NO_LAST_NAME;
        }
        else if(majorCB.getSelectedIndex() == 0) {
            majorCB.requestFocus();
            return UI_INVALID_NO_MAJOR_SELECTED;
        }
        else if(dummyRB.isSelected()) {
            aaRB.requestFocus();
            return UI_INVALID_NO_DEGREE_SELECTED;
        }
        else if(yearCB.getSelectedIndex() == 0) {
            yearCB.requestFocus();
            return UI_INVALID_NO_YEAR_SELECTED;
        }
        else {
            return UI_VALID;
        }
    }
    
    public void clearUI() {
        fNameTF.setText("");
        lNameTF.setText("");
        majorCB.setSelectedIndex(0);
        dummyRB.setSelected(true);
        yearCB.setSelectedIndex(0);
        fAidCHK.setSelected(false);
        fTimeCHK.setSelected(false);
        outOfStateCHK.setSelected(false);
    }
    
    public void setUIData(String[] s) {
	clearUI();
        lNameTF.setText(s[0]);
        fNameTF.setText(s[1]);
        for(int i = 0; i < majorCB.getItemCount(); i++) {
            if((majorCB.getItemAt(i).toString()).equals(s[2])) {
                majorCB.setSelectedIndex(i);
            }
        }
        
        if(s[3].equals("AA")) {
            aaRB.setSelected(true);
        }
        else if(s[3].equals("BA")) {
            baRB.setSelected(true);
        }
        else if(s[3].equals("BS")) {
            bsRB.setSelected(true);
        }

	for(int i = 0; i < yearCB.getItemCount(); i++) {
          if((yearCB.getItemAt(i).toString()).equals(s[4])) {
              yearCB.setSelectedIndex(i);
          }
		}


        if(s[5].equals("T")) {
            fAidCHK.setSelected(true);
        }
        if(s[6].equals("T")) {
            fTimeCHK.setSelected(true);
        }
        if(s[7].equals("T")) {
            outOfStateCHK.setSelected(true);
        }
    }
    
    public String[] getData() {
        String[] s = new String[8];
        s[0] = lNameTF.getText();
        s[1] = fNameTF.getText();
        s[2] = majorCB.getSelectedItem().toString();
        if(aaRB.isSelected()) {
            s[3] = "AA";
        }
        else if(baRB.isSelected()) {
            s[3] = "BA";
        }
        else if(bsRB.isSelected()) {
            s[3] = "BS";
        }

	s[4] = yearCB.getSelectedItem().toString();


        if(fAidCHK.isSelected()) {
            s[5] = "T";
        }
        else {
            s[5] = "F";
        }
        if(fTimeCHK.isSelected()) {
            s[6] = "T";
        }
        else {
            s[6] = "F";
        }
        if(outOfStateCHK.isSelected()) {
            s[7] = "T";
        }
        else {
            s[7] = "F";
        }
        return s;
    }
    
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            parent.updateNotification();
        }
    }
    
    private class KeyHandler extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            parent.updateNotification();
        }
    }
    
    private class ItemHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            parent.updateNotification();
        }
    }
}

