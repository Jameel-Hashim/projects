//func: for how many lines{how many odd number} and space{how many odd number-1 but Reflaction no need}
public class Stars
{
	public static void main(String args[])
	{
		int min = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[1]);

		/*if(min%2 == 0 || max%2 == 0) //catch error
		{
			System.out.println("!!Error!!: Min and Max Must Be Odd Numbers");
			System.exit(0);
		}*/

		//functtion > {how many odd number from 1 to max, - 1} to know lines number
		int spaceMax=0;
		for(int lines=min ; lines<=max ; lines++) //how many lines
			if(lines%2 != 0)
				spaceMax++;
		spaceMax--;

		for(int lines=min ; lines<=max ; lines++) //how many lines
			if(lines%2 != 0)
			{
				for(int space=spaceMax ; space>0 ; space--) //spaces
					System.out.print(" ");
				spaceMax--;

				for(int oddNum=0 ; oddNum<lines ; oddNum++) //print odd stars
					System.out.print("*");
				System.out.println();
			}

		//Reflection
		spaceMax=1;
		for(int lines=max-1 ; lines>=min ; lines--) //how many lines
			if(lines%2 != 0)
			{
				for(int space=0 ; space<spaceMax ; space++) //spaces
					System.out.print(" ");
				spaceMax++;

				for(int oddNum=0 ; oddNum<lines ; oddNum++) //print odd stars
					System.out.print("*");
				System.out.println();
			}
	}
}