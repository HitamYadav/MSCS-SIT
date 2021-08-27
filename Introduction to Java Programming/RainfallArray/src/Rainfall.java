import java.util.Scanner;

public class Rainfall {
	
	
	//populate the array with the conents of the input file
	private static void populate ( float[] rainAmt)
	{
		Scanner scnr = new Scanner(System.in);
		
		for (int i = 0; i < rainAmt.length; i++)
		{
			System.out.printf("Enter rainfall for month %d: ", i + 1);
			rainAmt [i] = scnr.nextFloat();
		}
	}

}
