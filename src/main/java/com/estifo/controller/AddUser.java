package com.estifo.controller;

import java.io.IOException;

import com.estifo.beans.Gender;
import com.estifo.beans.User;
import com.estifo.service.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
//    private String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        

//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
//
//        Part part= req.getPart("image");

        User user = new User(firstName, lastName, userName, email, password, gender);

        if(userDAO.add(user)) {
//            if(!userName.equals("")) {
//                String path = uploadPath + File.separator +userName;
//                part.write(path);
//            }
            resp.sendRedirect("login.jsp");
        }
        else {
            resp.sendRedirect("signup.jsp");
        }
    }
}
