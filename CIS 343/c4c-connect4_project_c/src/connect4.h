#ifndef CONNECT4_H
#define CONNECT4_H

// Declare your helper functions here.
int x_in_a_row(int x, int length, int array[]);

// You don't have to use this.  It's just here as a demo.
// int x_in_a_row(int x, int length, int array[]);
void makeBoard(int board[], int numRows, int numCols);
void buildGame(int numRows, int numCols, int numWins);

#endif