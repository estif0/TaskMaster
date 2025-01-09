package com.estifo.controller;

import java.io.IOException;

import com.estifo.beans.Gender;
import com.estifo.beans.User;
import com.estifo.service.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        User user = new User(firstName, lastName, userName, email, password, gender);
        if(userDAO.add(user)) {
            resp.sendRedirect("login.jsp");
        }
        else {
            resp.sendRedirect("signup.jsp");
        }
    }
}
