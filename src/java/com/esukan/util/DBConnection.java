/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 20248
 */
public class DBConnection {
        private static final String URL = "jdbc:derby://localhost:1527/ESukanDB";
    private static final String USER = "adminEsukan";
    private static final String PASSWORD = "admin123";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected!");
        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}
