
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Write a description of class CovidDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CovidDatabase {
    // Instance Variables
    private ArrayList<CovidEntry> CovidEntryList;
    
    // Constructors
    public CovidDatabase() {
        // initialise instance variables
        CovidEntryList = new ArrayList<CovidEntry>();
    }
    
    // Mutator Methods
    public void readCovidData(String filename) {
        Scanner scnr = null;
        FileInputStream fileByteStream = null;

        try{
            // open the File and set delimiters
            fileByteStream = new FileInputStream(filename);
            scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");
            
            // TO-DO read the first line of the file
            
            // continue while there is more data to read
            while(scnr.hasNext()) {

                // read three data elements
                String state = scnr.next();
                int month = scnr.nextInt();
                int day = scnr.nextInt();
                int di = scnr.nextInt();
                int dd = scnr.nextInt();
                int ti = scnr.nextInt();
                int td = scnr.nextInt();
                
                CovidEntry temp = new CovidEntry(state, month, day, di, dd, ti, td);
                CovidEntryList.add(temp);
            }
            System.out.println(CovidEntryList);
            fileByteStream.close();

            // error while reading the file
        }catch(IOException error1) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
    
    
}
