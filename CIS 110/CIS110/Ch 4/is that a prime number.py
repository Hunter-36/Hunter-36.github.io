# Hunter Sutton
# March 2, 2020
# Ch4 is that a prime number


def main():
    # Dec
    number = 0
    half = 0
    prime = True

    # In
    number = int(input("Enter a number: "))

    # Process
    half = int(number / 2)
    # count from 2, the smallest possible divisor, to half of the number
    # for 13 it will be 6 so it would loop 2, 3, 4, 5
    for counter in range(2, half):
        if number % counter == 0: # if number id divisible by counter
            prime = False # the number is not prime
            break


    # Out
    if prime == False:
        print(number, "is not prime.")
    else:
        print(number, "is Prime")

# Call main
main()