# Hunter Sutton
# 2/17/2020
# ch3 while loop password checker

# Define main
def main():

    # Declarations
    PASSWORD = "12345"
    userGuess = " "
    guesses = 1

    # Inputs
    userGuess = input("Enter your password: ") # priming input

    # Processing
    while userGuess != PASSWORD and guesses < 3:
        print("Incorrect password.")
        userGuess = input("Enter your password: ")
        guesses = guesses + 1

    # Outputs
    if userGuess == PASSWORD:
        print("Password Accepted.")
    else:
        print("Access denied. IT has been notified.")

# Call main
main()
