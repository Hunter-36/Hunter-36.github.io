import java.text.DecimalFormat;

/**
 * Write a description of class CovidEntry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CovidEntry
{
    // Instance Variables
    private String state;
    private int month;
    private int day;
    private int dailyDeaths;
    private int dailyInfections;
    private int totalDeaths;
    private int totalInfections;
    
    private static DecimalFormat df = new DecimalFormat ("#,###,###");
    
    // Constructors
    public CovidEntry(String st, int m, int d, int di, int dd, int ti, int td)
    {
        // initialise instance variables
        this.state = st;
        this.month = m;
        this.day = d;
        this.dailyInfections = di;
        this.dailyDeaths = dd;
        this.totalInfections = ti;
        this.totalDeaths = td;
    }
    
    // Accessor Methods
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public String getState() {
        return state;
    }
    
    public int getDailyInfections() {
        return dailyInfections;
    }
    
    public int getDailyDeaths() {
        return dailyDeaths;
    }
    
    public int getTotalInfections() {
        return totalInfections;
    }
    
    public int getTotalDeaths() {
        return totalDeaths;
    }
    
    public String toString() {
        return state + " " + month + "/" + day + " " +
        df.format(dailyInfections) + " infections" +
        " " + df.format(dailyDeaths) + " deaths";
    }
    
    
}
