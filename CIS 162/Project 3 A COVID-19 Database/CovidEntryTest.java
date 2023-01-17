
/**
 * Write a description of class CovidEntryTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CovidEntryTest
{
    public static void main(String [] args) {
        CovidEntry sample = new CovidEntry("MI", 5, 4, 1000, 2000, 4, 3);
        System.out.println(sample);
        
        CovidDatabase database = new CovidDatabase();
        database.readCovidData("covid_data.csv");
    }
}
