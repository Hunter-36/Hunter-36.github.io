# Hunter Sutton
# 2/19/2020
# Ch3 while loop beer

def main():
    # Declarations
    bottles = 100

    #Inputs
    stuff = input("What's in the bottles? Enter Here: ")

    # Processing
    while bottles > 2:
        print(bottles, "bottles of", stuff, "on the wall")
        print(bottles, "bottles of", stuff)
        print("take one down, pass it around")
        bottles = bottles - 1
        print(bottles, "bottles of", stuff, "on the wall")
        print()


    # Outputs
    print("2 bottles of", stuff, "on the wall")
    print("2 bottles of", stuff)
    print("take one down, pass it around")
    print("1 bottle of", stuff, "on the wall")
    print()
    print("1 bottle of", stuff, "on the wall")
    print("1 bottle of", stuff)
    print("take it down, pass it around")
    print("no more bottles of", stuff, "on the wall")
    print()
    print("boo hoo")


# Call main
main()