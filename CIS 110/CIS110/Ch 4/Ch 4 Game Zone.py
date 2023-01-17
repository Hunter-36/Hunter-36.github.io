# Hunter Sutton
# 3-3-2020
# Ch 4 Game Zone

import random

def main():
    # Declarations
    ran1 = 0
    ran2 = 0
    ran3 = 0
    guess1 = 0
    guess2 = 0
    guess3 = 0

    # Inputs
    guess1 = int(input("Enter your first number 1 through 9: "))
    guess2 = int(input("Enter your second number 1 through 9: "))
    guess3 = int(input("Enter your third number 1 through 9: "))

    # Processing
    ran1 = random.randint(1, 9)
    ran2 = random.randint(1, 9)
    ran3 = random.randint(1, 9)

    # Outputs
    print("You guessed:", guess1, guess2, guess3)
    print("The machine rolled:", ran1, ran2, ran3)

    # All Three matches in order for $1,000,000.
    if guess1 == ran1 and guess2 == ran2 and guess3 == ran3:
        print("You Won the $1,000,000 Jackpot!!!")

    # Three matches not in order for $1,000.
    elif guess1 == ran2 and guess2 == ran3 and guess3 == ran1:
        print("Almost hit the Jackpot! You Won $1,000!")
    elif guess1 == ran3 and guess2 == ran1 and guess3 == ran2:
        print("Almost hit the Jackpot! You Won $1,000!")
    elif guess1 == ran3 and guess2 == ran2 and guess3 == ran1:
        print("Almost hit the Jackpot! You Won $1,000!")
    elif guess1 == ran1 and guess2 == ran3 and guess3 == ran2:
        print("Almost hit the Jackpot! You Won $1,000!")
    elif guess1 == ran2 and guess2 == ran1 and guess3 == ran3:
        print("Almost hit the Jackpot! You Won $1,000!")

    # Two matches for $100.
    elif guess1 != ran1 and guess2 == ran2 and guess3 == ran3:
        print("You got two matches! You Won $100!")
    elif guess1 == ran1 and guess2 != ran2 and guess3 == ran3:
        print("You got two matches! You Won $100!")
    elif guess1 == ran1 and guess2 == ran2 and guess3 != ran3:
        print("You got two matches! You Won $100!")

    elif guess1 != ran1 and guess2 == ran3 and guess3 == ran2:
        print("You got two matches! You Won $100!")
    elif guess1 == ran1 and guess2 != ran3 and guess3 == ran2:
        print("You got two matches! You Won $100!")
    elif guess1 == ran1 and guess2 == ran3 and guess3 != ran2:
        print("You got two matches! You Won $100!")

    elif guess1 == ran2 and guess2 == ran3 and guess3 != ran1:
        print("You got two matches! You Won $100!")
    elif guess1 == ran2 and guess2 != ran3 and guess3 == ran1:
        print("You got two matches! You Won $100!")
    elif guess1 != ran2 and guess2 == ran3 and guess3 == ran1:
        print("You got two matches! You Won $100!")

    elif guess1 == ran2 and guess2 == ran1 and guess3 != ran3:
        print("You got two matches! You Won $100!")
    elif guess1 == ran2 and guess2 != ran1 and guess3 == ran3:
        print("You got two matches! You Won $100!")
    elif guess1 != ran2 and guess2 == ran1 and guess3 == ran3:
        print("You got two matches! You Won $100!")

    elif guess1 == ran3 and guess2 == ran1 and guess3 != ran2:
        print("You got two matches! You Won $100!")
    elif guess1 == ran3 and guess2 != ran1 and guess3 == ran2:
        print("You got two matches! You Won $100!")
    elif guess1 != ran3 and guess2 == ran1 and guess3 == ran2:
        print("You got two matches! You Won $100!")

    elif guess1 == ran3 and guess2 == ran2 and guess3 != ran1:
        print("You got two matches! You Won $100!")
    elif guess1 == ran3 and guess2 != ran2 and guess3 == ran1:
        print("You got two matches! You Won $100!")
    elif guess1 != ran3 and guess2 == ran2 and guess3 == ran1:
        print("You got two matches! You Won $100!")

    # One match for $10.
    elif guess1 == ran1 and guess2 != ran2 and guess3 != ran3:
        print("You got one match. You Won $10!")
    elif guess1 != ran1 and guess2 == ran2 and guess3 != ran3:
        print("You got one match. You Won $10!")
    elif guess1 != ran1 and guess2 != ran2 and guess3 == ran3:
        print("You got one match. You Won $10!")

    elif guess1 == ran1 and guess2 != ran3 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran1 and guess2 == ran3 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran1 and guess2 != ran3 and guess3 == ran2:
        print("You got one match. You Won $10!")

    elif guess1 == ran2 and guess2 != ran3 and guess3 != ran1:
        print("You got one match. You Won $10!")
    elif guess1 != ran2 and guess2 == ran3 and guess3 != ran1:
        print("You got one match. You Won $10!")
    elif guess1 != ran2 and guess2 != ran3 and guess3 == ran1:
        print("You got one match. You Won $10!")

    elif guess1 == ran2 and guess2 != ran1 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran2 and guess2 == ran1 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran2 and guess2 != ran1 and guess3 == ran2:
        print("You got one match. You Won $10!")

    elif guess1 == ran3 and guess2 != ran1 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran3 and guess2 == ran1 and guess3 != ran2:
        print("You got one match. You Won $10!")
    elif guess1 != ran3 and guess2 != ran1 and guess3 == ran2:
        print("You got one match. You Won $10!")

    elif guess1 == ran3 and guess2 != ran2 and guess3 != ran1:
        print("You got one match. You Won $10!")
    elif guess1 != ran3 and guess2 == ran2 and guess3 != ran1:
        print("You got one match. You Won $10!")
    elif guess1 != ran3 and guess2 != ran2 and guess3 == ran1:
        print("You got one match. You Won $10!")

    # No matches no money.
    else:
        print("You did not match any numbers. What a loser.")





# Call Main
main()
