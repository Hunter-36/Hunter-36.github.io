# Hunter Sutton
# 2/17/2020
# ch3 comparing rectangles

# Define main
def main():

    # Declarations
    lengthA = 0.0
    widthA = 0.0
    lengthB = 0.0
    widthB = 0.0
    areaA = 0.0
    areaB = 0.0

    # Inputs
    lengthA = float(input("Enter the length of rectangle A: "))
    widthA = float(input("Enter the width of rectangle A: "))
    lengthB = float(input("Enter the length of rectangle B: "))
    widthB = float(input("Enter the width of rectangle B: "))

    # Processing
    areaA = calcArea(lengthA, widthA)
    areaB = calcArea(lengthB, widthB)

    # Outputs
    print("areaA: ", areaA)
    print("areaB: ", areaB)

    if areaA == areaB:
        print("The rectangles are the same size!")
    elif areaA > areaB:
        print("Rectangle A is bigger than rectangle B!")
    elif areaA < areaB:
        print("Rectangle A is smaller than rectangle B!")

def calcArea(length, width):
    area = length * width
    return area


# Call main
main()