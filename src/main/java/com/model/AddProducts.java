package com.model;

public class AddProducts 
{
	    private String name;
	    private String detail;
	    private int price;
	    private int quantity;
	    private String imageName;
	    private String imagePath;

	    public AddProducts(String name, String detail, int price, int quantity, String imageName, String imagePath) 
	    {
	        this.name = name;
	        this.detail = detail;
	        this.price = price;
	        this.quantity = quantity;
	        this.imageName = imageName;
	        this.imagePath = imagePath;
	    }

	    // Getters and Setters

	    public String getName() 
	    {
	        return name;
	    }

	    public void setName(String name) 
	    {
	        this.name = name;
	    }

	    public String getDetail() 
	    {
	        return detail;
	    }

	    public void setDetail(String detail) 
	    {
	        this.detail = detail;
	    }

	    public int getPrice() 
	    {
	        return price;
	    }

	    public void setPrice(int price) 
	    {
	        this.price = price;
	    }

	    public int getQuantity() 
	    {
	        return quantity;
	    }

	    public void setQuantity(int quantity) 
	    {
	        this.quantity = quantity;
	    }

	    public String getImageName() 
	    {
	        return imageName;
	    }

	    public void setImageName(String imageName) 
	    {
	        this.imageName = imageName;
	    }

	    public String getImagePath() 
	    {
	        return imagePath;
	    }

	    public void setImagePath(String imagePath) 
	    {
	        this.imagePath = imagePath;
	    }
}
