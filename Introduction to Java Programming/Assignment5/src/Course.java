
public class Course {
	
	private String courseNum;
	private String courseTitle;

public String getCourseNumber() {
    return courseNum;
    }

public void setCourseNumber(String courseNum) {
    this.courseNum = courseNum;
    }

public String getCourseTitle() {
    return courseTitle;
    }

public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
    }

public void printInfo(){
    System.out.println("Course Information: ");
    System.out.println("   Course Number: " + getCourseNumber());
    System.out.println("   Course Title: " + getCourseTitle());
    }

}
