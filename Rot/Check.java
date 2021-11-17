import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Check
{
	public static void main(String args[]) throws FileNotFoundException
	{
		File inputFile = new File("/home/jameel/JavaProjects/DONE/Rot/input");
		Scanner input = new Scanner(inputFile);

		File outputFile = new File("/home/jameel/JavaProjects/DONE/Rot/ex");
		Scanner output = new Scanner(outputFile);

		//System.out.println(input.next());

		boolean good = true;
		//String s = null;
		while(input.hasNext())
		{
			if(!input.next().equals(output.next()))
				good = false;
		}

		if(good)
			System.out.println("**Matching**");
		else
			System.out.println("!!Not Matching!!");
	}
}