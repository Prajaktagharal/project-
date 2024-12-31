package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.model.Login;
import com.model.AddProducts;
import com.model.BakerRegister;
import com.model.CustomerRegister;

public class RegisterDao 
{
	static Connection con;
	
	public int saveData(CustomerRegister reg)
	{
		con=MyConnection.MyConnection();
		int i=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into CustomerRegister values(?,?,?,?,?)");
			ps.setString(1, reg.getFname());
			ps.setString(2, reg.getLname());
			ps.setString(3, reg.getMob());
			ps.setString(4, reg.getUserid());
			ps.setString(5, reg.getPass());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;	
	}
	
	public boolean validateUser(Login lobj)
	{
		boolean b=false;
		con=MyConnection.MyConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from CustomerRegister where userid=? and pass=?");
			ps.setString(1,lobj.getUserid());
			ps.setString(2,lobj.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				b=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
	
	public int saveBakerData(BakerRegister reg)
	{
		con=MyConnection.MyConnection();
		int i=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into BakerRegister values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, reg.getBakeryname());
			ps.setString(2, reg.getBakername());
			ps.setString(3, reg.getNickname());
			ps.setString(4, reg.getMob());
			ps.setString(5, reg.getEmail());
			ps.setString(6, reg.getPass());
			ps.setString(7, reg.getLink());
			ps.setString(8, reg.getAbout());
			ps.setString(9, reg.getAddress());
			ps.setString(10, reg.getCountry());
			ps.setString(11, reg.getState());
			ps.setString(12, reg.getDeliveryManagement());
			ps.setString(13, reg.getDietFilter());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;	
	}
	
	public boolean addProduct(AddProducts product) 
	{
        boolean status = false;
        try 
        {
            // Establishing a database connection
            Connection con = MyConnection.MyConnection();

            // SQL query to insert product details
            String query = "INSERT INTO products (name, detail, price, quantity, image_name, image_path) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDetail());
            pstmt.setInt(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getImageName());
            pstmt.setString(6, product.getImagePath());

            int result = pstmt.executeUpdate();
            return result > 0;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return status;
    }
	
	public boolean validateUserBaker(Login lobj)
	{
		boolean b=false;
		con=MyConnection.MyConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from BakerRegister where email=? and pass=?");
			ps.setString(1,lobj.getUserid());
			ps.setString(2,lobj.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				b=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
	
	 public boolean cancelRegistration(String email) 
	 {
	        boolean isCancelled = false;
	        con = MyConnection.MyConnection();

	        try 
	        {
	            PreparedStatement ps = con.prepareStatement("delete from BakerRegister where email = ?");
	            ps.setString(1, email);

	            int result = ps.executeUpdate();
	            isCancelled = result > 0;
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }

	        return isCancelled;
	  }
}
