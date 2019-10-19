import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * @author David Davidov
 * This class is a Menu Handler for the Edit section 
 * which has one item - Insert which allows the user 
 * a new date
 */
public class EditMenuHandler implements ActionListener {
    SortedDate212List sorted = new SortedDate212List();
    UnsortedDate212List unsorted = new UnsortedDate212List();
    JFrame jframe;

    public EditMenuHandler (JFrame jf, SortedDate212List s, UnsortedDate212List u) {
        jframe = jf;
        sorted = s;
        unsorted = u;
   }
   /**
    * @param event An Action event that is being performed on
    * The action Insert is called here
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      String newDate; 
        if (menuName.equals("Insert")){
            newDate = JOptionPane.showInputDialog(null, "Enter a new date to be inserted");
            //System.out.println(newDate);
            Date212 dateInserted = new Date212(newDate);
            if(dateInserted.dateInIntForm() != 0){
                unsorted.add(dateInserted);
                sorted.add(dateInserted);
                DateGUI newGUI = new DateGUI(sorted, unsorted);
            }
        }
     }
} 