/**
 * @author David Davidov
 * This class Uses Date212Nodes to fill in a linked list 
 */
public abstract class Date212List{
    protected Date212Node first; 
    protected Date212Node last; 
    protected int length;
    
    /**
     * Date212List default constructor 
     */
    public Date212List () {
          Date212Node ln = new Date212Node();
          first = ln;
          last = ln;
          length = 0;
       }
    /**
     * @param s Date212 obj to be added into the list
     * adds Date212 objects to the linked list
     */
    public void append (Date212 s) {
       Date212Node n = new Date212Node(s);
       last.next = n;
       last = n;
       length++;
    }
    /**
     * prints the linked list 
     */
    public void printList(){
        Date212Node p = first.next;
        while(p != null){
            System.out.println(p.data.toString());
            p = p.next;
        }
    }
    /**
     * @return length of the list
     */
    public int length(){
        return length;
    }
    /**
     * @param i the index of the node looking to return
     * @return a Date212Node at a specific index
     */
    public Date212Node at(int i){
        if(i > this.length || length == 0)
            return null;
        Date212Node p = first.next;
        for(int j = 0; j < length; j++){
            if (j == i)
                return  p;
            p = p.next;
        }
        return null;    
    }
 }