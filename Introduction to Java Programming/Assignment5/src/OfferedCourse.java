
public class OfferedCourse extends Course {
		
		String instructorName;
	    String term;
	    String classTime;

	    public String getInstructorName() {
	        return instructorName;
	    }
	    
	    public void setInstructorName(String instructorName) {
	        this.instructorName = instructorName;
	    }
	   

	    public String getTerm() {
	        return term;
	    } 
	    
	    public void setTerm(String term) {
	        this.term = term;
	    }

	    public String getClassTime() {
	        return classTime;
	    }

	 

	    public void setClassTime(String classTime) {
	        this.classTime = classTime;
	    }
	    

	    public void printInfo(){
	        super.printInfo();
	        System.out.println("   Instructor Name: " + getInstructorName());
	        System.out.println("   Term: " + getTerm());
	        System.out.println("   Class Time: " + getClassTime());

	    
	}
}


