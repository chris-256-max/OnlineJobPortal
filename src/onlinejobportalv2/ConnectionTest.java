/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinejobportalv2;

import java.sql.Connection;

public class ConnectionTest {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }
    }
}