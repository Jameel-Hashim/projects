import java.util.ArrayList;
import java.util.Scanner;

public class Game2048
{
	static int table[][];
	static int tableSize;
	static Scanner in = new Scanner(System.in); 
	public static void main(String args[])
	{
		tableSize = 4;
		table = new int[tableSize][tableSize];
		table[0][0] = 16; table[0][1] = 4; table[0][2] = 0; table[0][3] = 4;
		table[1][0] = 2; table[1][1] = 4; table[1][2] = 4; table[1][3] = 8;
		table[2][0] = 32; table[2][1] = 0; table[2][2] = 0; table[2][3] = 4;
		table[3][0] = 8; table[3][1] = 256; table[3][2] = 8; table[3][3] = 2;

		/*table[0][0] = 2; table[0][1] = 8; table[0][2] = 32; table[0][3] = 128;
		table[1][0] = 2; table[1][1] = 8; table[1][2] = 32; table[1][3] = 128;
		table[2][0] = 4; table[2][1] = 16; table[2][2] = 64; table[2][3] = 256;
		table[3][0] = 4; table[3][1] = 16; table[3][2] = 64; table[3][3] = 256;*/


		play();
	}

	public static void play()
	{
		System.out.println("\t\t    WELCOME TO THE GAME\n\n");
		show();
		show();
		print();

		while(!checkImpossible() && !checkWin())
		{
			char choise = 0;
			do
			{
				System.out.println("Controls: LEFT=A, RIGHT=D, UP=W, DOWN=S");
				System.out.print("> ");
				choise = in.next().charAt(0);
			}while(choise != 'A' && choise != 'D' && choise != 'W' && choise != 'S');

			if(choise == 'A')
				shiftLeft();
			else if(choise == 'D')
				shiftRight();
			else if(choise == 'W')
				shiftUp();
			else if(choise == 'S')
				shiftDown();
			show();
			print();
		}
	}

