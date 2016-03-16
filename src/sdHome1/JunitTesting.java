package sdHome1;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JunitTesting {

	@Test
	public void addCourseTest() {
		
		Courses courseTest=new Courses();
		courseTest.viewCourseTable("courseName");
		courseTest.printTheNo();
		courseTest.addCourse(6,"Fizica","Grasutu",1);
		courseTest.viewCourseTable("courseName");
		assertTrue(courseTest.printTheNo()==6);
		System.out.println("Had 6 rows now we have  :"+courseTest.printTheNo());
	}

	@Test
	public void removeCourseTest() {
		
		Courses courseTest=new Courses();
		courseTest.viewCourseTable("courseName");
		courseTest.printTheNo();
		courseTest.removeCourse(6);
		courseTest.viewCourseTable("courseName");
		assertTrue(courseTest.printTheNo()==5);
		System.out.println("Had 6 rows now we have  :"+courseTest.printTheNo());
	}
}