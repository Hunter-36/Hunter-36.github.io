# Hunter Sutton
# March 2, 2020
# Ch4 magic date

# In month * day == 2-digit year, that's a magic date

def main():
    # Dec
    month = 0
    day = 0
    year = 0

    # In
    month = int(input("Enter the month's number: "))
    day = int(input("Enter the day of the month: "))
    year = int(input("Enter the 2-digit year: "))

    # Process
    if month * day == year:
        # Example: 3-6-18 is a magic date
        print(month, "-", day, "-", year, "Is a magic date!")
    else:
        print(month, "-", day, "-", year, "Is not a magic date!")

    # Out

# Call main
main()