	public static void shiftLeft()
	{
		int times = tableSize;
		while(times > 0)
		{
			for(int row=0 ; row<tableSize ; row++)
			    for(int column=0 ; column<tableSize-1 ; column++)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row][column+1];
			        	table[row][column+1] = 0;
			        }
			times -= 1;
		}

		for(int row=0 ; row<tableSize ; row++)
		    for(int column=0 ; column<tableSize-1 ; column++)
		        if(table[row][column] == table[row][column+1])
		        {
		            table[row][column] = (table[row][column] + table[row][column+1]);
		            table[row][column+1] = 0;
		        }

        times = tableSize;
		while(times > 0)
		{
			for(int row=0 ; row<tableSize ; row++)
			    for(int column=0 ; column<tableSize-1 ; column++)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row][column+1];
			        	table[row][column+1] = 0;
			        }
			times -= 1;
		}
	}

	public static void shiftRight()
	{
		int times = tableSize;
		while(times > 0)
		{
			for(int row=0 ; row<tableSize ; row++)
			    for(int column=tableSize-1 ; column>0 ; column--)		        
 					if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row][column-1];
			        	table[row][column-1] = 0;
			        }
	        times -= 1;
		}

		for(int row=0 ; row<tableSize ; row++)
		    for(int column=tableSize-1 ; column>0 ; column--)
		        if(table[row][column] == table[row][column-1])
		        {
		            table[row][column] = (table[row][column] + table[row][column-1]);
		            table[row][column-1] = 0;
		        }

	    times = tableSize;
		while(times > 0)
		{
			for(int row=0 ; row<tableSize ; row++)
			    for(int column=tableSize-1 ; column>0 ; column--)		        
 					if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row][column-1];
			        	table[row][column-1] = 0;
			        }
	        times -= 1;
		}
	}

	public static void shiftUp()
	{
		int times = tableSize;
		while(times > 0)
		{
			for(int column=0 ; column<tableSize ; column++)
	   			for(int row=0 ; row<tableSize-1 ; row++)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row+1][column];
			        	table[row+1][column] = 0;
			        }
			times -= 1;
		}

		for(int column=0 ; column<tableSize ; column++)
   			for(int row=0 ; row<tableSize-1 ; row++)
		        if(table[row][column] == table[row+1][column])
		        {
		            table[row][column] = (table[row][column] + table[row+1][column]);
		            table[row+1][column] = 0;
		        }

        times = tableSize;
		while(times > 0)
		{
			for(int column=0 ; column<tableSize ; column++)
	   			for(int row=0 ; row<tableSize-1 ; row++)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row+1][column];
			        	table[row+1][column] = 0;
			        }
			times -= 1;
		}
	}

	public static void shiftDown()
	{
		int times = tableSize;
		while(times > 0)
		{
			for(int column=0 ; column<tableSize ; column++)
	    		for(int row=tableSize-1 ; row>0 ; row--)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row-1][column];
			        	table[row-1][column] = 0;
			        }
			times -= 1;
		}

		for(int column=0 ; column<tableSize ; column++)
    		for(int row=tableSize-1 ; row>0 ; row--)
		        if(table[row][column] == table[row-1][column])
		        {
		            table[row][column] = (table[row][column] + table[row-1][column]);
		            table[row-1][column] = 0;
		        }

    	times = tableSize;
		while(times > 0)
		{
			for(int column=0 ; column<tableSize ; column++)
	    		for(int row=tableSize-1 ; row>0 ; row--)
			        if(table[row][column] == 0)
			        {
			        	table[row][column] = table[row-1][column];
			        	table[row-1][column] = 0;
			        }
			times -= 1;
		}
	}

	public static void show()
	{
		ArrayList<String> emptyCell = new ArrayList();

		for(int row=0 ; row<tableSize ; row++)
			for(int column=0 ; column<tableSize ; column++)
				if(table[row][column] == 0)
					emptyCell.add(row+"" + column+"");

		if(emptyCell.size() != 0)
		{
			String thisPlace = null;
			if(emptyCell.size() != 1) //all of them can get random place
			{
				int choise = (int)(Math.random()*((emptyCell.size()-1)-0)+1);
				thisPlace = emptyCell.get(choise);
			}
			else
				thisPlace = emptyCell.get(0);

			int textRandom = (int)(Math.random()*((1-0)+1));
			int text = 0;
			if(textRandom == 0)
				text = 2;
			else
				text = 4;

			int row = Integer.parseInt(thisPlace.charAt(0)+"");
			int column = Integer.parseInt(thisPlace.charAt(1)+"");
			table[row][column] = text;
		}
	}

	public static boolean checkWin()
	{
		for(int row=0 ; row<tableSize ; row++)
			for(int column=0 ; column<tableSize ; column++)
				if(table[row][column] == 2048)
				{
					System.out.println("*YOU WIN*");
					return true;
				}
		return false;
		
	}

	public static boolean checkImpossible()
	{
		int countEmptyCells = 0;
		int countTheSame = 0;
		int cheakSteps = 0;

		////////// STEP_1 (if there are any empty cells)
		for(int row=0 ; row<tableSize ; row++)
			for(int column=0 ; column<tableSize ; column++)
				if(table[row][column] == 0)
					countEmptyCells += 1;

		if(countEmptyCells == 0)
			cheakSteps +=1;
		else
			return false; //for less procces for prossecor
		////////// DONE

		////////// STEP_2 (if there are any 2 cells the same) AND (it's 100% there no empty cells, check STEP_1 *_^)
		for(int row=0 ; row<tableSize ; row++) //LEFT
		    for(int column=0 ; column<tableSize-1 ; column++)
		        if(table[row][column] == table[row][column+1])
		        	countTheSame +=1;
		for(int row=0 ; row<tableSize ; row++) //RIGHT
		    for(int column=tableSize-1 ; column>0 ; column--)
		        if(table[row][column] == table[row][column-1])
		        	countTheSame +=1;
        for(int column=0 ; column<tableSize ; column++) //UP
   			for(int row=0 ; row<tableSize-1 ; row++)
   				if(table[row][column] == table[row+1][column])
   					countTheSame +=1;
     	for(int column=0 ; column<tableSize ; column++) //DOWN
    		for(int row=tableSize-1 ; row>0 ; row--)
		        if(table[row][column] == table[row-1][column])
		        	countTheSame +=1; 

        if(countTheSame == 0)
        	cheakSteps +=1;
        ////////// DONE

		if(cheakSteps == 2) //mean both check steps is good it's Impossible
		{
			System.out.println("!GAME OVER!");
			return true;
		}
		return false;
	}
	
	public static void print()
	{
		for(int a=0 ; a<tableSize ; a++)
		{
			System.out.print("\t\t\t");
			for(int b=0 ; b<tableSize ; b++)
				System.out.print(table[a][b] + "  ");
			System.out.println();
		}
	}
}
