 import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Sudoku
{
	static int table[][] = new int[9][9];
	static ArrayList<String> constantValues = new ArrayList();
	static HashMap<Integer, String> hMap = new HashMap<Integer, String>();
	static ArrayList<Integer> busyValues = new ArrayList();


	public static void main(String args[])
	{
		//hashMap for table[][]
		int count = 1; 
		for(int row=0 ; row<table.length ; row++)
			for(int column=0 ; column<table.length ; column++)
				hMap.put(count++, row + "" + column);

		play();
	}

	public static void play()
	{
		Scanner in = new Scanner(System.in);
		int ch = 0;
		String type = "";
		do
		{
			System.out.println("1-Easy");
			System.out.println("2-Normal");
			System.out.println("3-Hard");
			System.out.print("Enter The Level: ");
			ch = in.nextInt();
		}while(ch != 1 && ch != 2 && ch != 3);

		if(ch == 1)
			type = "easy";
		else if(ch == 2)
			type = "normal";
		else if(ch == 3)
			type = "hard";

		setRandomly(type);
		print();
		System.out.println();

		while(!isWin())
		{
			System.out.print("Enter Cell Number And The Number >> ");
			int cellNum = in.nextInt();
			int num = in.nextInt();
			while(!checkAndPut(cellNum, num))
			{
				System.out.print("Enter Cell Number And The Number >> ");
				cellNum = in.nextInt();
				num = in.nextInt();
			}	
			print();
		}
	}

	public static boolean checkAndPut(int cellNum, int num) //part of play()
	{
		if(num > 9 || num == 0)
		{
			System.out.println("!Wrong Try Again (1-9)Number!");
			return false;
		}

		if(cellNum == 0 || cellNum > 81)
		{
			System.out.println("!Wrong Try Again (1-81)Cells!");
			return false;
		}

		String index = hMap.get(cellNum);
		int row = Integer.parseInt(index.charAt(0)+"");
		int column = Integer.parseInt(index.charAt(1)+"");

		//save constant Values
		for(int row2=0 ; row2<table.length ; row2++)
			for(int column2=0 ; column2<table.length ; column2++)
				if(table[row2][column2] != 0)
					constantValues.add(row2 + "" + column2);

		if(constantValues.contains(index))
		{
			System.out.println("!Wrong Try Again Cell \'" + cellNum + "\' Is Constant Value!");
			return false;
		}

		table[row][column] = num;
		return true;	
	}

	public static void setRandomly(String type)
    {
    	ArrayList<Integer> lemits = new ArrayList();
    	int cellsFill=0;
    	if(type.equals("easy"))
    	{
    		lemits.add(4); lemits.add(8); lemits.add(12); lemits.add(16);
	    	lemits.add(20); lemits.add(24); lemits.add(28); lemits.add(32);
	    	cellsFill=36;
    	}
    	else if(type.equals("normal"))
    	{
    		lemits.add(3); lemits.add(6); lemits.add(9); lemits.add(12);
	    	lemits.add(15); lemits.add(18); lemits.add(21); lemits.add(24);
	    	cellsFill=27;
    	}
    	else if(type.equals("hard"))
    	{
    		lemits.add(2); lemits.add(4); lemits.add(6); lemits.add(8);
	    	lemits.add(10); lemits.add(12); lemits.add(14); lemits.add(16);
	    	cellsFill=18;
    	}
    	
    	ArrayList<Integer> columnDone = new ArrayList();
    	int row=0;
		for(int time=0 ; time<cellsFill ; time++)
		{
			if(lemits.contains(time))
			{
				row++;
				columnDone.clear();
			}

			int column = 0 + (int)(Math.random() * ((8-0)+1));
			while(columnDone.contains(column))
				column = 0 + (int)(Math.random() * ((8-0)+1));
			columnDone.add(column); //mean is Done

			look(row, column); //set busy

			int value = 1 + (int)(Math.random() * ((9-1)+1));
			while(busyValues.contains(value))
				value = 1 + (int)(Math.random() * ((9-1)+1));

			table[row][column] = value;
		}
    }

	public static void look(int currentRow, int currentColumn) //part of setRandomly()
	{
		busyValues.clear();
    	for(int row=0 ; row<table.length ; row++)
    		if(table[row][currentColumn] != 0 && !busyValues.contains(table[row][currentColumn]))
    			busyValues.add(table[row][currentColumn]);

		for(int column=0 ; column<table.length ; column++)
    		if(table[currentRow][column] != 0 && !busyValues.contains(table[currentRow][column]))
    			busyValues.add(table[currentRow][column]);
	}

	public static boolean isWin()
	{
		for(int row=0 ; row<table.length ; row++) //should not be empty cell
			for(int column=0 ; column<table.length ; column++)
				if(table[row][column] == 0)
					return false;

		for(int row=0 ; row<table.length ; row++) //should not be value had the same in row or column
			for(int column=0 ; column<table.length ; column++)
				if(!isGoodPlace(row, column))
					return false;

		System.out.println("You Win");
		return true;
	}

	public static boolean isGoodPlace(int currentRow, int currentColumn) //part of isWin() ,return true, mean there are Not two number the same in row or column
	{
		if(table[currentRow][currentColumn] == 0)
			return true;

		for(int column=currentColumn+1 ; column<table.length ; column++)
			if(table[currentRow][column] == table[currentRow][currentColumn])
				return false;
		
		for(int row=currentRow+1 ; row<table.length ; row++)
			if(table[row][currentColumn] == table[currentRow][currentColumn])
				return false;

		return true;
	}

	public static void print()
	{
		for(int row=0 ; row<table.length ; row++)
		{
			for(int column=0 ; column<table.length ; column++)
				System.out.print(table[row][column] + " ");
			System.out.println();
		}
	}
}