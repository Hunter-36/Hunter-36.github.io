/* 
   Hunter Sutton
   Jacob Stone
   Place all your Connect4 functions here --- except for main.
   main() needs to go in its own separate .c file.
*/
#include "connect4.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int x_in_a_row(int x, int length, int array[]) {
    int checkerArray = array[0];
    int count = 1;
    for(int i = 1; i < length; i++){

        if(array[i] == checkerArray && (array[i], "1" == 0 || array[i], "2" == 0)){
            count++;
        }
        else{
            count = 1;
        }
        checkerArray = array[i];
        if(count == x){
            printf("Congratulations, Player %s. You win.\n", array[i]);
            exit(0);
        }
    }
    return 0;
}

void buildGame(int numRows, int numCols, int numWins)
{
    int board[numRows*numCols];
    for(int i = 0; i < (numCols*numRows); i++) // set all values to 0
    {
        board[i] = 0;
    }
    int currPlayer = 1; // players can be 1 and 2 
    char place = '\0'; // sets first user input value to null
    int invalidFlag = 0;

    makeBoard(board, numRows, numCols); // prints out board for user input
    // scan for user input
    fflush(stdin);
    while(toupper(place) != 'Q')
    {
        printf("Please pick a column: ");
        scanf("%c", &place);
        fflush(stdin);

        if(toupper(place) == 'Q')
        {
            printf("Goodbye.\n");
            break; // breaks out of while
        }

    }
}

void makeBoard(int board[], int numRows, int numCols)
{
    char columnHeaders[16] = {'A', 'B', 'C', 'D', 'E',
     'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'}; // 16X16 is largest board size
    printf("\n");
    for(int i = 0; i < numCols; i++) // print out headers
    {
        printf("%c ", columnHeaders[i]);
    }
    printf("\n");
    //print out array
    for (int j = 0; j < numRows; j++) {
        for (int k = 0; k < numCols; k++){
            printf("%d ", board[j * numCols + k]); // printing out 10th element in default board
            // means j is 1 (second row) * 7 + 3 3rd element in second row
        }
        printf("\n");
    }
}