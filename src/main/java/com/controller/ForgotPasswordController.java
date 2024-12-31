package com.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ForgotPasswordController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        if (email != null && !email.equals("")) {
            // sending otp
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);

            String to = email; // recipient email
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() 
            {
                protected PasswordAuthentication getPasswordAuthentication() 
                {
                    return new PasswordAuthentication("your_email", "your_app_password"); // Replace with your email and app password
                }
            });

            try 
            {
                // compose message
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("your_email")); // Replace with your email
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("OTP Verification");
                message.setText("Your OTP is: " + otpvalue);

                // send message
                Transport.send(message);
                System.out.println("Message sent successfully");

                dispatcher = request.getRequestDispatcher("EnterOTP.jsp");
                request.setAttribute("message", "OTP has been sent to your email ID");
                mySession.setAttribute("otp", otpvalue);
                mySession.setAttribute("email", email);
                dispatcher.forward(request, response);
            } 
            catch (MessagingException e) 
            {
                e.printStackTrace();
                request.setAttribute("message", "Failed to send OTP. Please try again.");
                dispatcher = request.getRequestDispatcher("ForgotPassword.html");
                dispatcher.forward(request, response);
            }
        }
        else 
        {
            request.setAttribute("message", "Invalid email address.");
            dispatcher = request.getRequestDispatcher("ForgotPassword.html");
            dispatcher.forward(request, response);
        }
    }
}

