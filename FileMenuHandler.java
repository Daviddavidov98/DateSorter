import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * @author David Davidov
 * This class is a Menu Handler for the File section 
 * which has two items, Open - opens a new file in directory
 * and Quit - Quits program
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   /**
    * @param event An Action event that is being performed on
    * The actions of Open and Quit are called here
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      
        if (menuName.equals("Open"))
            openFile();
      
        else if (menuName.equals("Quit"))
            System.exit(0);
            
     } 
     /**
      * This is a method to open a new file/ create a new GUI with 
      * new data from file
      */
     public void openFile(){
         int status;
         JFileChooser chooser = new JFileChooser();
         status = chooser.showOpenDialog(null);
         String filename = chooser.getSelectedFile().getName();
         System.out.println(filename);
         DateGUI newGUI = new DateGUI(filename);  
   }
   
}
