import java.util.Scanner;
import java.util.ArrayList;

class Astar
{
    private String symbols[];
	private int h_values[];
    private int g_values[][];
    private Integer f_values[][];

	protected Astar(String symbols[], int h_values[])
	{
		this.symbols = symbols;
        this.h_values = h_values;
        g_values = new int[symbols.length][symbols.length];
        f_values = new Integer[symbols.length][symbols.length];
	}

    protected void addEdge(int r, int c, int g_value)
    {
        g_values[r][c] = g_value;
    }
 
	protected ArrayList<String> run()
	{
        ArrayList<String> open = new ArrayList<String>();
        ArrayList<String> closed = new ArrayList<String>();
        open.add("0-4"); //start with this state
        int x=0; //or next(open.get(0));
        while(x!=5)
        {
        	System.out.println("X=" + symbols[x] + ", Open=" + asChar(open, 1) + ", Closed=" + asChar(closed, 2));
        	closed.add(open.get(0));
        	open.remove(0);

        	for(int c=0 ; c<f_values.length ; c++) //get childrens
        		if(f_values[x][c] != null)
        			open.add(c+"-"+f_values[x][c]);

        	open=sort(open);
        	x=next(open.get(0));
        }
    	System.out.println("X=" + symbols[x] + ", Open=" + asChar(open, 1) + ", Closed=" + asChar(closed, 2));
    	System.out.println("\nTotal Cost: " + get_value(open.get(0)));
    	
        closed.add(open.get(0));
        return closed;
    }

    private String asChar(ArrayList<String> array, int what)
    {
    	String string = "";

    	if(what == 1)
	    	for(int i=0 ; i<array.size() ; i++)
			{
				string+=symbols[next(array.get(i))] + get_value(array.get(i));
				if(i != array.size()-1)
					string+=", ";
			}
		else if(what == 2)
			for(int i=array.size()-1 ; i>=0 ; i--)
			{
				string+=symbols[next(array.get(i))] + get_value(array.get(i));
				if(i != 0)
					string+=", ";
			}
		return "["+string+"]";
    }

    protected void play() //f(n)
    {
        f_values[0][1] = g_values[0][1] + h_values[1];
            f_values[1][2] = g_values[0][1] + g_values[1][2] + h_values[2];
                f_values[2][4] = g_values[0][1] + g_values[1][2] + g_values[2][4] + h_values[4];
            f_values[1][3] = g_values[0][1] + g_values[1][3] + h_values[3];
                f_values[3][4] = g_values[0][1] + g_values[1][3] + g_values[3][4] + h_values[4];
                    f_values[4][5] = g_values[0][1] + g_values[1][3] + g_values[3][4] + g_values[4][5] + h_values[5];
                f_values[3][5] = g_values[0][1] + g_values[1][3] + g_values[3][5] + h_values[5];
        f_values[0][5] = g_values[0][5] + h_values[5];
    }

    private ArrayList sort(ArrayList<String> array)
    {
    	for(int i=0 ; i<array.size() ; i++)
    	{
    		int min=i;
    		for(int c=i+1 ; c<array.size() ; c++)
    			if(get_value(array.get(c))<get_value(array.get(min)))
    				min = c;

    		String tmp = array.get(min);
    		array.set(min, array.get(i));
    		array.set(i, tmp);
    	}

    	return array;
    }

    private int next(String string)
    {
    	String new_string[] = string.split("-");
    	return Integer.parseInt(new_string[0]);
    }

    private int get_value(String string)
    {
    	String new_string[] = string.split("-");
    	return Integer.parseInt(new_string[1]);
    }

    protected void print_result(ArrayList<String> closed)
    {
        /*System.out.println("\nCost For Every State: ");
        System.out.println("-------------------------------------------------");
        System.out.println("|     State" + "\t||" + "     h(n)" + "\t|" + "      f(n)" + "\t|");
        System.out.println("-------------------------------------------------");
        for(int i=0 ; i<closed.size() ; i++)
        {
            System.out.println("|\t" + symbols[next(closed.get(i))] + "\t||\t" + h_values[next(closed.get(i))] + "\t|\t" + get_value(closed.get(i)) + "\t|");
            System.out.println("-------------------------------------------------");
        }*/
    }
}