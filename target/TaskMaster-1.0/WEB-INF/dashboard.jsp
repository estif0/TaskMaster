<%@ page import="com.estifo.beans.User" %><%-- Created by IntelliJ IDEA. User:
Estifo1 Date: 1/1/2025 Time: 1:22 AM To change this template use File | Settings
| File Templates. --%> <%@ page contentType="text/html;charset=UTF-8"
language="java" %> <%@taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard - TaskMaster</title>
    <link rel="stylesheet" href="css/style.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />
  </head>
  <body class="dashboard-body">
    <div class="dashboard">
      <!-- Sidebar -->
      <aside class="sidebar">
        <div class="user-profile">
          <img src="https://i.pravatar.cc/150?img=4" alt="User Profile" />

          <% User user = (User)request.getSession().getAttribute("user");%>
          <h1><%=user.getFirstName()%> <%=user.getLastName()%></h1>

          <p><%=user.getEmail()%></p>
        </div>

        <div class="categories">
          <h3>Categories</h3>
          <a href="home?category=Miscellaneous" class="category-btn active">
            <i class="fas fa-inbox"></i> Miscellaneous
          </a>
          <a href="home?category=Personal" class="category-btn">
            <i class="fas fa-user"></i> Personal
          </a>
          <a href="home?category=Home" class="category-btn">
            <i class="fas fa-home"></i> Home
          </a>
          <a href="home?category=Work" class="category-btn">
            <i class="fas fa-briefcase"></i> Work
          </a>
          <a href="home?category=Education" class="category-btn">
            <i class="fas fa-graduation-cap"></i> Education
          </a>
          <a href="home?category=Health" class="category-btn">
            <i class="fas fa-heartbeat"></i> Health
          </a>
          <a href="home?category=Finances" class="category-btn">
            <i class="fas fa-dollar-sign"></i> Finances
          </a>
          <a href="home?category=Shopping" class="category-btn">
            <i class="fas fa-shopping-cart"></i> Shopping
          </a>
          <a href="home?category=Family_and_Friends" class="category-btn">
            <i class="fas fa-users"></i> Family & Friends
          </a>
          <a href="home?category=Travel" class="category-btn">
            <i class="fas fa-plane"></i> Travel
          </a>
        </div>
      </aside>

      <!-- Main Content -->
      <main class="main-content">
        <div class="tasks-header">
          <h2>All Tasks</h2>
        </div>

        <div class="tasks-list">
          <!-- Task Items -->

          <c:forEach var="task" items="${tasks}">
            <div class="task-item">
              <input type="checkbox" class="task-checkbox" />
              <div class="task-content">
                <h3>${task.taskDescription}</h3>
                <p class="task-date">Due: ${task.dueDate}</p>
              </div>
              <div class="task-actions">
                <button class="edit-btn"><i class="fas fa-edit"></i></button>
                <button class="delete-btn"><i class="fas fa-trash"></i></button>
              </div>
            </div>
          </c:forEach>
        </div>

        <!-- Add Task Section -->
        <div class="add-task-section">
          <form method="post" action="task" class="add-task-form">
            <input
              type="text"
              placeholder="Task title"
              class="task-input"
              name="taskDescription"
              required
            />
            <input type="datetime-local" class="date-input" name="dueDate" /><i
              >Due Date</i
            >
            <select class="category-input" name="category">
              <option value="">Select Category</option>
              <option value="Miscellaneous">Miscellaneous</option>
              <option value="Personal">Personal</option>
              <option value="Home">Home</option>
              <option value="Work">Work</option>
              <option value="Education">Education</option>
              <option value="Health">Health</option>
              <option value="Finances">Finances</option>
              <option value="Shopping">Shopping</option>
              <option value="Family_and_Friends">Family & Friends</option>
              <option value="Travel">Travel</option>
            </select>
            <button type="submit" class="add-task-btn">
              <i class="fas fa-plus"></i> Add Task
            </button>
          </form>
        </div>
      </main>
    </div>
  </body>
</html>
