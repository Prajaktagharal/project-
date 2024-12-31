package com.model;

public class CustomerRegister 
{
    private String fname;
    private String lname;
    private String mob;
    private String userid;
    private String pass;

    // Default Constructor
    public CustomerRegister() 
    {
    }

    // Parameterized Constructor
    public CustomerRegister(String fname, String lname, String mob, String userid, String pass) 
    {
        this.fname = fname;
        this.lname = lname;
        this.mob = mob;
        this.userid = userid;
        this.pass = pass;
    }

    // Getters and Setters

    public String getFname() 
    {
        return fname;
    }

    public void setFname(String fname) 
    {
        this.fname = fname;
    }

    public String getLname() 
    {
        return lname;
    }

    public void setLname(String lname) 
    {
        this.lname = lname;
    }

    public String getMob() 
    {
        return mob;
    }

    public void setMob(String mob) 
    {
        this.mob = mob;
    }

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
