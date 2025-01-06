package com.estifo.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.estifo.beans.Category;
import com.estifo.beans.Task;
import com.estifo.beans.User;
import com.estifo.service.TaskDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddTask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String taskDescription = request.getParameter("taskDescription");
        LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("dueDate"));
        Category category = Category.valueOf(request.getParameter("category"));

        try {
            if (user != null) {
                Task task = new Task(taskDescription, dueDate, category, user);
                TaskDAO taskDAO = new TaskDAO();
                taskDAO.add(task);
                response.sendRedirect("home?category=" + category);
            } else {
                System.out.println("User is null");
                request.setAttribute("error", "User session has ended");
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
