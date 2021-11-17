public class Rot
{	
	public static void main(String args[])
	{
		//int size = 12;
		int bigTable[][] = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

		//fill
		int count = 1;
		for(int row=0 ; row<bigTable.length ; row++)
			for(int column=0 ; column<bigTable.length ; column++)
				bigTable[row][column] = count++;


		print(bigTable);
		System.out.println("--------------");

		for(int rot=0 ; rot<Integer.parseInt(args[2]) ; rot++)
			for(int i=0 ; i<3 ; i++)
				rot(bigTable, i);
		//print(subTable(bigTable));

		//int newSize = size-4;
		//while(newSize > 0)
		//{
			/*int subTable[][] = new int[4][4];
			subTable = subTable(bigTable);

			//join
			int bigTableRow = subTable.length-1;
			int bigTableColumn = subTable.length-1;;	
			for(int row=0 ; row<subTable.length ; row++)
			{
				for (int column=0 ; column<subTable.length ; column++) 
					bigTable[bigTableRow][bigTableColumn++] = subTable[row][column];
				bigTableRow++;
				bigTableColumn=subTable.length-1;
			}*/

		//	newSize-=2;
		//}

		print(bigTable);
		System.out.println("--------------");

	}

	/*public static int[][] subTable(int table[][])
	{
		int subTable[][] = new int[table.length-2][table.length-2];
		int bigTableRow = subTable.length-1;
		int bigTableColumn = subTable.length-1;
		for(int row=0 ; row<subTable.length ; row++)
		{
			for(int column=0 ; column<subTable.length ; column++)
				subTable[row][column] = table[bigTableRow][bigTableColumn++];
			bigTableRow++;
			bigTableColumn = subTable.length-1;
		}

		rot(subTable);
		return subTable;
	}*/

	public static void rot(int table[][], int subNumber) //subNumber 0 first rot, 1 second, 2 therid
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

	public static void print(int table[][])
	{
		for(int row=0 ; row<table.length ; row++)
		{
			for(int column=0 ; column<table.length ; column++)
				System.out.print(table[row][column] + "   ");
			System.out.println();
		}
	}
}