public class ConCells
{
	static int rowSize, columnSize;

	public static void main(String args[])
	{
		rowSize = 4;
		columnSize = 4;
		int matrix[][] = new int[rowSize][columnSize];

		//fill up
		matrix[0][0] = 1; matrix[0][1] = 1; matrix[0][2] = 0; matrix[0][3] = 0;
		matrix[1][0] = 1; matrix[1][1] = 1; matrix[1][2] = 1; matrix[1][3] = 0;
		matrix[2][0] = 0; matrix[2][1] = 1; matrix[2][2] = 1; matrix[2][3] = 0;
		matrix[3][0] = 1; matrix[3][1] = 1; matrix[3][2] = 1; matrix[3][3] = 0;

		System.out.println(getItToMe(matrix));
	}

	public static int getItToMe(int matrix[][])
	{
		int size=0;
		int roro=0; //mean return ^_^

		for(int row=0 ; row<rowSize ; row++)
			for(int column=0 ; column<columnSize ; column++)
				if(matrix[row][column] == 1)
					if((roro=looking(matrix, row, column)) > size)
						size = roro;

		return size;
	}

	public static int looking(int matrix[][], int row, int column)
	{
		if(row < 0 || column < 0 || row >= rowSize || column >=columnSize)
			return 0;
		if(matrix[row][column] == 0)
			return 0;

		matrix[row][column] = 0;
		int size = 1;
		for(int r=row-1 ; r<=row+1 ; r++) //left and right
			for(int c=column-1 ; c<=column+1 ; c++)	//up and down
				size += looking(matrix, r, c);
		return size;
	}
}