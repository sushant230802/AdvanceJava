package com.cdac.acts.assigns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
	private static Scanner sc=new Scanner(System.in);
	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static ResultSet result;
	
	private static void registerUser() {
		System.out.println("enter Username");
		String userName=sc.nextLine();
		System.out.println("enter password");
		String password=sc.nextLine();
		System.out.println("enter name");
		String name=sc.nextLine();
		System.out.println("enter email");
		String email=sc.nextLine();
		System.out.println("enter city");
		String city=sc.nextLine();
		
		String insertQuery=""
				+ "INSERT INTO user (username, password, name, email, city) "
				+ "values(?,?,?,?,?)";
		try {
			prepareStatement=connection.prepareStatement(insertQuery);
			prepareStatement.setString(1,userName);
			prepareStatement.setString(2,password);
			prepareStatement.setString(3,name);
			prepareStatement.setString(4,email);
			prepareStatement.setString(5,city);
			prepareStatement.executeUpdate();
			System.out.println("user registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void listUsers(String city) {
		String selectQuery="select * from user where city=?";
		try {
			prepareStatement=connection.prepareStatement(selectQuery);
			prepareStatement.setString(1, city);
			result=prepareStatement.executeQuery();
			while(result.next()) {
				System.out.print(result.getString(1)+" ");
				System.out.print(result.getString(2)+" ");
				System.out.print(result.getString(3)+" ");
				System.out.print(result.getString(4)+" ");
				System.out.print(result.getString(5)+" ");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(result!=null) 
					result.close();
				if(prepareStatement!=null)
					prepareStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void updatePassword(String userName,String newPassword) {
		String updateQuery="update user set password=? where username=?";
		try {
			prepareStatement=connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, newPassword);
			prepareStatement.setString(2, userName);
			prepareStatement.executeUpdate();
			System.out.println("password updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void displayMenu() {
		int choice=0;
		do {
			System.out.println("\nMenu:");
            System.out.println("1. Register a User");
            System.out.println("2. List All Users Based on City");
            System.out.println("3. Update Password of a User");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

           choice = sc.nextInt();
           sc.nextLine();
           switch(choice) {
           case 1:
           {
        	   registerUser();
           }break;
           case 2:
           {
        	System.out.println("enter the city name");
        	String city=sc.nextLine();
        	listUsers(city);
           }break;
           case 3:
           {
        	System.out.println("enter the username");
        	String userName=sc.nextLine();
        	System.out.println("enter the new password");
        	String newPassword=sc.nextLine();
        	updatePassword(userName,newPassword);
           }break;
           case 4:{
        	   System.exit(choice);
           }break;
           }
		}while(choice!=0);
	}
	
	public static void main(String[] args) {
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_pune","root","cdac");
				displayMenu();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}
}
