package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Connection connection=null;
//		Statement stInsert=null;
//		Scanner sc=null;
	
		
		try(
			Scanner sc=new Scanner(System.in);	
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
			Statement stInsert=connection.createStatement();
				)
		{
			System.out.println("enter username:");
			String userName=sc.nextLine();
			System.out.println("enter password:");
			String password=sc.nextLine();
			System.out.println("enter name:");
			String name=sc.nextLine();
			System.out.println("enter email:");
			String email=sc.nextLine();
			stInsert.executeUpdate("insert into users values('"+ userName+"','"+password+"','"+
					name+"','"+email+"')");
			System.out.println("Record saved");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
