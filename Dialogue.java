import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Dialogue extends JPanel implements ActionListener
{
// the main class creates dialogue objects
    // each dialogue object displays information it was passed
        // (dialogue name, A, B, mode, comments)
        // the Dname is the title of the dialogue
        // A and B are the filenames of the users' messages
        // and mode shows if it's user A or user B, or a commenter
    
// Dialogue object is a panel, filled with 2 adjacent panels
            // A textfield, and I guess another panel underneith for comments.

    private String mode = "C";
    private String title = "";
    private String afile = "none";
    private String bfile = "none";
    private String cfile = "none";
    private Negotiation negotiation = null;
    private int id = 0;
    private String userA = "";
    private String userB = "";
    
    private JPanel a;
    private JPanel b;
    private JPanel c;
    
    private JTextArea atext;
    private JTextArea btext;
    private JTextArea comments;
    private JTextArea textenter;
    
    
    public Dialogue ()
    {
        this.setPreferredSize(new Dimension(1000,1000));
        a = new JPanel();
        b = new JPanel();
        c = new JPanel();
        this.add(a);
        this.add(b);
        this.add(c);
        
        
        comments = new JTextArea("comments");
        comments.setEnabled(false);
        
        atext = new JTextArea(20,20);
        atext.setEnabled(false);
        a.add(atext);
        
        btext = new JTextArea(20,20);
        btext.setEnabled(false);
        b.add(btext);
        
        a.add(atext);
        b.add(btext);
        c.add(comments);
        
        textenter = new JTextArea(5,5);
        textenter.setText("Type Here");
        textenter.setEnabled(true);
        this.add(textenter);
        
        JTextArea enter_a = new JTextArea("Person A");
        enter_a.setEnabled(false);
        a.add(enter_a);
        
        JTextArea enter_b = new JTextArea("Person B");
        enter_b.setEnabled(false);
        b.add(enter_b);
        
        
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        enter.setPreferredSize(new Dimension(2,2));
        this.add(enter);

    }
    
    public Dialogue (String[] dinfo, Negotiation n)
    {
        //String ID, String dname, String afile, String bfile, String cfile
        this();
        id = Integer.parseInt(dinfo[0]);
        title = dinfo[1];
        afile = dinfo[2];
        userA = parseName(afile);
        
        if (dinfo.length == 4){
        bfile = dinfo[3];
        userB = parseName(bfile);
            
        cfile = dinfo[4];
        }
        
        else
            cfile = dinfo[3];
        
        negotiation = n;
        
        
        if (negotiation.getUserName().toLowerCase().equals(userA.toLowerCase()))
            mode = "A";
        else if (negotiation.getUserName().toLowerCase().equals(userB.toLowerCase()))
            mode = "B";
        else
            mode = "C";
        
    }
    
    private String parseName(String namefile){
        int exclaim = namefile.indexOf('!');
        String name = namefile.substring(0,exclaim);
        return name;
        
    }

    
    
    public static void main(String[] args){
        
        
        Dialogue dialogue = new Dialogue();
        dialogue.setNegotiation();
        dialogue.setPreferredSize(new Dimension(1000,1000));
        dialogue.setLayout(new GridLayout(2,2));
        JFrame test = new JFrame("Testing Dialogue Panels");
        test.getContentPane().add(dialogue);
        
        
        test.pack();
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        add();
        
    }
    
    private void add(){
        if (mode.equals("A"))
            addA();
        else if (mode.equals("B"))
            addB();
        else
            addC();
    }
    
    private void addA(){
        atext.setText(atext.getText() + "\n\n" + textenter.getText());
        
    }
    
    private void addB(){
        btext.setText(btext.getText() + "\n\n" + textenter.getText());
        
    }
    
    private void addC(){
        comments.setText(comments.getText() + "\n\n" + negotiation.getUserName() +
                          ":\n" + textenter.getText());
        
    }
    
    
    
    public void setNegotiation()
    {
        negotiation = new Negotiation();
    }
    
    

    
    
    

}