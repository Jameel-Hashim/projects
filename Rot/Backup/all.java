public static void rot(int table[][], int subNumber) //subNumber 0 first 
{
	int column = subNumber;
	int row = subNumber;

	int swap = table[row][column];

	while(column+1 <= table.length-1-subNumber)
		table[row][column] = table[row][++column];
	while(row+1 <= table.length-1-subNumber)
		table[row][column] = table[++row][column];
	while(column-1 >= subNumber)
		table[row][column] = table[row][--column];
	while(row-1 >= subNumber)
		table[row][column] = table[--row][column];

	table[row+1][column] = swap;
}