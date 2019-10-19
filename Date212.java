/**
 * @author David Davidov 
 * This Class reads a string, verifies it is a date, gets the year month and day and stores it in 
 * private vairables, converts the verified date to a string again and can convert the verified date
 * to an integer
 */
public class Date212{
    private int year, month, date;
    
    Date212(){
        year = 0;
        month = 0;
        date = 0;
    }
    /**
     * @param day The inputted day
     */
    Date212(String day){
        try{
            if(!verifyDate(day)){
                throw new Date212Exception("Invalid Day Provided: "+day);
            }
        }catch(Date212Exception e){
            System.out.println(e);
        }
    }
    /**
     * @param day The inputted day
     * @return Either true or false depending if the date is valid
     * This method verifies the date provided
     */
    private boolean verifyDate(String day){
        //Checking if the date 8 characters and all integers, otherwise returns false
        if (((day.length()) < 8) || ((day.length()) > 8))
            return false;
        char[] arr = day.toCharArray();
        for(char digit : arr){
            if(Character.isDigit(digit))
                continue;
            else
                return false;
        }
        if((getYear(day)) && (getMonth(day)) && (getDay(day)))
            return true;
        else//will get here if either year, month or date is invalid
            return false;
    }
    /**
     * @param day The inputted day
     * @return Either true or false depending if the year is valid
     */
    private boolean getYear(String day){
        //retrieving first four numbers which reps year
        int yr = Integer.parseInt(day.substring(0, 4));
        if(yr <= 2018)
        {
            year = yr;
            return true;
        }     
        else{
            System.out.println("INVALID YEAR");
            return false;
        }
    }
    /**
     * @param day The inputted day
     * @return Either true or false depending if the month is valid
     */
    private boolean getMonth(String day){
        //retrieves month and converts to int
        int m = Integer.parseInt(day.substring(4, 6));
        if ((m > 0) && (m <= 12))
        {
            month = m;
            return true;
        }       
        else{
            System.out.println("INVALID MONTH");
            return false;
        }
    }
    /**
     * @param day The inputted day
     * @return Either true or false depending if the day is valid
     */
    private boolean getDay(String day){
        //retrieves date and converts to in
        int d = Integer.parseInt(day.substring(6, 8));
        if ((d > 0) && (d <= 31)){
            date = d;
            return true;
        }       
        else{
            System.out.println("INVALID DAY OF MONTH");
            return false;
        }
    }
    /**
     * @return Returns the provided date in String form ie: 1/2/12
     */
    public String toString(){
        String yr, m, d, stringDate;
        yr = Integer.toString(this.year);
        m = Integer.toString(this.month);
        d = Integer.toString(this.date);
        stringDate = m + "/" + d + "/" + yr;
        
        return stringDate;
    }
    /**
     * @return Returns the verified date in integer form ie: 20120102
     * If the date is invalid it returns 0 which is used to see if we 
     * should output in onto the GUI or not.
     */
    public int dateInIntForm(){
        int intDate = (year*100+month)*100+date;
        return intDate;
    }
}