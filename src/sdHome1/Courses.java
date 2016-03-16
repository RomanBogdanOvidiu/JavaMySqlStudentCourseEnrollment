package sdHome1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Courses {

	private int courseID;
	private String courseName;
	private String teacherName;
	private int studyYear;
	int i=0;


	
	public Courses (){
	//	this.courseID=courseID;
	//	this.courseName=name;
	//	this.teacherName=teacherName;
	//	this.studyYear=studyYear;
		
	}
	
	public int getCourseID() {
		// TODO Auto-generated method stub
		return courseID;
	}

	public void addCourse(int courseID,String name,String teacherName,int studyYear)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for adding a course!");

			Statement sqlState=connection1.createStatement();
	
		int rs=sqlState.executeUpdate("Insert into course "+ "values"
            + " ('"
            + courseID
            + "', '"
            + name
            + "', '"
            + teacherName
            + "', '"
            + studyYear
            + "')" );
			
			
			 System.out.println("Course added successful");
			  connection1.close();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void removeCourse(int courseID)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for removing a course succesfully!");

			Statement sqlState=connection1.createStatement();
	
			sqlState.executeUpdate("Delete from course "+ "where idcourse="+courseID );
			
			 System.out.println("Course removed successfully");
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void updateCourse(int index,String cName,String teacherName,int year)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for updating succesfully!");

			Statement sqlState=connection1.createStatement();
	
			sqlState.executeUpdate("UPDATE course "+"set courseName="+ cName+ "where idcouse="+index);
			sqlState.executeUpdate("UPDATE course "+"set teacherName="+ teacherName+ "where idcouse= "+index );
			sqlState.executeUpdate("UPDATE course "+"set studyYear="+ year+ "where idcouse= "+index);
			
			
			 System.out.println("Course info updated successfully");
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void viewCourseTable(String name1){
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for viewing succesfull!");

			Statement sqlState=connection1.createStatement();
			
		
			ResultSet rows=sqlState.executeQuery("Select idcourse, courseName, teacherName, studyYear "
					+ "	from course "
					+ "where courseName like " + "'" + name1 + "'");
			
			i=0;
			while(rows.next()){
i++;
				System.out.print(rows.getString("idcourse"));
				System.out.print("|");
				System.out.print(rows.getString("courseName"));
				System.out.print("|");
				System.out.print(rows.getString("teacherName"));
				System.out.print("|");
				System.out.print(rows.getString("studyYear"));
				System.out.println();
			}
			System.out.println("ATATEA IS: " +i);
			 System.out.println("This is your student table");
			  connection1.close();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		
		

	}
	
	public int printTheNo(){
		System.out.println("ATATEA IS: " +i);
		return i;
		}
	
}
