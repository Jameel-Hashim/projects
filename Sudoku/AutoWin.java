public class AutoWin extends Sudoku
{
	public static void win()
	{
		ArrayList<String> emptyCells = new ArrayList();
		for(int row=0 ; row<table.length ; row++)
			for(int column=0 ; column<table.length ; column++)
				if(table[row][column] == 0)
					emptyCells.add(row + "" + column);

		for(int time=0 ; time<64 ; time++)
		{
			int index = 0 + (int)(Math.random() * (((emptyCells.size()-1)-0)+1));
			int row = Integer.parseInt(emptyCells.get(index).charAt(0)+"");
			int column = Integer.parseInt(emptyCells.get(index).charAt(1)+"");
			emptyCells.remove(index);

			ArrayList<Integer> notUsed = new ArrayList();
			notUsed = getNotUsed(row, column);
			table[row][column] = notUsed.get(0);
		}
	}
}