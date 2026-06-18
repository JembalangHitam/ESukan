/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esukan.dao;

import com.esukan.model.User;
import com.esukan.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 20248
 */
public class UserDAO {

    public boolean registerUser(User user) {
        boolean rowInserted = false;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO USERS(FULLNAME, EMAIL, PASSWORD, ROLE) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            rowInserted = ps.executeUpdate() > 0;

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public User loginUser(String email, String password) {
        User user = null;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();

                user.setUserId(rs.getInt("USER_ID"));
                user.setFullname(rs.getString("FULLNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(rs.getString("ROLE"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
