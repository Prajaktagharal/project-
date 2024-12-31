package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.BakerRegister;


@WebServlet("/CancelBakerRegistrationController")
public class CancelBakerRegistrationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public CancelBakerRegistrationController() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email = request.getParameter("email");

	     RegisterDao rd = new RegisterDao();
	     boolean isCancelled = rd.cancelRegistration(email);

	        if (isCancelled) 
	        {
	            response.sendRedirect("RegistrationCancelled.html");
	        } 
	        else 
	        {	            
	            response.sendRedirect("RegistrationCancelledError.html");
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
