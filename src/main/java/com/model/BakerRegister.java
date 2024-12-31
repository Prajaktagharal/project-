
package com.model;

public class BakerRegister 
{
    private String bakeryname;
    private String bakername;
    private String nickname;
    private String mob;
    private String email;
    private String pass;
    private String link;
    private String about;
    private String address;
    private String country;
    private String state;
    private String deliveryManagement;
    private String dietFilter;

    // Default Constructor
    public BakerRegister() 
    {
    }

    // Parameterized Constructor
    public BakerRegister(String bakeryname, String bakername, String nickname, String mob, String email, 
                         String pass, String link, String about, String address, String country, 
                         String state, String deliveryManagement, String dietFilter) 
    {
        this.bakeryname = bakeryname;
        this.bakername = bakername;
        this.nickname = nickname;
        this.mob = mob;
        this.email = email;
        this.pass = pass;
        this.link = link;
        this.about = about;
        this.address = address;
        this.country = country;
        this.state = state;
        this.deliveryManagement = deliveryManagement;
        this.dietFilter = dietFilter;
    }

    // Getters and Setters

    public String getBakeryname() 
    {
        return bakeryname;
    }

    public void setBakeryname(String bakeryname) 
    {
        this.bakeryname = bakeryname;
    }

    public String getBakername() 
    {
        return bakername;
    }

    public void setBakername(String bakername) 
    {
        this.bakername = bakername;
    }

    public String getNickname() 
    {
        return nickname;
    }

    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getMob() 
    {
        return mob;
    }

    public void setMob(String mob) 
    {
        this.mob = mob;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPass() 
    {
        return pass;
    }

    public void setPass(String pass) 
    {
        this.pass = pass;
    }

    public String getLink() 
    {
        return link;
    }

    public void setLink(String link) 
    {
        this.link = link;
    }

    public String getAbout() 
    {
        return about;
    }

    public void setAbout(String about) 
    {
        this.about = about;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    public String getDeliveryManagement() 
    {
        return deliveryManagement;
    }

    public void setDeliveryManagement(String deliveryManagement) 
    {
        this.deliveryManagement = deliveryManagement;
    }

    public String getDietFilter() 
    {
        return dietFilter;
    }

    public void setDietFilter(String dietFilter) 
    {
        this.dietFilter = dietFilter;
    }
}
