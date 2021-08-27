import java.util.Scanner;
public class CourseInformation {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		
		Course courseInfo = new Course();
		OfferedCourse theCourse = new OfferedCourse ();
		
		courseInfo.setCourseNumber(scnr.nextLine());
		courseInfo.setCourseTitle(scnr.nextLine());
		theCourse.setCourseNumber(scnr.nextLine());
		theCourse.setCourseTitle(scnr.nextLine());
		theCourse.setInstructorName(scnr.nextLine());
		theCourse.setTerm(scnr.nextLine());
		theCourse.setClassTime(scnr.nextLine());

        courseInfo.printInfo();
        theCourse.printInfo();

	}

}
