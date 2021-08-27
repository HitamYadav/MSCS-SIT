import java.util.Scanner;

public class ProgrammingAssignment1 {

	public static void main(String[] args) {
		
	Scanner scnr = new Scanner(System.in);
		
		int num1;
		int num2;
		int num3;
		int num4;
		
		num1 = scnr.nextInt();
		
		
		num2 = scnr.nextInt();		
		
		num3 = scnr.nextInt();		
		
		num4 = scnr.nextInt();		
			   
		int product = num1*num2*num3*num4;
		int average = (num1+num2+num3+num4)/4;
		
		System.out.println(product+" "+average);
		
		//Part 2
		
		 double product2 =  (double) num1*num2*num3*num4;
		 double average2 =  (double)(num1+num2+num3+num4)/4;
		 
		 System.out.printf("%.3f", product2);
		 System.out.print(" ");
		 System.out.printf("%.3f", average2);
		 System.out.println();
		   }


			
			
		}

