# Hunter Sutton
# March 2, 2020
# Ch4 faces on money


def main():
    # Dec
    bill = 0

    # In
    bill = int(input("Enter the denomination of the US bill and I will tell you who is on it: "))

    # Process
    if bill == 1:
        print("Eddie Murphy is on the 1 dollar bill.")
    elif bill == 2:
        print("Michell Jackson is on the 2 dollar bill.")
    elif bill == 5:
        print("I am on the 5 dollar bill.")
    elif bill == 10:
        print("The cast of Friends is on the 10 dollar bill.")
    elif bill == 20:
        print("The Rock is on the 20 dollar bill.")
    elif bill == 50:
        print("Austin Case is on the 50 dollar bill.")
    elif bill == 100:
        print("Jesus is on the 100 dollar bill.")
    else:
        print("Dumbass", bill, "is not a valid bill...")

    # Out
    print("The End...")

# Call main
main()