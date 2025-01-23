/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class connect_database {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/logindanregist";
        String user = "root";
        String password = ""; // Pastikan password sesuai dengan konfigurasi MySQL Anda
        
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection c = connect_database.getConnection();
            if (c != null) {
                System.out.println(String.format("Connected to database %s Success", c.getCatalog()));
            } else {
                System.out.println("Connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
