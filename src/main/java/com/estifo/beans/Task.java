package com.estifo.beans;

import java.time.LocalDateTime;

public class Task {
    private int taskId;
    private String taskDescription;
    private LocalDateTime createdTime;
    private LocalDateTime dueDate;
    private LocalDateTime finishedDate;
    private Category category;
    private User user;
    private boolean isDone;

    public Task(String taskDescription, LocalDateTime dueDate, LocalDateTime finishedDate,
            Category category, User user) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.finishedDate = finishedDate;
        this.category = category;
        this.user = user;
        this.isDone = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDateTime finishedDate) {
        this.finishedDate = finishedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskDescription=" + taskDescription + ", createdTime=" + createdTime
                + ", dueDate=" + dueDate + ", finishedDate=" + finishedDate + ", category=" + category + ", user="
                + user + ", isDone=" + isDone + "]";
    }
}
