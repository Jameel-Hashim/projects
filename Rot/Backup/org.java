public class Rot
{	
	static String table[][];
	static int m, n, min;
	public static void main(String args[])
	{
		m = Integer.parseInt(args[0]);
		n = Integer.parseInt(args[1]);
		table = new String[m][n];

		//fill for review
		for(int row=0 ; row<m ; row++)
			for(int column=0 ; column<n ; column++)
				if(row<10 && column<10)
					table[row][column] = "0"+row + "/" + "0"+column;
				else if(row<10)
					table[row][column] = "0"+row + "/" +column;
				else if(column<10)
					table[row][column] = row + "/" + "0"+column;
				else
					table[row][column] = row + "/" + column;

		//exce
		if(isGood())
		{
			print();
			System.out.println("--------------");
			for(int rot=0 ; rot<Integer.parseInt(args[2]) ; rot++)
				for(int i=0 ; i<min/2 ; i++)
					rot(i);
			print();
			System.out.println("--------------");
		}
	}

	public static void rot(int part) //part 0 first rot, 1 second, 2 therid
	{
		int row = part;
		int column = part;

		String swap = table[row][column];

		while(column+1 <= n-1-part)
			table[row][column] = table[row][++column];
		while(row+1 <= m-1-part)
			table[row][column] = table[++row][column];
		while(column-1 >= part)
			table[row][column] = table[row][--column];
		while(row-1 >= part)
			table[row][column] = table[--row][column];

		table[row+1][column] = swap;
	}

	public static boolean isGood()
	{
		min = m;
		if(n == m)
			return true;
		else if(n<min)
			min = n;

		if(min%2 != 0)
		{
			System.out.println("!!Error!! the min number must be even");
			return false;
		}

		return true;
	}

	public static void print()
	{
		for(int row=0 ; row<m ; row++)
		{
			for(int column=0 ; column<n ; column++)
				System.out.print(table[row][column] + "   ");
			System.out.println();
		}
	}
}