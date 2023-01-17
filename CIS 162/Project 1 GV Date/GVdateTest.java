
/**
 * Write a description of class GVdateTest here.
 * Test for the GVdate class using if statements, Method 2
 * @author Hunter Sutton
 * @version 10-5-2020
 */
public class GVdateTest{
    public static void main (String [] args){
        int errors = 0;
        System.out.println ("Testing begings");
        //********** phase 1 testing ************
        // testing the default constructor
        GVdate today = new GVdate();
        if (today.getMonth() != 10){
            System.out.println("month should be 10");
            errors++;
        }
        if (today.getDay() != 12){
            System.out.println("day should be 12");
            errors++;
        }
        if (today.getYear() != 2020){
            System.out.println("year should be 2020");
            errors++;
        }
        
        // TO DO: test the year
        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        // TO DO: complete the checks for month, day and year
        // testing setter methods
        //testing setMonth
        theDay.setMonth(8);
        // TO DO: complete the code to check for month
        // TO DO: finish testing setDay and setYear
        // TO DO: test the toString method
        System.out.println("Errors: " + errors);
        System.out.println ("Testing ends");
    } 
}
