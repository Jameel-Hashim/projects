import java.util.Scanner;

public class Rot
{	
	static String table[][];
	static int m, n, min;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		int r = in.nextInt();
		table = new String[m][n];

		//fill for review
		for(int row=0 ; row<m ; row++)
			for(int column=0 ; column<n ; column++)
				table[row][column] = in.next();;

		//exce
		if(isGood())
		{
			for(int rot=0 ; rot<r ; rot++)
				for(int part=0 ; part<min/2 ; part++)	
					rot(part);
			print();
		}
	}

	public static void rot(int part) //part 0 first rot, 1 second, 2 therid
	{
		int row = part;
		int column = part;

		String swap = table[row][column];

		while(column+1 <= n-1-part) //n-1-part +1 is the length
			table[row][column] = table[row][++column];
		while(row+1 <= m-1-part) //n-1-part +1 is the length
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
			return false;

		return true;
	}

	public static void print()
	{
		for(int row=0 ; row<m ; row++)
		{
			for(int column=0 ; column<n ; column++)
				System.out.print(table[row][column] + " ");
			System.out.println();
		}
	}
}