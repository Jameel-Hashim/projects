public class Player2 extends XO
{
	public static void easy()
	{
		System.out.print("Player2");
		for(int i=0 ; i<5 ; i++)
		{
			System.out.print(".");
			sleep();
		}
		System.out.println();

		randomly();
		playersSwitch = false;
	}
	
	public static void normal()
	{
		System.out.print("Player2");
		for(int i=0 ; i<5 ; i++)
		{
			System.out.print(".");
			sleep();
		}
		System.out.println();

		if(!fightOff())
			randomly();
		playersSwitch = false;
	}

	public static void hard()
	{
		System.out.print("Player2");
		for(int i=0 ; i<5 ; i++)
		{
			System.out.print(".");
			sleep();
		}
		System.out.println();

		if(!fightOff())
			if(!patterns())
				randomly();
		playersSwitch = false;
	}

	//method tools
	public static void randomly()
	{
		update();
		if(available.size() != 0)
		{
			int ch = 0 + (int)(Math.random() * (((available.size()-1) - 0) + 1));
			int row = Integer.parseInt(available.get(ch).charAt(0)+"");
			int column = Integer.parseInt(available.get(ch).charAt(1)+"");
			table[row][column] = player2Is;
		}
	}

	public static boolean fightOff()
	{
		update();
		if(available.size() != 0) //there is empty cell
		{
			boolean goBack = false;
			int goBackRow = 0;
			int goBackColumn = 0;

			/////////START
			boolean foundOnRow = false;
			for(int row=0 ; row<3 ; row++)
			{
				int onColumn = 0;
				int countO = 0;
				int countX = 0;
				int countEmpty = 0;
				for(int column=0 ; column<3 ; column++)
					if(table[row][column] == player2Is)
						countO++;
					else if(table[row][column] == player1Is)
						countX++;
					else //mean empty (+)
					{
						countEmpty++;
						onColumn = column;
					}


				if(countO == 2 && countEmpty == 1)
				{
					table[row][onColumn] = player2Is;
					foundOnRow = true;
					goBack = false;
					break;
				}
				else if(countX == 2 && countEmpty == 1)
				{
					goBackRow = row;
					goBackColumn = onColumn;
					goBack = true;
				}
			}
			if(goBack)
			{
				table[goBackRow][goBackColumn] = player2Is;
				foundOnRow = true;
			}
			/////////DONE

			/////////START
			boolean foundOnColumn = false;
			if(!foundOnRow)
			{
				goBack = false;
				goBackRow = 0;
				goBackColumn = 0;
				for(int column=0 ; column<3 ; column++)
				{
					int onRow = 0;
					int countO = 0;
					int countX = 0;
					int countEmpty = 0;
					for(int row=0 ; row<3 ; row++)
						if(table[row][column] == player2Is)
							countO++;
						else if(table[row][column] == player1Is)
							countX++;
						else //mean empty (+)
						{
							countEmpty++;
							onRow = row;
						}


					if(countO == 2 && countEmpty == 1)
					{
						table[onRow][column] = player2Is;
						foundOnColumn = true;
						goBack = false;
						break;
					}
					else if(countX == 2 &&  countEmpty == 1)
					{
						goBackRow = onRow;
						goBackColumn = column;
						goBack = true;
					}
				}
				if(goBack)
				{
					table[goBackRow][goBackColumn] = player2Is;
					foundOnColumn = true;
				}
			}
			/////////DONE

			/////////START
			boolean lLX = false; //(lLX), mean left Line X
			if(!foundOnRow && !foundOnColumn)
				//first option ooo (win)
				if(table[0][0] == player2Is && table[1][1] == player2Is && table[2][2] == '+')
				{
					table[2][2] = player2Is;
					lLX = true;
				}
				else if(table[0][0] == player2Is && table[2][2] == player2Is && table[1][1] == '+')
				{
					table[1][1] = player2Is;
					lLX = true;
				}
				else if(table[1][1] == player2Is && table[2][2] == player2Is && table[0][0] == '+')
				{
					table[0][0] = player2Is;
					lLX = true;
				}
				//second option is xxo (do't make him win)
				else if(table[0][0] == player1Is && table[1][1] == player1Is && table[2][2] == '+')
				{
					table[2][2] = player2Is;
					lLX = true;
				}
				else if(table[0][0] == player1Is && table[2][2] == player1Is && table[1][1] == '+')
				{
					table[1][1] = player2Is;
					lLX = true;
				}
				else if(table[1][1] == player1Is && table[2][2] == player1Is && table[0][0] == '+')
				{
					table[0][0] = player2Is;
					lLX = true;
				}
			/////////DONE

			/////////START
			boolean rLX = false; //(rLX), mean right Line X
			if(!foundOnRow && !foundOnColumn && !lLX)
				//first option ooo (win)
				if(table[0][2] == player2Is && table[1][1] == player2Is && table[2][0] == '+')
				{
					table[2][0] = player2Is;
					rLX = true;
				}
				else if(table[0][2] == player2Is && table[2][0] == player2Is && table[1][1] == '+')
				{
					table[1][1] = player2Is;
					rLX = true;
				}
				else if(table[1][1] == player2Is && table[2][0] == player2Is && table[0][2] == '+')
				{
					table[0][2] = player2Is;
					rLX = true;
				}
				//second option is xxo (do't make him win)
				else if(table[0][2] == player1Is && table[1][1] == player1Is && table[2][0] == '+')
				{
					table[2][0] = player2Is;
					rLX = true;
				}
				else if(table[0][2] == player1Is && table[2][0] == player1Is && table[1][1] == '+')
				{
					table[1][1] = player2Is;
					rLX = true;
				}
				else if(table[1][1] == player1Is && table[2][0] == player1Is && table[0][2] == '+')
				{
					table[0][2] = player2Is;
					rLX = true;
				}
			/////////DONE

			if(foundOnRow || foundOnColumn || lLX || rLX)
				return true;
		}
		return false;
	}

	//"I win or non"
	public static boolean patterns()
	{
		update();
		if(ansF == 'n' || ansF == 'N')
		{
			if(available.size() == 9) //first play 
			{
				table[0][0] = player2Is;
				return true;
			}

			if(table[1][1] == '+')
			{
				if(table[2][0] == '+')
				{
					table[2][0] = player2Is;
					return true;
				}
				else if(table[0][2] == '+')
				{
					table[0][2] = player2Is;
					return true;
				}
				else if(table[2][2] == '+')
				{
					table[2][2] = player2Is;
					return true;
				}

				//table[1][1] = player2Is;
				//return true;
			}
			else if(table[1][1] == player1Is) //trap, if(table[2][0] == player1)
				if(table[2][2] == '+')
				{
					table[2][2] = player2Is;
					return true;
				}
		}
		else
			if(table[1][1] == player1Is)
			{
				if(table[0][0] == '+')
				{
					table[0][0] = player2Is;
					return true;
				}
				else if(table[0][2] == '+')
				{
					table[0][2] = player2Is;
					return true;
				}
				else if(table[2][0] == '+')
				{
					table[2][0] = player2Is;
					return true;
				}
				else if(table[2][2] == '+')
				{
					table[2][2] = player2Is;
					return true;
				}
			}
			else if(table[1][1] == '+')
			{
				table[1][1] = player2Is;
				return true;
			}
			else if(table[0][2] == '+')
			{
				table[0][2] = player2Is;
				return true;
			}


		return false;
	}

	//tools
	public static void sleep()
	{
		try
		{
			Thread.sleep(400);
		}catch(Exception e){}
	}
}