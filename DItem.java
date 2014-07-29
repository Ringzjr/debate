import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class DItem extends JButton {

    private JLabel label;
    Component negotiation;

    public DItem(String[] vars, Component comp) {
        add (label = new JLabel(vars[1]));
        negotiation = comp;
        
        
    }















}