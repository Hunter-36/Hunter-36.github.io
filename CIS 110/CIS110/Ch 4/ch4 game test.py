import random

def main():
    computerNum1 = 0
    computerNum2 = 0
    computerNum3 = 0
    guess1 = 0
    guess2 = 0
    guess3 = 0

    guess1 = int(input("Enter in your first number guess between 1 and 9: "))
    guess2 = int(input("Enter in your second number guess between 1 and 9: "))
    guess3 = int(input("Enter in your third number guess between 1 and 9: "))

    computerNum1 = random.randint(1,9)

    print(computerNum1)