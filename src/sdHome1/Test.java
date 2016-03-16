package sdHome1;

import java.sql.*;

public class Test {
	
	public static void main (String []args){
		
		
		try {
			Connection connection1= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
			System.out.println("Connection to mysql DB done!");
		
		/*	
			Statement sqlState=connection1.createStatement();
			String selectStuff="Select Name from student";
			ResultSet rows=sqlState.executeQuery(selectStuff);
			while(rows.next()){
				System.out.println(rows.getString("Name"));
			}
			*/
			
	
		Courses course= new Courses();
		//	Student student1=new Student();
		//	Enrollment enroll=null;
			//student1.addStudent(5,"Dan", 1993, "Vlaicu");
course.viewCourseTable("MATE");
//enroll.enrollStudentToCourse(1, 2, 3213);
			
		} catch (SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}

	

}
