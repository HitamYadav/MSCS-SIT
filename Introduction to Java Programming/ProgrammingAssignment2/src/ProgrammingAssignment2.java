import java.util.Scanner;
public class ProgrammingAssignment2 {
	
	public static void main (String[] args) {
	Scanner scnr = new Scanner(System.in);
	int holePar;
    int userScore;
    
   // System.out.println("enter par # for the hole");
    holePar =  scnr.nextInt();
   // System.out.println("enter your score");
    userScore = scnr.nextInt();
    
    if (holePar == 3 || holePar == 4 || holePar == 5) {
        if ( (holePar - userScore)  == 2) { 
             System.out.println("Eagle"); 
             }
        else if ((holePar - userScore) ==1){
        	System.out.println("Birdie");
        }
        else if ((userScore - holePar) ==1){
        	System.out.println("Bogey");
        }
        
        else if ((holePar - userScore) ==0){
        	System.out.println("Par");
        }
   }
   else { 
          System.out.println("Error");
   }
    
	}
}
   