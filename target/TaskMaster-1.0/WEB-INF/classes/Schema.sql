CREATE DATABASE TaskMaster;

USE TaskMaster;

CREATE TABLE User
(
    userId            INT AUTO_INCREMENT PRIMARY KEY,
    firstName         VARCHAR(255),
    lastName          VARCHAR(255),
    userName          VARCHAR(255) UNIQUE,
    email             VARCHAR(255) UNIQUE,
    password          VARCHAR(255),
    gender            ENUM ('Male', 'Female')
);

-- Create the Task table
CREATE TABLE Task
(
    taskId          INT AUTO_INCREMENT PRIMARY KEY,
    taskDescription TEXT,
    createdTime     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    finishedDate    TIMESTAMP NULL,
    dueDate         TIMESTAMP NULL,
    category        ENUM ('Miscellaneous', 'Personal', 'Home', 'Work', 'Education', 'Health', 'Finances', 'Shopping', 'Family_and_Friends', 'Travel') DEFAULT 'Miscellaneous',
    userId          INT,
    isDone          BOOLEAN,
    FOREIGN KEY (userId) REFERENCES User (userId)
);
