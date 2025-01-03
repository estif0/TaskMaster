package com.estifo.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBService {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/TaskMaster";
    public static String USER = "root";
    public static String PASSWORD = "root" ;

    public static Connection openConnection() {
        try {
            System.out.println("driver " + DRIVER);
            Class.forName(DRIVER);
            System.out.println("beginning database connection...");
            Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("database connection established!");
            return c;
        } catch (Exception ex) {
            System.out.println("database connection failed:==> "+ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        openConnection();
    }
}
