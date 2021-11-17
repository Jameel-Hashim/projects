public static void rot(int table[][], int subNumber)
{
	int column = 2;
	int row = 2;

	int swap = table[row][column];

	while(column+1 <= 3)
		table[row][column] = table[row][++column];
	while(row+1 <= 3)
		table[row][column] = table[++row][column];
	while(column-1 >= 2)
		table[row][column] = table[row][--column];
	while(row-1 >= 2)
		table[row][column] = table[--row][column];

	table[row+1][column] = swap;
}