import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;



public class Main extends JPanel {

    
    Component negotiation;
    Scanner scanner;
    JButton createButton;
    File dialogues;
    File superinfo;

    public Main(Component comp) throws FileNotFoundException {
        
        negotiation = comp;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
       // setLayout(null);
        setBorder(new EmptyBorder(100,100,100,100));
        add (createButton = new JButton("Create Dialogue"));
        dialogues = new File("dialogues.txt");
        scanner = new Scanner(dialogues);
        
        //loop that goes through each line in dialogues and creates a new dItem with each piece of info
        //goes through each line in the file:
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            //loop that goes through string input and seperates the dialogue id, the title, and A and B
            String[] vars = input.split(":");
            add(new DItem(vars, negotiation));
            
            
            
        }
        
    }
    
    
    
    public void actionPerformed (ActionEvent e) throws FileNotFoundException, IOException {
        
        if (e.getSource().equals(createButton)) {
       
            //read the count number
            Scanner read = new Scanner(new File("counter.txt"));
            int count = Integer.parseInt(read.nextLine());
            
            //increment the count number
            superinfo = new File("counter.txt");
            FileWriter write = new FileWriter(superinfo);
            PrintWriter printwriter = new PrintWriter(write);
            printwriter.print(count++);
            printwriter.close();
            
            //add a new entry to the dialogues file
            try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dialogues.txt", true));
            bw.newLine();
           // bw.write(count+"");
            bw.newLine();
            bw.flush();
            bw.close();
            } catch (IOException o) {
                
            }
            
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    

}

//to pass to dialogue object: dialogue title, filenames of responses (make sure name is username + dialogue id), filename of comments, and the mode (resume, view, or join)