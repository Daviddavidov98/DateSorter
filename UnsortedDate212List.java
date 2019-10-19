/**
 * @author David Davidov
 * This class extends the Date212List class 
 * lists the Date212 objects in an unsorted liked list
 */
public class UnsortedDate212List extends Date212List {
    /**
     * Unsorted list constructor
     */
    public UnsortedDate212List(){
        super();
    }
    /**
     * @param date Adds a Date212 object to the linked list
     */
    public void add(Date212 d){
        append(d);
    }
     /**
      * Prints the date212 list using the abstract print method
      */ 
    public void print(){
        printList();
    }
     /**
      * @return the length of the list
      */ 
    public int getLength(){
        return length();
    }
    /**
     * @param i the index of the node looking to return
     * @return a Date212Node at a specific index
     */
    public Date212Node dateAt(int i){
        return at(i);
    }
}