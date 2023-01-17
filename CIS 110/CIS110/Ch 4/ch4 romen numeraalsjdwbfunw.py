# Hunter Sutton
# March 2, 2020
# Ch4 roman numerls


def main():
    # declar
    number = 0

    # In
    number = int(input("Enter a number between 1 and 10: "))

    # Process
    if number == 1:
        print("1 == I")
        print("Did you know that before I told you?")
        letter = input("Enter y or n: ")
        if letter == "n" or letter == "N":
            print("Wow. I thought everyone knew that!")
        elif letter == "y" or letter == "Y":
            print("You already knew? Thanks for wasting my time.")
        else:
            print("So you dont know how to follow directions ethier?")
    elif number == 2:
        print("2 == II")
    elif number == 3:
        print("3 == III")
    elif number == 4:
        print("4 == IV")
    elif number == 5:
        print("5 == V")
    elif number == 6:
        print("6 == VI")
    elif number == 7:
        print("7 == VII")
    elif number == 8:
        print("8 == VIII")
    elif number == 9:
        print("9 == IX")
    elif number == 10:
        print("10 == X")

    # Out
    print("End of ufhsu")

# Call main
main()