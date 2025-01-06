package com.estifo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.estifo.beans.Task;
import com.estifo.beans.Category;
import com.estifo.beans.User;

public class TaskDAO implements DAO<Task> {

    @Override
    public boolean add(Task t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO TaskMaster.Task (taskDescription, dueDate,category, userId, isDone) VALUES (?,?,?,?,?);";
            ps = con.prepareStatement(insert);

            ps.setString(1, t.getTaskDescription());
            ps.setObject(2, t.getDueDate());
            ps.setString(3, t.getCategory().toString());
            ps.setInt(4, t.getUser().getUserId());
            ps.setBoolean(5, t.isDone());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public boolean update(Task t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE TaskMaster.Task SET taskDescription=?, dueDate=?, finishedDate=?, category=?, isDone=? WHERE taskId=?";
            ps = con.prepareStatement(update);
            ps.setString(1, t.getTaskDescription());
            ps.setObject(2, t.getDueDate());
            ps.setObject(3, t.getFinishedDate());
            ps.setString(4, t.getCategory().toString());
            ps.setBoolean(5, t.isDone());
            ps.setInt(6, t.getTaskId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String delete = "DELETE FROM TaskMaster.Task WHERE taskId=?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM TaskMaster.Task";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("taskId"),
                        rs.getString("taskDescription"),
                        rs.getObject("createdTime", LocalDateTime.class),
                        rs.getObject("dueDate", LocalDateTime.class),
                        rs.getObject("finishedDate", LocalDateTime.class),
                        Category.valueOf(rs.getString("category")),
                        (new UserDAO()).get(rs.getInt("userId")),
                        rs.getBoolean("isDone"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }

    @Override
    public Task get(int id) {
        Task task = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM TaskMaster.Task WHERE taskId=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                task = new Task(
                    rs.getInt("taskId"),
                        rs.getString("taskDescription"),
                        rs.getObject("createdTime", LocalDateTime.class),
                        rs.getObject("dueDate", LocalDateTime.class),
                        rs.getObject("finishedDate", LocalDateTime.class),
                        Category.valueOf(rs.getString("category")),
                        (new UserDAO()).get(rs.getInt("userId")),
                        rs.getBoolean("isDone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return task;
    }

    public List<Task> getByCategory(Category category, User user) {
        List<Task> tasks = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM TaskMaster.Task WHERE category=? AND userId=?";
            ps = con.prepareStatement(query);
            ps.setString(1, category.toString());
            ps.setInt(2, user.getUserId()); 
            rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("taskId"),
                        rs.getString("taskDescription"),
                        rs.getObject("createdTime", LocalDateTime.class),
                        rs.getObject("dueDate", LocalDateTime.class),
                        rs.getObject("finishedDate", LocalDateTime.class),
                        Category.valueOf(rs.getString("category")),
                        (new UserDAO()).get(rs.getInt("userId")),
                        rs.getBoolean("isDone"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }
}
