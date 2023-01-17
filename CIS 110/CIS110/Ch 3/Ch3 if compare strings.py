# Hunter Sutton
# 2/19/2020
# Ch3 if compare strings

def main():
    # Declarations
    fav = "pizza"
    guess = " "
    count = 1

    # Inputs
    print("I'm going to give you 3 chances to guess my favorite food.")

    # Processing
    while count <= 3:
        guess = input("Enter your guess: ")
        if guess.lower() == fav:
            print("Yes, that's my favorite food!")
            break
        else:
            print("Gross, who likes", guess, "?")
        count = count + 1

    print("program ended")


main()