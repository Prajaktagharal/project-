package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Login;

@WebServlet("/BakerLoginController")
public class BakerLoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public BakerLoginController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		Login lobj=new Login();
		lobj.setPass(pass);
		lobj.setUserid(email);		
		RegisterDao rd=new RegisterDao();
		boolean b=rd.validateUserBaker(lobj);
		if(b)
		{
			System.out.println("Login successful.....");
			response.sendRedirect("BakerDashBoard.html");
		}
		else
		{
			System.out.println("Login failed.....");
			response.sendRedirect("BakerLogin.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
