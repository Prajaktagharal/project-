package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.BakerRegister;

@WebServlet("/BakerRegisterController")
public class BakerRegisterController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public BakerRegisterController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bakeryname = request.getParameter("bakeryname");
		String bakername = request.getParameter("bakername");
		String nickname = request.getParameter("nickname");
		String mob = request.getParameter("mob");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String link = request.getParameter("link");
		String about = request.getParameter("about");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String deliveryManagement = request.getParameter("deliveryManagement");
		String dietFilter = request.getParameter("dietFilter");
		
		BakerRegister reg=new BakerRegister();
		reg.setBakeryname(bakeryname);
		reg.setBakername(bakername);
		reg.setNickname(nickname);
		reg.setMob(mob);
		reg.setEmail(email);
		reg.setPass(pass);
		reg.setLink(link);
		reg.setAbout(about);
		reg.setAddress(address);
		reg.setCountry(country);
		reg.setState(state);
		reg.setDeliveryManagement(deliveryManagement);
		reg.setDietFilter(dietFilter);
		
		RegisterDao rd=new RegisterDao();
		int i=rd.saveBakerData(reg);
		if(i>0)
		{
			response.sendRedirect("BakerLogin.html");
		}
		//else 
		//{
      //      response.sendRedirect("ErrorPage.html"); // Redirect to an error page or handle the error accordingly
       // }
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
