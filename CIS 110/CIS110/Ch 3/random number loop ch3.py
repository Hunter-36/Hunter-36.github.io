# Hunter Sutton
# 2/17/2020
# ch3 random number loop

# Import random number generator
import random

# Define main
def main():

    # Declarations
    loops = 0
    number = 0

    # Inputs
    loops = int(input("Enter number of loops:"))

    # Processing
    # for counter in range (number of loops)
    for count in range(loops):
        number = random.randint(1, 100)
        print(number)
        # print("I like number this is fun!")
        # print("This is fun!")
        if number >= 80:
            print("   ", number, "is a big number!")
        elif number <= 20:
            print("   ", number, "is a tiny number!")
        elif number == 36:
            print("*****Lucky Number!!*****")

    # Outputs
    print("The loop is finished.")


# Call main
main()