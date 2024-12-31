package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection 
{
	public static Connection MyConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/baker","root","Prajakta@123");
			System.out.println("Connection.."+con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
