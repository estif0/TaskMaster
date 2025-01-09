<%@ page import="com.estifo.beans.User" %><%-- Created by IntelliJ IDEA. User: Estifo1 Date: 1/1/2025 Time: 1:22 AM To change this template use File | Settings | File Templates. --%> <%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Dashboard - TaskMaster</title>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
    </head>
    <body class="dashboard-body">
        <div class="dashboard">
            <!-- Sidebar -->
            <aside class="sidebar">
                <div class="user-profile">
                    <img src="https://i.pravatar.cc/150?img=4" alt="User Profile" />

                    <% User user = (User)request.getSession().getAttribute("user");%>
                    <% String category = request.getAttribute("currentCategory").toString();%>
                    <h1><%=user.getFirstName()%> <%=user.getLastName()%></h1>

                    <p><%=user.getEmail()%></p>
                    <form action="logout" method="post">
                        <button type="submit" class="add-task-btn">Logout</button>
                    </form>
                </div>

                <div class="categories">
                    <h3>Categories</h3>
                    <a id='Miscellaneous' href="home?category=Miscellaneous" class="category-btn"> <i class="fas fa-inbox"></i> Miscellaneous </a>
                    <a id='Personal' href="home?category=Personal" class="category-btn"> <i class="fas fa-user"></i> Personal </a>
                    <a id='Home' href="home?category=Home" class="category-btn"> <i class="fas fa-home"></i> Home </a>
                    <a id='Work' href="home?category=Work" class="category-btn"> <i class="fas fa-briefcase"></i> Work </a>
                    <a id='Education' href="home?category=Education" class="category-btn"> <i class="fas fa-graduation-cap"></i> Education </a>
                    <a id='Health' href="home?category=Health" class="category-btn"> <i class="fas fa-heartbeat"></i> Health </a>
                    <a id='Finances' href="home?category=Finances" class="category-btn"> <i class="fas fa-dollar-sign"></i> Finances </a>
                    <a id='Shopping' href="home?category=Shopping" class="category-btn"> <i class="fas fa-shopping-cart"></i> Shopping </a>
                    <a id='Family' href="home?category=Family" nd_Friends')" class="category-btn"> <i class="fas fa-users"></i> Family </a>
                    <a id='Travel' href="home?category=Travel" class="category-btn"> <i class="fas fa-plane"></i> Travel </a>
                </div>
            </aside>

            <!-- Main Content -->
            <main class="main-content">
                <div class="tasks-header">
                    <h2 id="header" ><%=category%></h2>
                </div>

                <div class="tasks-list">
                    <!-- Task Items -->

                    <c:forEach var="task" items="${tasks}">
                        <div class="task-item">
                            <form method="post" action="finishTask">
                                <input type="hidden" name="taskId" value="${task.taskId}" />
                                <input type="hidden" name="category" value="${task.category}" />
                                <input type="checkbox" class="task-checkbox" onclick="this.form.submit()" />
                            </form>
                            <div class="task-content">
                                <h3>${task.taskDescription}</h3>
                                <p class="task-date">Due: ${task.dueDate}</p>
                            </div>
                            <div class="task-actions">
                                <button class="edit-btn" onclick="openEditModal('${task.taskId}', '${task.taskDescription}', '${task.dueDate}')">
                                    <i class="fas fa-edit"></i>
                                </button>
                                <!-- Edit Task Modal -->
                                <div id="${task.taskId}" class="modal">
                                    <div class="modal-content">
                                        <span class="close" onclick="closeEditModal('${task.taskId}')">&times;</span>
                                        <form method="post" action="editTask" class="edit-task-form">
                                            <input type="hidden" id="editTaskId${task.taskId}" name="taskId" />
                                            <i>Task description</i>
                                            <input type="text" id="editTaskDescription${task.taskId}" placeholder="Task title" class="task-input" name="taskDescription" required />
                                            <i>Due Date</i>
                                            <input type="datetime-local" id="editDueDate${task.taskId}" class="date-input" name="dueDate" />
                                            <i>Category</i>
                                            <select class="category-input" name="category">
                                                <option value='${task.category}'>Select Category</option>
                                                <option value="Miscellaneous">Miscellaneous</option>
                                                <option value="Personal">Personal</option>
                                                <option value="Home">Home</option>
                                                <option value="Work">Work</option>
                                                <option value="Education">Education</option>
                                                <option value="Health">Health</option>
                                                <option value="Finances">Finances</option>
                                                <option value="Shopping">Shopping</option>
                                                <option value="Family">Family</option>
                                                <option value="Travel">Travel</option>
                                            </select>
                                            <button type="submit" class="add-task-btn"><i class="fas fa-save"></i> Save Task</button>
                                        </form>
                                    </div>
                                </div>
                                <a href="deleteTask?taskId=${task.taskId}" class="delete-btn" style="padding: 0.5rem; color: red" onclick="return confirm('Are you sure you want to delete this task?');">
                                    <i class="fas fa-trash"></i>
                                </a>
                            </div>
                            
                        </div>
                    </c:forEach>
                    <div class="tasks-header">
                        <h3>Completed tasks</h3>
                    </div>
                    <c:forEach var="task" items="${finishedTasks}">
                        <div class="task-item">
                            <div class="task-content">
                                <h4>${task.taskDescription}</h4>
                                <div style="display: flex; gap: 10px;">
                                    <p class="task-date">Due: ${task.dueDate}</p>
                                    <p class="task-date">Finished on: ${task.finishedDate}</p>
                                </div>
                            </div>                           
                        </div>
                    </c:forEach>
                </div>

                <!-- Add Task Section -->
                <div class="add-task-section">
                    <form method="post" action="addTask" class="add-task-form">
                        <input type="text" placeholder="Task title" class="task-input" name="taskDescription" required />
                        <i>Due Date</i>
                        <input type="datetime-local" class="date-input" name="dueDate" />
                        <select class="category-input" name="category" required>
                            <option value="">Select Category</option>
                            <option value="Miscellaneous">Miscellaneous</option>
                            <option value="Personal">Personal</option>
                            <option value="Home">Home</option>
                            <option value="Work">Work</option>
                            <option value="Education">Education</option>
                            <option value="Health">Health</option>
                            <option value="Finances">Finances</option>
                            <option value="Shopping">Shopping</option>
                            <option value="Family">Family</option>
                            <option value="Travel">Travel</option>
                        </select>
                        <button type="submit" class="add-task-btn"><i class="fas fa-plus"></i> Add Task</button>
                    </form>
                </div>
            </main>
        </div>
        <script src="js/script.js">  
        </script>
    </body>
</html>
