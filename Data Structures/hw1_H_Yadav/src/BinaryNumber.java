// By: Hitam Yadav
import java.util.*;
public class BinaryNumber {
	
	
	
	private int[] data;
	private boolean overflow;
	
	
	
	public BinaryNumber(int length) {
		try {	
			data = new int[length];
			overflow = false;
		} 
		catch(Exception e){
			System.out.println("Cannot Create with given parameters");
		}
	}

	
	public BinaryNumber(String str) {
		
		try { 
			data = new int[str.length()];

			
			//1011
			for (int i=0;i<str.length() ;i++) {

			data[i] = Character.getNumericValue(str.charAt(i));

			}	

			overflow = false; 
		} 
		catch(Exception e){
			System.out.println("Cannot Create with given parameters");
		}
		
		
	}
	
	public int getLength() {
		try {
			return data.length;
		} catch (Exception e) {
			System.out.println("Cannot find length");
			return -1;
		}
		
	}
	
	public int getDigit(int index) {
		try {
		return data[index];
		} catch(Exception e) {
			System.out.println("Index out of bounds");
			return -1;
		}
	}
	
	public int toDecimal() {
		try {
			StringBuilder sb = new StringBuilder();
	        for(int i : data) sb.append(i);

	        return Integer.parseInt(sb.toString(),2 );

		} catch(Exception e) {
			System.out.println("Decimal out of bounds");
			return -1;
	}
	}
	
	public void shiftR(int amount) {
		try {
			int copyData[]= Arrays.copyOf(data,getLength()+amount);
			//10560000 
			//00001056
			//data = 1056
			// i want x amount of indexes to be 0
			// i want the 
			for (int i =0; i<amount; i++) {
				copyData[i] =0;
			}
			//00001056
			//trying to start with 4th index
			for (int j=amount; j<copyData.length; j++) {
				copyData[j] = data[j-amount];
				
			}
			data = copyData;
		} catch (Exception e) {
			System.out.println("Decimal out of bounds");
	}
		
	}
	
	public void add (BinaryNumber aBinaryNumber) {
		try {
			if(this.getLength() != aBinaryNumber.getLength()) {
	            System.out.println("Lengths of binary numbers don't match.");
	            return; 
	        }

	        StringBuilder sb = new StringBuilder();
	        int len = this.getLength();
	        int carry = 0;
	        for(int i = len - 1; i >= 0; i--) {
	          if (this.getDigit(i) == 1) carry++;
	          if (aBinaryNumber.getDigit(i) == 1) carry++;

	          if (carry % 2 == 1) sb.append(1);
	          else sb.append(0);

	          carry /= 2;
	        }
	        if (carry == 1) sb.append(1);
	        sb.reverse();


	        int[] copy = new int[sb.length()];
	        if(sb.length() > this.getLength()){
	            this.overflow = true;
	            aBinaryNumber.overflow = true; 
	        }

	        for(int i = 0; i < sb.length(); i++) {
	            copy[i] = sb.charAt(i) - '0'; 
	        }
	        data = copy;

		} catch (Exception e) {
			System.out.println("out of bounds");
	}
		
	}
	
	public String toString() {
		try {
			String str ="";

			for (int i=0;i<getLength();i++) {

			str+=data[i];
			
			}

			return this.overflow ? "Overflow" : str;
			
		} catch (Exception e) {
			System.out.println("out of bounds");
			return("");
	}
	}
	
	
	public void clearOverflow() {
		try {
			this.overflow = false; 
		} catch (Exception e) {
			System.out.println(" out of bounds");
		
	}
	
}
}