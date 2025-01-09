package com.estifo.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.estifo.beans.Category;
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

@WebServlet("/finishTask")
public class FinishTask extends HttpServlet {
    private TaskDAO taskDAO = new TaskDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Category category = Category.valueOf(req.getParameter("category"));
        int taskId = Integer.parseInt(req.getParameter("taskId"));

        try {
            if (user != null) {
                Task task = taskDAO.get(taskId);
                if(task != null){
                    task.setDone(true);
                    task.setFinishedDate(LocalDateTime.now());
                    taskDAO.update(task);
                }
                resp.sendRedirect("home?category=" + category);
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
