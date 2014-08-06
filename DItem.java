import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;


public class DItem extends JButton implements ActionListener {

    private JLabel label;
    Negotiation negotiation;
    String[] dinfo;
    Dialogue d;
    JButton view;
    JButton join;

    public DItem(String[] vars, Negotiation comp) {
        add (label = new JLabel(vars[1]));
        negotiation = comp;
        dinfo = vars;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println();
        try {
            negotiation.addDialogue((d = new Dialogue(dinfo, negotiation)));
        }
        catch (Exception o) {
            System.out.println("There's an exception dude");
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
}















