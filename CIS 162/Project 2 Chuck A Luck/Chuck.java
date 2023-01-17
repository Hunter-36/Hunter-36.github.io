
/**
 * Write a description of class Chuck here.
 *
 * @author Hunter Sutton
 * @version (a version number or a date)
 */
public class Chuck {
    // Instance Variables
    private int credits;
    private GVdie[] diceArray;
    private String message;
    private boolean[] betsArray;
    
    // Constructors
    /**
     * Constructor for objects of class Chuck
     */
    public Chuck() {
        // Initialise Instance Variables
        credits = 10;
        diceArray = new GVdie[3];
        for (int i = 0; i < 3; i++) {
            diceArray[i] = new GVdie();
            diceArray[i].setBlank();
        }
        message = "";
        betsArray = new boolean[9];
        for (int i = 0; i < 9; i++) {
            betsArray[i] = false;
        }
    }
    
    // Accessor Methods
    public String getMessage() {
       return message;
    }
    
    public int getCredits() {
       return credits;
    }
    
    public GVdie[] getDice() {
       return diceArray;
    }
    
    // Private Helper Methods
    private int getSumDiceValues() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += diceArray[i].getValue();
        }
        return sum;
    }
    
    private boolean isDoubles(int num) {
        int matches = 0;
        for (int i = 0; i < 3; i++) {
            if (diceArray[i].getValue() == num) {
                matches++;
            }
        }
        if (matches == 2) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isTriplets() {
        int matches = 0;
        int num = diceArray[0].getValue();
        for (int i = 0; i < 3; i++) {
            if (diceArray[i].getValue() == num) {
                matches++;
            }
        }
        if (matches == 3) {
            return true;
        } else {
            return false;
        }
    }
    
    private void checkLarge() {
        if (getSumDiceValues() > 10 && !isTriplets()) {
            credits += 2;
            message = "You won!";
        }
    }
    
    private void checkSmall() {
        if (getSumDiceValues() < 11 && !isTriplets()) {
            credits += 2;
            message = "You won!";
        }
    }
    
    private void checkField() {
        if (getSumDiceValues() < 8 || getSumDiceValues() > 12) {
            credits += 2;
            message = "You won!";
        }
    }
    
    private void checkNumber(int num) {
        int matches = 0;
        for ( int i = 0; i < 3; i++) {
            if (diceArray[i].getValue() == num) {
                matches++;
            }
        }
        if (matches == 3) {
            credits += 11;
            message = "You won!";
        }
        else if (matches == 2) {
            credits += 3;
            message = "You won!";
        }
        else if (matches == 1) {
            credits += 2;
            message = "You won!";
        }
    }
    
    private void checkAllBets() {
        message = "You Lost!";
        for (int i = 0; i < 9; i++) {
            if (betsArray[i]) {
                credits--;
                switch (i) {
                    case 0: checkNumber(1);
                        break;
                    case 1: checkNumber(2);
                        break;
                    case 2: checkNumber(3);
                        break;
                    case 3: checkNumber(4);
                        break;
                    case 4: checkNumber(5);
                        break;
                    case 5: checkNumber(6);
                        break;
                    case 6: checkField();
                        break;
                    case 7: checkSmall();
                        break;
                    case 8: checkLarge();
                        break;
                }
            }
        }
    }
    
    // Mutator Methods
    public void addCredits(int amount) {
        if (amount > 0) {
            credits = credits + amount;
            message = "10 Credits Added!";
        }
    }
    
    public void placeBet(int bet) {
        if (bet > 0 && bet < 10) {
            betsArray[bet - 1] = true;
        }
    }
    
    public void cancelBet(int bet) {
        if (bet > 0 && bet < 10) {
            betsArray[bet - 1] = false;
        }
    }
    
    public void clearAllBets() {
        for (int i = 0; i < 9; i++) {
            betsArray[i] = false;
        }
    }
    
    public void roll() {
        if (enoughCredits() == true) {
            for (int i = 0; i < 3; i++) {
                diceArray[i].roll();
            }
            checkAllBets();
            clearAllBets();
        } else {
            message = "Not Enough Credits to Play!";
            for (int i = 0; i < 3; i++) {
                diceArray[i].setBlank();
            }
        }
    }
    
    public void reset() {
        for (int i = 0; i < 3; i++) {
            diceArray[i].setBlank();
        }
        credits = 10;
        message = "";
        clearAllBets();
    }
    
    // Preventing PLayer Errors
    public boolean enoughCredits() { // failed test
        int betsTotal = 0;
        for (int i = 0; i < 9; i++) {
            if (betsArray[i] == true) {
                betsTotal++;
            }
        }
        if (betsTotal <= credits) {
            return true;
        } else {
            return false;
        }
    }
    
    // Software Testing
    public String diceToString() {
        String aString = "[";
        for (int i = 0; i < 3; i++) {
            aString += diceArray[i].getValue() + ",";
        }
        aString += "]";
        return aString;
    }
    
    public void testRoll(int [] values) { // ask question if complete
        if (enoughCredits()) {
            for (int i = 0; i < 3; i++) {
                if (values[i] < 1 || values[i] > 6) {
                    values[i] = 1;
                }
            }
            for (int i = 0; i < 3; i++) {
                while (diceArray[i].getValue() != values[i]) {
                    diceArray[i].roll();
                }
            }
            checkAllBets();
            clearAllBets();
        }
    }
}
