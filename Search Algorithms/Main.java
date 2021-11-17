public class Main
{
	public static void main(String[] args)
	{
		/*String symbols[] = {"S","A","B","C","D","G"};
		int h_values[] = {4,2,6,2,3,0};

        System.out.println("The h(n) for every state:");
		System.out.println("---------------------------------");
		System.out.println("|     "+"State" + "\t||     " + "h(n)" + "\t|");
		System.out.println("---------------------------------");
		for(int i=0 ; i<symbols.length ; i++)
		{
			System.out.println("|\t" + symbols[i] + "\t||\t" + h_values[i] + "\t|");
			System.out.println("---------------------------------");
		}

		Astar a_star = new Astar(symbols, h_values);
		a_star.addEdge(0,1, 1);
		a_star.addEdge(0,5, 12);
		a_star.addEdge(1,2, 3);
		a_star.addEdge(1,3, 1);
		a_star.addEdge(2,4, 3);
		a_star.addEdge(3,4, 1);
		a_star.addEdge(3,5, 2);
		a_star.addEdge(4,5, 3);
		a_star.play(); //get f(n)
		a_star.print_result(a_star.run());*/

		/*Character symbols[] = {'A','B','C','D','E','F','G','H','I'};
		Depth depth = new Depth(symbols, 6); //num_nodes, goal
		depth.addEdge(0, 1);
		depth.addEdge(0, 2);
		depth.addEdge(0, 3);
		depth.addEdge(1, 4);
		depth.addEdge(2, 5);
		depth.addEdge(2, 6);
		depth.addEdge(3, 7);
		depth.addEdge(5, 8);
		depth.run();*/

		Character symbols[] = {'A','B','C','D','E','F','G','H','I'};
		Breadth breadth = new Breadth(symbols, 6); //num_nodes, goal
		breadth.addEdge(0, 1);
		breadth.addEdge(0, 2);
		breadth.addEdge(0, 3);
		breadth.addEdge(1, 4);
		breadth.addEdge(2, 5);
		breadth.addEdge(2, 6);
		breadth.addEdge(3, 7);
		breadth.addEdge(5, 8);
		breadth.run();
	}
}