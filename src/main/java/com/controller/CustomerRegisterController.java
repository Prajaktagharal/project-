package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.CustomerRegister;


@WebServlet("/CustomerRegisterController")
public class CustomerRegisterController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public CustomerRegisterController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String mob=request.getParameter("mob");
		String userid=request.getParameter("userid");
		String pass=request.getParameter("pass");
		
		CustomerRegister reg=new CustomerRegister();
		reg.setFname(fname);
		reg.setLname(lname);
		reg.setMob(mob);
		reg.setUserid(userid);
		reg.setPass(pass);
		
		RegisterDao rd=new RegisterDao();
		int i=rd.saveData(reg);
		if(i>0)
		{
			response.sendRedirect("CustomerLogin.html");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
