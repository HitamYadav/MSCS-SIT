package test;
import java.util.Scanner;

public class OutputWithVars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		      Scanner scnr = new Scanner(System.in);
		      int userNum;

		      System.out.println("Enter integer:");
		      userNum = scnr.nextInt();  
		      
		      System.out.println("You entered: " + (userNum));
		      System.out.print ((userNum) + " squared is ");
		      System.out.println((userNum*userNum));
		      System.out.println("and " + userNum + " cubed is " + (userNum*userNum*userNum*userNum));
		   }
		}
	

