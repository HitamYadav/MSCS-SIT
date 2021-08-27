import java.util.Scanner;
public class Statistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Part 1
	Scanner scnr = new Scanner(System.in);
	
	int num1;
	int num2;
	int num3;
	int num4;
	
	
	System.out.print("Enter a number: ");
	num1 = scnr.nextInt();
	
	System.out.print("Enter a number: ");
	num2 = scnr.nextInt();		
	
	System.out.print("Enter a number: ");
	num3 = scnr.nextInt();		
	
	System.out.print("Enter a number: ");
	num4 = scnr.nextInt();		
		   
	int product = num1*num2*num3*num4;
	int average = (num1+num2+num3+num4)/4;
	
	System.out.println(product+" "+average);
	
	//Part 2
	
	 double product2 = num1*num2*num3*num4;
	 double average2 =  (double)(num1+num2+num3+num4)/4;
	 
	 System.out.printf("%.3f", product2);
	 System.out.print(" ");
	 System.out.printf("%.3f", average2);
	   }


		
		
	}

