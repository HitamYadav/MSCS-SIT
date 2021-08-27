public class main {
   
   public String golfScore(int par, int strokes){
      
	   if ((par != 3) && (par != 4) && (par != 5)){
		     return "Error";
		  }
		  else if(strokes <= par - 2){
		     return "Eagle";
		  }
		  else if(strokes <= par -1){
		     return "Birdie";
		  }
		  else if(strokes == par){
		     return "Par";
		  }
		  else{
		     return "Bogey";
		  } 
   }
}
   
   