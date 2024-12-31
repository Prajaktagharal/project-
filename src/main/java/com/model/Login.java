package com.model;

public class Login 
{
    private String userid;
    private String pass;

    // Default Constructor
    public Login() 
    {
    	
    }
    // Parameterized Constructor
    public Login(String userid, String pass) 
    {
        this.userid = userid;
        this.pass = pass;
    }

    // Getters and Setters

    public String getUserid() 
    {
        return userid;
    }

    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getPass() 
    {
        return pass;
    }

    public void setPass(String pass) 
    {
        this.pass = pass;
    }
}
