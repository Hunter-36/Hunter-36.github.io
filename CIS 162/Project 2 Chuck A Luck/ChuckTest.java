
/**
 * Write a description of class ChuckTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChuckTest
{
    // instance variables
    public static void main(String[] args) {
        int before = 0;
        
        final int ONES = 1;
        final int TWOS = 2;
        final int THREES = 3;
        final int FOURS = 4;
        final int FIVES = 5;
        final int SIXES = 6;
        final int FIELD = 7;
        final int SMALL = 8;
        final int LARGE = 9;
        
        Chuck game = new Chuck();
        System.out.println("Testing begins...");
        assert game.getCredits() == 10 : "credits should start at 10";
        // wins bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before + 1 : "should have won betting on Large";

        // loses bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(new int [] {2,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on Large";

        System.out.println("Testing completed.");
        
        System.out.println("Testing begins...2");
        
        Chuck game2 = new Chuck();
        
        
        System.out.println("Testing completed.2");
    }
}
