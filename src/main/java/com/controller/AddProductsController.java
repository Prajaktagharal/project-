package com.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.RegisterDao;
import com.model.AddProducts;

@WebServlet("/AddProductsController")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class AddProductsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddProductsController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form data
            String productName = request.getParameter("pname");
            String productDetail = request.getParameter("productdetail");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Handle file upload
            Part filePart = request.getPart("fileUpload");
            String fileName = extractFileName(filePart);

            // Define the upload directory and create it if it doesn't exist
            String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) 
            {
                uploadDirFile.mkdir();
            }

            // Define the complete file path for storing the uploaded file
            String filePath = uploadDir + File.separator + fileName;
            
            // Write the file to the upload directory
            filePart.write(filePath);

            // Create product object
            AddProducts product = new AddProducts(productName, productDetail, price, quantity, fileName, filePath);

            // Save product to database using DAO (Data Access Object)
            RegisterDao registerDao = new RegisterDao();
            boolean result = registerDao.addProduct(product);

            // Redirect or respond based on result
            if (result) 
            {
                response.sendRedirect("DashBoard.html");
            } 
            else 
            {
                response.sendRedirect("AddProducts.html");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    // Extracts file name from the content-disposition header
    private String extractFileName(Part part) 
    {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) 
        {
            if (s.trim().startsWith("filename")) 
            {
                // Extract and sanitize the filename
                String fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return new File(fileName).getName(); // Strip any path information
            }
        }
        return "";
    }
}
