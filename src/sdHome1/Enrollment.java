package sdHome1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Enrollment {
	
	private int enrollmentNo;
	private int studentId;
	private int courseId;
	
	
	/*public Enrollment(int studentId, int enrollmentNo, int courseId )
	{this.studentId=studentId;
	this.enrollmentNo=enrollmentNo;
	this.courseId=courseId;
	}*/
	
	
	public static void enrollStudentToCourse ( int enrollmentNo,int studentId,int courseId){
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for enrolling a course!");

			Statement sqlState=connection1.createStatement();
			
	if ( (sqlState.executeUpdate("SELECT EXISTS(SELECT idStudent FROM student where idStudent =" + studentId ) == 1)
			&& (sqlState.executeUpdate("SELECT EXISTS(SELECT idcourse FROM course where idCourse =" + courseId )==1) )
	{ 
		sqlState.executeUpdate("Insert into enrollment "+ "values"
	            + " ('"
	            + studentId + "', '"
	            + courseId
	            + "', '"
	            + enrollmentNo          
	            + "')" );
				
				 System.out.println("Course added successful");
				  
	} else System.out.println("The student or the course does not exist");
	
	
	connection1.close();
			
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
