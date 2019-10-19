/**
 * @author David Davidov
 * This class creates a Date212 Node used for linked list
 */
public class Date212Node {
    protected Date212 data;
    protected Date212Node next;
    /**
     * @param data Date212 object used for list
     * @param next Date212Node used to link the current object to
     */
    public Date212Node(Date212 data, Date212Node next)  {
       this.data = data;
       this.next = next;
    }  // constructor
    /**
     * constructor that leaves both data and next node null
     */
    public Date212Node()  {
       this.data = null;
       this.next = null;
    }  // constructor
    /**
     * @param data Date212 object used for list
     */
    public Date212Node(Date212 data)  {
       this.data = data;
       this.next = null;
    }  
    
 }