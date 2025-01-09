package com.estifo.controller;

import java.io.IOException;

import com.estifo.beans.Task;
import com.estifo.beans.User;
import com.estifo.service.TaskDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteTask")
public class RemoveTask extends HttpServlet {
    private TaskDAO taskDAO = new TaskDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int taskId = Integer.parseInt(req.getParameter("taskId"));

        try {
            if (user != null) {
                Task task = taskDAO.get(taskId);
                if(task != null){
                    taskDAO.delete(taskId);
                }
                resp.sendRedirect("home?category=Miscellaneous");
            } else {
                System.out.println("User is null");
                req.setAttribute("error", "User session has ended");
                RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
                dis.forward(req, resp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
