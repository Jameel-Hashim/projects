public static void rot(int table[][])
{
	int column = 0;
	int row = 0;

	int swap = table[row][column];

	while(column+1 <= 5)
		table[row][column] = table[row][++column];
	while(row+1 <= 5)
		table[row][column] = table[++row][column];
	while(column-1 >= 0)
		table[row][column] = table[row][--column];
	while(row-1 >= 0)
		table[row][column] = table[--row][column];

	table[row+1][column] = swap;
}