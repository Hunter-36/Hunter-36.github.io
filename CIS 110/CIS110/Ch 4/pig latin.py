# Hunter Sutton
# March 2, 2020
# Ch4 is that a prime number


def main():
    # Dec
    word = " "

    # In
    word = input("Enter a word to be translated into pig latin: ")

    # Process
    piggy = translate(word)

    # Out
    print(word, "translates too: ", piggy)

def translate(word):
    piggy = " "
    first = " "

    first = word[0]

    if first == "a" or first == "e" or first == "i" or first == "u":
        piggy = word + "ay"
    else:
        piggy = word + first
        piggy = piggy + "ay"
        piggy = piggy [1::]


    return piggy

# Call main
main()
