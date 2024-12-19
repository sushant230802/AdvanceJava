package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Connection connection=null;
//		Statement stInsert=null;
//		Scanner sc=null;
	
		
		try(
			Scanner sc=new Scanner(System.in);	
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			PreparedStatement prepareStatement=connection.prepareStatement("insert into users(username,email) values(?,?)");
				)
		{
			System.out.println("enter username:");
			String userName=sc.nextLine();
			System.out.println("enter email:");
			String email=sc.nextLine();
			
			prepareStatement.setString(1,userName);
			prepareStatement.setString(2,email);
			prepareStatement.executeUpdate();
			System.out.println("Record saved");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
