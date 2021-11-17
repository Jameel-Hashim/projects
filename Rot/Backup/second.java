public static void rot(int table[][])
{
	int column = 1;
	int row = 1;

	int swap = table[row][column];

	while(column+1 <= 4)
		table[row][column] = table[row][++column];
	while(row+1 <= 4)
		table[row][column] = table[++row][column];
	while(column-1 >= 1)
		table[row][column] = table[row][--column];
	while(row-1 >= 1)
		table[row][column] = table[--row][column];

	table[row+1][column] = swap;
}