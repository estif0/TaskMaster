# 📋 TaskMaster 📋

TaskMaster is a powerful and intuitive task management application designed to streamline your productivity. Built with Java, Jakarta Servlet, JSP, and MySQL, TaskMaster helps you stay organized and on top of your tasks.

## 📑 Table of Contents 📑

- [📋 TaskMaster 📋](#-taskmaster-)
  - [📑 Table of Contents 📑](#-table-of-contents-)
  - [✨ Features ✨](#-features-)
  - [📂 Project Structure 📂](#-project-structure-)
  - [🚀 Getting Started 🚀](#-getting-started-)
    - [📋 Prerequisites 📋](#-prerequisites-)
    - [🛠️ Installation 🛠️](#️-installation-️)
    - [🏃 Running the Application 🏃](#-running-the-application-)
  - [📖 Usage 📖](#-usage-)
  - [🤝 Contributing 🤝](#-contributing-)
  - [📜 License 📜](#-license-)

## ✨ Features ✨

- 📝 **Add Tasks**: Seamlessly create and manage tasks.
- 📂 **Categorize Tasks**: Organize tasks into categories like Personal, Work, Education, etc.
- 🔒 **User Authentication**: Secure login and registration system.
- 📱 **Responsive Design**: User-friendly interface optimized for all devices.
- ✅ **Task Management**: Mark tasks as done, update, and delete tasks effortlessly.

## 📂 Project Structure 📂

```
TaskMaster/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── estifo/
│   │   │   │   │   ├── beans/
│   │   │   │   │   ├── controller/
│   │   │   │   │   └── service/
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── css/
│   │       │   ├── styles.css
│   │       ├── WEB-INF/
│   │       │    ├── dashboard.jsp
│   │       │    ├── web.xml
│   │       ├── index.html
│   │       ├── login.jsp
│   │       └── signup.jsp
├── target/
├── .idea/
├── .vscode/
├── .gitignore
├── pom.xml
└── README.md
```

## 🚀 Getting Started 🚀

### 📋 Prerequisites 📋

- ☕ **Java 21**: Ensure you have [Java Development Kit (JDK) 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) installed.
- 🐱 **Tomcat**: Install [Apache Tomcat](https://tomcat.apache.org/) to deploy the application.
- 🐬 **MySQL**: Set up [MySQL](https://www.mysql.com/) for the database.
- 🌐 **Jakarta EE**: Utilize [Jakarta EE](https://jakarta.ee/) for enterprise Java development.
- 🛠️ **Maven**: Manage the project with [Maven](https://maven.apache.org/).

### 🛠️ Installation 🛠️

1.  **Clone the repository**:

    ```sh
    git clone https://github.com/estif0/TaskMaster.git
    cd TaskMaster
    ```

2.  **Set up the database**:

    - Create a MySQL database named `TaskMaster`.
    - Execute the SQL script located at `src/main/resources/Schema.sql` to create the necessary tables.

3.  **Configure the database connection**: Update the database connection details in `src/main/java/com/estifo/service/DBService.java`.

4.  **Build the project**: Run the following command to build the project using Maven.

    ```sh
    mvn clean install
    ```

5.  **Deploy the WAR file**: Deploy the generated WAR file located in the `target` directory to your preferred servlet container (e.g., Apache Tomcat).

### 🏃 Running the Application 🏃

- Access the application at `http://localhost:8080/TaskMaster`.

## 📖 Usage 📖

- **Sign Up**: Create a new account.
- **Login**: Access your account.
- **Dashboard**: View and manage your tasks.
- **Add Task**: Create new tasks and assign them to categories.
- **Edit/Delete Task**: Update or remove existing tasks.

## 🤝 Contributing 🤝

We welcome contributions! Please fork the repository and create a pull request with your changes.

## 📜 License 📜

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
