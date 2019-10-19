import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * @author David Davidov
 * This class displays two Date212 linked lists on a 
 * Gridlayout JFrame
 */
public class DateGUI extends JFrame{
    /**
     * @param unsorted The Date212 linked list read straight from the file being dislpayed on the left side of GUI
     * @param temp The sorted Date212 linked list from the file being displayed on the right side of the GUI
     */
    DateGUI(SortedDate212List temp, UnsortedDate212List unsorted){
        SortedDate212List sorted = new SortedDate212List();
        sorted = temp.sort();
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Dates Read From File");
        myFrame.setSize(700, 500);
        myFrame.setLayout(new GridLayout(1, 2));
        myFrame.setLocation(100, 100);

        JMenuBar menuBar  = new JMenuBar(); 
        

        printDatesToGUI(myFrame, unsorted, sorted);
        createFileMenu(menuBar, myFrame);
        createEditMenu(menuBar, myFrame, sorted, unsorted);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
    /**
     * @param filename The name of the file that is being displayed on the GUI
     */
    DateGUI(String filename){
        SortedDate212List temp = new SortedDate212List();
        SortedDate212List sorted = new SortedDate212List();
        UnsortedDate212List unsorted = new UnsortedDate212List();
        
        fillArray(filename, temp, unsorted);
        sorted = temp.sort();
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Dates Read From File");
        myFrame.setSize(700, 500);
        myFrame.setLayout(new GridLayout(1, 2));
        myFrame.setLocation(100, 100);

        JMenuBar menuBar  = new JMenuBar(); 
        

        printDatesToGUI(myFrame, unsorted, sorted);
        createFileMenu(menuBar, myFrame);
        createEditMenu(menuBar, myFrame, sorted, unsorted);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
    /**
     * @param frame The Gridlayout JFrame
     * @param orig The original Date212 list read from the file
     * @param sorted The sorted Date212 list
     * This method prints the dates on the GUI created 
     */
    private static void printDatesToGUI(JFrame frame, UnsortedDate212List orig, SortedDate212List sorted){
        Container myContentPane = frame.getContentPane();
        TextArea originalDates = new TextArea();
        TextArea sortedDates = new TextArea();
        for(int i = 0; i < orig.length; i++){
            originalDates.append(orig.at(i).data.toString()+"\n");
        }
        for(int i = 0; i < sorted.length; i++){
            sortedDates.append(sorted.at(i).data.toString()+"\n");
        }
        originalDates.setEditable(false); //we dont want to edit the GUI
        sortedDates.setEditable(false);
        myContentPane.add(originalDates); // Adding textfields to Contentpane
        myContentPane.add(sortedDates);

    }
    /**
     * @param menuBar The menubar being constructed
     * @param frame The Frame the menu bar is being added to
     * This method creates a File menu on the MenuBar on the GUI
     */
    private void createFileMenu(JMenuBar menuBar, JFrame frame) {
        JMenuItem   item;
        JMenu       fileMenu = new JMenu("File");
        FileMenuHandler fmh  = new FileMenuHandler(frame);
  
        item = new JMenuItem("Open");    //Open...
        item.addActionListener( fmh );
        fileMenu.add( item );
  
        fileMenu.addSeparator();           //add a horizontal separator line
      
        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( fmh );
        fileMenu.add( item );
  
        frame.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
     }
     /**
     * @param menuBar The menubar being constructed
     * @param frame The Frame the menu bar is being added to
     * @param sort The sorted list being displayed on the GUI
     * @param unsort The unsorted list being displayed ont the GUI
     * This method creates a Edit menu on the MenuBar on the GUI
     */
     private void createEditMenu(JMenuBar menuBar, JFrame frame, SortedDate212List sort, UnsortedDate212List unsort) {
        JMenuItem   item;
        JMenu       editMenu = new JMenu("Edit");
        EditMenuHandler emh  = new EditMenuHandler(frame, sort, unsort);
  
        item = new JMenuItem("Insert");    //Open...
        item.addActionListener( emh );
        editMenu.add( item );
 
        frame.setJMenuBar(menuBar);
        menuBar.add(editMenu);
     }
     /**
     * @param fileName This is the file being read
     * @param s Linked list used for sorting
     * @param u Linked list unsorted
     * Fills the lists with date212 objects
     */
    public static void fillArray(String fileName, SortedDate212List s, UnsortedDate212List u){
        File theFile = new File(fileName);
        try{
            FileReader reader = new FileReader(theFile);
            BufferedReader buff = new BufferedReader(reader);
            String line;
        
            while((line = buff.readLine()) != null){
                StringTokenizer myToken = new StringTokenizer(line, ",");
                while(myToken.hasMoreTokens()){
                    
                    Date212 current = new Date212(myToken.nextToken());
                    
                    if(current.dateInIntForm()!= 0){
                        s.add(current);
                        u.add(current);
                    }
                }
            }
            buff.close();
            
        }catch(FileNotFoundException e){
            System.err.print("File not found");
        }catch(IOException ioE){
            System.err.print("IO Exception caught");
        }
    }
}