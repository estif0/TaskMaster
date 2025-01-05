package com.estifo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

public class TaskController extends HttpServlet {
    private Map<Integer, Task> tasks = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        Task task = tasks.get(taskId);
        if (task != null) {
            response.getWriter().write(task.toString());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Task not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession();

        User user = (User) sess.getAttribute("user");
        String taskDescription = request.getParameter("taskDescription");

        LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("dueDate"));
        System.out.println(dueDate);

        Category category = Category.valueOf(request.getParameter("category"));

        try {
            if (user != null) {
                Task task = new Task(taskDescription, dueDate, null, category, user);
                TaskDAO taskDAO = new TaskDAO();
                taskDAO.add(task);
                response.sendRedirect("home?category=" + category);
            } else {
                System.out.println("User is null");
                request.setAttribute("error", "User does not exist");
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        Task task = tasks.get(taskId);
        if (task != null) {
            String taskDescription = request.getParameter("taskDescription");
            LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("dueDate"));
            LocalDateTime finishedDate = LocalDateTime.parse(request.getParameter("finishedDate"));
            // Category category = new Category(); // Assuming Category object creation
            // User user = new User(); // Assuming User object creation

            // task.setTaskDescription(taskDescription);
            // task.setDueDate(dueDate);
            // task.setFinishedDate(finishedDate);
            // task.setCategory(category);
            // task.setUser(user);

            response.getWriter().write("Task updated with ID: " + task.getTaskId());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Task not found");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        TaskDAO taskDAO = new TaskDAO();
        HttpSession sess = request.getSession();

        User user = (User) sess.getAttribute("user");

        Category category = Category.valueOf(request.getParameter("category"));
        try {
            if (user != null) {
                if (taskDAO.delete(taskId)) {
                    response.getWriter().write("Task deleted with ID: " + taskId);
                    response.sendRedirect("home?category=" + category);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("Task not found");
                }
            } else {
                System.out.println("User is null");
                request.setAttribute("error", "User does not exist");
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
