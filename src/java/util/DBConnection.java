/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 20248
 */
public class DBConnection {

    public static Connection createConnection() {

        Connection conn = null;

        String url = "jdbc:derby://localhost:1527/ESukan";
        String user = "app";
        String pass = "app";

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("Database Connected");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return conn;
    }

    public static Connection getConnection() {
        return createConnection();
    }

}
