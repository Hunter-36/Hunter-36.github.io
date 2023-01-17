import java.text.DecimalFormat;
/**
 * Write a description of class GVdate here.
 *
 * @author Hunter Sutton
 * @version 10-13-2020
 */
public class GVdate
{
    //Instance Variables
    private int month;
    private int day;
    private int year;
    private int myMonth;
    private int myDay;
    private static DecimalFormat df = new DecimalFormat ("00");

    //Constructors
    /**
     * Constructor for objects of class GVdate
     */
    public GVdate(){
        month = 10;
        day = 12;
        year = 2020;
    }

    public GVdate(int m, int d, int y){
        if (isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        }
        else{
            month = 10;
            day = 20; 
            year = 2020;
        }
    }

    public GVdate (String date){
        int firstSlash = date.indexOf ("/");
        int secondSlash = date.indexOf("/", firstSlash + 1);
        int m = Integer.parseInt(date.substring(0, firstSlash));
        int d = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        int y = Integer.parseInt(date.substring(secondSlash + 1));
        if (isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        }
        else{
            month = 10;
            day = 20; 
            year = 2020;
        }
    }

    //Methods
    /**
     * Method getMonth
     * This method is used to grab the month
     * @return It return the month
     */
    public int getMonth( ){
        return month;
    }

    /**
     * Method getDay
     * This method is used to grab the day
     * @return It returns the day
     */
    public int getDay( ){
        return day;
    }

    /**
     * Method getYear
     * This method is used to grab the year
     * @return It returns the year
     */
    public int getYear( ){
        return year;
    }

    /**
     * Method toString
     * This method converts the integers month, day, and year into a string
     * @return It returns the date as a string
     */
    public String toString( ){
        return month + "/" + day + "/" + year;
    }
    
    public String toString(int format){
        String result = "";
        String[] months = {"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] monthsLong = {"None","January","February","March","April","May","June","July","August","September","October","November","December"};
        switch (format){
            case 1: result = this.toString(); break;
            case 2: result = df.format(this.month) + "/" + df.format(this.day) + "/" + this.year; break;
            case 3: result = months[this.month] + " " + df.format(this.day) + ", " + this.year; break;
            case 4: result = monthsLong[this.month] + " " + df.format(this.day) + ", " + this.year; break;
        }
        return result;
    }

    /**
     * Method isMyBirthday
     * This method compares the date to my brithday
     * @return It returns the if my brithday is the same as the date, as true or false
     */
    public boolean isMyBirthday( ){
        if (month == myMonth && day == myDay){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method isLeapYear
     * This method figures out weather the the year in the date is a leap year
     * @param y Is the int for the year
     * @return It returns weather or not the the leap year is true or false
     */
    public boolean isLeapYear(int y){
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //Mutator Methods
    public void setMonth(int m){
        if (isDateValid(m, this.day, this.year) == true){
            month = m;
        }
        else{
            System.out.println("Error, Invalid Date.");
        }
    }

    public void setDay(int d){
        if (isDateValid(this.month, d, this.year) == true){
            day = d;
        }
        else{
            System.out.println("Error, Invalid Date.");
        }
    }

    public void setYear(int y){
        if (isDateValid(this.month, this.day, y) == true){
            year = y;
        }
        else{
            System.out.println("Error, Invalid Date.");
        }
    }

    public void setDate(int m, int d, int y){
        if (isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        }
        else{
            System.out.println("Error, Invalid Date.");
        }
    }
    
    public void nextDay( ){
        if (this.day == getLastDayOfMonth(this.month, this.year) && this.month == 12){
            month = 1;
            day = 1;
            year += 1;
        }
        else if(this.day == getLastDayOfMonth(this.month, this.year)){
            day = 1;
            month += 1;
        }
        else{
            day += 1;
        }
    }
    
    public boolean equals(GVdate otherDate){
        if (month == otherDate.getMonth() && day == otherDate.getDay() && year == otherDate.getYear()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void skipAhead(int numDays){
        for(int i = 0; i < numDays; i++){
            this.nextDay();
        }
    }

    // Private Helper Methods
    private int getLastDayOfMonth(int m, int y){
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            return 31;
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11){
            return 30;
        }
        else if (m == 2){
            if (isLeapYear(y) == true){
                return 29;
            }
            else{
                return 28;
            }
        }
        return -1;
    }

    private boolean isDateValid(int m, int d, int y){
        if (m < 1 || m > 12){
            return false;
        }
        else if (y < 1){
            return false;
        }
        else if (d < 1 || d > getLastDayOfMonth(m, y)){
            return false;
        }
        else{
            return true;
        }
    }
}
