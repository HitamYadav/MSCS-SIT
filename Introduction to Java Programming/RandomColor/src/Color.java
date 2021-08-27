import java.util.Scanner;
import java.util.Random;
public class Color {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variables
		final int NUM_COLORS = 3;
		
		String userGuess; 		//user's guess
		int rNumber;			// generated random number
		String rColor;			// corresponding color name
		
		//create objects
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Test your ESP skills");
		
		//get a random number
		rNumber = rand.nextInt(NUM_COLORS);

		//get the name of the random number
		if (rNumber ==1) {
			rColor = "red";
		}
		else if (rNumber ==2)
			rColor = "blue";
		else
			rColor = "green";
		
		//prompt the user
		
		System.out.println("Im thinking of a color. IS it red, blue, or green?");
		userGuess = scnr.next();
		
		//compare
		if (userGuess.equals(rColor))
			System.out.println("You won! Good Guess");
		else 
			System.out.println("No the color was " + rColor);
		
	}

}
