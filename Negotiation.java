import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// The negotiation class is the main class of this app. This is where info is cached, and controls what pages are brought up, and with what information.

public class Negotiation extends JFrame implements ActionListener
{
    private boolean loggedIn;
    private String userName = "Ringz";
    private String theme;
    private String[] interests;
    //private Page page // depending on how we set up the pages
    
    public static void main(String[] args) throws IOException {
        new Negotiation().append("counter.txt", "hey there");
        
        
    }


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

    
public void addEntry(String title) throws FileNotFoundException, IOException{
    //increment counter
    int count = incrementCounter();
    //add a new entry to the dialogues file
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("dialogues.txt", true));
        bw.newLine();
        bw.write(count+":"+title+":"+userName+"!"+count+":"+"comments"+count);
        bw.flush();
        bw.close();
    } catch (IOException o) {
         System.out.println("IOException");
    }
    //create file
    createFile("comments"+count);

    
}
    
    
    public void createFile(String filename) throws IOException {
        //done
        //creates a file with filename in this folder
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.close();
        
    }
    

    public void append(String filename, String text) {
        //done
        
        try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
        bw.newLine();
        bw.write(text);
        bw.flush();
        bw.close();
        
        } catch (IOException o) {
            System.out.println("IOException");
            
        }
        
        
        
        
    }
    
    public int incrementCounter() throws FileNotFoundException, IOException {
        //done
        
        //read the count number
        Scanner read = new Scanner(new File("counter.txt"));
        int count = Integer.parseInt(read.nextLine());
        
        //increment the count number
        File superinfo = new File("counter.txt");
        FileWriter write = new FileWriter(superinfo);
        PrintWriter printwriter = new PrintWriter(write);
        printwriter.print(count+1);
        printwriter.close();
        
        return count;
    }
    
    
    public String read(String filename) {
        //done
    Scanner read = new Scanner(new File(filename));
        String text = "";
        while (read.hasNextLine) {
            text += read.nextLine();
        }
        
        return text;
        
        
    }
    
    
    
    
    public void updateEntry(String id) throws FileNotFoundException {
        //done
        //iterate through dialogues file, find that id
        //get the line in a string
        //split the string around that particular colon
        //and insert current username + id
        Scanner read = new Scanner(new File("dialogues.txt"));
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] split = line.split(":");
            if (split[0].equals(id)) {
                String fin = "";
                for (int i = 0; i < 3; i++) {
                    fin += split[i]+":";
                }
                fin += userName+"!"+id+":";
                fin += split[3];
               System.out.println(fin);
            }
        }
        
            
    }
   
        
        
        


}