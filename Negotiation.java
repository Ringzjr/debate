import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The negotiation class is the main class of this app. This is where info is cached, and controls what pages are brought up, and with what information.

public class Negotiation extends JFrame implements ActionListener
{
    private boolean loggedIn;
    private String userName = "Anonymous";
    private String theme;
    private String[] interests;
    //private Page page // depending on how we set up the pages
    



public Negotiation ()
    {
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        
    }




public String getUserName(){
return userName;
}

public void setUserName(String name){
userName = name;
}


}