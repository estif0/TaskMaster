package com.estifo.controller;

import com.estifo.service.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import com.estifo.beans.User;
import com.estifo.beans.Gender;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)
public class UserController extends HttpServlet {
    private Map<Integer, User> users = new HashMap<>();
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

        UserDAO userDAO = new UserDAO();
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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = users.get(userId);

        if (user != null) {
            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setGender(Gender.valueOf(req.getParameter("gender")));


            resp.getWriter().write("User updated with ID: " + userId);
        } else {
            resp.getWriter().write("User not found with ID: " + userId);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = users.remove(userId);

        if (user != null) {
            resp.getWriter().write("User deleted with ID: " + userId);
        } else {
            resp.getWriter().write("User not found with ID: " + userId);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = users.get(userId);

        if (user != null) {
            resp.getWriter().write(user.toString());
        } else {
            resp.getWriter().write("User not found with ID: " + userId);
        }
    }
}
