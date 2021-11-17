import java.util.ArrayList;

class Breadth
{
	private boolean matrix[][];
	private Character symbols[];
	private int goal;

	protected Breadth(Character symbols[], int goal)
	{
		this.symbols = symbols;
		this.goal = goal;
		matrix = new boolean[symbols.length][symbols.length];
	}

	protected void addEdge(int r, int c)
	{
		matrix[r][c] = true;
	}

	protected void run()
	{
		ArrayList<Integer> open = new ArrayList<Integer>();
		ArrayList<Integer> closed = new ArrayList<Integer>();
		open.add(0); //as default
		int x=0; //or open.get(0);
		while(x!=goal)
		{
        	System.out.println("X=" + symbols[x] + ", Open=" + asChar(open, 1) + ", Closed=" + asChar(closed, 2));
			closed.add(open.get(0));
			open.remove(0);

			for(int c=0 ; c<matrix.length ; c++)
				if(matrix[x][c])
					open.add(c);

			x=open.get(0);
		}
    	System.out.println("X=" + symbols[x] + ", Open=" + asChar(open, 1) + ", Closed=" + asChar(closed, 2));
	}

    private String asChar(ArrayList<Integer> array, int what)
    {
    	String string = "";

    	if(what == 1)
	    	for(int i=0 ; i<array.size() ; i++)
			{
				string+=symbols[array.get(i)];
				if(i != array.size()-1)
					string+=", ";
			}
		else if(what == 2)
			for(int i=array.size()-1 ; i>=0 ; i--)
			{
				string+=symbols[array.get(i)];
				if(i != 0)
					string+=", ";
			}
		return "["+string+"]";
    }
}