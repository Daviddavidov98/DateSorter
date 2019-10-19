/**
 * @author David Davidov
 * This class extends the Date212List class 
 * and organizes the Date212 objects in a sorted liked list
 */
public class SortedDate212List extends Date212List {
    /**
     * Sorted list constructor
     */
    public SortedDate212List(){
        super();
    }
    /**
     * @param date Adds a Date212 object to the linked list
     */
    public void add(Date212 date) 
    { 
        append(date);
    }
    /**
     * Sorts the Date212List
     */
    public SortedDate212List sort(){
        Date212[] myArray = new Date212[length];
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = this.at(i).data;
        }
        int i, j, minIndex;
        Date212 tmp;
        int n = myArray.length;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                if (myArray[j].dateInIntForm() < myArray[minIndex].dateInIntForm())
                    minIndex = j;
            if (minIndex != i) {
                tmp = myArray[i];
                myArray[i] = myArray[minIndex];
                myArray[minIndex] = tmp;
            }
        }
        SortedDate212List newList = new SortedDate212List();
        for(int l = 0; l < myArray.length; l++){
             newList.append(myArray[l]);
        }
        return newList;
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