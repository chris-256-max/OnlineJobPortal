/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package onlinejobportalv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/online_job_portal_v2";
    private static final String USER = "root";
    private static final String PASSWORD = "chris256";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
