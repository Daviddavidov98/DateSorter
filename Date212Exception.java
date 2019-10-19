/**
 * @author David Davidov
 * This class throws a Date212Exception which extends from an 
 * IllegalArgumentException and prints an Exception message
 */
public class Date212Exception extends IllegalArgumentException{
    public Date212Exception(String message){
        super(message);
    }
}