package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Login;

@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public CustomerLoginController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userid=request.getParameter("userid");
		String pass=request.getParameter("pass");
		
		Login lobj=new Login();
		lobj.setPass(pass);
		lobj.setUserid(userid);		
		RegisterDao rd=new RegisterDao();
		boolean b=rd.validateUser(lobj);
		if(b)
		{
			System.out.println("Login successful...");
			response.sendRedirect("DashBoard.html");
		}
		else
		{
			System.out.println("Login failed.....");
			response.sendRedirect("CustomerLogin.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
