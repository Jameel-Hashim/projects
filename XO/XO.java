import java.util.Scanner;
import java.util.ArrayList;

public class XO
{
	static Scanner in = new Scanner(System.in);
	static char table[][] = new char[3][3];
	static ArrayList<String> available = new ArrayList(); //empty cells
	static boolean playersSwitch = false; //false > player1, true > player2
	static char ansF; //who first player1 or player2;
	static char player1Is;
	static char player2Is;

	public static void main(String args[])
	{
		for(int row=0 ; row<3 ; row++) //fill default (+)
			for(int column=0 ; column<3 ; column++)
				table[row][column] = '+';
			
		//who start
		System.out.print("Do You Want To Start(Y/N)? ");
		ansF = in.next().charAt(0);
		while(ansF != 'y' && ansF != 'Y' && ansF != 'n' && ansF != 'N')
		{
			System.out.print("try again, Do You Want To Start(Y/N)? ");
			ansF = in.next().charAt(0);
		}

		if(ansF == 'n' || ansF == 'N')
			playersSwitch = true;
		//

		//X or O
		System.out.print("What Do You Like(X/O)? ");
		char ansXO = in.next().charAt(0);
		while(ansXO != 'x' && ansXO != 'X' && ansXO != 'o' && ansXO != 'O')
		{
			System.out.print("try again, What Do You Like(X/O)? ");
			ansXO = in.next().charAt(0);
		}

		if(ansXO == 'x' || ansXO == 'X')
		{
			player1Is = 'X';
			player2Is = 'O';
		}
		else
		{
			player1Is = 'O';
			player2Is = 'X';
		}
		//

		//choice level
		int choose = 0;
		do
		{
			System.out.println("1-Easy");
			System.out.println("2-Normal");
			System.out.println("3-Hard");
			System.out.print("Choose The Level(1-3): ");
			choose = in.nextInt();
		}while(choose < 1 || choose > 3);

		while(!checkWin())
		{
			if(ansF == 'y' || ansF == 'Y')
				print();

			if(playersSwitch == false)
				player1();
			else
				if(choose == 1)
					Player2.easy();
				else if(choose == 2)
					Player2.normal();
				else if(choose == 3)
					Player2.hard();

			if(ansF == 'n' || ansF == 'N')
				print();
		}					
	} 

	public static void player1()
	{
		System.out.print("Player1> ");
		int ch = in.nextInt();
		while(!player1Wall(ch))
		{
			System.out.print("Player1> ");
			ch = in.nextInt();
		}

		if(ch == 1)
			table[0][0] = player1Is;
		else if(ch == 2)
			table[0][1] = player1Is;
		else if(ch == 3)
			table[0][2] = player1Is;
		else if(ch == 4)
			table[1][0] = player1Is;
		else if(ch == 5)
			table[1][1] = player1Is;
		else if(ch == 6)
			table[1][2] = player1Is;
		else if(ch == 7)
			table[2][0] = player1Is;
		else if(ch == 8)
			table[2][1] = player1Is;
		else if(ch == 9)
			table[2][2] = player1Is;

		playersSwitch = true; //turn on
	}

	public static boolean player1Wall(int ch)
	{
		if(ch == 1)
		{
			if(table[0][0] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}
		else if(ch == 2)
		{
			if(table[0][1] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 3)
		{
			if(table[0][2] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 4)
		{
			if(table[1][0] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 5)
		{
			if(table[1][1] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 6)
		{
			if(table[1][2] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 7)
		{
			if(table[2][0] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 8)
		{
			if(table[2][1] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else if(ch == 9)
		{
			if(table[2][2] != '+')
			{
				System.out.println("\tThis cell it's alrady fill, try again");
				return false;
			}
			return true;
		}		
		else
		{
			System.out.println("\twrong input, just from 1 >> 9 , try again");
			return false;
		}
	}


	//tools
	public static boolean checkWin()
	{
		int time = 2;
		char who = player1Is;
		while(time != 0)
		{
			for(int row=0 ; row<3 ; row++)
			{
				int count = 0;
				for(int column=0 ; column<3 ; column++)
					if(table[row][column] == who)
						count++;
				if(count == 3)
				{
					System.out.println("---------DONE---------");
					print();
					System.out.println("----------------------");
					if(who == player1Is)
						System.out.println("*You Win*");
					else
						System.out.println("!You Lose!");
					return true;
				}
			}

			for(int row=0 ; row<3 ; row++)
			{
				int count = 0;
				for(int column=0 ; column<3 ; column++)
					if(table[column][row] == who)
						count++;
				if(count == 3)
				{
					System.out.println("---------DONE---------");
					print();
					System.out.println("----------------------");
					if(who == player1Is)
						System.out.println("*You Win*");
					else
						System.out.println("!You Lose!");
					return true;
				}
			}

			//X
			if(table[0][0] == who && table[1][1] == who && table[2][2] == who)
			{
				System.out.println("---------DONE---------");
				print();
				System.out.println("----------------------");
				if(who == player1Is)
					System.out.println("*You Win*");
				else
					System.out.println("!You Lose!");
				return true;
			}
			else if(table[0][2] == who && table[1][1] == who && table[2][0] == who)
			{
				System.out.println("---------DONE---------");
				print();
				System.out.println("----------------------");
				if(who == player1Is)
					System.out.println("*You Win*");
				else
					System.out.println("!You Lose!");
				return true;
			}

			who = player2Is;
			time--;
		}

		//no one Win
		update();
		if(available.size() == 0)
		{
			System.out.println("---------DONE---------");
			print();
			System.out.println("----------------------");
			System.out.println("!!No Winer!!");
			return true; //mean stop
		}
		return false;
	}

	public static void update()
	{
		//clear
		available.clear();
		//check
		for(int row=0 ; row<3 ; row++)
			for(int column=0 ; column<3 ; column++)
				if(table[row][column] == '+')
					available.add(row+""+column);
	}

	public static void print()
	{
		for(int row=0 ; row<3 ; row++)
		{
			for(int column=0 ; column<3 ; column++)
				System.out.print(table[row][column] + " ");
			System.out.println();
		}
	}
}
