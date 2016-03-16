package sdHome1;

import java.sql.*;

public class Student {

	private int studentID;
	private String name;
	private int birthDate;
	private String address;

	int i=0;
	public Student (){
		//this.studentID=studentID;
		//this.name=name;
		//this.birthDate=birthDate;
		//this.address=address;
		
	}
	
	public void addStudent(int studentID,String name,int birthDate,String address)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for adding succesfull!");

			Statement sqlState=connection1.createStatement();
	
			sqlState.executeUpdate("Insert into student "+ " values"
            + " ('"
            + studentID
            + "', '"
            + name
            + "', '"
            + birthDate
            + "', '"
            + address
            + "')" );
			
			 System.out.println("Student inserted successful");
			  connection1.close();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void removeStudent(int studentID)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for removing succesfully!");

			Statement sqlState=connection1.createStatement();
	
			sqlState.executeUpdate("Delete from student "+ " where idStudent="+studentID );
			
			 System.out.println("Student removed successfully");
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(int index,String name,int birthDate,String address)
	{
	
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for updating succesfully!");

			Statement sqlState=connection1.createStatement();
	
			sqlState.executeUpdate("UPDATE student "+"set Name="+ " ' "+ name + " ' "+ " where idStudent like "+index);
			sqlState.executeUpdate("UPDATE student "+"set DateOfBirth="+ birthDate+ " where idStudent like "+index );
			sqlState.executeUpdate("UPDATE student "+"set Address="+ " ' "+ address + " ' "+ " where idStudent like "+index);
			
			
			 System.out.println("Student info updated successfully");
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public int getStudentID() {
		return studentID;
	}

	
	public void viewStudentInfo(String name1){
		Connection connection1;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb?autoReconnect=true&useSSL=false", "root", "B0gd@n94");
		
			System.out.println("Connection to DB for viewing succesfull!");

			Statement sqlState=connection1.createStatement();
			
		
			ResultSet rows=sqlState.executeQuery("Select idStudent, Name, DateOfBirth, Address "
					+ "	from student "
					+ "where Name =" +name1);
			
			while(rows.next()){
				i++;
				System.out.print(rows.getString("idStudent"));
				System.out.print("|");
				System.out.print(rows.getString("Name"));
				System.out.print("|");
				System.out.print(rows.getString("DateOfBirth"));
				System.out.print("|");
				System.out.print(rows.getString("Address"));
			//	System.out.println(rows.getInt("idStudent") + rows.getString("Name"));
				
			}
			printTheNo();
			
			
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
