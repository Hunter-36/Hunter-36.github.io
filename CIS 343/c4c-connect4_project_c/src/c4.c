/* 
   Hunter Sutton
   Jacob Stone
   Place your Connect4's main() function here.
   Anything that you want unit tested must go in a separate file.
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "connect4.h"

int main(int argc, char* argv[]) {
    // default values if no value is supplied
    int rows = 6;
    int cols = 7;
    int numWin = 4;
    char token = 'x';
    if (argc > 1) { // checks for any user input, if none then use default values

        for (int i = 0; i < argc; i++) // using resources... i.e. stack overflow found a way to get user input
        { // dynamically for when input has multiple arguments 
            if(strchr(argv[i], token) != NULL)
            {    //search for 'x' in the command line argument
                sscanf(argv[1], "%dx%d", &rows, &cols);
            }
            else if(strchr(argv[i], token) == NULL)
            {   //check if the command line argument does NOT contain an 'x' (for the number of wins)
                sscanf(argv[i], "%d", &numWin);
            }
        }
    }
    buildGame(rows, cols, numWin);

    return 0;
}