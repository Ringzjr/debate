import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;


public class Popup extends JPanel implements ActionListener {

    public Popup(String type) {
        //either create title, login, or signup
        if (type.equals("title")) {
            JLabel label1 = new JLabel("Enter Title:");
            this.add(label1);
            JTextField input1 = new JTextField(16);
            this.add(input1);
            String text = input1.getText();
            text.addActionListener
            System.out.println(text);
        }
        else if (type.equals("login")) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel label2 = new JLabel("Enter Username:");
            this.add(label2);
            JTextField input2 = new JTextField(8);
            this.add(input2);
            JLabel label3 = new JLabel("Enter Password:");
            this.add(label3);
            JTextField input3 = new JTextField(8);
            this.add(input3);
            
            
        }
        
    }






}